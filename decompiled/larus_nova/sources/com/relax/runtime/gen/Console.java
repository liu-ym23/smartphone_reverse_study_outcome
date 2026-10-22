package com.relax.runtime.gen;

/* JADX INFO: loaded from: classes34.dex */
public class Console {
    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeerror(long r100, Object r101);

    private native void nativeinfo(long r100, Object r101);

    private native void nativelog(long r100, Object r101);

    private native void nativeprofile(long r100, String r101);

    private native void nativeprofileEnd(long r100);

    private native void nativewarn(long r100, Object r101);

    public Console() {
    }
}
