package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class LoginSourceInfo implements Serializable {
    private int loginSource;
    private String url;

    public LoginSourceInfo() {
        this.loginSource = 0;
    }

    public int getLoginSource() {
        return this.loginSource;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLoginSource(int r100) {
        this.loginSource = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public LoginSourceInfo(int r100, String r101) {
        this.loginSource = r100;
        this.url = r101;
    }
}
