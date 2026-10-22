package com.bytedance.ee.bear.document.record;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setData(String r1) {
        this.data = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }
}
