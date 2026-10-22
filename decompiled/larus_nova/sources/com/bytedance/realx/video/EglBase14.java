package com.bytedance.realx.video;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.view.Surface;
import com.bytedance.realx.base.RXLogging;

/* JADX INFO: loaded from: classes21.dex */
public class EglBase14 implements EglBase {
    private static final int CURRENT_SDK_VERSION = 0;
    private static final int EGLExt_SDK_VERSION = 18;
    private static final String TAG = "EglBase14";
    private static int egl14ContextCount;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private int glesVersion;

    public static class Context implements EglBase.Context {
        private final EGLContext egl14Context;
        private final int glesVersion;

        @Override // com.bytedance.realx.video.EglBase.Context
        public long getNativeEglContext() {
            if (EglBase14.access$000() < 21) goto L6;
            return this.egl14Context.getNativeHandle();
        L6:
            return this.egl14Context.getHandle();
        }

        @Override // com.bytedance.realx.video.EglBase.Context
        public EGLContext getEgl14Context() {
            return this.egl14Context;
        }

        @Override // com.bytedance.realx.video.EglBase.Context
        public int getGLESVersion() {
            return this.glesVersion;
        }

        public Context(EGLContext r100) {
            this.egl14Context = r100;
            this.glesVersion = 2;
        }

        public static /* synthetic */ EGLContext access$100(Context r100) {
            return r100.egl14Context;
        }

        public Context(EGLContext r100, int r101) {
            this.egl14Context = r100;
            this.glesVersion = r101;
        }
    }

    private static EGLDisplay getEglDisplay() {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L10;
        int[] r101 = new int[2];
        if (EGL14.eglInitialize(r100, r101, 0, r101, 1) == false) goto L8;
        return r100;
    L8:
        throw new RuntimeException("Unable to initialize EGL14: 0x" + Integer.toHexString(EGL14.eglGetError()));
    L10:
        throw new RuntimeException("Unable to get EGL14 display: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // com.bytedance.realx.video.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // com.bytedance.realx.video.EglBase
    public int surfaceHeight() {
        int[] r100 = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, r100, 0);
        return r100[0];
    }

    @Override // com.bytedance.realx.video.EglBase
    public int surfaceWidth() {
        int[] r100 = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, r100, 0);
        return r100[0];
    }

    static {
        CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
        egl14ContextCount = 0;
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == EGL14.EGL_NO_DISPLAY) goto L10;
        if (this.eglContext == EGL14.EGL_NO_CONTEXT) goto L10;
        if (this.eglConfig == null) goto L10;
        return;
    L10:
        throw new RuntimeException("This object has been released");
    }

    private void eglDetachCurrent() {
        EGLDisplay r100 = this.eglDisplay;
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT) == false) goto L5;
        return;
    L5:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    private void eglMakeCurrent() {
        EGLDisplay r100 = this.eglDisplay;
        EGLSurface r101 = this.eglSurface;
        if (EGL14.eglMakeCurrent(r100, r101, r101, this.eglContext) == false) goto L5;
        return;
    L5:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    public static boolean isEGL14Supported() {
        if (CURRENT_SDK_VERSION < 18) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.realx.video.EglBase
    public void detachCurrent() {
        if (EglBase.EglLock.enableEglLock == false) goto L12;
        Object r100 = EglBase.lock;
        monitor-enter(r100);
        eglDetachCurrent();     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        eglDetachCurrent();
    }

    @Override // com.bytedance.realx.video.EglBase
    public Context getEglBaseContext() {
        return new Context(this.eglContext, this.glesVersion);
    }

    @Override // com.bytedance.realx.video.EglBase
    public boolean hasSurface() {
        if (this.eglSurface == EGL14.EGL_NO_SURFACE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.realx.video.EglBase
    public void releaseSurface() {
        EGLSurface r100 = this.eglSurface;
        if (r100 == EGL14.EGL_NO_SURFACE) goto L6;
        EGL14.eglDestroySurface(this.eglDisplay, r100);
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        return;
    }

    @Override // com.bytedance.realx.video.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == EGL14.EGL_NO_SURFACE) goto L17;
        if (EglBase.EglLock.enableEglLock == false) goto L14;
        Object r100 = EglBase.lock;
        monitor-enter(r100);
        eglMakeCurrent();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        eglMakeCurrent();
        return;
    L17:
        throw new RuntimeException("No EGLSurface - can't make current");
    }

    @Override // com.bytedance.realx.video.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface();
        detachCurrent();
        EglBase.CC.eglContextDestoryStart();
        EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        EglBase.CC.eglContextDestoryEnd();
        if (GlReleaseThreadByPass.isEglReleaseThreadByPass() == true) goto L5;
        EGL14.eglReleaseThread();
    L5:
        EGL14.eglTerminate(this.eglDisplay);
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglConfig = null;
        egl14ContextCount--;
        RXLogging.w(TAG, "EGL14 context destroy. current count is:" + egl14ContextCount);
    }

    @Override // com.bytedance.realx.video.EglBase
    public void swapBuffers() {
        checkIsNotReleased();
        EGLSurface r100 = this.eglSurface;
        if (r100 == EGL14.EGL_NO_SURFACE) goto L17;
        if (EglBase.EglLock.enableEglLock == false) goto L14;
        Object r101 = EglBase.lock;
        monitor-enter(r101);
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        EGL14.eglSwapBuffers(this.eglDisplay, r100);
        return;
    L17:
        throw new RuntimeException("No EGLSurface - can't swap buffers");
    }

    public static /* synthetic */ int access$000() {
        return CURRENT_SDK_VERSION;
    }

    @Override // com.bytedance.realx.video.EglBase
    public int getGLESVersion() {
        return this.glesVersion;
    }

    @Override // com.bytedance.realx.video.EglBase
    public /* bridge */ /* synthetic */ EglBase.Context getEglBaseContext() {
        return getEglBaseContext();
    }

    private void createSurfaceInternal(Object r100) {
        if ((r100 instanceof Surface) == false) goto L5;
    L9:
        checkIsNotReleased();
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) goto L17;
        EGLSurface r101 = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, r100, new int[]{12344}, 0);
        this.eglSurface = r101;
        if (r101 == EGL14.EGL_NO_SURFACE) goto L14;
        return;
    L14:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(EGL14.eglGetError()));
    L17:
        throw new RuntimeException("Already has an EGLSurface");
    L5:
        if ((r100 instanceof SurfaceTexture) == true) goto L9;
        throw new IllegalStateException("Input must be either a Surface or SurfaceTexture");
    }

    @Override // com.bytedance.realx.video.EglBase
    public void createSurface(SurfaceTexture r100) {
        createSurfaceInternal(r100);
    }

    @Override // com.bytedance.realx.video.EglBase
    public void swapBuffers(long r100) {
        checkIsNotReleased();
        EGLSurface r101 = this.eglSurface;
        if (r101 == EGL14.EGL_NO_SURFACE) goto L17;
        if (EglBase.EglLock.enableEglLock == false) goto L14;
        Object r102 = EglBase.lock;
        monitor-enter(r102);
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, r100);     // Catch: Throwable -> L11
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, r101, r100);
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        return;
    L17:
        throw new RuntimeException("No EGLSurface - can't swap buffers");
    }

    @Override // com.bytedance.realx.video.EglBase
    public void createSurface(Surface r100) {
        createSurfaceInternal(r100);
    }

    public EglBase14(Context r100, int[] r101) {
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.glesVersion = -1;
        init(EglBase.EglVersion.getPreferredEglVersion(), r100, r101);
    }

    private static EGLConfig getEglConfig(EGLDisplay r110, int[] r111) {
        EGLConfig[] r100 = new EGLConfig[1];
        int[] r101 = new int[1];
        if (EGL14.eglChooseConfig(r110, r111, 0, r100, 0, 1, r101, 0) == false) goto L14;
        if (r101[0] <= 0) goto L12;
        EGLConfig r112 = r100[0];
        if (r112 == null) goto L10;
        return r112;
    L10:
        throw new RuntimeException("eglChooseConfig returned null");
    L12:
        throw new RuntimeException("Unable to find any matching EGL config");
    L14:
        throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // com.bytedance.realx.video.EglBase
    public void createPbufferSurface(int r100, int r101) {
        checkIsNotReleased();
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) goto L10;
        EGLSurface r102 = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, r100, 12374, r101, 12344}, 0);
        this.eglSurface = r102;
        if (r102 == EGL14.EGL_NO_SURFACE) goto L7;
        return;
    L7:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("Failed to create pixel buffer surface with size " + r100 + "x" + r101 + ": 0x" + Integer.toHexString(EGL14.eglGetError()));
    L10:
        throw new RuntimeException("Already has an EGLSurface");
    }

    public EglBase14(int r100, Context r101, int[] r102) {
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.glesVersion = -1;
        init(r100, r101, r102);
    }

    private void init(int r100, Context r101, int[] r102) {
        this.glesVersion = r100;
        EGLDisplay r103 = getEglDisplay();
        this.eglDisplay = r103;
        EGLConfig r104 = getEglConfig(r103, r102);     // Catch: RuntimeException -> L5
        this.eglConfig = r104;     // Catch: RuntimeException -> L5
        this.eglContext = createEglContext(r101, r100, this.eglDisplay, r104);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        if (r100 != 3) goto L10;
        RXLogging.w(TAG, "EGL14 GLES3 context create failed: " + e.toString() + ". trying falback to EGLS2");
        EGLConfig r105 = getEglConfig(this.eglDisplay, EglBase.CC.createModifiedEGLConfigArray(r102, 12352, 64, 4));
        this.eglConfig = r105;
        this.eglContext = createEglContext(r101, 2, this.eglDisplay, r105);
        return;
    L10:
        RXLogging.w(TAG, "EGL14 GLES context create failed.");
        throw e;
    }

    private static EGLContext createEglContext(Context r100, int r101, EGLDisplay r102, EGLConfig r103) {
        if (r100 != null) goto L4;
    L8:
        int[] r104 = {12440, r101, 12344};
        if (r100 != null) goto L11;
    L14:
        EGLContext r105 = EGL14.EGL_NO_CONTEXT;
    L15:
        Object r106 = EglBase.lock;
        monitor-enter(r106);
        EGLContext r107 = EGL14.eglCreateContext(r102, r103, r105, r104, 0);     // Catch: Throwable -> L25
        monitor-exit(r106);     // Catch: Throwable -> L25
        if (r107 == EGL14.EGL_NO_CONTEXT) goto L23;
        egl14ContextCount++;
        RXLogging.w(TAG, "EGL14 context create. current count is:" + egl14ContextCount);
        return r107;
    L23:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(EGL14.eglGetError()));
    L25:
        th = move-exception;
        throw th;
    L11:
        if (Context.access$100(r100) == null) goto L14;
        r105 = Context.access$100(r100);
        goto L15
    L4:
        if (Context.access$100(r100) != EGL14.EGL_NO_CONTEXT) goto L8;
        throw new RuntimeException("Invalid sharedContext");
    }
}
