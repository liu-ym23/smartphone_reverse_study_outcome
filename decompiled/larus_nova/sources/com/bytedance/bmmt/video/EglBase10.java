package com.bytedance.bmmt.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: classes8.dex */
class EglBase10 implements EglBase {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final String TAG = "EglBase10";
    private static int egl10ContextCount;
    private final EGL10 egl;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;

    public static class Context implements EglBase.Context {
        private final EGLContext eglContext;

        public static /* bridge */ /* synthetic */ EGLContext a(Context r100) {
            return r100.eglContext;
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public android.opengl.EGLContext getEgl14Context() {
            return null;
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public int getGLESVersion() {
            return 2;
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public long getNativeEglContext() {
            return 0;
        }

        public Context(EGLContext r100) {
            this.eglContext = r100;
        }
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public android.opengl.EGLDisplay getDisplay() {
        return null;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int getGLESVersion() {
        return 2;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public android.opengl.EGLSurface getSurface() {
        return null;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int surfaceHeight() {
        int[] r100 = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, r100);
        return r100[0];
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int surfaceWidth() {
        int[] r100 = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, r100);
        return r100[0];
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == EGL10.EGL_NO_DISPLAY) goto L10;
        if (this.eglContext == EGL10.EGL_NO_CONTEXT) goto L10;
        if (this.eglConfig == null) goto L10;
        return;
    L10:
        throw new RuntimeException("This object has been released");
    }

    private void eglDetachCurrent() {
        EGL10 r100 = this.egl;
        EGLDisplay r101 = this.eglDisplay;
        EGLSurface r102 = EGL10.EGL_NO_SURFACE;
        if (r100.eglMakeCurrent(r101, r102, r102, EGL10.EGL_NO_CONTEXT) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    private void eglMakeCurrent() {
        EGL10 r100 = this.egl;
        EGLDisplay r101 = this.eglDisplay;
        EGLSurface r102 = this.eglSurface;
        if (r100.eglMakeCurrent(r101, r102, r102, this.eglContext) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    private EGLDisplay getEglDisplay() {
        EGLDisplay r100 = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (r100 == EGL10.EGL_NO_DISPLAY) goto L10;
        if (this.egl.eglInitialize(r100, new int[2]) == false) goto L8;
        return r100;
    L8:
        throw new RuntimeException("Unable to initialize EGL10: 0x" + Integer.toHexString(this.egl.eglGetError()));
    L10:
        throw new RuntimeException("Unable to get EGL10 display: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    @Override // com.bytedance.bmmt.video.EglBase
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

    @Override // com.bytedance.bmmt.video.EglBase
    public EglBase.Context getEglBaseContext() {
        return new Context(this.eglContext);
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public boolean hasSurface() {
        if (this.eglSurface == EGL10.EGL_NO_SURFACE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void releaseSurface() {
        EGLSurface r100 = this.eglSurface;
        if (r100 == EGL10.EGL_NO_SURFACE) goto L6;
        this.egl.eglDestroySurface(this.eglDisplay, r100);
        this.eglSurface = EGL10.EGL_NO_SURFACE;
        return;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == EGL10.EGL_NO_SURFACE) goto L17;
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

    @Override // com.bytedance.bmmt.video.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface();
        detachCurrent();
        EglBase.CC.eglContextDestoryStart();
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        EglBase.CC.eglContextDestoryEnd();
        this.egl.eglTerminate(this.eglDisplay);
        this.eglContext = EGL10.EGL_NO_CONTEXT;
        this.eglDisplay = EGL10.EGL_NO_DISPLAY;
        this.eglConfig = null;
        egl10ContextCount--;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void swapBuffers() {
        checkIsNotReleased();
        EGLSurface r100 = this.eglSurface;
        if (r100 == EGL10.EGL_NO_SURFACE) goto L17;
        if (EglBase.EglLock.enableEglLock == false) goto L14;
        Object r101 = EglBase.lock;
        monitor-enter(r101);
        this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        this.egl.eglSwapBuffers(this.eglDisplay, r100);
        return;
    L17:
        throw new RuntimeException("No EGLSurface - can't swap buffers");
    }

    private void createSurfaceInternal(Object r100) {
        if ((r100 instanceof SurfaceHolder) == false) goto L5;
    L9:
        checkIsNotReleased();
        if (this.eglSurface != EGL10.EGL_NO_SURFACE) goto L17;
        EGLSurface r101 = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, r100, new int[]{12344});
        this.eglSurface = r101;
        if (r101 == EGL10.EGL_NO_SURFACE) goto L15;
        return;
    L15:
        throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(this.egl.eglGetError()));
    L17:
        throw new RuntimeException("Already has an EGLSurface");
    L5:
        if ((r100 instanceof SurfaceTexture) == true) goto L9;
        throw new IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createSurface(final Surface r100) {
        createSurfaceInternal(new C1FakeSurfaceHolder(this, r100));
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void swapBuffers(long r100) {
        swapBuffers();
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createSurface(SurfaceTexture r100) {
        createSurfaceInternal(r100);
    }

    public EglBase10(Context r100, int[] r101) {
        this.eglSurface = EGL10.EGL_NO_SURFACE;
        this.egl = (EGL10) EGLContext.getEGL();
        EGLDisplay r102 = getEglDisplay();
        this.eglDisplay = r102;
        EGLConfig r103 = getEglConfig(r102, r101);
        this.eglConfig = r103;
        this.eglContext = createEglContext(r100, this.eglDisplay, r103);
    }

    private EGLConfig getEglConfig(EGLDisplay r100, int[] r110) {
        EGLConfig[] r101 = new EGLConfig[1];
        int[] r102 = new int[1];
        if (this.egl.eglChooseConfig(r100, r110, r101, 1, r102) == false) goto L14;
        if (r102[0] <= 0) goto L12;
        EGLConfig r103 = r101[0];
        if (r103 == null) goto L10;
        return r103;
    L10:
        throw new RuntimeException("eglChooseConfig returned null");
    L12:
        throw new RuntimeException("Unable to find any matching EGL config");
    L14:
        throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createPbufferSurface(int r100, int r101) {
        checkIsNotReleased();
        if (this.eglSurface != EGL10.EGL_NO_SURFACE) goto L10;
        EGLSurface r102 = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, r100, 12374, r101, 12344});
        this.eglSurface = r102;
        if (r102 == EGL10.EGL_NO_SURFACE) goto L8;
        return;
    L8:
        throw new RuntimeException("Failed to create pixel buffer surface with size " + r100 + "x" + r101 + ": 0x" + Integer.toHexString(this.egl.eglGetError()));
    L10:
        throw new RuntimeException("Already has an EGLSurface");
    }

    private EGLContext createEglContext(Context r100, EGLDisplay r101, EGLConfig r102) {
        if (r100 != null) goto L4;
    L8:
        int[] r103 = {EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
        if (r100 != null) goto L11;
        EGLContext r104 = EGL10.EGL_NO_CONTEXT;
    L12:
        Object r105 = EglBase.lock;
        monitor-enter(r105);
        EGLContext r106 = this.egl.eglCreateContext(r101, r102, r104, r103);     // Catch: Throwable -> L22
        monitor-exit(r105);     // Catch: Throwable -> L22
        if (r106 == EGL10.EGL_NO_CONTEXT) goto L21;
        egl10ContextCount++;
        return r106;
    L21:
        throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(this.egl.eglGetError()));
    L22:
        th = move-exception;
        throw th;
    L11:
        r104 = Context.a(r100);
        goto L12
    L4:
        if (Context.a(r100) != EGL10.EGL_NO_CONTEXT) goto L8;
        throw new RuntimeException("Invalid sharedContext");
    }
}
