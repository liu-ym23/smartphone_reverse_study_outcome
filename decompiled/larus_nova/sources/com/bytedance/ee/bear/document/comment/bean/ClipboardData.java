package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class ClipboardData implements BaseJSModel {
    private String encryptId;
    private String text;

    public ClipboardData() {
    }

    public String toString() {
        return "ClipboardData{text='" + this.text + "'encryptId='" + this.encryptId + "'}";
    }

    public String getEncryptId() {
        return this.encryptId;
    }

    public String getText() {
        return this.text;
    }

    public void setEncryptId(String r100) {
        this.encryptId = r100;
    }

    public void setText(String r100) {
        this.text = r100;
    }
}
