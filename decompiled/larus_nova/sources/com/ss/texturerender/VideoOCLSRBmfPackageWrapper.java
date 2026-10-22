package com.ss.texturerender;

import android.content.Context;
import android.os.Bundle;
import com.heytap.mcssdk.constant.b;
import java.util.HashMap;
import lc4.c;
import lc4.d;
import lc4.g;
import lc4.h;
import lc4.i;
import lc4.j;

/* JADX INFO: loaded from: classes40.dex */
public class VideoOCLSRBmfPackageWrapper {
    private static final String VIDEO_OCLSR_COMPONENT_CLASS_NAME = "com.bytedance.bmf_mods_lite.VideoSuperResolution";
    private final String LOG_TAG;
    private c mMultiScaleParams;
    private d mOesParams;
    private int mProcessCount;
    private int mProcessRet;
    private g mRoiParams;
    private kc4.c mSRObject;
    private i mSharpLevelParams;
    private j mSuperAlgParam;
    private final int mTexType;

    public void free() {
        kc4.c r100 = this.mSRObject;
        if (r100 == null) goto L6;
        r100.Free();
        this.mSRObject = null;
        return;
    }

    public VideoOCLSRBmfPackageWrapper(int r100) {
        this.mProcessCount = 0;
        this.mProcessRet = -1;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mTexType = r100;
    }

    public void giveBackBuffer(int r100) {
        kc4.c r101 = this.mSRObject;
        if (r101 != null) goto L6;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "give back buffer failed, no instance");
        return;
    L6:
        r101.g();
    }

    public int init(int r100, String r101, int r102, int r103) {
        kc4.c r104 = (kc4.c) TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_OCLSR_COMPONENT_CLASS_NAME).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{TextureRenderManager.getManager().getContext()});     // Catch: Exception -> L5
        this.mSRObject = r104;     // Catch: Exception -> L5
        return r104.l();
    L5:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "init super class failed, exp:" + e);
        this.mSRObject = null;
        return 10;
    }

    public int enableAlg(int r100, int r101, int r102, int r103, int r104, int r105, int r106, String r107, String r108, String r110, Bundle r111) {
        if (this.mSRObject != null) goto L6;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "enable alg failed, no instance");
        return -1;
    L6:
        this.mProcessCount = 0;
        this.mProcessRet = -1;
        if (this.mSuperAlgParam != null) goto L9;
        this.mSuperAlgParam = new j();
    L9:
        this.mSuperAlgParam.getClass();
        this.mSuperAlgParam.getClass();
        j r109 = this.mSuperAlgParam;
        r109.f508429a = r101;
        r109.getClass();
        this.mSuperAlgParam.getClass();
        this.mSuperAlgParam.getClass();
        this.mSuperAlgParam.getClass();
        this.mSuperAlgParam.getClass();
        this.mSuperAlgParam.getClass();
        this.mSuperAlgParam.getClass();
        if (r111 == null) goto L12;
        r111.getBoolean(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_ALLOW_FALLBACK);
        int r112 = r111.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_SHARP_LEVELS);
        h.a r113 = new h.a();
        r113.b(r111.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_HOST, ""), r111.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_ACCESSKEY, ""));
        String r114 = r111.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_DEVIECEID, "");
        ((HashMap) r113.f508426b).put("deviceId", r114);
        String r115 = r111.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_ID, "");
        ((HashMap) r113.f508426b).put(b.f276371u, r115);
        String r116 = r111.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_VERSION, "");
        ((HashMap) r113.f508426b).put("appVersion", r116);
        r113.f508425a = r112;
        r111.getInt(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_SOURCE, 0);
        r113.f508427c = r111.getString(TextureRenderKeys.KEY_IS_BMF_INIT_CONFIG_MODEL_NAME, "");
        r113.a();
    L12:
        this.mSuperAlgParam.getClass();
        return this.mSRObject.h();
    }

    public int processTexture(int r100, int r110, int r111, int r112, float[] r113, int r114, int r115, int r116, int r117, int r118, long r119, int r210, Bundle r211, float[] r212, float[] r213, boolean r214) {
        if (this.mSRObject != null) goto L6;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "process texture failed, no instance");
        return -1;
    L6:
        g r101 = this.mRoiParams;
        if (r101 != null) goto L9;
        this.mRoiParams = new g(0);
    L11:
        if (this.mMultiScaleParams != null) goto L13;
        this.mMultiScaleParams = new c(0);
    L13:
        if (r211 != null) goto L15;
    L20:
        if (r211 == null) goto L28;
        if (r211.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION) == false) goto L28;
        r211.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_ENABLE_OVERSHOOT_REDUCTION, 0);
        r211.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_THRESHOLD, 0.0f);
        r211.getFloat(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_OVERSHOOT_COEFF, 0.0f);
        r211.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL_DISABLE_MVP_CVT, 0);
        i r102 = this.mSharpLevelParams;
        if (r102 != null) goto L26;
        this.mSharpLevelParams = new i(null);
        goto L28
    L26:
        r102.getClass();
        this.mSharpLevelParams.getClass();
        this.mSharpLevelParams.getClass();
    L28:
        if (r110 != 36197) goto L33;
        d r103 = this.mOesParams;
        if (r103 != null) goto L32;
        this.mOesParams = new d(0);
        goto L33
    L32:
        r103.getClass();
        this.mOesParams.getClass();
    L33:
        int r104 = this.mSRObject.i();
        if (this.mProcessRet == r104) goto L36;
        this.mProcessCount = 0;
    L36:
        this.mProcessRet = r104;
        if ((this.mProcessCount % 100) != 0) goto L39;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process texture id:" + r100 + " target:" + r110 + " width:" + r111 + " height:" + r112 + " scale:" + r210 + " ret:" + r104 + " algType:" + this.mSuperAlgParam.f508429a);
        this.mProcessCount = 0;
    L39:
        this.mProcessCount++;
        return this.mProcessRet;
    L15:
        if (r211.containsKey(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL) == false) goto L20;
        int r105 = r211.getInt(TextureRenderKeys.KEY_IS_BMF_SHARP_LEVEL);
        i r106 = this.mSharpLevelParams;
        if (r106 != null) goto L19;
        this.mSharpLevelParams = new i(r105);
        goto L20
    L19:
        r106.f508428a = r105;
        goto L20
    L9:
        r101.getClass();
        this.mRoiParams.getClass();
        this.mRoiParams.getClass();
        this.mRoiParams.getClass();
        this.mRoiParams.getClass();
        goto L11
    }
}
