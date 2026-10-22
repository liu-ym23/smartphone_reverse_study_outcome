package com.bytedance.mira.signature;

/* JADX INFO: loaded from: classes21.dex */
public class VerifyException extends Exception {
    public static final int FAILED_BAD_MANIFEST = 1;
    public static final int FAILED_CERTIFICATE_ENCODING = 2;
    public static final int FAILED_INCONSISTENT_CERTIFICATES = 3;
    public static final int FAILED_NO_CERTIFICATES = 4;
    public static final int FAILED_UNEXPECTED_EXCEPTION = 5;
    public final int error;

    public VerifyException(int r100, String r101) {
        super(r101);
        this.error = r100;
    }

    public VerifyException(int r100, String r101, Throwable r102) {
        super(r101, r102);
        this.error = r100;
    }
}
