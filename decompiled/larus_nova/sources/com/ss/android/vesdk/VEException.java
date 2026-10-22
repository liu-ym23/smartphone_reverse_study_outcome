package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class VEException extends RuntimeException {
    private String msgDes;
    private int ret;

    public String getMsgDes() {
        return this.msgDes;
    }

    public int getRetCd() {
        return this.ret;
    }

    public VEException(int r100, String r101) {
        super("VESDK exception ret: " + r100 + "msg: " + r101);
        this.ret = r100;
        this.msgDes = r101;
    }
}
