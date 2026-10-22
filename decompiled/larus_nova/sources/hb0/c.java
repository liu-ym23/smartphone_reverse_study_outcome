package hb0;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.h f484433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.i f484434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.j f484435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EGLDisplay f484436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EGLConfig f484437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EGLContext f484438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EGLSurface f484439g;

    public final void b() {
        EGLSurface r100 = this.f484439g;
        if (r100 == null) goto L8;
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;
        if (r100 == r101) goto L9;
        EGL14.eglMakeCurrent(this.f484436d, r101, r101, EGL14.EGL_NO_CONTEXT);
        d.j r102 = this.f484435c;
        EGLDisplay r103 = this.f484436d;
        EGLSurface r104 = this.f484439g;
        ((d.g) r102).getClass();
        EGL14.eglDestroySurface(r103, r104);
        this.f484439g = null;
        return;
    L9:
        return;
    }

    public final boolean a(Object r100) {
        if (this.f484436d == null) goto L24;
        if (this.f484437e == null) goto L22;
        b();
        d.j r101 = this.f484435c;
        EGLDisplay r102 = this.f484436d;
        EGLConfig r103 = this.f484437e;
        ((d.g) r101).getClass();
        EGLSurface r104 = EGL14.eglCreateWindowSurface(r102, r103, r100, new int[]{12344}, 0);     // Catch: IllegalArgumentException -> L9
    L10:
        this.f484439g = r104;
        if (r104 != null) goto L13;
    L20:
        return false;
    L13:
        if (r104 == EGL14.EGL_NO_SURFACE) goto L20;
        if (EGL14.eglMakeCurrent(this.f484436d, r104, r104, this.f484438f) == true) goto L19;
        EGL14.eglGetError();
        return false;
    L19:
        return true;
    L9:
        r104 = null;
        goto L10
    L22:
        throw new RuntimeException("mEglConfig not initialized");
    L24:
        throw new RuntimeException("eglDisplay not initialized");
    }

    public final a c(a r110) {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        this.f484436d = r100;
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L25;
        int[] r101 = new int[2];
        if (EGL14.eglInitialize(r100, r101, 0, r101, 1) == false) goto L22;
        d.h r102 = this.f484433a;
        EGLDisplay r103 = this.f484436d;
        if (((d.a) r102).f484446a < 3) goto L9;
        int r104 = 68;
    L10:
        int[] r105 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, r104, 12344, 0, 12344};
        EGLConfig[] r106 = new EGLConfig[1];
        if (EGL14.eglChooseConfig(r103, r105, 0, r106, 0, 1, new int[1], 0) == true) goto L13;
        EGLConfig r107 = null;
    L14:
        this.f484437e = r107;
        d.i r108 = this.f484434b;
        EGLDisplay r109 = this.f484436d;
        EGLContext r111 = r110.f484432a;
        ((d.f) r108).getClass();
        EGLContext r112 = EGL14.eglCreateContext(r109, r107, r111, new int[]{12440, 2, 12344}, 0);
        this.f484438f = r112;
        if (r112 != null) goto L17;
    L20:
        this.f484438f = null;
        throw new RuntimeException(b.a("; createContext", EGL14.eglGetError()));
    L17:
        if (r112 == EGL14.EGL_NO_CONTEXT) goto L20;
        this.f484439g = null;
        a r113 = new a();
        r113.f484432a = this.f484438f;
        return r113;
    L13:
        r107 = r106[0];
        goto L14
    L9:
        r104 = 4;
        goto L10
    L22:
        this.f484436d = null;
        throw new RuntimeException("eglInitialize failed");
    L25:
        throw new RuntimeException("eglGetDisplay failed");
    }

    public c(d.h r100, d.i r101, d.j r102) {
        this.f484433a = r100;
        this.f484434b = r101;
        this.f484435c = r102;
    }
}
