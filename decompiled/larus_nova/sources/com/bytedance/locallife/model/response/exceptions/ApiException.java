package com.bytedance.locallife.model.response.exceptions;

/* JADX INFO: loaded from: classes21.dex */
public class ApiException extends RuntimeException {
    private final int mErrorCode;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public ApiException(int r100) {
        super("error_code = " + r100);
        this.mErrorCode = r100;
    }

    public ApiException(int r100, Throwable r101) {
        super("error_code = " + r100, r101);
        this.mErrorCode = r100;
    }
}
