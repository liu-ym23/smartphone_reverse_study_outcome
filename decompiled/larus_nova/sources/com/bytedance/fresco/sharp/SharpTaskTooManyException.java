package com.bytedance.fresco.sharp;

/* JADX INFO: loaded from: classes19.dex */
public class SharpTaskTooManyException extends Exception {
    public static final int SHARP_TASK_TOO_MANY = -200000;
    private int mCode;

    public SharpTaskTooManyException() {
        this.mCode = -1;
    }

    public int getCode() {
        return this.mCode;
    }

    public SharpTaskTooManyException(String r100) {
        super(r100);
        this.mCode = -1;
    }

    public SharpTaskTooManyException(int r100, String r101) {
        super(r101);
        this.mCode = r100;
    }
}
