package com.ss.ttm.player;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    private static final int[] EGL_CONFIG_ATTRIBUTES = null;
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    public static final int SECURE_MODE_NONE = 0;
    public static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    public static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
    private EGLContext context;
    private EGLDisplay display;
    private final Handler handler;
    private EGLSurface surface;
    private SurfaceTexture texture;
    private final int[] textureIdHolder;

    /* JADX INFO: renamed from: com.ss.ttm.player.EGLSurfaceTexture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class GlException extends RuntimeException {
        private GlException(String r100) {
            super(r100);
        }

        public /* synthetic */ GlException(String r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SecureMode {
    }

    private static EGLDisplay getDefaultDisplay() {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        AnonymousClass1 r101 = null;
        if (r100 == null) goto L10;
        int[] r102 = new int[2];
        if (EGL14.eglInitialize(r100, r102, 0, r102, 1) == false) goto L8;
        return r100;
    L8:
        throw new GlException("eglInitialize failed", r101);
    L10:
        throw new GlException("eglGetDisplay failed", r101);
    }

    @Override // java.lang.Runnable
    public void run() {
        com_ss_ttm_player_EGLSurfaceTexture_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        EGL_CONFIG_ATTRIBUTES = new int[]{12352, 4, 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12344};
    }

    public void com_ss_ttm_player_EGLSurfaceTexture__run$___twin___() {
        SurfaceTexture r100 = this.texture;     // Catch: Exception -> L6
        if (r100 == null) goto L9;
        r100.updateTexImage();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public SurfaceTexture getSurfaceTexture() {
        SurfaceTexture r100 = this.texture;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw null;
    }

    public void release() {
        this.handler.removeCallbacks(this);
        SurfaceTexture r100 = this.texture;     // Catch: Throwable -> L21
        if (r100 == null) goto L6;
        r100.release();     // Catch: Throwable -> L21
        GLES20.glDeleteTextures(1, this.textureIdHolder, 0);     // Catch: Throwable -> L21
    L6:
        EGLDisplay r101 = this.display;
        if (r101 != null) goto L9;
    L11:
        EGLSurface r102 = this.surface;
        if (r102 != null) goto L14;
    L16:
        EGLContext r103 = this.context;
        if (r103 == null) goto L19;
        EGL14.eglDestroyContext(this.display, r103);
    L19:
        EGL14.eglReleaseThread();
        this.display = null;
        this.context = null;
        this.surface = null;
        this.texture = null;
        return;
    L14:
        if (r102.equals(EGL14.EGL_NO_SURFACE) == true) goto L16;
        EGL14.eglDestroySurface(this.display, this.surface);
        goto L16
    L9:
        if (r101.equals(EGL14.EGL_NO_DISPLAY) == true) goto L11;
        EGLDisplay r104 = this.display;
        EGLSurface r105 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r104, r105, r105, EGL14.EGL_NO_CONTEXT);
    L21:
        th = move-exception;
        EGLDisplay r106 = this.display;
        if (r106 != null) goto L25;
    L27:
        EGLSurface r107 = this.surface;
        if (r107 != null) goto L30;
    L32:
        EGLContext r108 = this.context;
        if (r108 == null) goto L35;
        EGL14.eglDestroyContext(this.display, r108);
    L35:
        EGL14.eglReleaseThread();
        this.display = null;
        this.context = null;
        this.surface = null;
        this.texture = null;
        throw th;
    L30:
        if (r107.equals(EGL14.EGL_NO_SURFACE) == true) goto L32;
        EGL14.eglDestroySurface(this.display, this.surface);
        goto L32
    L25:
        if (r106.equals(EGL14.EGL_NO_DISPLAY) == true) goto L27;
        EGLDisplay r109 = this.display;
        EGLSurface r110 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r109, r110, r110, EGL14.EGL_NO_CONTEXT);
        goto L27
    }

    public EGLSurfaceTexture(Handler r100) {
        this.handler = r100;
        this.textureIdHolder = new int[1];
    }

    private static EGLConfig chooseEGLConfig(EGLDisplay r110) {
        EGLConfig[] r100 = new EGLConfig[1];
        int[] r111 = new int[1];
        boolean r112 = EGL14.eglChooseConfig(r110, EGL_CONFIG_ATTRIBUTES, 0, r100, 0, 1, r111, 0);
        if (r112 == false) goto L10;
        if (r111[0] <= 0) goto L10;
        EGLConfig r101 = r100[0];
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw new GlException(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", new Object[]{Boolean.valueOf(r112), Integer.valueOf(r111[0]), r100[0]}), null);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ss_ttm_player_EGLSurfaceTexture_com_larus_apm_impl_protector_RunnableLancet_run(EGLSurfaceTexture r100) {
        r100.com_ss_ttm_player_EGLSurfaceTexture__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private static void generateTextureIds(int[] r100) {
        GLES20.glGenTextures(1, r100, 0);
        int r101 = GLES20.glGetError();
        if (r101 != 0) goto L6;
        return;
    L6:
        throw new GlException("glGenTextures failed. Error: " + Integer.toHexString(r101), null);
    }

    public void init(int r100) {
        EGLDisplay r101 = getDefaultDisplay();
        this.display = r101;
        EGLConfig r102 = chooseEGLConfig(r101);
        EGLContext r103 = createEGLContext(this.display, r102, r100);
        this.context = r103;
        this.surface = createEGLSurface(this.display, r102, r103, r100);
        generateTextureIds(this.textureIdHolder);
        SurfaceTexture r104 = new SurfaceTexture(this.textureIdHolder[0]);
        this.texture = r104;
        r104.setOnFrameAvailableListener(this);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r100) {
        this.handler.post(this);
    }

    private static EGLContext createEGLContext(EGLDisplay r100, EGLConfig r101, int r102) {
        if (r102 != 0) goto L4;
        int[] r103 = {12440, 2, 12344};
    L5:
        EGLContext r104 = EGL14.eglCreateContext(r100, r101, EGL14.EGL_NO_CONTEXT, r103, 0);
        if (r104 == null) goto L9;
        return r104;
    L9:
        throw new GlException("eglCreateContext failed", null);
    L4:
        r103 = new int[]{12440, 2, EGL_PROTECTED_CONTENT_EXT, 1, 12344};
        goto L5
    }

    private static EGLSurface createEGLSurface(EGLDisplay r100, EGLConfig r101, EGLContext r102, int r103) {
        AnonymousClass1 r104 = null;
        if (r103 != 1) goto L6;
        EGLSurface r105 = EGL14.EGL_NO_SURFACE;
    L12:
        if (EGL14.eglMakeCurrent(r100, r105, r105, r102) == false) goto L15;
        return r105;
    L15:
        throw new GlException("eglMakeCurrent failed", r104);
    L6:
        if (r103 != 2) goto L8;
        int[] r106 = {12375, 1, 12374, 1, EGL_PROTECTED_CONTENT_EXT, 1, 12344};
    L9:
        r105 = EGL14.eglCreatePbufferSurface(r100, r101, r106, 0);
        if (r105 != null) goto L12;
        throw new GlException("eglCreatePbufferSurface failed", r104);
    L8:
        r106 = new int[]{12375, 1, 12374, 1, 12344};
        goto L9
    }
}
