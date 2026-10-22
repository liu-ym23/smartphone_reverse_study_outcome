package com.volcengine.zeus;

/* JADX INFO: loaded from: classes41.dex */
public class ZeusException extends Exception {
    public int errorCode;

    @Override // java.lang.Throwable
    public String toString() {
        String r100 = getClass().getName();
        String r101 = getLocalizedMessage();
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r100 + ": " + r101 + " errorCode: " + this.errorCode;
    }

    public ZeusException(String r100, int r101) {
        super(r100);
        this.errorCode = r101;
    }

    public ZeusException(String r100, Throwable r101, int r102) {
        super(r100, r101);
        this.errorCode = r102;
    }
}
