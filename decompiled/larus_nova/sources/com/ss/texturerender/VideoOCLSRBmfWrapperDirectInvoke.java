package com.ss.texturerender;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.heytap.mcssdk.constant.b;
import com.ss.texturerender.modeldownload.ModelDownloadTaskEnum;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kc4.c;
import lc4.f;
import lc4.h;
import lc4.i;
import mc4.a;

/* JADX INFO: loaded from: classes40.dex */
public class VideoOCLSRBmfWrapperDirectInvoke extends VideoOCLSRBaseWrapper {
    public static final int ASYC_INIT_DOWNLOADING = 200010;
    private static final int ASYNC_INIT_STATUS_INITING = 1;
    private static final int ASYNC_INIT_STATUS_INIT_FAIL = 3;
    private static final int ASYNC_INIT_STATUS_INIT_SUCCESS = 2;
    private static final int ASYNC_INIT_STATUS_UNKONW = 0;
    private static final int HEIGHT_DEFAULT = 4096;
    private static final String VIDEO_OCLSR_COMPONENT_CLASS_NAME = "com.bytedance.bmf_mods_lite.VideoSuperResolution";
    private static final int WIDTH_DEFAULT = 4096;
    private int algType;
    private int bmflogCount;
    private volatile int mAsyncInitStatus;
    private MySRInitCallback mMySRInitCallback;
    private float mSRInitStartTime;
    private c mSRObject;
    private volatile int mSupportSharpness;
    private int mTexType;
    private int oTextureId;

    public static class MySRInitCallback implements a {
        private String LOG_TAG;
        private final WeakReference<VideoOCLSRBmfWrapperDirectInvoke> mRef;

        public MySRInitCallback(VideoOCLSRBmfWrapperDirectInvoke r100) {
            this.LOG_TAG = r100.LOG_TAG;
            this.mRef = new WeakReference(r100);
        }

        public void onInitResult(int r100, int r101) {
            VideoOCLSRBmfWrapperDirectInvoke r102 = this.mRef.get();
            if (r102 != null) goto L6;
            TextureRenderLog.i(-1, this.LOG_TAG, "bmf on initResult fail vst is null");
            return;
        L6:
            r102.setSRInitReportInfo(r100);
            r102.onSRAsyncInitResult(r100, r101);
        }
    }

    private void _initObjAndMethod() {
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_COMPONENT_CLASS_NAME);     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        this.mSRObject = (c) r100.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{TextureRenderManager.getManager().getContext()});     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "VideoOCLSR get fail:" + e.toString());
        this.mSRObject = null;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public void ReleaseVideoOclSr() {
        c r100 = this.mSRObject;
        if (r100 == null) goto L5;
        r100.Free();
    L5:
        this.mAsyncInitStatus = 0;
        this.mSRObject = null;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int GetVideoOclSrOutput() {
        return this.oTextureId;
    }

    public VideoOCLSRBmfWrapperDirectInvoke(int r100) {
        this.mSRObject = null;
        this.bmflogCount = 0;
        this.oTextureId = -1;
        this.mTexType = -1;
        this.mAsyncInitStatus = 0;
        this.mSupportSharpness = 1;
        this.mMySRInitCallback = null;
        this.mSRInitStartTime = 0.0f;
        this.mTexType = r100;
        TextureRenderLog.d(r100, this.LOG_TAG, "new VideoOCLSRBmfWrapperDirectInvoke");
        _initObjAndMethod();
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

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r110, int r111, boolean r112, int r113, int r114) {
        return InitVideoOclSr(r110, r111, r112, false, r113, r114, "", 0, 0, 0, "", "", null);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, Bundle r107) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L8;
        _initObjAndMethod();
    L8:
        if (r107 != null) goto L10;
    L12:
        int r108 = this.algType;
        if (r108 != 12) goto L15;
    L20:
        Integer r109 = Integer.valueOf(this.mSRObject.d());
    L21:
        if (r109 == null) goto L27;
        int r110 = r109.intValue();
        this.oTextureId = r110;
        int r111 = this.bmflogCount;
        if (r111 < 100) goto L26;
        if (r110 <= 0) goto L26;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "bmfTextureProcess oes yuv success, algType = " + this.algType);
        this.bmflogCount = 0;
    L26:
        this.bmflogCount = r111 + 1;
    L27:
        if (r109 != null) goto L30;
        return -1;
    L30:
        return r109.intValue();
    L15:
        if (r108 == 14) goto L20;
        if (r108 == 16) goto L20;
        r109 = null;
        goto L21
    L10:
        if (r107.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L12;
        r107.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
        goto L12
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r110, int r111, boolean r112, String r113, int r114, int r210, int r211, String r212, String r213) {
        return InitVideoOclSr(r110, r111, r112, false, 4096, 4096, r113, r114, r210, r211, r212, r213, null);
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrDirectDraw(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, long r108, int r110, Bundle r111, int[] r112) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L9;
        _initObjAndMethod();
    L9:
        if (this.mSRObject != null) goto L11;
        return -1;
    L11:
        if (r111 != null) goto L13;
    L17:
        int r109 = this.mSRObject.f();
        this.oTextureId = r109;
        if (r109 == 0) goto L20;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "Sr DirectDraw return unexpected code: " + r109 + ", algType: " + this.algType + ", scaleType: " + r110);
    L20:
        int r113 = this.bmflogCount;
        if (r113 < 100) goto L24;
        if (r109 != 0) goto L24;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "Sr DirectDraw successful, algType: " + this.algType + ", scaleType: " + r110);
        this.bmflogCount = 0;
    L25:
        return r109;
    L24:
        this.bmflogCount = r113 + 1;
        goto L25
    L13:
        if (r111.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L17;
        int r114 = r111.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
        if (r114 == (-1)) goto L17;
        int r115 = r114 & this.mSupportSharpness;
        goto L17
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoAsyncOclSr(String r100, int r101, boolean r102, boolean r103, int r104, int r105, String r106, int r107, int r108, int r110, String r111, String r112, Bundle r113) {
        if (this.mAsyncInitStatus != 1) goto L5;
        return false;
    L5:
        if (this.mAsyncInitStatus != 2) goto L8;
        return false;
    L8:
        if (this.mSRObject != null) goto L10;
        _initObjAndMethod();
    L10:
        this.algType = r101;
        if (this.mSRObject != null) goto L13;
        Integer r109 = null;
    L32:
        if (r109 != null) goto L34;
    L35:
        this.mAsyncInitStatus = 3;
    L36:
        if (r109 != null) goto L38;
        return false;
    L38:
        if (r109.intValue() != 0) goto L43;
        return true;
    L43:
        return false;
    L34:
        if (r109.intValue() >= 0) goto L36;
    L13:
        if (this.mMySRInitCallback != null) goto L15;
        this.mMySRInitCallback = new MySRInitCallback(this);
    L15:
        this.mSRInitStartTime = SystemClock.elapsedRealtime();
        if (r113 == null) goto L18;
        r113.getBoolean(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ALLOW_FALLBACK);
        int r114 = r113.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_SHARP_LEVELS);
        r113.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_AES_BOOST_FUSION, 0);
        h.a r115 = new h.a();
        r115.b(r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_HOST, ""), r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_ACCESSKEY, ""));
        ((HashMap) r115.f508426b).put("deviceId", r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_DEVIECEID, ""));
        ((HashMap) r115.f508426b).put(b.f276371u, r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_ID, ""));
        ((HashMap) r115.f508426b).put("appVersion", r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_VERSION, ""));
        r115.f508425a = r114;
        r113.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_SOURCE, 0);
        r115.f508427c = r113.getString(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_NAME, "");
        r113.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ADJUST_SHARPNESS, 0);
        r115.a();
    L18:
        if (r106 != null) goto L20;
    L22:
        r109 = Integer.valueOf(this.mSRObject.k());
    L23:
        if (r109 != null) goto L25;
    L27:
        if (r109 == null) goto L32;
        if (r109.intValue() != 0) goto L32;
        this.mSupportSharpness = 15;
        this.mAsyncInitStatus = 2;
        setSRInitReportInfo(0);
        goto L32
    L25:
        if (r109.intValue() != 200010) goto L27;
        this.mAsyncInitStatus = 1;
        goto L32
    L20:
        if (r106.length() <= 0) goto L22;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mInitWithLicenseMethod ".concat(r106));
        r109 = Integer.valueOf(this.mSRObject.a());
        goto L23
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public boolean InitVideoOclSr(String r100, int r101, boolean r102, boolean r103, int r104, int r105, String r106, int r107, int r108, int r110, String r111, String r112, Bundle r113) {
        if (this.mSRObject != null) goto L5;
        _initObjAndMethod();
    L5:
        this.algType = r101;
        Integer r109 = null;
        h r114 = null;
        if (this.mSRObject == null) goto L19;
        if (r113 == null) goto L9;
        r113.getBoolean(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ALLOW_FALLBACK);
        int r115 = r113.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_SHARP_LEVELS);
        r113.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_AES_BOOST_FUSION, 0);
        h.a r116 = new h.a();
        r116.b(r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_HOST, ""), r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_ACCESSKEY, ""));
        String r117 = r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_DEVIECEID, "");
        ((HashMap) r116.f508426b).put("deviceId", r117);
        String r118 = r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_ID, "");
        ((HashMap) r116.f508426b).put(b.f276371u, r118);
        String r119 = r113.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_VERSION, "");
        ((HashMap) r116.f508426b).put("appVersion", r119);
        r116.f508425a = r115;
        r113.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_SOURCE, 0);
        r116.f508427c = r113.getString(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_NAME, "");
        r113.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ADJUST_SHARPNESS, 0);
        r114 = r116.a();
    L9:
        if (r106 != null) goto L11;
    L16:
        if (r114 == null) goto L18;
        r109 = Integer.valueOf(this.mSRObject.j());
        goto L19
    L18:
        r109 = Integer.valueOf(this.mSRObject.a());
        goto L19
    L11:
        if (r106.length() <= 0) goto L16;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mInitWithLicenseMethod ".concat(r106));
        if (r114 == null) goto L15;
        r109 = Integer.valueOf(this.mSRObject.j());
        goto L19
    L15:
        r109 = Integer.valueOf(this.mSRObject.a());
    L19:
        this.mAsyncInitStatus = 2;
        if (r109 != null) goto L22;
        return false;
    L22:
        if (r109.intValue() != 0) goto L26;
        return true;
    L26:
        return false;
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrProcess(int r100, int r101, int r102, boolean r103, int r104, int r105, int r106, int r107, int r108, long r110, int r111, int r112, Bundle r113) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L8;
        _initObjAndMethod();
    L8:
        f r109 = null;
        if (r113 == null) goto L19;
        if (r113.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L19;
        int r114 = r113.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
        if (r114 != (-1)) goto L15;
    L17:
        new i(r114);
        goto L19
    L15:
        if ((this.mSupportSharpness & r114) != 0) goto L17;
        r114 = 1;
    L19:
        int r115 = this.algType;
        if (24 <= r115) goto L22;
    L24:
        boolean r116 = false;
    L25:
        float r117 = 0.0f;
        if (r113 == null) goto L32;
        if (r113.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION) == false) goto L32;
        if (r116 == false) goto L32;
        r113.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION, 0);
        r113.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_THRESHOLD, 0.0f);
        r113.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_COEFF, 0.0f);
        r113.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_DISABLE_MVP_CVT, 0);
    L32:
        if (this.algType >= 7) goto L34;
        Integer r118 = Integer.valueOf(this.mSRObject.c());
    L41:
        if (r118 == null) goto L54;
        int r119 = r118.intValue();
        this.oTextureId = r119;
        int r120 = this.bmflogCount;
        if (r120 < 100) goto L53;
        if (r119 <= 0) goto L53;
        int r121 = this.mTexType;
        String r122 = this.LOG_TAG;
        StringBuilder r123 = new StringBuilder("bmfTextureProcess success, algType:");
        r123.append(this.algType);
        r123.append(", scaleType:");
        r123.append(r112);
        r123.append(", simpleK:");
        if (r109 == null) goto L48;
        float r124 = r109.f508422a;
    L49:
        r123.append(r124);
        r123.append(", alpha:");
        if (r109 == null) goto L52;
        r117 = r109.f508423b;
    L52:
        r123.append(r117);
        TextureRenderLog.i(r121, r122, r123.toString());
        this.bmflogCount = 0;
        goto L54
    L48:
        r124 = 0.0f;
    L53:
        this.bmflogCount = r120 + 1;
    L54:
        if (r118 != null) goto L57;
        return -1;
    L57:
        return r118.intValue();
    L34:
        if (r113 != null) goto L36;
    L38:
        if (r109 == null) goto L40;
        r118 = Integer.valueOf(this.mSRObject.f());
        goto L41
    L40:
        r118 = Integer.valueOf(this.mSRObject.c());
        goto L41
    L36:
        if (r113.containsKey(TextureRenderKeys.KEY_IS_AES_BOOST_SIMPLE_K) == false) goto L38;
        float r125 = r113.getFloat(TextureRenderKeys.KEY_IS_AES_BOOST_SIMPLE_K, 1.0f);
        float r126 = r113.getFloat("alpha", 1.0f);
        f r127 = new f();
        r127.f508422a = r125;
        r127.f508423b = r126;
        r109 = r127;
        goto L38
    L22:
        if (r115 > 31) goto L24;
        r116 = true;
        goto L25
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int r100, int r101, int r102, float[] r103, boolean r104, int r105, int r106, int r107, int r108, int r110, long r111, int r112, int r113, Bundle r114) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L8;
        _initObjAndMethod();
    L8:
        if (r114 == null) goto L15;
        if (r114.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L15;
        int r109 = r114.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
        if (r109 == (-1)) goto L15;
        int r115 = r109 & this.mSupportSharpness;
    L15:
        if (this.algType >= 7) goto L17;
        Integer r116 = Integer.valueOf(this.mSRObject.d());
    L18:
        if (r116 == null) goto L24;
        int r117 = r116.intValue();
        this.oTextureId = r117;
        int r118 = this.bmflogCount;
        if (r118 < 100) goto L23;
        if (r117 <= 0) goto L23;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "bmfTextureProcess oes success, algType:" + this.algType + ", scaleType: " + r113);
        this.bmflogCount = 0;
    L23:
        this.bmflogCount = r118 + 1;
    L24:
        if (r116 != null) goto L27;
        return -1;
    L27:
        return r116.intValue();
    L17:
        r116 = Integer.valueOf(this.mSRObject.d());
        goto L18
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesProcess(int r110, int r111, int r112, float[] r113, float[] r114, float[] r115, boolean r116, int r210, int r211, int r212, int r213, int r214, long r215, int r216, Bundle r217) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L8;
        _initObjAndMethod();
    L8:
        Integer r100 = null;
        if (r217 != null) goto L11;
    L13:
        i r101 = null;
    L14:
        int r102 = this.algType;
        if (24 <= r102) goto L17;
    L19:
        boolean r103 = false;
    L20:
        float r104 = 0.0f;
        if (r217 != null) goto L23;
    L28:
        if (r217 != null) goto L30;
    L32:
        f r117 = null;
    L33:
        int r105 = this.algType;
        if (r105 != 15) goto L36;
    L50:
        c r106 = this.mSRObject;
        if (r106 == null) goto L55;
        if (r117 == null) goto L54;
        r100 = Integer.valueOf(r106.e());
        goto L55
    L54:
        r100 = Integer.valueOf(r106.d());
    L55:
        if (r100 == null) goto L72;
        int r107 = r100.intValue();
        this.oTextureId = r107;
        int r108 = this.bmflogCount;
        if (r108 < 100) goto L71;
        if (r107 <= 0) goto L71;
        int r109 = this.mTexType;
        String r118 = this.LOG_TAG;
        StringBuilder r119 = new StringBuilder("bmfTextureProcess oes success, algType:");
        r119.append(this.algType);
        r119.append(", scaleType:");
        r119.append(r216);
        r119.append(", sharpLevel:");
        if (r101 == null) goto L62;
        Object r120 = Integer.valueOf(r101.f508428a);
    L63:
        r119.append(r120);
        r119.append(", simpleK:");
        if (r117 == null) goto L66;
        float r121 = r117.f508422a;
    L67:
        r119.append(r121);
        r119.append(", alpha:");
        if (r117 == null) goto L70;
        r104 = r117.f508423b;
    L70:
        r119.append(r104);
        TextureRenderLog.i(r109, r118, r119.toString());
        this.bmflogCount = 0;
        goto L72
    L66:
        r121 = 0.0f;
        goto L67
    L62:
        r120 = "-1";
    L71:
        this.bmflogCount = r108 + 1;
    L72:
        if (r100 != null) goto L75;
        return -1;
    L75:
        return r100.intValue();
    L36:
        if (r105 == 17) goto L50;
        if (r105 == 18) goto L50;
        if (r105 == 19) goto L50;
        if (r105 == 20) goto L50;
        if (r105 == 21) goto L50;
        if (r105 == 22) goto L50;
        if (r105 == 23) goto L50;
        if (r103 == false) goto L55;
    L30:
        if (r217.containsKey(TextureRenderKeys.KEY_IS_AES_BOOST_SIMPLE_K) == false) goto L32;
        float r122 = r217.getFloat(TextureRenderKeys.KEY_IS_AES_BOOST_SIMPLE_K, 1.0f);
        float r123 = r217.getFloat("alpha", 1.0f);
        r117 = new f();
        r117.f508422a = r122;
        r117.f508423b = r123;
        goto L33
    L23:
        if (r217.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION) == false) goto L28;
        if (r103 == false) goto L28;
        r217.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION, 0);
        r217.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_THRESHOLD, 0.0f);
        r217.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_COEFF, 0.0f);
        r217.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_DISABLE_MVP_CVT, 0);
        if (r101 != null) goto L28;
        r101 = new i(null);
        goto L28
    L17:
        if (r102 > 31) goto L19;
        r103 = true;
        goto L20
    L11:
        if (r217.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L13;
        r101 = new i(r217.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL));
        goto L14
    }

    @Override // com.ss.texturerender.VideoOCLSRBaseWrapper
    public int VideoOclSrOesDirectDraw(int r100, int r110, int r111, float[] r112, float[] r113, float[] r114, boolean r115, int r116, int r117, int r118, int r119, int r210, long r211, int r212, Bundle r213, int[] r214) {
        if (this.mAsyncInitStatus == 2) goto L6;
        return -1;
    L6:
        if (this.mSRObject != null) goto L9;
        _initObjAndMethod();
    L9:
        if (this.mSRObject != null) goto L11;
        return -1;
    L11:
        if (r213 != null) goto L13;
    L15:
        int r101 = this.mSRObject.e();
        this.oTextureId = r101;
        int r102 = this.bmflogCount;
        if (r102 >= 100) goto L18;
        this.bmflogCount = r102 + 1;
    L23:
        return r101;
    L18:
        if (r101 != 0) goto L20;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "Sr OesDirectDraw oes successful, algType: " + this.algType + ", scaleType: " + r212);
    L21:
        this.bmflogCount = 0;
        goto L23
    L20:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "Sr OesDirectDraw return unexpected code: " + r101 + ", algType: " + this.algType + ", scaleType: " + r212);
        goto L21
    L13:
        if (r213.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L15;
        r213.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
        goto L15
    }
}
