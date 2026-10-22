package com.ss.ugc.effectplatform.util;

import android.os.Build;
import bytekn.foundation.logger.Logger;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EGL10 f458027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EGLDisplay f458028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EGLConfig f458029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EGLSurface f458030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EGLContext f458031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GL10 f458032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EGLContext f458033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f458034h;

    public static final class a {
    }

    static {
    }

    public final void b() {
        EGL10 r100 = this.f458027a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f458034h == true) goto L8;
        EGLDisplay r101 = this.f458028b;
        EGLSurface r102 = EGL10.EGL_NO_SURFACE;
        r100.eglMakeCurrent(r101, r102, r102, EGL10.EGL_NO_CONTEXT);
        r100.eglDestroySurface(this.f458028b, this.f458030d);
        r100.eglDestroyContext(this.f458028b, this.f458031e);
        r100.eglTerminate(this.f458028b);
        return;
    L8:
        EGLDisplay r103 = this.f458028b;
        if (r103 == EGL10.EGL_NO_DISPLAY) goto L23;
        EGLSurface r104 = this.f458030d;
        if (r104 == null) goto L15;
        EGLSurface r105 = EGL10.EGL_NO_SURFACE;
        if (r104 == r105) goto L15;
        r100.eglMakeCurrent(r103, r105, r105, EGL10.EGL_NO_CONTEXT);
        r100.eglDestroySurface(this.f458028b, this.f458030d);
        this.f458030d = null;
    L15:
        EGLContext r106 = this.f458031e;
        if (r106 == null) goto L18;
        r100.eglDestroyContext(this.f458028b, r106);
        this.f458031e = null;
    L18:
        EGLDisplay r107 = this.f458028b;
        if (r107 == null) goto L24;
        r100.eglTerminate(r107);
        this.f458028b = null;
        return;
    L24:
        return;
    }

    public final void c() {
        int[] r100 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
        EGL r101 = EGLContext.getEGL();
        GL r102 = null;
        if ((r101 instanceof EGL10) == true) goto L5;
        r101 = null;
    L5:
        EGL10 r103 = (EGL10) r101;
        if (r103 == null) goto L43;
        EGLDisplay r104 = r103.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f458028b = r104;
        if (r104 != EGL10.EGL_NO_DISPLAY) goto L10;
        d("unable to get EGL10 display");
    L10:
        a(r103);
        if (r103.eglInitialize(this.f458028b, new int[2]) == true) goto L13;
        d("unable to initialize EGL10");
    L13:
        a(r103);
        int[] r105 = new int[1];
        if (r103.eglChooseConfig(this.f458028b, r100, null, 0, r105) == true) goto L16;
        d("eglChooseConfig failed");
    L16:
        a(r103);
        int r106 = r105[0];
        EGLConfig[] r110 = new EGLConfig[r106];
        if (r103.eglChooseConfig(this.f458028b, r100, r110, r106, r105) == true) goto L19;
        d("eglChooseConfig#2 failed");
    L19:
        a(r103);
        EGLConfig r107 = r110[0];
        this.f458029c = r107;
        if (r107 != null) goto L22;
        d("Unable to find a suitable EGLConfig");
    L22:
        EGLSurface r108 = r103.eglCreatePbufferSurface(this.f458028b, this.f458029c, new int[]{12375, 16, 12374, 16, 12344});
        this.f458030d = r108;
        if (r108 == EGL10.EGL_NO_SURFACE) goto L25;
        if (r108 == null) goto L25;
    L26:
        a(r103);
        EGLContext r109 = r103.eglCreateContext(this.f458028b, this.f458029c, this.f458033g, new int[]{12440, 2, 12344});
        this.f458031e = r109;
        if (r109 == EGL10.EGL_NO_CONTEXT) goto L29;
        if (r109 == null) goto L29;
    L30:
        a(r103);
        EGLDisplay r111 = this.f458028b;
        EGLSurface r112 = this.f458030d;
        if (r103.eglMakeCurrent(r111, r112, r112, this.f458031e) == true) goto L33;
        d("eglMakeCurrent failed");
    L33:
        a(r103);
        EGLContext r113 = this.f458031e;
        if (r113 == null) goto L36;
        GL r114 = r113.getGL();
    L38:
        if ((r114 instanceof GL10) == false) goto L41;
        r102 = r114;
    L41:
        this.f458032f = (GL10) r102;
        this.f458027a = r103;
        return;
    L36:
        r114 = null;
    L29:
        d("context was null");
    L25:
        d("surface was null");
        goto L26
    }

    public e() {
        this.f458033g = EGL10.EGL_NO_CONTEXT;
        String r100 = Build.MODEL;
        if (r100 == null) goto L5;
        String r101 = r100.toLowerCase();
    L6:
        this.f458034h = Intrinsics.areEqual("mi play", r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void a(EGL10 r100) {
        int r101 = r100.eglGetError();
        if (r101 == 12288) goto L6;
        d("EGL error: 0x" + Integer.toHexString(r101));
        return;
    }

    public final void d(String r100) {
        if (this.f458034h == true) goto L7;
        Logger.e$default(Logger.INSTANCE, "EGLUtils", "get gpu info error:" + r100, null, 4, null);
        return;
    L7:
        throw new RuntimeException(r100);
    }
}
