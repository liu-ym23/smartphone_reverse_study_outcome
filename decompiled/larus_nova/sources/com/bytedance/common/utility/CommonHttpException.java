package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes.dex */
public class CommonHttpException extends Exception {
    private int mResponseCode;

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public CommonHttpException(int r100, String r101) {
        super(r101);
        this.mResponseCode = r100;
    }
}
