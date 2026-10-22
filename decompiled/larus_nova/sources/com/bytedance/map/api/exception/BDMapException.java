package com.bytedance.map.api.exception;

/* JADX INFO: loaded from: classes21.dex */
public class BDMapException extends Exception {
    public static final String IMAGE_LOAD_FAIL = "4";
    public static final String IMAGE_OPTION_NULL = "2";
    public static final String SUCCESS = "0";
    private final String mCode;
    private final String mMessage;

    public String getCode() {
        return this.mCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mMessage;
    }

    public BDMapException(String r100, String r101) {
        this.mCode = r100;
        this.mMessage = r101;
    }
}
