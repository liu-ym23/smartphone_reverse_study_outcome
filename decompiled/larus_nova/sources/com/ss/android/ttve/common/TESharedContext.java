package com.ss.android.ttve.common;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes38.dex */
public class TESharedContext {
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final String LOG_TAG = "TESharedContext";
    private static int mBitsA = 8;
    private static int mBitsB = 8;
    private static int mBitsG = 8;
    private static int mBitsR = 8;
    private static boolean mUse10BitDepth;
    private EGLConfig mConfig;
    private EGLContext mContext;
    private EGLDisplay mDisplay;
    private EGLSurface mSurface;

    public static native void refEGLDisplay();

    public static native boolean unrefEGLDisplay();

    public static TESharedContext create() {
        return create(EGL14.EGL_NO_CONTEXT, 64, 64, 1, null, false);
    }

    public boolean doneCurrent() {
        EGLDisplay r100 = this.mDisplay;
        if (r100 != EGL14.EGL_NO_DISPLAY) goto L5;
        return false;
    L5:
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT) == true) goto L9;
        VELogUtil.e(LOG_TAG, "doneCurrent error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        return false;
    L9:
        return true;
    }

    public boolean makeCurrent() {
        EGLDisplay r100 = this.mDisplay;
        EGLSurface r101 = this.mSurface;
        if (EGL14.eglMakeCurrent(r100, r101, r101, this.mContext) == true) goto L6;
        checkEglError("eglMakeCurrent");
        return false;
    L6:
        VELogUtil.d(LOG_TAG, "java makeCurrent success 1");
        return true;
    }

    public void makeNoCurrent() {
        EGLDisplay r100 = this.mDisplay;
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT);
        checkEglError("makeNoCurrent");
    }

    public void release() {
        VELogUtil.i(LOG_TAG, "#### CGESharedGLContext Destroying context... ####");
        EGLDisplay r100 = this.mDisplay;
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L7;
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroyContext(this.mDisplay, this.mContext);
        EGL14.eglDestroySurface(this.mDisplay, this.mSurface);
        if (unrefEGLDisplay() == false) goto L7;
        EGL14.eglTerminate(this.mDisplay);
    L7:
        this.mDisplay = EGL14.EGL_NO_DISPLAY;
        this.mSurface = EGL14.EGL_NO_SURFACE;
        this.mContext = EGL14.EGL_NO_CONTEXT;
    }

    public void releaseSurface() {
        EGLDisplay r100 = this.mDisplay;
        if (r100 == null) goto L8;
        EGLSurface r101 = this.mSurface;
        if (r101 == null) goto L9;
        EGL14.eglDestroySurface(r100, r101);
        return;
    L9:
        return;
    }

    public boolean swapBuffers() {
        return EGL14.eglSwapBuffers(this.mDisplay, this.mSurface);
    }

    public TESharedContext() {
    }

    public EGLContext getContext() {
        return this.mContext;
    }

    public EGLDisplay getDisplay() {
        return this.mDisplay;
    }

    public EGLSurface getSurface() {
        return this.mSurface;
    }

    private void checkEglError(String r100) {
        int r101 = EGL14.eglGetError();
        if (r101 == 12288) goto L8;
        VELogUtil.e(LOG_TAG, r100 + ": EGL error: 0x" + Integer.toHexString(r101));
        if (r101 != 12294) goto L9;
        VELogUtil.e(LOG_TAG, "gl error EGL_BAD_CONTEXT");
        return;
    L9:
        return;
    }

    public void setPresentationTime(long r100) {
        EGLExt.eglPresentationTimeANDROID(this.mDisplay, this.mSurface, r100);
        checkEglError("eglPresentationTimeANDROID");
    }

    public static TESharedContext create(int r100, int r101) {
        return create(EGL14.EGL_NO_CONTEXT, r100, r101, 1, null, false);
    }

    public boolean ensureContextCurrent(EGLSurface r100, EGLContext r101) {
        EGLSurface r102 = EGL14.EGL_NO_SURFACE;
        if (r100 != r102) goto L6;
        r100 = this.mSurface;
    L6:
        if (r100 != r102) goto L9;
        VELogUtil.e(LOG_TAG, "ensureContextCurrent Invalid Surface!");
        return false;
    L9:
        EGLContext r103 = EGL14.EGL_NO_CONTEXT;
        if (r101 != r103) goto L12;
        r101 = this.mContext;
    L12:
        if (r101 != r103) goto L15;
        VELogUtil.e(LOG_TAG, "ensureContextCurrent Invalid Context!");
        return false;
    L15:
        VELogUtil.d(LOG_TAG, "ensureContextCurrent CurrentContext: " + EGL14.eglGetCurrentContext() + ", context: " + r101 + ", CurrentSurface: " + EGL14.eglGetCurrentSurface(12377) + ", surface: " + r100);
        if (EGL14.eglGetCurrentContext() != r101) goto L23;
        if (EGL14.eglGetCurrentSurface(12377) != r100) goto L23;
        VELogUtil.d(LOG_TAG, "ensureContextCurrent the context is already current");
        return false;
    L23:
        if (EGL14.eglMakeCurrent(this.mDisplay, r100, r100, r101) == false) goto L26;
        VELogUtil.d(LOG_TAG, "java makeCurrent success 2");
        return true;
    L26:
        VELogUtil.e(LOG_TAG, "ensureContextCurrent makeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
        return false;
    }

    public static TESharedContext create(EGLContext r100, int r101, Object r102) {
        return create(r100, 64, 64, r101, r102, false);
    }

    public static TESharedContext create(EGLContext r100, int r101, int r102) {
        return create(r100, r101, r102, 1, null, false);
    }

    public static void setContextColorBits(int r100, int r101, int r102, int r103) {
        mBitsR = r100;
        mBitsG = r101;
        mBitsB = r102;
        mBitsA = r103;
    }

    public boolean updateSurface(int r100, int r101, int r102, Object r103) {
        EGLDisplay r104 = this.mDisplay;
        if (r104 == null) goto L7;
        EGLSurface r105 = this.mSurface;
        if (r105 == null) goto L7;
        EGL14.eglDestroySurface(r104, r105);
    L7:
        int[] r106 = {12375, r100, 12374, r101, 12344};
        if (r102 == 2) goto L18;
        if (r102 != 4) goto L11;
    L14:
        int[] r107 = {12344};
        EGLDisplay r108 = this.mDisplay;
        EGLConfig r109 = this.mConfig;
        if (mUse10BitDepth == false) goto L17;
        r106 = r107;
    L17:
        this.mSurface = EGL14.eglCreateWindowSurface(r108, r109, r103, r106, 0);
    L20:
        if (this.mSurface != EGL14.EGL_NO_SURFACE) goto L24;
        checkEglError("eglCreateSurface");
        return false;
    L24:
        return makeCurrent();
    L11:
        if (r102 == 12610) goto L13;
        this.mSurface = EGL14.eglCreatePbufferSurface(this.mDisplay, this.mConfig, r106, 0);
        goto L20
    L13:
        r106[0] = 12344;
        r106[2] = 12344;
        goto L14
    L18:
        this.mSurface = EGL14.eglCreatePixmapSurface(this.mDisplay, this.mConfig, 0, r106, 0);
        goto L20
    }

    public static TESharedContext createReuseGLContext(EGLContext r110, EGLDisplay r111, EGLSurface r112, int r113, boolean r114) {
        TESharedContext r100 = new TESharedContext();
        r100.mContext = r110;
        r100.mDisplay = r111;
        r100.mSurface = r112;
        mUse10BitDepth = r114;
        if (r114 == false) goto L5;
        int r101 = 10;
    L7:
        if (r114 == false) goto L9;
        int r102 = 2;
    L10:
        int r103 = !r114 ? 1 : 0;
        int[] r104 = new int[13];
        r104[0] = 12324;
        r104[1] = r101;
        r104[2] = 12323;
        r104[3] = r101;
        int r115 = 4;
        r104[4] = 12322;
        r104[5] = r101;
        r104[6] = 12321;
        r104[7] = r102;
        r104[8] = 12352;
        if (r114 == false) goto L13;
        r115 = 64;
    L13:
        r104[9] = r115;
        r104[10] = 12610;
        r104[11] = r103;
        r104[12] = 12344;
        if (r113 != 12610) goto L16;
        r104[10] = 12610;
        r104[11] = 1;
    L16:
        EGLConfig[] r116 = new EGLConfig[1];
        EGL14.eglChooseConfig(r111, r104, 0, r116, 0, 1, new int[1], 0);
        r100.mConfig = r116[0];
        return r100;
    L9:
        r102 = mBitsA;
        goto L10
    L5:
        r101 = 8;
        goto L7
    }

    private boolean initEGL(EGLContext r210, int r211, int r212, int r213, Object r214) {
        if (r210 != null) goto L5;
        EGLContext r100 = EGL14.EGL_NO_CONTEXT;
    L6:
        int[] r101 = new int[3];
        r101[0] = 12440;
        boolean r102 = mUse10BitDepth;
        if (r102 == false) goto L9;
        int r103 = 3;
    L10:
        r101[1] = r103;
        r101[2] = 12344;
        if (r102 == false) goto L13;
        int r110 = 10;
    L14:
        if (r102 == false) goto L16;
        int r111 = 2;
    L17:
        int r112 = !r102 ? 1 : 0;
        int[] r104 = new int[13];
        r104[0] = 12324;
        r104[1] = r110;
        r104[2] = 12323;
        r104[3] = r110;
        r104[4] = 12322;
        r104[5] = r110;
        r104[6] = 12321;
        r104[7] = r111;
        r104[8] = 12352;
        if (r102 == false) goto L20;
        int r105 = 64;
    L21:
        r104[9] = r105;
        r104[10] = 12610;
        r104[11] = r112;
        r104[12] = 12344;
        if (r213 != 12610) goto L24;
        r104[10] = 12610;
        r104[11] = 1;
    L24:
        EGLConfig[] r113 = new EGLConfig[1];
        int[] r114 = new int[1];
        int[] r115 = {0, 1};
        int[] r106 = {12375, r211, 12374, r212, 12344};
        EGLDisplay r116 = EGL14.eglGetDisplay(0);
        this.mDisplay = r116;
        if (r116 != EGL14.EGL_NO_DISPLAY) goto L28;
        checkEglError("eglGetDisplay");
        return false;
    L28:
        int[] r117 = new int[2];
        if (r100.equals(EGL14.EGL_NO_CONTEXT) == true) goto L34;
        if (EGL14.eglQueryContext(this.mDisplay, r100, 12440, r117, 0) == false) goto L34;
        r101[1] = r117[0];
    L34:
        if (EGL14.eglInitialize(this.mDisplay, r115, 0, r115, 1) == true) goto L37;
        checkEglError("eglInitialize");
        return false;
    L37:
        refEGLDisplay();
        VELogUtil.i(LOG_TAG, String.format("eglInitialize - major: %d, minor: %d", new Object[]{Integer.valueOf(r115[0]), Integer.valueOf(r115[1])}));
        if (EGL14.eglChooseConfig(this.mDisplay, r104, 0, r113, 0, 1, r114, 0) == true) goto L41;
        checkEglError("eglChooseConfig");
        return false;
    L41:
        Object[] r107 = new Object[2];
        r107[0] = Integer.valueOf(r114[0]);
        if (r100 != EGL14.EGL_NO_CONTEXT) goto L44;
        String r108 = "NO";
    L45:
        r107[1] = r108;
        VELogUtil.i(LOG_TAG, String.format("Config num: %d, has sharedContext: %s", r107));
        EGLConfig r109 = r113[0];
        this.mConfig = r109;
        EGLContext r118 = EGL14.eglCreateContext(this.mDisplay, r109, r100, r101, 0);
        this.mContext = r118;
        if (r118 != EGL14.EGL_NO_CONTEXT) goto L49;
        checkEglError("eglCreateContext");
        return false;
    L49:
        if (r213 != 2) goto L51;
        this.mSurface = EGL14.eglCreatePixmapSurface(this.mDisplay, this.mConfig, 0, r106, 0);
    L62:
        if (this.mSurface != EGL14.EGL_NO_SURFACE) goto L66;
        checkEglError("eglCreateSurface");
        return false;
    L66:
        if (makeCurrent() == true) goto L68;
        return false;
    L68:
        int[] r119 = new int[1];
        EGL14.eglQueryContext(this.mDisplay, this.mContext, 12440, r119, 0);
        VELogUtil.i(LOG_TAG, "EGLContext created, client version " + r119[0] + ", mContext = " + this.mContext);
        return true;
    L51:
        if (r213 == 4) goto L55;
        if (r213 == 12610) goto L54;
        this.mSurface = EGL14.eglCreatePbufferSurface(this.mDisplay, this.mConfig, r106, 0);
        goto L62
    L54:
        int r120 = 12344;
        r106[0] = 12344;
        r106[2] = 12344;
    L56:
        int[] r121 = {r120};
        EGLDisplay r122 = this.mDisplay;
        EGLConfig r123 = this.mConfig;
        if (mUse10BitDepth == false) goto L59;
        r106 = r121;
    L59:
        this.mSurface = EGL14.eglCreateWindowSurface(r122, r123, r214, r106, 0);
        goto L62
    L55:
        r120 = 12344;
        goto L56
    L44:
        r108 = "YES";
        goto L45
    L20:
        r105 = 4;
        goto L21
    L16:
        r111 = mBitsA;
        goto L17
    L13:
        r110 = 8;
        goto L14
    L9:
        r103 = 2;
        goto L10
    L5:
        r100 = r210;
        goto L6
    }

    public static TESharedContext create(EGLContext r100, int r101, int r102, int r110, Object r111, boolean r112) {
        TESharedContext r103 = new TESharedContext();
        mUse10BitDepth = r112;
        if (r103.initEGL(r100, r101, r102, r110, r111) == true) goto L6;
        r103.release();
        return null;
    L6:
        return r103;
    }
}
