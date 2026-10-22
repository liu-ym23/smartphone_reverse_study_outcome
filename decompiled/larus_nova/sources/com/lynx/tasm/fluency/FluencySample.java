package com.lynx.tasm.fluency;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public class FluencySample {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f383337a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f383338b;

    public FluencySample() {
    }

    private static native void nativeNeedCheckFluencyEnable();

    private static native void nativeSetFluencySample(boolean r100);

    static {
        f383337a = new AtomicBoolean(true);
        f383338b = false;
    }

    public static void a() {
        f383337a.set(true);
        nativeNeedCheckFluencyEnable();
    }
}
