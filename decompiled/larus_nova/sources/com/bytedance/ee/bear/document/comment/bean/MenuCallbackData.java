package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class MenuCallbackData implements NonProguard {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f219282id;
    private String targetLanguage;
    private String value;

    public String toString() {
        return "MenuCallbackData{id='" + this.f219282id + "', value='" + this.value + "', targetLanguage='" + this.targetLanguage + "'}";
    }

    public MenuCallbackData() {
    }

    public String getId() {
        return this.f219282id;
    }

    public String getTargetLanguage() {
        return this.targetLanguage;
    }

    public String getValue() {
        return this.value;
    }

    public void setId(String r100) {
        this.f219282id = r100;
    }

    public void setTargetLanguage(String r100) {
        this.targetLanguage = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }

    public MenuCallbackData(String r100, String r101) {
        this.f219282id = r100;
        this.targetLanguage = r101;
    }

    public MenuCallbackData(String r100, String r101, String r102) {
        this.f219282id = r100;
        this.value = r101;
        this.targetLanguage = r102;
    }
}
