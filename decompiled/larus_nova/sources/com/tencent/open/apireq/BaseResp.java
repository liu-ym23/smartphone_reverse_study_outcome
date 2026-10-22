package com.tencent.open.apireq;

/* JADX INFO: loaded from: classes29.dex */
public class BaseResp {
    public static final int CODE_ERROR_PARAMS = -2000;
    public static final int CODE_NOT_LOGIN = -2001;
    public static final int CODE_PERMISSION_NOT_GRANTED = -1003;
    public static final int CODE_QQ_LOW_VERSION = -1001;
    public static final int CODE_QQ_NOT_INSTALLED = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED_BRANCH = -1002;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f461700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461701b;

    public String a(int r100) {
        return "Api call failed.";
    }

    public boolean isSuccess() {
        if (this.f461700a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "BaseResp{mCode=" + this.f461700a + ", mErrorMsg='" + this.f461701b + "'}";
    }

    public BaseResp() {
        this.f461700a = 0;
        this.f461701b = "";
    }

    public int getCode() {
        return this.f461700a;
    }

    public String getErrorMsg() {
        return this.f461701b;
    }

    public void setCode(int r100) {
        this.f461700a = r100;
        if (r100 != (-2001)) goto L5;
        String r101 = "Not login.";
    L15:
        setErrorMsg(r101);
        return;
    L5:
        if (r100 == (-2000)) goto L13;
        if (r100 == 0) goto L12;
        switch(r100) {
            case -1002: goto L11;
            case -1001: goto L10;
            case -1000: goto L9;
            default: goto L8;
        };
    L8:
        r101 = a(r100);
        goto L15
    L9:
        r101 = "QQ is not installed.";
        goto L15
    L10:
        r101 = "QQ version is too low.";
        goto L15
    L11:
        r101 = "The QQ branch (e.g. TIM) is not supported";
        goto L15
    L12:
        r101 = "";
        goto L15
    L13:
        r101 = "The given params check failed.";
        goto L15
    }

    public void setErrorMsg(String r100) {
        this.f461701b = r100;
    }
}
