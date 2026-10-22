package com.ss.videoarch.strategy;

import com.ss.videoarch.strategy.utils.JNINamespace;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class NativeObject {
    protected long mNativeObj;

    private native void nativeRelease(long r100);

    public synchronized void release() {
        monitor-enter(this);
        long r100 = this.mNativeObj;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        nativeRelease(r100);     // Catch: Throwable -> L8
        this.mNativeObj = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void finalize() throws Throwable {
        if (this.mNativeObj == 0) goto L6;
        release();
        return;
    }

    public NativeObject() {
        this.mNativeObj = 0;
    }

    private long getNativeObj() {
        return this.mNativeObj;
    }

    public void setNativeObj(long r100) {
        this.mNativeObj = r100;
    }
}
