package com.bytedance.ee.bear.sheet.exportimage.preview;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShareOperationTypeModel implements NonProguard {
    private String data;
    private String type;

    public ShareOperationTypeModel() {
    }

    public String toString() {
        return "ShareOperationTypeModel{type='" + this.type + "', data='" + du5.b.g(this.data) + "'}";
    }

    public String getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }
}
