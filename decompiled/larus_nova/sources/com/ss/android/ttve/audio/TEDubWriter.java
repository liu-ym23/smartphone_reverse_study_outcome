package com.ss.android.ttve.audio;

import ngc.b;

/* JADX INFO: loaded from: classes38.dex */
public class TEDubWriter implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f449826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f449827b;

    public native int nativeAddPCMData(long r100, byte[] r101, int r102);

    public native int nativeCloseWavFile(long r100);

    public native long nativeCreate();

    public native void nativeDestroy(long r100);

    public native long nativeGetCurrentTime(long r100);

    public native int nativeInitWavFile(long r100, String r101, int r102, int r103, double r104, int r105, int r106);

    public TEDubWriter() {
        this.f449826a = nativeCreate();
    }
}
