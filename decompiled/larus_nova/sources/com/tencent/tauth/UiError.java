package com.tencent.tauth;

/* JADX INFO: loaded from: classes35.dex */
public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public String toString() {
        return "errorCode: " + this.errorCode + ", errorMsg: " + this.errorMessage + ", errorDetail: " + this.errorDetail;
    }

    public UiError(int r100, String r101, String r102) {
        this.errorMessage = r101;
        this.errorCode = r100;
        this.errorDetail = r102;
    }
}
