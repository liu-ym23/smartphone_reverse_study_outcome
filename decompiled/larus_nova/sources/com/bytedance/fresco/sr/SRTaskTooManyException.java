package com.bytedance.fresco.sr;

/* JADX INFO: loaded from: classes19.dex */
public class SRTaskTooManyException extends Exception {
    public static final int SR_TASK_TOO_MANY = -200000;
    private int mCode;

    public SRTaskTooManyException() {
        this.mCode = -1;
    }

    public int getCode() {
        return this.mCode;
    }

    public SRTaskTooManyException(String r100) {
        super(r100);
        this.mCode = -1;
    }

    public SRTaskTooManyException(int r100, String r101) {
        super(r101);
        this.mCode = r100;
    }
}
