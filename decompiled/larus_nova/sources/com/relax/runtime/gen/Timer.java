package com.relax.runtime.gen;

/* JADX INFO: loaded from: classes34.dex */
public class Timer {
    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeclearInterval(long r100, int r101);

    private native void nativeclearTimeout(long r100, int r101);

    private native int nativesetInterval(long r100, TimerCallback r101, int r102);

    private native int nativesetTimeout(long r100, TimerCallback r101, int r102);

    public Timer() {
    }
}
