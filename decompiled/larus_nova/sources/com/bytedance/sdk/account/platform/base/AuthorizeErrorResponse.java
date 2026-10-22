package com.bytedance.sdk.account.platform.base;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public class AuthorizeErrorResponse {
    public Bundle extras;
    public boolean isCancel;
    public String logid;
    public String platformErrorCode;
    public String platformErrorDetail;
    public String platformErrorMsg;

    public String toString() {
        return "AuthorizeErrorResponse{logid='" + this.logid + "', isCancel=" + this.isCancel + ", platformErrorCode='" + this.platformErrorCode + "', platformErrorMsg='" + this.platformErrorMsg + "', platformErrorDetail='" + this.platformErrorDetail + "', extras=" + this.extras + '}';
    }

    public AuthorizeErrorResponse() {
        this.logid = "";
    }

    public AuthorizeErrorResponse(String r100) {
        this.logid = "";
        this.platformErrorMsg = r100;
    }

    public AuthorizeErrorResponse(boolean r100) {
        this.logid = "";
        this.isCancel = r100;
    }

    public AuthorizeErrorResponse(int r100, String r101) {
        this.logid = "";
        this.platformErrorCode = String.valueOf(r100);
        this.platformErrorMsg = r101;
    }

    public AuthorizeErrorResponse(String r100, String r101) {
        this.logid = "";
        this.platformErrorMsg = r101;
        this.platformErrorCode = r100;
    }

    public AuthorizeErrorResponse(int r100, String r101, String r102) {
        this.logid = "";
        this.platformErrorCode = String.valueOf(r100);
        this.platformErrorMsg = r101;
        this.platformErrorDetail = r102;
    }
}
