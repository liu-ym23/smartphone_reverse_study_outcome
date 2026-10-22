package com.bytedance.ee.bear.middleground.comment.widget;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class Info implements NonProguard {
    public int code;
    public boolean readAble;
    public String token;

    public Info() {
    }

    public String getToken() {
        return this.token;
    }

    public boolean isReadAble() {
        return this.readAble;
    }

    public void setReadAble(boolean r100) {
        this.readAble = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
