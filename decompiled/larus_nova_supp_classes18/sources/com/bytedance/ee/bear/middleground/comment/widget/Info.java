package com.bytedance.ee.bear.middleground.comment.widget;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setReadAble(boolean r1) {
        this.readAble = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }
}
