package com.ss.ttm.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes40.dex */
public final class DummySurface extends Surface {
    public static final int CACHE_MODE_ALL = 0;
    public static final int CACHE_MODE_DYNAMIC_EXCEPTION = 1;
    public static final int CACHE_MODE_DYNAMIC_EXCEPTION_OTHER = 2;
    public static final int CACHE_MODE_FORBIDDEN_EXCEPTION = 3;
    public static final int CACHE_MODE_FORBIDDEN_EXCEPTION_OTHER = 4;
    public static final int EVENT_SETOUTPUTSSURFACE_EXCEPTION = 1;
    public static final int EVENT_SETOUTPUTSSURFACE_EXCEPTION_OTHER = 2;
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final int MAX_CAPACITY_CACHES = 2;
    private static int SetOutputSurfaceExceptionCounter = 0;
    private static volatile int SetOutputSurfaceExceptionLimit = 1;
    private static int SetOutputSurfaceExceptionOtherCounter = 0;
    private static volatile int SetOutputSurfaceExceptionOtherLimit = 1;
    private static final String TAG = "DummySurface";
    private static volatile int cacheMode;
    private static final ConcurrentLinkedQueue<DummySurface> caches = null;
    private static int secureMode;
    private static boolean secureModeInitialized;
    private static volatile boolean useDummySurfaceCaches;
    private volatile boolean cached;
    private boolean hasSetOutputSurfaceException;
    private boolean hasSetOutputSurfaceExceptionOther;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    /* JADX INFO: renamed from: com.ss.ttm.player.DummySurface$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DummySurfaceThread extends PthreadHandlerThreadV2 implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        private void releaseInternal() {
            EGLSurfaceTexture r100 = this.eglSurfaceTexture;
            if (r100 == null) goto L7;
            r100.release();
            return;
        L7:
            throw null;
        }

        public void release() {
            Handler r100 = this.handler;
            if (r100 == null) goto L7;
            r100.sendEmptyMessage(2);
            return;
        L7:
            throw null;
        }

        private void initInternal(int r100) {
            EGLSurfaceTexture r101 = this.eglSurfaceTexture;
            AnonymousClass1 r102 = null;
            if (r101 == null) goto L10;
            r101.init(r100);
            SurfaceTexture r103 = this.eglSurfaceTexture.getSurfaceTexture();
            if (r100 == 0) goto L7;
            boolean r104 = true;
        L8:
            this.surface = new DummySurface(this, r103, r104, r102);
            return;
        L7:
            r104 = false;
            goto L8
        L10:
            throw null;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            initInternal(r100.arg1);     // Catch: Throwable -> L18 Error -> L20 RuntimeException -> L29
            monitor-enter(this);
            notify();     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
        L56:
            return true;
        L15:
            th = move-exception;
            throw th;
        L20:
            e = move-exception;
            this.initError = e;     // Catch: Throwable -> L18
            monitor-enter(this);
            notify();     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L29:
            e = move-exception;
            this.initException = e;     // Catch: Throwable -> L18
            monitor-enter(this);
            notify();     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;
        L5:
            if (r101 == 2) goto L52;
            return true;
        L52:
            releaseInternal();     // Catch: Throwable -> L45
        L8:
            quit();
            return true;
        L18:
            th = move-exception;
            monitor-enter(this);
            notify();     // Catch: Throwable -> L42
            throw th;
        L42:
            th = move-exception;
            throw th;
        }

        public DummySurface init(int r100) {
            ThreadMethodProxy.start(this);
            Handler r101 = new Handler(getLooper(), this);
            this.handler = r101;
            this.eglSurfaceTexture = new EGLSurfaceTexture(r101);
            monitor-enter(this);
            boolean r102 = false;
            this.handler.obtainMessage(1, r100, 0).sendToTarget();     // Catch: Throwable -> L28
        L6:
            if (this.surface != null) goto L14;
            if (this.initException != null) goto L14;
            if (this.initError != null) goto L14;
            wait();     // Catch: InterruptedException -> L13 Throwable -> L28
        L13:
            r102 = true;
        L14:
            monitor-exit(this);     // Catch: Throwable -> L28
            if (r102 == false) goto L17;
            ThreadMethodProxy.currentThread().interrupt();
        L17:
            RuntimeException r103 = this.initException;
            if (r103 != null) goto L27;
            Error r104 = this.initError;
            if (r104 != null) goto L26;
            DummySurface r105 = this.surface;
            if (r105 == null) goto L25;
            return r105;
        L25:
            throw null;
        L26:
            throw r104;
        L27:
            throw r103;
        L28:
            th = move-exception;
            throw th;
        }
    }

    private static void assertApiLevel17OrHigher() {
    }

    static {
        caches = new ConcurrentLinkedQueue();
        useDummySurfaceCaches = false;
        cacheMode = 0;
    }

    private void releaseInternal() {
        super.release();
        DummySurfaceThread r100 = this.thread;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.threadReleased == true) goto L7;
        this.thread.release();     // Catch: Throwable -> L9
        this.threadReleased = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    @Override // android.view.Surface
    public void release() {
        boolean r100 = false;
        if (useDummySurfaceCaches == true) goto L5;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L15;
    L38:
        r100 = r101;
    L39:
        if (r100 == true) goto L43;
        releaseInternal();
        return;
    L43:
        if (this.cached == true) goto L46;
        caches.add(this);
        this.cached = true;
        return;
    L46:
        return;
    L15:
        if (cacheMode != 1) goto L20;
        if (this.hasSetOutputSurfaceException == true) goto L39;
    L20:
        if (cacheMode != 2) goto L25;
        if (this.hasSetOutputSurfaceExceptionOther == true) goto L39;
    L25:
        if (cacheMode != 3) goto L32;
        if (this.hasSetOutputSurfaceException == false) goto L32;
        int r102 = SetOutputSurfaceExceptionCounter + 1;
        SetOutputSurfaceExceptionCounter = r102;
        if (r102 < SetOutputSurfaceExceptionLimit) goto L38;
        useCaches(false);
    L32:
        if (cacheMode != 4) goto L38;
        if (this.hasSetOutputSurfaceExceptionOther == false) goto L38;
        int r103 = SetOutputSurfaceExceptionOtherCounter + 1;
        SetOutputSurfaceExceptionOtherCounter = r103;
        if (r103 < SetOutputSurfaceExceptionOtherLimit) goto L38;
        useCaches(false);
        goto L39
    L5:
        if (caches.size() > 2) goto L12;
        if (this.secure == true) goto L12;
        if (isValid() == false) goto L12;
        r101 = true;
        goto L13
    }

    private static int getSecureModeV24(Context r100) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
    L9:
        String r101 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        if (r101 != null) goto L13;
        return 0;
    L13:
        if (r101.contains(EXTENSION_PROTECTED_CONTENT) == true) goto L16;
        return 0;
    L16:
        if (r101.contains(EXTENSION_SURFACELESS_CONTEXT) == false) goto L18;
        return 1;
    L18:
        return 2;
    L5:
        if (SmEditTextLeakOpt.SAMSUNG.equals(Build.MANUFACTURER) == false) goto L7;
    L8:
        return 0;
    L7:
        if ("XT1650".equals(Build.MODEL) == false) goto L9;
        goto L8
    }

    public static synchronized boolean isSecureSupported(Context r100) {
        monitor-enter(DummySurface.class);
        boolean r101 = true;
        if (secureModeInitialized == false) goto L7;
    L11:
        if (secureMode != 0) goto L15;
        r101 = false;
    L15:
        monitor-exit(DummySurface.class);
        return r101;
    L7:
        if (Build.VERSION.SDK_INT >= 24) goto L9;
        int r102 = 0;
    L10:
        secureMode = r102;     // Catch: Throwable -> L17
        secureModeInitialized = true;     // Catch: Throwable -> L17
        goto L11
    L9:
        r102 = getSecureModeV24(r100);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static DummySurface newInstanceV17(boolean r100) {
        if (useDummySurfaceCaches == false) goto L10;
        if (r100 == true) goto L10;
        DummySurface r101 = caches.poll();
        if (r101 == null) goto L10;
        r101.cached = false;
        return r101;
    L10:
        return newInstanceV17Internal(r100);
    }

    private static DummySurface newInstanceV17Internal(boolean r100) {
        assertApiLevel17OrHigher();
        DummySurfaceThread r101 = new DummySurfaceThread();
        if (r100 == false) goto L5;
        int r102 = secureMode;
    L7:
        return r101.init(r102);
    L5:
        r102 = 0;
        goto L7
    }

    public static void useCaches(boolean r100) {
        useCaches(r100, 0);
    }

    public void addEvent(int r100) {
        if (r100 != 1) goto L5;
        this.hasSetOutputSurfaceException = true;
        this.hasSetOutputSurfaceExceptionOther = true;
        return;
    L5:
        if (r100 != 2) goto L11;
        this.hasSetOutputSurfaceExceptionOther = true;
        return;
    }

    public static void useCaches(boolean r100, int r101) {
        useCaches(r100, r101, SetOutputSurfaceExceptionLimit);
    }

    private DummySurface(DummySurfaceThread r100, SurfaceTexture r101, boolean r102) {
        super(r101);
        this.cached = false;
        this.hasSetOutputSurfaceException = false;
        this.hasSetOutputSurfaceExceptionOther = false;
        this.thread = r100;
        this.secure = r102;
    }

    public static void useCaches(boolean r100, int r101, int r102) {
        useDummySurfaceCaches = r100;
        cacheMode = r101;
        if (r101 != 3) goto L6;
        SetOutputSurfaceExceptionLimit = r102;
    L9:
        if (useDummySurfaceCaches == true) goto L15;
    L10:
        ConcurrentLinkedQueue<DummySurface> r103 = caches;
        if (r103.isEmpty() == true) goto L21;
        DummySurface r104 = r103.poll();
        if (r104 == null) goto L10;
        r104.release();
        goto L10
    L21:
        return;
    L15:
        return;
    L6:
        if (r101 != 4) goto L9;
        SetOutputSurfaceExceptionOtherLimit = r102;
        goto L9
    }

    public /* synthetic */ DummySurface(DummySurfaceThread r100, SurfaceTexture r101, boolean r102, AnonymousClass1 r103) {
        this(r100, r101, r102);
    }
}
