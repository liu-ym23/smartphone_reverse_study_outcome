package com.ss.texturerender.effect;

import android.content.Context;
import com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPI;
import com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPI;
import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.VideoSurfaceTexture;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class BMFVQScoreLive implements BMFVQScoreWrapper.BMFVQScoreProxy {
    private static final String BMF_VQSCORE_CLASS_NAME = "com.bytedance.bmf_mods.VqscoreLive";
    private final String LOG_TAG;
    private Method mDownloadMethod;
    private Method mDownlodCallbackMethod;
    private int mEffectType;
    private Method mFreeMethod;
    private Method mInitMethod;
    private float mProcessAverageCostTime;
    private Method mProcessCallbackMethod;
    private Method mProcessMethod;
    private Method mProcessOesMethod;
    private float mProcessSuccessFrame;
    private float mProcessSumCostTime;
    private float mProcessSumFrame;
    private VideoSurfaceTexture mSurfaceTexture;
    private int mTexType;
    private Object mVQScoreObject;
    private Map<Long, Long> mVqscoreTimeMap;

    @Override // com.ss.texturerender.effect.BMFVQScoreWrapper.BMFVQScoreProxy
    public void release() {
        Object r100 = this.mVQScoreObject;
        if (r100 == null) goto L7;
        Method r101 = this.mFreeMethod;
        if (r101 == null) goto L7;
        _invokeMethod(r101, r100, new Object[0]);
    L7:
        this.mVQScoreObject = null;
        this.mVqscoreTimeMap = null;
    }

    public static /* synthetic */ int access$000(BMFVQScoreLive r100) {
        return r100.mTexType;
    }

    public static /* synthetic */ String access$100(BMFVQScoreLive r100) {
        return r100.LOG_TAG;
    }

    public static /* synthetic */ VideoSurfaceTexture access$200(BMFVQScoreLive r100) {
        return r100.mSurfaceTexture;
    }

    public static /* synthetic */ int access$300(BMFVQScoreLive r100) {
        return r100.mEffectType;
    }

    public static /* synthetic */ Map access$400(BMFVQScoreLive r100) {
        return r100.mVqscoreTimeMap;
    }

    public static /* synthetic */ float access$500(BMFVQScoreLive r100) {
        return r100.mProcessSuccessFrame;
    }

    public static /* synthetic */ float access$508(BMFVQScoreLive r100) {
        float r101 = r100.mProcessSuccessFrame;
        r100.mProcessSuccessFrame = 1.0f + r101;
        return r101;
    }

    public static /* synthetic */ float access$600(BMFVQScoreLive r100) {
        return r100.mProcessSumCostTime;
    }

    public static /* synthetic */ float access$700(BMFVQScoreLive r100) {
        return r100.mProcessAverageCostTime;
    }

    public static /* synthetic */ float access$800(BMFVQScoreLive r100) {
        return r100.mProcessSumFrame;
    }

    @Override // com.ss.texturerender.effect.BMFVQScoreWrapper.BMFVQScoreProxy
    public void downloadModel(Map<String, String> r100) {
        VqscoreLiveCallbackAPI r101 = new AnonymousClass1(this);
        _invokeMethod(this.mDownlodCallbackMethod, this.mVQScoreObject, new Object[]{r101});
        _invokeMethod(this.mDownloadMethod, this.mVQScoreObject, new Object[]{TextureRenderManager.getManager().getContext(), r100});
    }

    public static /* synthetic */ float access$602(BMFVQScoreLive r100, float r101) {
        r100.mProcessSumCostTime = r101;
        return r101;
    }

    public static /* synthetic */ float access$702(BMFVQScoreLive r100, float r101) {
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
        int r100 = -1;
        if (r112 == null) goto L31;
        if (r111 == null) goto L31;
        if (this.mVQScoreObject == null) goto L31;
        if (this.mProcessMethod == null) goto L31;
        if (this.mProcessOesMethod == null) goto L31;
        if (this.mProcessCallbackMethod == null) goto L31;
        this.mVqscoreTimeMap.put(Long.valueOf(r110), Long.valueOf(System.currentTimeMillis()));
        this.mProcessSumFrame += 1.0f;
        int r101 = 0;
        _invokeMethod(this.mProcessCallbackMethod, this.mVQScoreObject, new Object[]{new AnonymousClass2(this, r112)});
        int r113 = r111.getTexTarget();
        if (r113 != 36197) goto L23;
        float[] r102 = new float[16];
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L20;
        r103.getTransformMatrix(r102);
    L20:
        if (_invokeMethod(this.mProcessOesMethod, this.mVQScoreObject, new Object[]{Integer.valueOf(r111.getTexID()), Integer.valueOf(r111.getWidth()), Integer.valueOf(r111.getHeight()), r102, Long.valueOf(r110)}) == null) goto L28;
    L27:
        r100 = 0;
    L28:
        r101 = r100;
    L29:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process sequenceId: " + r110 + ", ret: " + r101 + ", textarget: " + r113);
        return r101;
    L23:
        if (r113 != 3553) goto L29;
        if (_invokeMethod(this.mProcessMethod, this.mVQScoreObject, new Object[]{Integer.valueOf(r111.getTexID()), Integer.valueOf(r111.getWidth()), Integer.valueOf(r111.getHeight()), Long.valueOf(r110)}) != null) goto L27;
    L31:
        return -1;
    }

    public BMFVQScoreLive(int r100, String r110, VideoSurfaceTexture r111, int r112) {
        this.mVQScoreObject = null;
        this.mInitMethod = null;
        this.mDownlodCallbackMethod = null;
        this.mProcessCallbackMethod = null;
        this.mDownloadMethod = null;
        this.mProcessMethod = null;
        this.mProcessOesMethod = null;
        this.mFreeMethod = null;
        this.mTexType = -1;
        this.mProcessAverageCostTime = 0.0f;
        this.mProcessSumCostTime = 0.0f;
        this.mProcessSumFrame = 0.0f;
        this.mProcessSuccessFrame = 0.0f;
        this.mVqscoreTimeMap = new ConcurrentHashMap();
        this.mTexType = r100;
        this.LOG_TAG = r110;
        this.mSurfaceTexture = r111;
        this.mEffectType = r112;
        Class<?> r101 = TextureRenderHelper.getClzUsingPluginLoader(1, BMF_VQSCORE_CLASS_NAME);     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        Class<?> r102 = Integer.TYPE;     // Catch: Exception -> L7
        this.mInitMethod = r101.getDeclaredMethod("Init", new Class[]{r102, r102, r102, r102, Boolean.TYPE, String.class, r102});     // Catch: Exception -> L7
        this.mDownlodCallbackMethod = r101.getDeclaredMethod("SetCallback", new Class[]{VqscoreLiveCallbackAPI.class});     // Catch: Exception -> L7
        this.mDownloadMethod = r101.getDeclaredMethod("DownloadModel", new Class[]{Context.class, Map.class});     // Catch: Exception -> L7
        this.mProcessCallbackMethod = r101.getDeclaredMethod("SetProcessCallback", new Class[]{VqscoreProcessCallbackAPI.class});     // Catch: Exception -> L7
        Class<?> r103 = Long.TYPE;     // Catch: Exception -> L7
        this.mProcessMethod = r101.getDeclaredMethod("ProcessAsync", new Class[]{r102, r102, r102, r103});     // Catch: Exception -> L7
        this.mProcessOesMethod = r101.getDeclaredMethod("ProcessOesAsync", new Class[]{r102, r102, r102, float[].class, r103});     // Catch: Exception -> L7
        this.mFreeMethod = r101.getDeclaredMethod("Free", new Class[0]);     // Catch: Exception -> L7
        this.mVQScoreObject = r101.newInstance();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "BMFVQScore get fail:" + e.toString());
        this.mVQScoreObject = null;
        this.mInitMethod = null;
        this.mDownlodCallbackMethod = null;
        this.mDownloadMethod = null;
        this.mProcessCallbackMethod = null;
        this.mProcessMethod = null;
        this.mProcessOesMethod = null;
        this.mFreeMethod = null;
    }

    @Override // com.ss.texturerender.effect.BMFVQScoreWrapper.BMFVQScoreProxy
    public int init(int r100, int r101, int r102, String r103, int r110) {
        Object r104 = this.mVQScoreObject;
        if (r104 == null) goto L12;
        Method r105 = this.mInitMethod;
        if (r105 != null) goto L8;
        return -1;
    L8:
        if (_invokeMethod(r105, r104, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), 1, Integer.valueOf(r102), Boolean.TRUE, r103, Integer.valueOf(r110)}) == null) goto L14;
        return 0;
    L14:
        return -1;
    L12:
        return -1;
    }
}
