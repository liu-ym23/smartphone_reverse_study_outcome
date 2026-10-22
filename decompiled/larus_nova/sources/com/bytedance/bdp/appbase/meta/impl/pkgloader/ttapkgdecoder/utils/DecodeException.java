package com.bytedance.bdp.appbase.meta.impl.pkgloader.ttapkgdecoder.utils;

import com.bytedance.bdp.appbase.errorcode.ErrorCode;

/* JADX INFO: loaded from: classes11.dex */
public class DecodeException extends Exception {
    public static final int CODE_ALREADY_CANCELED = -10;
    public static final int CODE_ALREADY_FAILED = -8;
    public static final int CODE_INVALID_URL = -5;
    public static final int CODE_LOAD_TWICE = -9;
    public static final int CODE_NETWORK_EXCEPTION = -2;
    public static final int CODE_PKG_FILE_INVALID = -3;
    public static final int CODE_PKG_FILE_OFFSET_WRONG = -6;
    public static final int CODE_UNKNOWN = -4;
    public static final int CODE_UNSUPPORT_TTAPKG_VERSION = -7;
    private ErrorCode mErrorCode;

    public ErrorCode getErrorCode() {
        return this.mErrorCode;
    }

    public DecodeException(ErrorCode r100, String r101) {
        super("ErrorCode: " + r100.getCode() + ", " + r101);
        this.mErrorCode = r100;
    }

    public DecodeException(ErrorCode r100, Throwable r101) {
        super("ErrorCode: " + r100 + ", " + r101.getMessage(), r101);
        this.mErrorCode = r100;
    }
}
