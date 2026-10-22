package com.lynx.tasm.provider;

/* JADX INFO: loaded from: classes32.dex */
public class LynxResourceResponse<T> {
    public static final int FAILED = -1;
    public static final int SUCCESS = 0;
    private int mCode;
    private T mData;
    private Throwable mError;

    public boolean success() {
        if (this.mData == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int getCode() {
        return this.mCode;
    }

    public T getData() {
        return this.mData;
    }

    public Throwable getError() {
        return this.mError;
    }

    private LynxResourceResponse(T r100) {
        this.mData = r100;
    }

    public static <T> LynxResourceResponse<T> success(T r100) {
        LynxResourceResponse<T> r101 = new LynxResourceResponse(r100);
        ((LynxResourceResponse) r101).mCode = 0;
        return r101;
    }

    private LynxResourceResponse(int r100, Throwable r101) {
        this.mCode = r100;
        this.mError = r101;
    }

    public static LynxResourceResponse failed(int r100, Throwable r101) {
        return new LynxResourceResponse(r100, r101);
    }
}
