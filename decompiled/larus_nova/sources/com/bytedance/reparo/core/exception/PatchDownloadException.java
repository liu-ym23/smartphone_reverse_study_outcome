package com.bytedance.reparo.core.exception;

/* JADX INFO: loaded from: classes21.dex */
public class PatchDownloadException extends PatchException {
    public static final int ERROR_TYPE_MD5_NOT_MATCH = 1;
    public static final int ERROR_TYPE_UNKNOWN = 0;

    public PatchDownloadException(String r100) {
        this(r100, 0);
    }

    public PatchDownloadException(String r100, Exception r101) {
        this(r100, r101, 0);
    }

    public PatchDownloadException(String r100, int r101) {
        super(r100, r101);
    }

    public PatchDownloadException(String r100, Exception r101, int r102) {
        super(r100, r101, r102);
    }
}
