package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MenuCallbackData implements NonProguard {
    private String id;
    private String targetLanguage;
    private String value;

    public String toString() {
        return "MenuCallbackData{id='" + this.id + "', value='" + this.value + "', targetLanguage='" + this.targetLanguage + "'}";
    }

    public MenuCallbackData() {
    }

    public String getId() {
        return this.id;
    }

    public String getTargetLanguage() {
        return this.targetLanguage;
    }

    public String getValue() {
        return this.value;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setTargetLanguage(String r1) {
        this.targetLanguage = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }

    public MenuCallbackData(String r1, String r2) {
        this.id = r1;
        this.targetLanguage = r2;
    }

    public MenuCallbackData(String r1, String r2, String r3) {
        this.id = r1;
        this.value = r2;
        this.targetLanguage = r3;
    }
}
