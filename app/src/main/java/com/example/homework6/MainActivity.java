package com.example.homework6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.assist.AssistStructure;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Name,Number;
    String value;
    Button count,reset,exit;
    public static final String TEXT="text",NAME="name";
    String text,number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editTextText);
        Number = findViewById(R.id.editTextText2);
        count= findViewById(R.id.button);
        reset= findViewById(R.id.button2);
        exit= findViewById(R.id.button3);

        loadDate();
        updateViews();
    }

    public void btn1(View view) {
        value = Number.getText().toString();
        Number.setText(String.valueOf(Integer.parseInt(value)+1));
    }

    public void btn2(View view) {
        value = "0";
        Number.setText("0");
    }

    public void btn3(View view) {
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        value=Number.getText().toString();
        editor.putString(TEXT,value);
        editor.putString(NAME,Name.getText().toString());

        editor.apply();
        finishAffinity();
    }
    public void loadDate(){
        SharedPreferences SharedPreferences=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        number=SharedPreferences.getString(TEXT,"");
        text  =SharedPreferences.getString(NAME,"");
    }
    public void updateViews(){
        Number.setText(number);
        Name.setText(text);
    }
}