package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class AccountInterceptorBean implements Serializable {
    private String cancelText;
    private String confirmText;
    private String desc;
    private String title;

    public String getCancelText() {
        return this.cancelText;
    }

    public String getConfirmText() {
        return this.confirmText;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCancelText(String r100) {
        this.cancelText = r100;
    }

    public void setConfirmText(String r100) {
        this.confirmText = r100;
    }

    public void setDesc(String r100) {
        this.desc = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public AccountInterceptorBean(String r100, String r101, String r102, String r103) {
        this.title = r100;
        this.desc = r101;
        this.confirmText = r102;
        this.cancelText = r103;
    }
}
