package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class CopyResult implements NonProguard {
    public static final int COPY_FAIL = 1;
    public static final int COPY_SUCCESS = 0;
    private int code;

    public String toString() {
        return "CopyResult{code=" + this.code + '}';
    }

    public CopyResult() {
    }

    public int getCode() {
        return this.code;
    }

    public CopyResult(int r100) {
        this.code = r100;
    }

    public void setCode(int r100) {
        this.code = r100;
    }
}
