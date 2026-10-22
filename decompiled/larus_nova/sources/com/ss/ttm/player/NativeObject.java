package com.ss.ttm.player;

/* JADX INFO: loaded from: classes40.dex */
public class NativeObject {
    protected long mNativeObj;
    protected boolean mRetain;

    private native void nativeRelease(long r100);

    public void finalize() throws Throwable {
    }

    public synchronized void release() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mRetain == false) goto L8;
        long r100 = this.mNativeObj;     // Catch: Throwable -> L10
        if (r100 == 0) goto L8;
        nativeRelease(r100);     // Catch: Throwable -> L10
        this.mNativeObj = 0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }

    public NativeObject() {
        this.mNativeObj = 0;
        this.mRetain = false;
    }

    private long getNativeObj() {
        return this.mNativeObj;
    }

    public void setNativeObj(long r100) {
        this.mNativeObj = r100;
        this.mRetain = true;
    }

    public void setWeakNativeObj(long r100) {
        this.mNativeObj = r100;
        this.mRetain = false;
    }
}
