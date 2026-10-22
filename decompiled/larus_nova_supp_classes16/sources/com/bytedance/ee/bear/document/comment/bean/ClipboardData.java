package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setEncryptId(String r1) {
        this.encryptId = r1;
    }

    public void setText(String r1) {
        this.text = r1;
    }
}
