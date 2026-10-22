package com.ss.android.ttve.common;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EGLContext f449836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EGLSurface f449837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EGLSurface f449838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EGLDisplay f449839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f449840e;

    public b() {
        this.f449836a = EGL14.EGL_NO_CONTEXT;
        EGLSurface r100 = EGL14.EGL_NO_SURFACE;
        this.f449837b = r100;
        this.f449838c = r100;
        this.f449839d = EGL14.EGL_NO_DISPLAY;
        this.f449840e = 2;
    }

    public final void c() {
        EGLContext r100 = EGL14.eglGetCurrentContext();
        this.f449836a = r100;
        if (r100.equals(EGL14.EGL_NO_CONTEXT) == false) goto L5;
        VELogUtil.e("TEEglStateSaver", "Saved EGL_NO_CONTEXT");
    L5:
        EGLSurface r101 = EGL14.eglGetCurrentSurface(12378);
        this.f449837b = r101;
        if (r101.equals(EGL14.EGL_NO_SURFACE) == false) goto L8;
        VELogUtil.e("TEEglStateSaver", "Saved EGL_NO_SURFACE");
    L8:
        EGLSurface r102 = EGL14.eglGetCurrentSurface(12377);
        this.f449838c = r102;
        if (r102.equals(EGL14.EGL_NO_SURFACE) == false) goto L11;
        VELogUtil.e("TEEglStateSaver", "Saved EGL_NO_SURFACE");
    L11:
        EGLDisplay r103 = EGL14.eglGetCurrentDisplay();
        this.f449839d = r103;
        int[] r104 = {2};
        EGL14.eglQueryContext(r103, this.f449836a, 12440, r104, 0);
        this.f449840e = r104[0];
        if (this.f449839d.equals(EGL14.EGL_NO_DISPLAY) == false) goto L15;
        VELogUtil.e("TEEglStateSaver", "Saved EGL_NO_DISPLAY");
        return;
    }

    public final int a() {
        return this.f449840e;
    }

    public final EGLContext b() {
        return this.f449836a;
    }
}
