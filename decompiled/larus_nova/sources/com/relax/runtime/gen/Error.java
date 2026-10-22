package com.relax.runtime.gen;

/* JADX INFO: loaded from: classes34.dex */
public class Error {
    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativesetOnRtsExceptionListener(long r100, RtsExceptionCallback r101);

    public Error() {
    }
}
