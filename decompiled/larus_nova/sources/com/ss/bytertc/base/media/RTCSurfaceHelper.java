package com.ss.bytertc.base.media;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class RTCSurfaceHelper {
    ConcurrentHashMap<String, Object> mSurfaceCallbackMap;
    final Object mSurfaceCallbackMapLock;
    Long mSurfaceHelperHandle;
    ConcurrentHashMap<String, Object> mViewMap;

    public static native void nativeSetRenderTarget(long r100, Surface r101, String r102, boolean r103);

    public void destroy() {
        Object r100 = this.mSurfaceCallbackMapLock;
        monitor-enter(r100);
        Iterator<Object> r101 = this.mSurfaceCallbackMap.values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        unRegisterSurfaceCallback(r101.next());     // Catch: Throwable -> L11
        goto L6
    L8:
        this.mSurfaceCallbackMap.clear();     // Catch: Throwable -> L11
        this.mViewMap.clear();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean checkIsOnMainThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public RTCSurfaceHelper(long r100) {
        this.mSurfaceCallbackMap = new ConcurrentHashMap();
        this.mViewMap = new ConcurrentHashMap();
        this.mSurfaceCallbackMapLock = new Object();
        this.mSurfaceHelperHandle = 0L;
        this.mSurfaceHelperHandle = Long.valueOf(r100);
    }

    private void unRegisterSurfaceCallback(Object r100) {
        if ((r100 instanceof RTCSurfaceTextureListener) == false) goto L6;
        ((RTCSurfaceTextureListener) r100).resetCallback();
        return;
    L6:
        if ((r100 instanceof RTCSurfaceViewListener) == false) goto L10;
        ((RTCSurfaceViewListener) r100).resetCallback();
        return;
    }

    public void registerRenderTargetView(View r100, String r101) {
        Object r102 = this.mSurfaceCallbackMapLock;
        monitor-enter(r102);
        boolean r103 = false;
        if (this.mSurfaceCallbackMap.containsKey(r101) == false) goto L8;
        unRegisterRenderTargetView(r101, false);     // Catch: Throwable -> L19
    L8:
        if (this.mViewMap.containsKey(r101) == true) goto L10;
    L12:
        r103 = true;
    L13:
        Object r104 = registerSurfaceCallback(r100, r101, r103);     // Catch: Throwable -> L19
        if (r104 == null) goto L16;
        this.mSurfaceCallbackMap.put(r101, r104);     // Catch: Throwable -> L19
    L16:
        this.mViewMap.put(r101, r100);     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
        return;
    L10:
        if (this.mViewMap.get(r101) != r100) goto L12;
    L19:
        th = move-exception;
        throw th;
    }

    public void unRegisterRenderTargetView(String r100, boolean r101) {
        Object r102 = this.mSurfaceCallbackMapLock;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mSurfaceCallbackMap.containsKey(r100) == false) goto L7;
        unRegisterSurfaceCallback(this.mSurfaceCallbackMap.get(r100));     // Catch: Throwable -> L13
        this.mSurfaceCallbackMap.remove(r100);     // Catch: Throwable -> L13
    L7:
        if (r101 == true) goto L9;
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L9:
        if (this.mViewMap.containsKey(r100) == false) goto L11;
        this.mViewMap.remove(r100);     // Catch: Throwable -> L13
        goto L11
    }

    private Object registerSurfaceCallback(Object r100, String r101, boolean r110) {
        if ((r100 instanceof SurfaceView) == false) goto L7;
        SurfaceView r102 = (SurfaceView) r100;
        RTCSurfaceViewListener r103 = new RTCSurfaceViewListener(r102, this.mSurfaceHelperHandle.longValue(), r101, r110);
        r102.getHolder().addCallback(r103);
        return r103;
    L7:
        if ((r100 instanceof TextureView) == false) goto L10;
        TextureView r104 = (TextureView) r100;
        RTCSurfaceTextureListener r105 = new RTCSurfaceTextureListener(r104, this.mSurfaceHelperHandle.longValue(), r101, r110);
        r104.setSurfaceTextureListener(r105);
        return r105;
    L10:
        return null;
    }
}
