package com.ss.texturerender.effect;

import android.content.Context;
import com.bytedance.bmf_mods_lite_api.packageHandler.ParamApi;
import com.bytedance.bmf_mods_lite_api.packageHandler.VideoFrameApi;
import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.VideoSurfaceTexture;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import oc4.b;
import oc4.c;

/* JADX INFO: loaded from: classes40.dex */
public class BMFVQScoreOmniLite implements BMFVQScoreWrapper.BMFVQScoreProxy {
    private static final String BMF_PARAM = "com.bytedance.bmf_mods_lite.packageHandler.Param";
    private static final String BMF_UTILS_DOWNLOADER = "com.bytedance.bmf_mods_lite.packageHandler.packageUtil.PackageDownload";
    private static final String BMF_VIDEO_FRAME = "com.bytedance.bmf_mods_lite.packageHandler.VideoFrame";
    private static final String BMF_VQSCORE_OMNI_CLASS_NAME = "com.bytedance.bmf_mods_lite.packageHandler.PackageHandler";
    private final int DOWNLOAD_SUCCESS;
    private final String LOG_TAG;
    private Object mBmfAlgParam;
    private Object mBmfInitParam;
    private Method mBmfParamSetFloatListMethod;
    private Method mBmfParamSetIntMethod;
    private Method mBmfParamSetLongMethod;
    private Method mBmfParamSetStringMethod;
    private Method mBmfSetVideoFrameMethod;
    private Object mBmfUtilsDownloader;
    private Object mBmfVideoFrame;
    private Method mDownloadModelMethod;
    private String mDownloadPath;
    private int mEffectType;
    private Method mEnableAlgMethod;
    private Method mInitMethod;
    private Method mProcessAsyncMethod;
    private float mProcessAverageCostTime;
    private float mProcessSuccessFrame;
    private float mProcessSumCostTime;
    private float mProcessSumFrame;
    private Method mReleaseVQScoreOmniMethod;
    private Method mSetDownloadCbMethod;
    private VideoSurfaceTexture mSurfaceTexture;
    private int mTexType;
    private Object mVQScoreOmniObject;
    private Map<Long, Long> mVqscoreTimeMap;

    private void _initBmfUtilsDownloaderMethod() {
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, BMF_UTILS_DOWNLOADER);     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        this.mBmfUtilsDownloader = r100.newInstance();     // Catch: Exception -> L6
        this.mSetDownloadCbMethod = r100.getDeclaredMethod("SetDownloadCallback", new Class[]{b.class});     // Catch: Exception -> L6
        this.mDownloadModelMethod = r100.getDeclaredMethod("DownloadModel", new Class[]{Context.class, Map.class});     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "BMFUtilsDownloader get fail:" + e.toString());
        this.mBmfUtilsDownloader = null;
        this.mSetDownloadCbMethod = null;
        this.mDownloadModelMethod = null;
    }

    private void _initParamMethod() {
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, BMF_PARAM);     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        this.mBmfInitParam = r100.newInstance();     // Catch: Exception -> L6
        this.mBmfAlgParam = r100.newInstance();     // Catch: Exception -> L6
        Class<?> r101 = Long.TYPE;     // Catch: Exception -> L6
        this.mBmfParamSetIntMethod = r100.getDeclaredMethod("setInt", new Class[]{r101, Integer.TYPE});     // Catch: Exception -> L6
        this.mBmfParamSetStringMethod = r100.getDeclaredMethod("setString", new Class[]{r101, String.class});     // Catch: Exception -> L6
        this.mBmfParamSetLongMethod = r100.getDeclaredMethod("setLong", new Class[]{r101, r101});     // Catch: Exception -> L6
        this.mBmfParamSetFloatListMethod = r100.getDeclaredMethod("setFloatList", new Class[]{r101, float[].class});     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "BMFParam get fail:" + e.toString());
        this.mBmfInitParam = null;
        this.mBmfAlgParam = null;
        this.mBmfParamSetIntMethod = null;
        this.mBmfParamSetStringMethod = null;
        this.mBmfParamSetLongMethod = null;
        this.mBmfParamSetFloatListMethod = null;
    }

    private void _initVideoFrameMethod() {
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, BMF_VIDEO_FRAME);     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        this.mBmfVideoFrame = r100.newInstance();     // Catch: Exception -> L6
        Class<?> r101 = Integer.TYPE;     // Catch: Exception -> L6
        this.mBmfSetVideoFrameMethod = r100.getDeclaredMethod("setVideoFrame", new Class[]{r101, r101, r101, r101, r101});     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "BMFVideoFrame get fail:" + e.toString());
        this.mBmfVideoFrame = null;
        this.mBmfSetVideoFrameMethod = null;
    }

    private void _initVqscoreOmniMethod() {
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, BMF_VQSCORE_OMNI_CLASS_NAME);     // Catch: Exception -> L6
        if (r100 == null) goto L11;
        this.mVQScoreOmniObject = r100.newInstance();     // Catch: Exception -> L6
        this.mInitMethod = r100.getDeclaredMethod("init", new Class[]{ParamApi.class});     // Catch: Exception -> L6
        this.mEnableAlgMethod = r100.getDeclaredMethod("enableAlg", new Class[]{ParamApi.class});     // Catch: Exception -> L6
        this.mProcessAsyncMethod = r100.getDeclaredMethod("processAsync", new Class[]{VideoFrameApi.class, ParamApi.class, c.class});     // Catch: Exception -> L6
        this.mReleaseVQScoreOmniMethod = r100.getDeclaredMethod("release", new Class[0]);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "BMFVQScoreOmni get fail:" + e.toString());
        this.mVQScoreOmniObject = null;
        this.mInitMethod = null;
        this.mEnableAlgMethod = null;
        this.mProcessAsyncMethod = null;
        this.mReleaseVQScoreOmniMethod = null;
    }

    @Override // com.ss.texturerender.effect.BMFVQScoreWrapper.BMFVQScoreProxy
    public void release() {
        Object r100 = this.mVQScoreOmniObject;
        if (r100 == null) goto L7;
        Method r101 = this.mReleaseVQScoreOmniMethod;
        if (r101 == null) goto L7;
        _invokeMethod(r101, r100, new Object[0]);
    L7:
        this.mVQScoreOmniObject = null;
        this.mVqscoreTimeMap = null;
    }

    public static /* synthetic */ int access$000(BMFVQScoreOmniLite r100) {
        return r100.mTexType;
    }

    public static /* synthetic */ String access$100(BMFVQScoreOmniLite r100) {
        return r100.LOG_TAG;
    }

    public static /* synthetic */ VideoSurfaceTexture access$200(BMFVQScoreOmniLite r100) {
        return r100.mSurfaceTexture;
    }

    public static /* synthetic */ int access$400(BMFVQScoreOmniLite r100) {
        return r100.mEffectType;
    }

    public static /* synthetic */ Map access$500(BMFVQScoreOmniLite r100) {
        return r100.mVqscoreTimeMap;
    }

    public static /* synthetic */ float access$600(BMFVQScoreOmniLite r100) {
        return r100.mProcessSuccessFrame;
    }

    public static /* synthetic */ float access$608(BMFVQScoreOmniLite r100) {
        float r101 = r100.mProcessSuccessFrame;
        r100.mProcessSuccessFrame = 1.0f + r101;
        return r101;
    }

    public static /* synthetic */ float access$700(BMFVQScoreOmniLite r100) {
        return r100.mProcessSumCostTime;
    }

    public static /* synthetic */ float access$800(BMFVQScoreOmniLite r100) {
        return r100.mProcessAverageCostTime;
    }

    public static /* synthetic */ float access$900(BMFVQScoreOmniLite r100) {
        return r100.mProcessSumFrame;
    }

    @Override // com.ss.texturerender.effect.BMFVQScoreWrapper.BMFVQScoreProxy
    public void downloadModel(Map<String, String> r100) {
        b r101 = new AnonymousClass1(this);
        _invokeMethod(this.mSetDownloadCbMethod, this.mBmfUtilsDownloader, new Object[]{r101});
        _invokeMethod(this.mDownloadModelMethod, this.mBmfUtilsDownloader, new Object[]{TextureRenderManager.getManager().getContext(), r100});
    }

    public static /* synthetic */ String access$302(BMFVQScoreOmniLite r100, String r101) {
        r100.mDownloadPath = r101;
        return r101;
    }

    public static /* synthetic */ float access$702(BMFVQScoreOmniLite r100, float r101) {
        r100.mProcessSumCostTime = r101;
        return r101;
    }

    public static /* synthetic */ float access$802(BMFVQScoreOmniLite r100, float r101) {
        r100.mProcessAverageCostTime = r101;
        return r101;
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

    @Override // com.ss.texturerender.effect.BMFVQScoreWrapper.BMFVQScoreProxy
    public int process(long r110, EffectTexture r111, final VideoSurface.VQScoreCallback r112) {
        if (r112 == null) goto L34;
        if (r111 != null) goto L6;
        return -1;
    L6:
        if (this.mVQScoreOmniObject != null) goto L8;
        return -1;
    L8:
        if (this.mBmfSetVideoFrameMethod != null) goto L10;
        return -1;
    L10:
        if (this.mProcessAsyncMethod == null) goto L39;
        this.mVqscoreTimeMap.put(Long.valueOf(r110), Long.valueOf(System.currentTimeMillis()));
        this.mProcessSumFrame += 1.0f;
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, BMF_PARAM);     // Catch: Exception -> L29
        if (r100 == null) goto L16;
        Object r101 = r100.newInstance();     // Catch: Exception -> L29
        float[] r102 = new float[16];     // Catch: Exception -> L29
        this.mSurfaceTexture.getTransformMatrix(r102);     // Catch: Exception -> L29
        _invokeMethod(this.mBmfParamSetLongMethod, r101, new Object[]{1210L, Long.valueOf(r110)});     // Catch: Exception -> L29
        _invokeMethod(this.mBmfParamSetFloatListMethod, r101, new Object[]{1201L, r102});     // Catch: Exception -> L29
    L17:
        Class<?> r113 = TextureRenderHelper.getClzUsingPluginLoader(1, BMF_VIDEO_FRAME);     // Catch: Exception -> L29
        if (r113 == null) goto L28;
        Object r114 = r113.newInstance();     // Catch: Exception -> L29
        int r115 = r111.getTexTarget();     // Catch: Exception -> L29
        if (r115 != 36197) goto L23;
        _invokeMethod(this.mBmfSetVideoFrameMethod, r114, new Object[]{Integer.valueOf(r111.getTexID()), 4, Integer.valueOf(r111.getWidth()), Integer.valueOf(r111.getHeight()), 0});     // Catch: Exception -> L29
    L25:
        if (_invokeMethod(this.mProcessAsyncMethod, this.mVQScoreOmniObject, new Object[]{r114, r101, new AnonymousClass2(this, r112)}) != null) goto L28;
        return -1;
    L23:
        if (r115 != 3553) goto L25;
        _invokeMethod(this.mBmfSetVideoFrameMethod, r114, new Object[]{Integer.valueOf(r111.getTexID()), 3, Integer.valueOf(r111.getWidth()), Integer.valueOf(r111.getHeight()), 0});     // Catch: Exception -> L29
    L28:
        return 0;
    L16:
        r101 = null;
    L29:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "vqscoreOmni process get fail:" + e.toString());
        return -1;
    L39:
        return -1;
    L34:
        return -1;
    }

    public BMFVQScoreOmniLite(int r100, String r101, VideoSurfaceTexture r102, int r103) {
        this.mTexType = -1;
        this.mProcessAverageCostTime = 0.0f;
        this.mProcessSumCostTime = 0.0f;
        this.mProcessSumFrame = 0.0f;
        this.mProcessSuccessFrame = 0.0f;
        this.mVqscoreTimeMap = new ConcurrentHashMap();
        this.mVQScoreOmniObject = null;
        this.mBmfUtilsDownloader = null;
        this.mBmfInitParam = null;
        this.mBmfAlgParam = null;
        this.mBmfVideoFrame = null;
        this.mSetDownloadCbMethod = null;
        this.mDownloadModelMethod = null;
        this.mInitMethod = null;
        this.mEnableAlgMethod = null;
        this.mBmfParamSetIntMethod = null;
        this.mBmfParamSetStringMethod = null;
        this.mBmfParamSetLongMethod = null;
        this.mBmfSetVideoFrameMethod = null;
        this.mProcessAsyncMethod = null;
        this.mReleaseVQScoreOmniMethod = null;
        this.mBmfParamSetFloatListMethod = null;
        this.DOWNLOAD_SUCCESS = 0;
        this.mDownloadPath = "";
        this.mTexType = r100;
        this.LOG_TAG = r101;
        this.mSurfaceTexture = r102;
        this.mEffectType = r103;
        _initVqscoreOmniMethod();
        _initBmfUtilsDownloaderMethod();
        _initParamMethod();
        _initVideoFrameMethod();
    }

    @Override // com.ss.texturerender.effect.BMFVQScoreWrapper.BMFVQScoreProxy
    public int init(int r100, int r101, int r102, String r110, int r111) {
        Object r103 = this.mBmfInitParam;
        int r104 = 0;
        if (r103 == null) goto L5;
        _invokeMethod(this.mBmfParamSetIntMethod, r103, new Object[]{101L, -100});
        _invokeMethod(this.mBmfParamSetStringMethod, this.mBmfInitParam, new Object[]{102L, "live"});
        _invokeMethod(this.mBmfParamSetIntMethod, this.mBmfInitParam, new Object[]{103L, 3});
        _invokeMethod(this.mBmfParamSetIntMethod, this.mBmfInitParam, new Object[]{104L, 3});
    L5:
        Object r105 = this.mBmfAlgParam;
        if (r105 == null) goto L9;
        _invokeMethod(this.mBmfParamSetIntMethod, r105, new Object[]{1101L, 4});
        _invokeMethod(this.mBmfParamSetIntMethod, this.mBmfAlgParam, new Object[]{1102L, 2});
        _invokeMethod(this.mBmfParamSetIntMethod, this.mBmfAlgParam, new Object[]{1105L, 2000});
        _invokeMethod(this.mBmfParamSetIntMethod, this.mBmfAlgParam, new Object[]{1106L, 2000});
        _invokeMethod(this.mBmfParamSetStringMethod, this.mBmfAlgParam, new Object[]{1107L, r110});
        _invokeMethod(this.mBmfParamSetStringMethod, this.mBmfAlgParam, new Object[]{1109L, this.mDownloadPath});
        _invokeMethod(this.mBmfParamSetIntMethod, this.mBmfAlgParam, new Object[]{14101L, 0});
        _invokeMethod(this.mBmfParamSetIntMethod, this.mBmfAlgParam, new Object[]{14102L, 1});
        _invokeMethod(this.mBmfParamSetIntMethod, this.mBmfAlgParam, new Object[]{1110L, 2});
    L9:
        if (_invokeMethod(this.mInitMethod, this.mVQScoreOmniObject, new Object[]{this.mBmfInitParam}) != null) goto L11;
        int r106 = -1;
    L12:
        if (r106 != (-1)) goto L14;
        return r106;
    L14:
        if (_invokeMethod(this.mEnableAlgMethod, this.mVQScoreOmniObject, new Object[]{this.mBmfAlgParam}) != null) goto L17;
        r104 = -1;
    L17:
        return r104;
    L11:
        r106 = 0;
        goto L12
    }
}
