package com.bytedance.vmsdk.worker;

/* JADX INFO: loaded from: classes3.dex */
public class VmSdkException extends Exception {
    private int mCode;
    private String mMessage;

    public int getCode() {
        return this.mCode;
    }

    public VmSdkException(int r100, String r101) {
        super(r101);
        this.mCode = r100;
    }

    public static void throwVmSdkException(int r100, String r101) throws VmSdkException {
        throw new VmSdkException(r100, r101);
    }
}
