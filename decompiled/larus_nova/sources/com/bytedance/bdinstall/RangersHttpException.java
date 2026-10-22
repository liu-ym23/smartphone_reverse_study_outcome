package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes3.dex */
public class RangersHttpException extends Exception {
    private int mResponseCode;

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public RangersHttpException(int r100, String r101) {
        super(r101);
        this.mResponseCode = r100;
    }

    public RangersHttpException(int r100, Throwable r101) {
        super(r101);
        this.mResponseCode = r100;
    }
}
