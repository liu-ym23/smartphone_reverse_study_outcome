package com.bytedance.reparo.core.exception;

/* JADX INFO: loaded from: classes21.dex */
public class PatchInstallException extends PatchException {
    public static final int ERROR_TYPE_SIGNATURE_VERIFY_FAILED = 1;
    public static final int ERROR_TYPE_UNKNOWN = 0;

    public PatchInstallException(String r100) {
        this(r100, 0);
    }

    public PatchInstallException(String r100, Throwable r101) {
        this(r100, r101, 0);
    }

    public PatchInstallException(String r100, int r101) {
        super(r100, r101);
    }

    public PatchInstallException(String r100, Throwable r101, int r102) {
        super(r100, r101, r102);
    }
}
