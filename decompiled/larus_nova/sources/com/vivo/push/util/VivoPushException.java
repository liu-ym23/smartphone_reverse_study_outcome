package com.vivo.push.util;

/* JADX INFO: loaded from: classes41.dex */
public class VivoPushException extends Exception {
    public static final int REASON_CODE_ACCESS = 10000;
    private int mReasonCode;

    public int getCode() {
        return this.mReasonCode;
    }

    public VivoPushException(String r100) {
        this(10000, r100);
    }

    public VivoPushException(int r100, String r101) {
        super(r101);
        this.mReasonCode = r100;
    }
}
