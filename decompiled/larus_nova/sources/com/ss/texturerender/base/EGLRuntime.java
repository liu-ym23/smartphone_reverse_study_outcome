package com.ss.texturerender.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.TextUtils;
import android.view.Surface;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.effect.EffectConfig;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class EGLRuntime {
    private final String LOG_TAG;
    public EGLConfig eglConfig;
    public EGLContext eglContext;
    public EGLDisplay eglDisplay;
    public EGLSurface eglDummySurface;
    private int mBitDepth;
    protected long mDrawingObjectId;
    private int mEGLContextClientVersion;
    private ErrorCallback mErrorCallback;
    private int mGLMajorVersion;
    private int mGLMinorVersion;
    private int mIsSupport2020PQ;
    protected volatile EGLConfig mSharedEglConfig;
    protected volatile EGLContext mSharedEglContext;
    private int mTexType;
    private boolean mUseGL3;

    public interface ErrorCallback {
        void onError(EGLRuntime r100, int r101, String r102);
    }

    private EGLConfig chooseEglConfig() {
        int r100 = 1;
        int[] r101 = new int[1];
        EGLConfig[] r110 = new EGLConfig[1];
        int[][] r111 = {getRGB10Attributes(), getRGB888Attributes(), getRGB565Attributes()};
        if (this.mBitDepth <= 8) goto L6;
        r100 = 0;
    L6:
        if (r100 >= 3) goto L14;
        if (EGL14.eglChooseConfig(this.eglDisplay, r111[r100], 0, r110, 0, 1, r101, 0) == false) goto L13;
        if (r101[0] <= 0) goto L13;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "chooseConfig:" + Arrays.toString(r111[r100]));
        return r110[0];
    L13:
        r100 = r100 + 1;
        goto L6
    L14:
        notifyEGLError(0, "eglChooseConfig failed");
        return null;
    }

    private EGLDisplay getDefaultDisplay() {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        if (r100 != null) goto L5;
        notifyEGLError(0, "egl get display failed");
    L5:
        int[] r101 = new int[2];
        if (EGL14.eglInitialize(r100, r101, 0, r101, 1) == true) goto L9;
        notifyEGLError(0, "eglInitialize failed");
        return null;
    L9:
        return r100;
    }

    private int[] getRGB10Attributes() {
        return new int[]{12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, TextureRenderKeys.EGL_COLOR_COMPONENT_TYPE_EXT, TextureRenderKeys.EGL_COLOR_COMPONENT_TYPE_FIXED_EXT, 12344};
    }

    private int[] getRGB565Attributes() {
        return new int[]{12352, 4, 12324, 5, 12323, 6, 12322, 5, 12344};
    }

    private int[] getRGB888Attributes() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344};
    }

    private boolean isSupportGL3() {
        boolean r100 = false;
        Context r101 = TextureRenderManager.getManager().getContext();     // Catch: Exception -> L14
        if (r101 == null) goto L16;
        ActivityManager r102 = (ActivityManager) r101.getSystemService("activity");     // Catch: Exception -> L14
        if (r102 == null) goto L16;
        ConfigurationInfo r103 = r102.getDeviceConfigurationInfo();     // Catch: Exception -> L14
        if (r103 == null) goto L16;
        if (r103.reqGlEsVersion < 196608) goto L12;
        r100 = true;
    L12:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "gles version: " + r103.reqGlEsVersion + ", isSupportGL3: " + r100);     // Catch: Exception -> L14
    L16:
        return r100;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private boolean isSupportGL3EGL() {
        EGLDisplay r100 = this.eglDisplay;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100 == EGL14.EGL_NO_DISPLAY) goto L16;
        int[] r110 = new int[1];
        if (EGL14.eglChooseConfig(r100, new int[]{12352, 64, 12344}, 0, new EGLConfig[1], 0, 1, r110, 0) == true) goto L11;
        return false;
    L11:
        if (r110[0] <= 0) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public void deinitEGL() {
        EGLDisplay r100 = this.eglDisplay;
        if (r100 != EGL14.EGL_NO_DISPLAY) goto L15;
        return;
    L15:
        EGLSurface r101 = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L14
        EGL14.eglMakeCurrent(r100, r101, r101, EGL14.EGL_NO_CONTEXT);     // Catch: Exception -> L14
        EGLSurface r102 = this.eglDummySurface;     // Catch: Exception -> L14
        if (r102 == EGL14.EGL_NO_SURFACE) goto L8;
        EGL14.eglDestroySurface(this.eglDisplay, r102);     // Catch: Exception -> L14
        this.eglDummySurface = EGL14.EGL_NO_SURFACE;     // Catch: Exception -> L14
    L8:
        EGLContext r103 = this.eglContext;     // Catch: Exception -> L14
        if (r103 == EGL14.EGL_NO_CONTEXT) goto L11;
        EGL14.eglDestroyContext(this.eglDisplay, r103);     // Catch: Exception -> L14
        this.eglContext = EGL14.EGL_NO_CONTEXT;     // Catch: Exception -> L14
    L11:
        EGL14.eglTerminate(this.eglDisplay);     // Catch: Exception -> L14
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;     // Catch: Exception -> L14
    L12:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "OpenGL deinit OK.");
    }

    public int isSupportBt2020PQ() {
        EGLDisplay r100 = this.eglDisplay;
        if (r100 != null) goto L6;
        return -1;
    L6:
        int r101 = this.mIsSupport2020PQ;
        if (r101 < 0) goto L9;
        return r101;
    L9:
        String r102 = EGL14.eglQueryString(r100, 12373);
        if (TextUtils.isEmpty(r102) == false) goto L12;
    L14:
        this.mIsSupport2020PQ = 0;
    L16:
        return this.mIsSupport2020PQ;
    L12:
        if (r102.contains("EGL_EXT_gl_colorspace_bt2020_pq") == false) goto L14;
        this.mIsSupport2020PQ = 1;
        goto L16
    }

    public int initEGL() {
        EGLDisplay r100 = getDefaultDisplay();
        this.eglDisplay = r100;
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (this.mSharedEglConfig == null) goto L8;
        this.eglConfig = this.mSharedEglConfig;
    L10:
        if (this.eglConfig != null) goto L13;
        return -1;
    L13:
        if (this.mSharedEglContext == null) goto L15;
        this.mEGLContextClientVersion = 3;
        this.eglContext = EGL14.eglCreateContext(this.eglDisplay, this.mSharedEglConfig, this.mSharedEglContext, new int[]{12440, 3, 12344}, 0);
    L17:
        if (this.eglContext != EGL14.EGL_NO_CONTEXT) goto L19;
        return -1;
    L19:
        EGLSurface r101 = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
        this.eglDummySurface = r101;
        if (r101 != null) goto L32;
    L23:
        notifyEGLError(0, "create eglCreatePbufferSurface failed");     // Catch: Exception -> L29
    L24:
        EGLDisplay r102 = this.eglDisplay;     // Catch: Exception -> L29
        EGLSurface r103 = this.eglDummySurface;     // Catch: Exception -> L29
        if (EGL14.eglMakeCurrent(r102, r103, r103, this.eglContext) == true) goto L27;
        notifyEGLError(0, "eglMakeCurrent failed");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        notifyEGLError(0, "create dummy env failed");
        return -1;
    L27:
        this.mGLMajorVersion = this.mEGLContextClientVersion;
        this.mGLMinorVersion = 0;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "gles version:" + this.mGLMajorVersion + "." + this.mGLMinorVersion);
        return 0;
    L32:
        if (r101 != EGL14.EGL_NO_SURFACE) goto L24;
    L15:
        this.eglContext = createContext(this.eglDisplay, this.eglConfig);
        goto L17
    L8:
        this.eglConfig = chooseEglConfig();
        goto L10
    }

    public long getDrawingObjectId() {
        return this.mDrawingObjectId;
    }

    public int getGLMajorVersion() {
        return this.mGLMajorVersion;
    }

    public int getGLMinorVersion() {
        return this.mGLMinorVersion;
    }

    public String toString() {
        return this.LOG_TAG;
    }

    public int clearSurface(Surface r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create window surface from " + r100);     // Catch: Exception -> L13
        EGLSurface r101 = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, r100, new int[]{12344}, 0);     // Catch: Exception -> L13
        if (r101 != EGL14.EGL_NO_SURFACE) goto L8;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create window surface failed" + GLUtils.getEGLErrorString(EGL14.eglGetError()));     // Catch: Exception -> L13
        return 0;
    L8:
        if (EGL14.eglMakeCurrent(this.eglDisplay, r101, r101, this.eglContext) == true) goto L11;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "make current failed = " + r101);     // Catch: Exception -> L13
        return 0;
    L11:
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);     // Catch: Exception -> L13
        GLES20.glClear(16384);     // Catch: Exception -> L13
        EGL14.eglSwapBuffers(this.eglDisplay, r101);     // Catch: Exception -> L13
        EGLDisplay r102 = this.eglDisplay;     // Catch: Exception -> L13
        EGLSurface r103 = this.eglDummySurface;     // Catch: Exception -> L13
        EGL14.eglMakeCurrent(r102, r103, r103, this.eglContext);     // Catch: Exception -> L13
        EGL14.eglDestroySurface(this.eglDisplay, r101);     // Catch: Exception -> L13
    L14:
        return 0;
    L13:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create current exception failed");
        goto L14
    }

    public boolean isCurrentObject(long r100) {
        if (this.mDrawingObjectId != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public void setBitDepth(int r100) {
        this.mBitDepth = r100;
    }

    public void setDrawingObjectId(long r100) {
        this.mDrawingObjectId = r100;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "setDrawingObjectId:" + this.mDrawingObjectId);
    }

    public void setUseGL3(boolean r100) {
        this.mUseGL3 = r100;
    }

    public EGLRuntime(int r100, ErrorCallback r101) {
        this.mIsSupport2020PQ = -1;
        this.mUseGL3 = false;
        this.mEGLContextClientVersion = 2;
        this.mGLMajorVersion = 2;
        this.mGLMinorVersion = 0;
        this.mBitDepth = 8;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mTexType = r100;
        this.mErrorCallback = r101;
    }

    private EGLContext createContext(EGLDisplay r100, EGLConfig r110) {
        if (EffectConfig.sEnableEGLCheckSupportGL3V == false) goto L5;
        boolean r101 = isSupportGL3EGL();
    L7:
        if (this.mUseGL3 == false) goto L10;
        if (r101 == false) goto L10;
        this.mEGLContextClientVersion = 3;
        int[] r102 = {12440, 3, 12344};
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "use GL3");
    L11:
        EGLContext r103 = EGL14.eglCreateContext(r100, r110, EGL14.EGL_NO_CONTEXT, r102, 0);
        if (r103 != EGL14.EGL_NO_CONTEXT) goto L14;
        notifyEGLError(0, "eglcreateContext failed");
    L14:
        return r103;
    L10:
        this.mEGLContextClientVersion = 2;
        r102 = new int[]{12440, 2, 12344};
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "use GL2");
        goto L11
    L5:
        r101 = isSupportGL3();
        goto L7
    }

    private void notifyEGLError(int r100, String r101) {
        ErrorCallback r102 = this.mErrorCallback;
        if (r102 == null) goto L6;
        r102.onError(this, r100, r101);
        return;
    }

    public EGLRuntime(int r100, ErrorCallback r101, EGLContext r102, EGLConfig r103) {
        this.mIsSupport2020PQ = -1;
        this.mUseGL3 = false;
        this.mEGLContextClientVersion = 2;
        this.mGLMajorVersion = 2;
        this.mGLMinorVersion = 0;
        this.mBitDepth = 8;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mTexType = r100;
        this.mErrorCallback = r101;
        this.mSharedEglContext = r102;
        this.mSharedEglConfig = r103;
    }
}
