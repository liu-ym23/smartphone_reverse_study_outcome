package com.bytedance.ee.bear.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes15.dex */
public class Icon implements NonProguard {
    private String fs_unit;
    private String key;
    private int type;

    public String toString() {
        return "Icon{type=" + this.type + ", key='" + this.key + "', fs_unit='" + this.fs_unit + "'}";
    }

    public Icon() {
    }

    public String getFs_unit() {
        return this.fs_unit;
    }

    public String getKey() {
        return this.key;
    }

    public int getType() {
        return this.type;
    }

    public void setFs_unit(String r100) {
        this.fs_unit = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public Icon(int r100, String r101, String r102) {
        this.type = r100;
        this.key = r101;
        this.fs_unit = r102;
    }
}
