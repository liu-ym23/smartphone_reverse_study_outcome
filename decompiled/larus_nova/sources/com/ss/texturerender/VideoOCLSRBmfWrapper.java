package com.ss.texturerender;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Bundle;
import android.os.SystemClock;
import com.heytap.mcssdk.constant.b;
import com.ss.texturerender.modeldownload.ModelDownloadTaskEnum;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import lc4.c;
import lc4.d;
import lc4.g;
import lc4.h;
import lc4.i;
import mc4.a;

/* JADX INFO: loaded from: classes40.dex */
public class VideoOCLSRBmfWrapper extends VideoOCLSRBaseWrapper {
    public static final int ASYC_INIT_DOWNLOADING = 200010;
    private static final int ASYNC_INIT_STATUS_INITING = 1;
    private static final int ASYNC_INIT_STATUS_INIT_FAIL = 3;
    private static final int ASYNC_INIT_STATUS_INIT_SUCCESS = 2;
    private static final int ASYNC_INIT_STATUS_UNKONW = 0;
    private static final int HEIGHT_DEFAULT = 4096;
    private static final String VIDEO_OCLSR_CLASS_NAME = "com.bytedance.bmf_mods.VideoSuperResolution";
    private static final String VIDEO_OCLSR_COMPONENT_CLASS_NAME = "com.bytedance.bmf_mods_lite.VideoSuperResolution";
    private static final String VIDEO_OCLSR_PICO_CLASS_NAME = "com.bytedance.bmf_mods.VideoSRLut";
    private static final int WIDTH_DEFAULT = 4096;
    private int algType;
    private int bmflogCount;
    private int curr_height;
    private int curr_width;
    private Method mAsyncInitMethod;
    private volatile int mAsyncInitStatus;
    private Method mFreeMethod;
    private Method mGlInitMethod;
    private Method mInitMethod;
    private Method mInitMethod2;
    private Method mMultiScaleOesProcessMethod;
    private Method mMultiScaleProcessMethod;
    private MySRInitCallback mMySRInitCallback;
    private Method mProcessMethod;
    private Method mProcessOesMethod;
    private Method mProcessOesMethodWithYUV;
    private float mSRInitStartTime;
    private Object mSRObject;
    private volatile int mSupportSharpness;
    private int mTexType;
    private boolean mUseBmfComponent;
    private int oTextureId;
    private boolean useGL;

    public static class MySRInitCallback implements a {
        private final String LOG_TAG;
        private final WeakReference<VideoOCLSRBmfWrapper> mRef;

        public MySRInitCallback(VideoOCLSRBmfWrapper r100) {
            this.LOG_TAG = r100.LOG_TAG;
            this.mRef = new WeakReference(r100);
        }

        public void onInitResult(int r100, int r101) {
            VideoOCLSRBmfWrapper r102 = this.mRef.get();
            if (r102 != null) goto L6;
            TextureRenderLog.i(-1, this.LOG_TAG, "bmf on initResult fail vst is null");
            return;
        L6:
            r102.setSRInitReportInfo(r100);
            r102.onSRAsyncInitResult(r100, r101);
        }
    }

    private void _initObjAndMethod() {
    L43:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "VideoOCLSR get fail:" + e.toString());
        this.mSRObject = null;
        this.mInitMethod = null;
        this.mInitMethod2 = null;
        this.mGlInitMethod = null;
        this.mFreeMethod = null;
        this.mProcessMethod = null;
        this.mProcessOesMethod = null;
        return;
    L4:
        if (this.mUseBmfComponent == false) goto L7;
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_COMPONENT_CLASS_NAME);     // Catch: Exception -> L43
    L10:
        if (r100 != null) goto L12;
        return;
    L12:
        if (this.useGL == false) goto L14;
        Class<?> r110 = Integer.TYPE;     // Catch: Exception -> L43
        Class<?> r111 = Boolean.TYPE;     // Catch: Exception -> L43
        this.mGlInitMethod = r100.getDeclaredMethod("GlSrInit", new Class[]{String.class, r110, r111, r110, r110});     // Catch: Exception -> L43
        this.mProcessMethod = r100.getDeclaredMethod("Process", new Class[]{r110, r110, r110, r110, r111});     // Catch: Exception -> L43
    L20:
        if (this.useGL == false) goto L23;
    L38:
        this.mFreeMethod = r100.getDeclaredMethod("Free", new Class[0]);     // Catch: Exception -> L43
        if (this.useGL == false) goto L41;
        this.mSRObject = r100.newInstance();     // Catch: Exception -> L43
        return;
    L41:
        this.mSRObject = r100.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{TextureRenderManager.getManager().getContext()});     // Catch: Exception -> L43
        return;
    L23:
        if (this.mUseBmfComponent == false) goto L25;
        Class<?> r101 = Integer.TYPE;     // Catch: Exception -> L43
        Method r102 = r100.getDeclaredMethod("ProcessOesTexture", new Class[]{r101, r101, r101, float[].class, g.class, c.class, i.class, d.class});     // Catch: Exception -> L43
        this.mProcessOesMethod = r102;     // Catch: Exception -> L43
        this.mProcessOesMethodWithYUV = r102;     // Catch: Exception -> L43
        this.mMultiScaleOesProcessMethod = r102;     // Catch: Exception -> L43
        this.mMultiScaleProcessMethod = this.mProcessMethod;     // Catch: Exception -> L43
        goto L38
    L25:
        Class<?> r112 = Integer.TYPE;     // Catch: Exception -> L43
        this.mProcessOesMethod = r100.getDeclaredMethod("ProcessOesTexture", new Class[]{r112, r112, r112, float[].class, r112, r112, r112, r112, r112, Long.TYPE});     // Catch: Exception -> L43
        this.mProcessOesMethodWithYUV = r100.getDeclaredMethod("ProcessOesTexture", new Class[]{r112, r112, r112, float[].class, float[].class, float[].class, Boolean.TYPE});     // Catch: Exception -> L28
    L48:
        Class<?> r103 = Integer.TYPE;     // Catch: Exception -> L32
        this.mMultiScaleProcessMethod = r100.getDeclaredMethod("ProcessMultiScaleTexture", new Class[]{r103, r103, r103, r103, r103, r103, r103, r103, Long.TYPE, r103, r103});     // Catch: Exception -> L32
    L50:
        Class<?> r113 = Integer.TYPE;     // Catch: Exception -> L36
        this.mMultiScaleOesProcessMethod = r100.getDeclaredMethod("ProcessMultiScaleOesTexture", new Class[]{r113, r113, r113, float[].class, r113, r113, r113, r113, r113, Long.TYPE, r113, r113});     // Catch: Exception -> L36
    L36:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "getmethod error:" + e.toString() + ", old bmf version maybe");     // Catch: Exception -> L43
    L32:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "getmethod error:" + e.toString() + ", old bmf version maybe");     // Catch: Exception -> L43
    L28:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "getmethod error:" + e.toString() + ", old bmf version maybe");     // Catch: Exception -> L43
        goto L48
    L14:
        Class<?> r114 = Integer.TYPE;     // Catch: Exception -> L43
        this.mInitMethod = r100.getDeclaredMethod("Init", new Class[]{r114, r114, r114, r114, String.class, String.class, String.class, r114, r114});     // Catch: Exception -> L43
        this.mInitMethod2 = r100.getDeclaredMethod("Init", new Class[]{r114, r114, r114, r114, String.class, String.class, String.class, r114, r114, h.class});     // Catch: Exception -> L43
        if (this.mUseBmfComponent == false) goto L18;
        this.mProcessMethod = r100.getDeclaredMethod("ProcessTexture", new Class[]{r114, r114, r114, g.class, c.class, i.class});     // Catch: Exception -> L43
        this.mAsyncInitMethod = r100.getDeclaredMethod("Init", new Class[]{r114, r114, r114, r114, String.class, String.class, String.class, r114, r114, h.class, a.class});     // Catch: Exception -> L43
        goto L20
    L18:
        this.mProcessMethod = r100.getDeclaredMethod("ProcessTexture", new Class[]{r114, r114, r114, r114, r114, r114, r114, r114, Long.TYPE});     // Catch: Exception -> L43
        this.mAsyncInitMethod = null;     // Catch: Exception -> L43
        goto L20
    L7:
        if (this.useGL == false) goto L9;
        r100 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_PICO_CLASS_NAME);     // Catch: Exception -> L43
        goto L10
    L9:
        r100 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_CLASS_NAME);     // Catch: Exception -> L43
        goto L10
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public void ReleaseVideoOclSr() {
        Object r100 = this.mSRObject;
        if (r100 == null) goto L7;
        Method r101 = this.mFreeMethod;
        if (r101 == null) goto L7;
        _invokeMethod(r101, r100, new Object[0]);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "FreeVideoOclSr");
    L7:
        this.mAsyncInitStatus = 0;
        this.mSRObject = null;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int GetVideoOclSrOutput() {
        return this.oTextureId;
    }

    public VideoOCLSRBmfWrapper(int r100) {
        this(r100, false);
    }

    public void setSRInitReportInfo(int r100) {
        TextureRenderManager r101 = TextureRenderManager.getManager();
        if (r101 == null) goto L9;
        if (r100 != 0) goto L6;
        int r102 = 1;
    L7:
        float r103 = SystemClock.elapsedRealtime() - this.mSRInitStartTime;
        r101.setModelDownloadInfo(ModelDownloadTaskEnum.OCL_SR_BMF, r102, r103, r100);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setSRInitReportInfo: modelDownloadSuccessRate:" + r102 + ", status: " + r100 + ", modelDownloadCostTime: " + r103);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public VideoOCLSRBmfWrapper(int r100, boolean r101) {
        this.mSRObject = null;
        this.mInitMethod = null;
        this.mInitMethod2 = null;
        this.mGlInitMethod = null;
        this.mAsyncInitMethod = null;
        this.mProcessMethod = null;
        this.mProcessOesMethod = null;
        this.mMultiScaleProcessMethod = null;
        this.mMultiScaleOesProcessMethod = null;
        this.mProcessOesMethodWithYUV = null;
        this.mFreeMethod = null;
        this.useGL = false;
        this.bmflogCount = 0;
        this.oTextureId = -1;
        this.mTexType = -1;
        this.mUseBmfComponent = false;
        this.mAsyncInitStatus = 0;
        this.mSupportSharpness = 1;
        this.mMySRInitCallback = null;
        this.mSRInitStartTime = 0.0f;
        this.mTexType = r100;
        this.mUseBmfComponent = r101;
        if (DeviceManager.isVRDevice() == false) goto L5;
        this.useGL = true;
    L5:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "new VideoOCLSRBmfWrapper");
        _initObjAndMethod();
    }

    public void onSRAsyncInitResult(int r100, int r101) {
        this.mSupportSharpness = r101;
        if (r100 == 0) goto L5;
        this.mAsyncInitStatus = 3;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "bmf asyncinit fail:" + r100);
        return;
    L5:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "bmf asyncinit success:" + r101);
        this.mAsyncInitStatus = 2;
    }

    private Object _invokeMethod(Method r100, Object r101, Object... r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        return r100.invoke(r101, r102);
    L6:
        e = move-exception;
        e.printStackTrace();
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, e.toString());
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrProcess(int r110, int r210, int r211, boolean r212) {
        if (this.mSRObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L8:
        if (this.curr_width == r210) goto L10;
    L11:
        TexGLUtils.deleteTexture(this.oTextureId);
        this.curr_width = r210;
        this.curr_height = r211;
        if (this.algType != 0) goto L14;
        double r100 = 2.0d;
    L15:
        int r111 = (int) (((double) r210) * r100);
        int r112 = (int) (r100 * ((double) r211));
        if (DeviceManager.isVRDevice() == false) goto L18;
        this.oTextureId = TexGLUtils.genTexture(3553, 9728);
    L19:
        GLES20.glBindTexture(3553, this.oTextureId);
        if (this.useGL == false) goto L22;
        GLES30.glTexStorage2D(3553, 1, 32856, r111, r112);
    L37:
        Object r101 = _invokeMethod(this.mProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(this.oTextureId), Integer.valueOf(r210), Integer.valueOf(r211), Boolean.valueOf(r212)});     // Catch: Exception -> L26
    L28:
        if (r101 == null) goto L33;
        int r102 = this.bmflogCount;
        if (r102 < 100) goto L32;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess sucess");
        this.bmflogCount = 0;
        goto L33
    L32:
        this.bmflogCount = r102 + 1;
    L33:
        if (r101 != null) goto L36;
        return -1;
    L36:
        return ((Integer) r101).intValue();
    L26:
        e = move-exception;
        e.printStackTrace();
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "fatal bmf sr");
        r101 = null;
        goto L28
    L22:
        GLES20.glTexImage2D(3553, 0, 6408, r111, r112, 0, 6408, 5121, null);
        goto L37
    L18:
        this.oTextureId = TexGLUtils.genTexture(3553);
        goto L19
    L14:
        r100 = 1.5d;
        goto L15
    L10:
        if (this.curr_height == r211) goto L37;
    L5:
        if (this.mProcessMethod != null) goto L8;
        goto L6
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r110, int r111, boolean r112, int r113, int r114) {
        return InitVideoOclSr(r110, r111, r112, false, r113, r114, "", 0, 0, 0, "", "", null);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean glSrInit(String r100, int r101, boolean r102, int r103, int r104) {
        this.bmflogCount = 0;
        if (this.mSRObject != null) goto L5;
        _initObjAndMethod();
    L5:
        this.algType = r101;
        Object r105 = this.mSRObject;
        if (r105 == null) goto L10;
        Method r106 = this.mGlInitMethod;
        if (r106 == null) goto L10;
        Object r107 = _invokeMethod(r106, r105, new Object[]{"", Integer.valueOf(r101), Boolean.valueOf(r102), 4096, 4096});
    L11:
        if (r107 != null) goto L13;
        return false;
    L13:
        if (((Boolean) r107).booleanValue() == false) goto L17;
        return true;
    L17:
        return false;
    L10:
        r107 = null;
        goto L11
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int videoOclSrProcess(int r100, int r101, int r102, boolean r103, int r110) {
        if (this.mSRObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L21:
        Object r104 = _invokeMethod(this.mProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r100), Integer.valueOf(r110), Integer.valueOf(r101), Integer.valueOf(r102), Boolean.valueOf(r103)});     // Catch: Exception -> L10
    L12:
        if (r104 == null) goto L17;
        int r105 = this.bmflogCount;
        if (r105 < 100) goto L16;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess sucess");
        this.bmflogCount = 0;
        goto L17
    L16:
        this.bmflogCount = r105 + 1;
    L17:
        if (r104 != null) goto L20;
        return -1;
    L20:
        return ((Integer) r104).intValue();
    L10:
        e = move-exception;
        e.printStackTrace();
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "fatal bmf sr");
        r104 = null;
        goto L12
    L5:
        if (this.mProcessMethod != null) goto L21;
        goto L6
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int r110, int r111, int r210, float[] r211, float[] r212, float[] r213, boolean r214, Bundle r215) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L8;
    L9:
        _initObjAndMethod();
    L10:
        d r100 = new d(0);
        Object r101 = null;
        if (r215 != null) goto L13;
    L15:
        i r102 = null;
    L16:
        int r103 = this.algType;
        if (r103 == 12) goto L23;
        if (r103 == 14) goto L23;
        if (r103 == 16) goto L23;
    L26:
        if (r101 == null) goto L32;
        int r104 = ((Integer) r101).intValue();
        this.oTextureId = r104;
        int r105 = this.bmflogCount;
        if (r105 < 100) goto L31;
        if (r104 <= 0) goto L31;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess oes yuv sucess");
        this.bmflogCount = 0;
    L31:
        this.bmflogCount = r105 + 1;
    L32:
        if (r101 != null) goto L35;
        return -1;
    L35:
        return ((Integer) r101).intValue();
    L23:
        if (this.mUseBmfComponent == false) goto L25;
        r101 = _invokeMethod(this.mProcessOesMethodWithYUV, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r210), r211, null, null, r102, r100});
        goto L26
    L25:
        r101 = _invokeMethod(this.mProcessOesMethodWithYUV, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r210), r212, r213, r211, Boolean.valueOf(r214)});
        goto L26
    L13:
        if (r215.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L15;
        r102 = new i(r215.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL));
        goto L16
    L8:
        if (this.mProcessOesMethodWithYUV != null) goto L10;
        goto L9
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r110, int r111, boolean r112, String r113, int r114, int r210, int r211, String r212, String r213) {
        return InitVideoOclSr(r110, r111, r112, false, 4096, 4096, r113, r114, r210, r211, r212, r213, null);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoAsyncOclSr(String r110, int r111, boolean r112, boolean r210, int r211, int r212, String r213, int r214, int r215, int r216, String r217, String r218, Bundle r219) {
        if (this.mUseBmfComponent == true) goto L6;
        return false;
    L6:
        if (this.mAsyncInitStatus != 1) goto L8;
        return false;
    L8:
        if (this.mAsyncInitStatus != 2) goto L11;
        return false;
    L11:
        if (this.mSRObject != null) goto L13;
        _initObjAndMethod();
    L13:
        this.algType = r111;
        Object r100 = null;
        if (this.mSRObject != null) goto L16;
    L36:
        if (r100 != null) goto L38;
    L39:
        this.mAsyncInitStatus = 3;
    L40:
        if (r100 != null) goto L42;
        return false;
    L42:
        if (((Integer) r100).intValue() != 0) goto L47;
        return true;
    L47:
        return false;
    L38:
        if (((Integer) r100).intValue() >= 0) goto L40;
    L16:
        if (this.mMySRInitCallback != null) goto L18;
        this.mMySRInitCallback = new MySRInitCallback(this);
    L18:
        this.mSRInitStartTime = SystemClock.elapsedRealtime();
        if (r219 == null) goto L22;
        r219.getBoolean(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ALLOW_FALLBACK, false);
        int r101 = r219.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_SHARP_LEVELS, 0);
        h.a r113 = new h.a();
        r113.b(r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_HOST, ""), r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_ACCESSKEY, ""));
        ((HashMap) r113.f508426b).put("deviceId", r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_DEVIECEID, ""));
        ((HashMap) r113.f508426b).put(b.f276371u, r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_ID, ""));
        ((HashMap) r113.f508426b).put("appVersion", r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_VERSION, ""));
        r113.f508425a = r101;
        r219.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_SOURCE, 0);
        r219.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ADJUST_SHARPNESS, 0);
        r100 = r113.a();
    L22:
        if (r213 != null) goto L24;
    L26:
        Object r102 = _invokeMethod(this.mAsyncInitMethod, this.mSRObject, new Object[]{Integer.valueOf(r111), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), r217, "", r218, Integer.valueOf(r212), Integer.valueOf(r211), r100, this.mMySRInitCallback});
    L27:
        r100 = r102;
        if (r100 != null) goto L30;
    L32:
        if (r100 == null) goto L36;
        if (((Integer) r100).intValue() != 0) goto L36;
        this.mSupportSharpness = 15;
        this.mAsyncInitStatus = 2;
        setSRInitReportInfo(0);
        goto L36
    L30:
        if (((Integer) r100).intValue() != 200010) goto L32;
        this.mAsyncInitStatus = 1;
        goto L36
    L24:
        if (r213.length() <= 0) goto L26;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mInitWithLicenseMethod ".concat(r213));
        r102 = _invokeMethod(this.mAsyncInitMethod, this.mSRObject, new Object[]{Integer.valueOf(r111), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), r217, r213, r218, Integer.valueOf(r212), Integer.valueOf(r211), r100, this.mMySRInitCallback});
        goto L27
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r110, int r111, boolean r112, boolean r210, int r211, int r212, String r213, int r214, int r215, int r216, String r217, String r218, Bundle r219) {
        if (this.mSRObject != null) goto L5;
        _initObjAndMethod();
    L5:
        this.algType = r111;
        Object r100 = null;
        if (this.mSRObject != null) goto L8;
    L21:
        this.mAsyncInitStatus = 2;
        if (r100 != null) goto L24;
        return false;
    L24:
        if (((Integer) r100).intValue() != 0) goto L28;
        return true;
    L28:
        return false;
    L8:
        if (r219 == null) goto L11;
        r219.getBoolean(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ALLOW_FALLBACK);
        int r101 = r219.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_SHARP_LEVELS);
        h.a r102 = new h.a();
        r102.b(r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_HOST, ""), r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_ACCESSKEY, ""));
        ((HashMap) r102.f508426b).put("deviceId", r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_DEVIECEID, ""));
        ((HashMap) r102.f508426b).put(b.f276371u, r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_ID, ""));
        ((HashMap) r102.f508426b).put("appVersion", r219.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_VERSION, ""));
        r102.f508425a = r101;
        r219.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_SOURCE, 0);
        r219.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ADJUST_SHARPNESS, 0);
        r100 = r102.a();
    L11:
        if (r213 != null) goto L13;
    L18:
        if (r100 == null) goto L20;
        r100 = _invokeMethod(this.mInitMethod2, this.mSRObject, new Object[]{Integer.valueOf(r111), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), r217, "", r218, Integer.valueOf(r212), Integer.valueOf(r211), r100});
        goto L21
    L20:
        r100 = _invokeMethod(this.mInitMethod, this.mSRObject, new Object[]{Integer.valueOf(r111), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), r217, "", r218, Integer.valueOf(r212), Integer.valueOf(r211)});
        goto L21
    L13:
        if (r213.length() <= 0) goto L18;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mInitWithLicenseMethod ".concat(r213));
        if (r100 == null) goto L17;
        r100 = _invokeMethod(this.mInitMethod2, this.mSRObject, new Object[]{Integer.valueOf(r111), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), r217, r213, r218, Integer.valueOf(r212), Integer.valueOf(r211), r100});
        goto L21
    L17:
        r100 = _invokeMethod(this.mInitMethod, this.mSRObject, new Object[]{Integer.valueOf(r111), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), r217, r213, r218, Integer.valueOf(r212), Integer.valueOf(r211)});
        goto L21
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrProcess(int r110, int r111, int r112, boolean r210, int r211, int r212, int r213, int r214, int r215, long r216, int r217, int r218, Bundle r310) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L8;
    L9:
        _initObjAndMethod();
    L10:
        g r100 = new g(0);
        if (r310 != null) goto L13;
    L20:
        i r101 = null;
    L21:
        int r102 = this.algType;
        if (24 <= r102) goto L24;
    L26:
        boolean r103 = false;
    L27:
        if (r310 == null) goto L35;
        if (r310.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION) == false) goto L35;
        if (r103 == false) goto L35;
        r310.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION, 0);
        r310.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_THRESHOLD, 0.0f);
        r310.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_COEFF, 0.0f);
        r310.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_DISABLE_MVP_CVT, 0);
        if (r101 != null) goto L35;
        r101 = new i(null);
    L35:
        if (this.algType < 7) goto L37;
        c r104 = new c(0);
        if (this.mUseBmfComponent == false) goto L43;
        Object r105 = _invokeMethod(this.mMultiScaleProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r112), r100, r104, r101});
    L44:
        if (r105 == null) goto L50;
        int r106 = ((Integer) r105).intValue();
        this.oTextureId = r106;
        int r107 = this.bmflogCount;
        if (r107 < 100) goto L49;
        if (r106 <= 0) goto L49;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess sucess, scale type: " + r218);
        this.bmflogCount = 0;
    L49:
        this.bmflogCount = r107 + 1;
    L50:
        if (r105 != null) goto L53;
        return -1;
    L53:
        return ((Integer) r105).intValue();
    L43:
        r105 = _invokeMethod(this.mMultiScaleProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r112), Integer.valueOf(r211), Integer.valueOf(r212), Integer.valueOf(r213), Integer.valueOf(r214), Integer.valueOf(r215), Long.valueOf(r216), Integer.valueOf(r217), Integer.valueOf(r218)});
        goto L44
    L37:
        if (this.mUseBmfComponent == false) goto L39;
        r105 = _invokeMethod(this.mProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r112), r100, null, r101});
        goto L44
    L39:
        r105 = _invokeMethod(this.mProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r112), Integer.valueOf(r211), Integer.valueOf(r212), Integer.valueOf(r213), Integer.valueOf(r214), Integer.valueOf(r215), Long.valueOf(r216)});
        goto L44
    L24:
        if (r102 > 31) goto L26;
        r103 = true;
        goto L27
    L13:
        if (r310.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L20;
        int r108 = r310.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
        if (r108 != (-1)) goto L17;
    L19:
        r101 = new i(r108);
        goto L21
    L17:
        if ((this.mSupportSharpness & r108) != 0) goto L19;
        r108 = 1;
        goto L19
    L8:
        if (this.mProcessMethod != null) goto L10;
        goto L9
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int r110, int r111, int r210, float[] r211, boolean r212, int r213, int r214, int r215, int r216, int r217, long r218, int r310, int r311, Bundle r312) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L8;
    L9:
        _initObjAndMethod();
    L10:
        g r100 = new g(0);
        if (r312 != null) goto L13;
    L20:
        i r101 = null;
    L22:
        if (this.algType < 7) goto L24;
        c r102 = new c(0);
        if (this.mUseBmfComponent == false) goto L30;
        Object r103 = _invokeMethod(this.mMultiScaleOesProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r210), r211, r100, r102, r101, null});
    L31:
        if (r103 == null) goto L35;
        int r104 = ((Integer) r103).intValue();
        this.oTextureId = r104;
        if (r104 <= 0) goto L35;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess oes sucess, scale type: " + r311);
    L35:
        if (r103 != null) goto L38;
        return -1;
    L38:
        return ((Integer) r103).intValue();
    L30:
        r103 = _invokeMethod(this.mMultiScaleOesProcessMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r210), r211, Integer.valueOf(r213), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), Integer.valueOf(r217), Long.valueOf(r218), Integer.valueOf(r310), Integer.valueOf(r311)});
        goto L31
    L24:
        if (this.mUseBmfComponent == false) goto L26;
        r103 = _invokeMethod(this.mProcessOesMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r210), r211, r100, null, r101, null});
        goto L31
    L26:
        r103 = _invokeMethod(this.mProcessOesMethod, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r210), r211, Integer.valueOf(r213), Integer.valueOf(r214), Integer.valueOf(r215), Integer.valueOf(r216), Integer.valueOf(r217), Long.valueOf(r218)});
        goto L31
    L13:
        if (r312.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L20;
        int r105 = r312.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
        if (r105 != (-1)) goto L17;
    L19:
        r101 = new i(r105);
        goto L22
    L17:
        if ((this.mSupportSharpness & r105) != 0) goto L19;
        r105 = 1;
        goto L19
    L8:
        if (this.mProcessOesMethod != null) goto L10;
        goto L9
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int r110, int r111, int r112, float[] r113, float[] r114, float[] r210, boolean r211, int r212, int r213, int r214, int r215, int r216, long r217, int r218, Bundle r310) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L8;
    L9:
        _initObjAndMethod();
    L10:
        g r100 = new g(0);
        d r101 = new d(0);
        c r102 = new c(0);
        Object r103 = null;
        if (r310 != null) goto L13;
    L15:
        i r115 = null;
    L16:
        int r104 = this.algType;
        if (24 <= r104) goto L19;
    L21:
        boolean r105 = false;
    L22:
        if (r310 != null) goto L24;
    L29:
        int r106 = this.algType;
        if (r106 == 15) goto L47;
        if (r106 == 17) goto L47;
        if (r106 == 18) goto L47;
        if (r106 == 19) goto L47;
        if (r106 == 20) goto L47;
        if (r106 == 21) goto L47;
        if (r106 == 22) goto L47;
        if (r106 == 23) goto L47;
        if (r105 == true) goto L47;
    L51:
        if (r103 == null) goto L57;
        int r107 = ((Integer) r103).intValue();
        this.oTextureId = r107;
        int r108 = this.bmflogCount;
        if (r108 < 100) goto L56;
        if (r107 <= 0) goto L56;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "bmfTextureProcess oes success, algType:" + this.algType);
        this.bmflogCount = 0;
    L56:
        this.bmflogCount = r108 + 1;
    L57:
        if (r103 != null) goto L60;
        return -1;
    L60:
        return ((Integer) r103).intValue();
    L47:
        if (this.mUseBmfComponent == false) goto L51;
        Method r109 = this.mProcessOesMethod;
        if (r109 == null) goto L51;
        r103 = _invokeMethod(r109, this.mSRObject, new Object[]{Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r112), r113, r100, r102, r115, r101});
        goto L51
    L24:
        if (r310.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION) == false) goto L29;
        if (r105 == false) goto L29;
        r310.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION, 0);
        r310.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_THRESHOLD, 0.0f);
        r310.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_COEFF, 0.0f);
        r310.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_DISABLE_MVP_CVT, 0);
        if (r115 != null) goto L29;
        r115 = new i(null);
        goto L29
    L19:
        if (r104 > 31) goto L21;
        r105 = true;
        goto L22
    L13:
        if (r310.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L15;
        r115 = new i(r310.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL));
        goto L16
    L8:
        if (this.mProcessOesMethod != null) goto L10;
        goto L9
    }
}
