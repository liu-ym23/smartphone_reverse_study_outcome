package com.lynx.tasm.core;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxEngineProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f383244a;

    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeDispatchTaskToLynxEngine(long r100, Runnable r101);

    private native void nativeInvokeLepusApiCallback(long r100, int r101, String r102, Object r103);

    private native void nativeOnPseudoStatusChanged(long r100, int r101, int r102, int r103);

    private native void nativeSendCustomEvent(long r100, String r101, int r102, ByteBuffer r103, int r104, String r105);

    private native void nativeSendGestureEvent(long r100, String r101, int r102, int r103, ByteBuffer r104, int r105);

    private native void nativeSendMultiTouchEvent(long r100, String r101, ByteBuffer r102, int r103, long r104);

    private native void nativeSendTouchEvent(long r100, String r101, int r102, float r103, float r104, float r105, float r106, float r107, float r110, long r111);

    private native void nativeStartEventBubble(long r100, long r101);

    private native void nativeStartEventCapture(long r100, long r101);

    private native void nativeStartEventFire(long r100, boolean r101, long r102);

    private native void nativeStartEventGenerate(long r100, ByteBuffer r101, int r102);

    public LynxEngineProxy(long r100) {
        this.f383244a = nativeCreate(r100);
    }

    private static void executeRunnable(Runnable r100) {
        r100.run();
    }

    public static /* synthetic */ void a(LynxEngineProxy r100, long r101) {
        r100.nativeDestroy(r101);
    }

    public static /* synthetic */ void b(LynxEngineProxy r100, long r101, long r102) {
        r100.nativeStartEventCapture(r101, r102);
    }

    public static /* synthetic */ void c(LynxEngineProxy r100, long r101, long r102) {
        r100.nativeStartEventBubble(r101, r102);
    }

    public static /* synthetic */ void e(LynxEngineProxy r100, long r101, Runnable r102) {
        r100.nativeDispatchTaskToLynxEngine(r101, r102);
    }

    public static /* synthetic */ void d(LynxEngineProxy r100, long r101, boolean r102, long r103) {
        r100.nativeStartEventFire(r101, r102, r103);
    }

    public static /* synthetic */ void l(LynxEngineProxy r100, long r101, ByteBuffer r102, int r103) {
        r100.nativeStartEventGenerate(r101, r102, r103);
    }

    public static /* synthetic */ void j(LynxEngineProxy r100, long r101, int r102, int r103, int r104) {
        r100.nativeOnPseudoStatusChanged(r101, r102, r103, r104);
    }

    public static /* synthetic */ void k(LynxEngineProxy r100, long r101, int r102, String r103, Object r104) {
        r100.nativeInvokeLepusApiCallback(r101, r102, r103, r104);
    }

    public static /* synthetic */ void g(LynxEngineProxy r100, long r101, String r102, ByteBuffer r103, int r104, long r105) {
        r100.nativeSendMultiTouchEvent(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void h(LynxEngineProxy r100, long r101, String r102, int r103, ByteBuffer r104, int r105, String r106) {
        r100.nativeSendCustomEvent(r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void i(LynxEngineProxy r100, long r101, String r102, int r103, int r104, ByteBuffer r105, int r106) {
        r100.nativeSendGestureEvent(r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void f(LynxEngineProxy r100, long r101, String r102, int r103, float r104, float r105, float r106, float r107, float r108, float r110, long r111) {
        r100.nativeSendTouchEvent(r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
    }
}
