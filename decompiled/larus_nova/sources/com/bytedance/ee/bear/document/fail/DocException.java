package com.bytedance.ee.bear.document.fail;

/* JADX INFO: loaded from: classes16.dex */
public class DocException extends Exception {
    private int mCode;

    public int getCode() {
        return this.mCode;
    }

    public DocException(int r100, String r101) {
        super(r101);
        this.mCode = r100;
    }
}
