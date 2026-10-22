package com.bytedance.ee.bear.document.fail;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocException extends Exception {
    private int mCode;

    public int getCode() {
        return this.mCode;
    }

    public DocException(int r1, String r2) {
        super(r2);
        this.mCode = r1;
    }
}
