package com.bytedance.common.utility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class CommonHttpException extends Exception {
    private int mResponseCode;

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public CommonHttpException(int r1, String r2) {
        super(r2);
        this.mResponseCode = r1;
    }
}
