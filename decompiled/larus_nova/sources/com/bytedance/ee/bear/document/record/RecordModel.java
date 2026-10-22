package com.bytedance.ee.bear.document.record;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class RecordModel implements NonProguard {
    private String data;
    private String token;
    private String type;

    public RecordModel() {
    }

    public String toString() {
        return "RecordModel{token='" + this.token + "', type='" + this.type + "', data='" + this.data + "'}";
    }

    public String getData() {
        return this.data;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }
}
