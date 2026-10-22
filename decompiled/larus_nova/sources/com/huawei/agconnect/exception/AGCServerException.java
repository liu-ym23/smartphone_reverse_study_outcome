package com.huawei.agconnect.exception;

/* JADX INFO: loaded from: classes23.dex */
public class AGCServerException extends AGCException {
    public static final int ACCESS_TOKEN_EXPIRED = 205524994;
    public static final int AUTHENTICATION_FAILED = 403;
    public static final int AUTHENTICATION_INVALID = 400;
    public static final int CLIENT_TOKEN_EXPIRED = 205524993;
    public static final int CONTEXT_ERROR = 4;
    public static final int FETCH_THROTTLED = 1;
    public static final int NO_USER_LOGIN = 3;
    public static final int OK = 200;
    public static final int SERVER_NOT_AVAILABLE = 503;
    public static final int SERVER_RSP_INVALID = 2;
    public static final int TOKEN_INVALID = 401;
    public static final int UNKNOW_EXCEPTION = 500;
    public static final int URL_IS_NULL_ERROR = 5;
    private int retCode;

    public AGCServerException(String r100, int r101) {
        super(r100, r101);
    }

    public AGCServerException(String r100, int r101, int r102) {
        this(r100, r101);
        this.retCode = r102;
    }

    public int getRetCode() {
        return this.retCode;
    }
}
