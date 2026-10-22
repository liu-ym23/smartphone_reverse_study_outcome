package com.lynx.clay.embedding.engine.sharedimage;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import c5a.c;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes32.dex */
public class SurfaceTexturePlatformWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f380940a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f380941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap<SurfaceTexture, a> f380942c = null;

    public interface a {
        void a();
    }

    public SurfaceTexturePlatformWrapper() {
    }

    static {
        f380940a = new Object();
        f380942c = new WeakHashMap();
    }

    private static SurfaceTexture create() {
        SurfaceTexture r100 = new SurfaceTexture(0);
        r100.detachFromGLContext();
        return r100;
    }

    private static void destroy(SurfaceTexture r100) {
        a(r100, null);
        r100.release();
    }

    private static void detachFromGLContext(SurfaceTexture r100) {
        r100.detachFromGLContext();
    }

    private static void release(SurfaceTexture r100) {
        r100.release();
    }

    private static void updateTexImage(SurfaceTexture r100) {
        r100.updateTexImage();     // Catch: RuntimeException -> L12
        WeakHashMap<SurfaceTexture, a> r101 = f380942c;     // Catch: RuntimeException -> L12
        monitor-enter(r101);     // Catch: RuntimeException -> L12
        a r102 = r101.get(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        if (r102 == null) goto L18;
        r102.a();     // Catch: RuntimeException -> L12
        return;
    L18:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L12
    L12:
        e = move-exception;
        c.b("SurfaceTexturePlatformWrapper", "Error calling updateTexImage", e);
    }

    public static void a(SurfaceTexture r100, SurfaceTexture.OnFrameAvailableListener r101) {
        if (r101 == null) goto L15;
        Object r102 = f380940a;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (f380941b != null) goto L8;
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("ClaySurfaceTextureFrameAvailable");     // Catch: Throwable -> L12
        ThreadMethodProxy.start(r103);     // Catch: Throwable -> L12
        f380941b = new Handler(r103.getLooper());     // Catch: Throwable -> L12
    L8:
        Handler r104 = f380941b;     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        r100.setOnFrameAvailableListener(r101, r104);
        return;
    L15:
        r100.setOnFrameAvailableListener(r101);
    }

    private static void attachToGLContext(SurfaceTexture r100, int r101) {
        r100.attachToGLContext(r101);
    }

    private static void getTransformMatrix(SurfaceTexture r100, float[] r101) {
        r100.getTransformMatrix(r101);
    }

    private static void setFrameAvailableCallback(SurfaceTexture r100, long r101) {
        if (r101 != 0) goto L5;
        a(r100, null);
        return;
    L5:
        a(r100, new SurfaceTextureListener(r101));
    }

    private static void setDefaultBufferSize(SurfaceTexture r100, int r101, int r102) {
        r100.setDefaultBufferSize(r101, r102);
    }
}
