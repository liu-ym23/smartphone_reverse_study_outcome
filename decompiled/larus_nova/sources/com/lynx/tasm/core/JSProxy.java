package com.lynx.tasm.core;

import com.lynx.jsbridge.RuntimeLifecycleListenerDelegate;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.ss.texturerender.VideoSurface;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes32.dex */
public class JSProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f383236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f383237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<LynxContext> f383238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f383239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReadWriteLock f383240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f383241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<Long, Object> f383242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f383243h;

    private native void nativeAddLifecycleListener(long r100, RuntimeLifecycleListenerDelegate r101);

    private native void nativeCallIntersectionObserver(long r100, int r101, int r102, long r103);

    private native void nativeCallJSApiCallbackWithValue(long r100, int r101, long r102);

    private native void nativeCallJSFunction(long r100, String r101, String r102, long r103);

    private native long nativeCreate(long r100, String r101);

    private native long nativeCreateWithRuntimeActor(long r100, String r101);

    private native void nativeDestroy(long r100, String r101);

    private static native void nativeEvaluateScript(long r100, String r101, byte[] r102, int r103);

    private static native void nativeRejectDynamicComponentLoad(long r100, String r101, int r102, int r103, String r104);

    private static native void nativeRunOnJSThread(long r100, Runnable r101);

    public final void f() {
        this.f383240e.writeLock().lock();
        long r100 = this.f383236a;
        if (r100 == 0) goto L5;
        nativeDestroy(r100, this.f383239d);
        this.f383236a = 0;
    L5:
        this.f383242g.clear();
        this.f383240e.writeLock().unlock();
    }

    private Object getArgs(long r100) {
        this.f383240e.writeLock().lock();
        Object r101 = this.f383242g.remove(Long.valueOf(r100));     // Catch: Throwable -> L6
        this.f383240e.writeLock().unlock();
        return r101;
    L6:
        th = move-exception;
        this.f383240e.writeLock().unlock();
        throw th;
    }

    private void setRuntimeId(long r100) {
        this.f383237b = r100;
    }

    public final void a(com.lynx.jsbridge.g r100) {
        if (r100 != null) goto L5;
        LLog.w("JSProxy", "add a null lifecycle listener.");
        return;
    L5:
        RuntimeLifecycleListenerDelegate r101 = new RuntimeLifecycleListenerDelegate(this.f383238c, r100);
        this.f383240e.readLock().lock();
        long r102 = this.f383236a;
        if (r102 == 0) goto L8;
        nativeAddLifecycleListener(r102, r101);
    L8:
        this.f383240e.readLock().unlock();
    }

    public final long g(Object r100) {
        HashMap<Long, Object> r101 = this.f383242g;
        long r102 = this.f383241f + 1;
        this.f383241f = r102;
        r101.put(Long.valueOf(r102), r100);
        return this.f383241f;
    }

    public final void h(Runnable r100) {
        this.f383240e.readLock().lock();
        long r101 = this.f383236a;
        if (r101 == 0) goto L5;
        nativeRunOnJSThread(r101, r100);
    L5:
        this.f383240e.readLock().unlock();
    }

    public JSProxy(LynxBackgroundRuntime r100, String r101) {
        this.f383240e = new ReentrantReadWriteLock();
        this.f383241f = 0;
        this.f383242g = new HashMap();
        this.f383243h = false;
        this.f383238c = new WeakReference(null);
        this.f383239d = r101;
        this.f383236a = nativeCreateWithRuntimeActor(r100.f381638f, r101);
    }

    public final void d(int r100, JavaOnlyMap r101) {
        ((ReentrantReadWriteLock) this.f383240e).writeLock().lock();
        long r102 = this.f383236a;
        if (r102 == 0) goto L5;
        nativeCallJSApiCallbackWithValue(r102, r100, g(r101));
    L5:
        int r103 = this.f383242g.size();
        ((ReentrantReadWriteLock) this.f383240e).writeLock().unlock();
        e(r103, "callJSApiCallbackWithValue");
    }

    public final void e(int r100, String r101) {
        if (this.f383243h == false) goto L5;
        return;
    L5:
        if (r100 <= 200) goto L13;
        WeakReference<LynxContext> r102 = this.f383238c;
        if (r102 == null) goto L14;
        this.f383243h = true;
        LynxContext r103 = r102.get();
        if (r103 == null) goto L15;
        r103.handleLynxError(new LynxError(VideoSurface.SUPER_RES_STAT_BMF_PACKAGE_SR_LL_V2_1, "Calling [" + r101 + "] too frequently.This may cause OOM issues."));
        return;
    L15:
        return;
    L14:
        return;
    }

    public JSProxy(long r100, WeakReference<LynxContext> r101, String r102) {
        this.f383240e = new ReentrantReadWriteLock();
        this.f383241f = 0;
        this.f383242g = new HashMap();
        this.f383243h = false;
        this.f383238c = r101;
        this.f383239d = r102;
        this.f383236a = nativeCreate(r100, r102);
    }

    public final void b(String r100, String r110, JavaOnlyArray r111) {
        ((ReentrantReadWriteLock) this.f383240e).writeLock().lock();
        long r101 = this.f383236a;
        if (r101 == 0) goto L5;
        nativeCallJSFunction(r101, r100, r110, g(r111));
    L5:
        int r112 = this.f383242g.size();
        ((ReentrantReadWriteLock) this.f383240e).writeLock().unlock();
        e(r112, "callFunction:" + r100 + "." + r110);
    }

    public final void c(int r100, int r110, JavaOnlyMap r111) {
        ((ReentrantReadWriteLock) this.f383240e).writeLock().lock();
        long r101 = this.f383236a;
        if (r101 == 0) goto L5;
        nativeCallIntersectionObserver(r101, r100, r110, g(r111));
    L5:
        int r102 = this.f383242g.size();
        ((ReentrantReadWriteLock) this.f383240e).writeLock().unlock();
        e(r102, "callIntersectionObserver");
    }
}
