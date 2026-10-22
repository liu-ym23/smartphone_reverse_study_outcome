package com.ss.texturerender;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class AdaptiveGradingWrapper {
    private static final int HEIGHT_DEFAULT = 720;
    private static final int MAX_RETRY_COUNT = 3;
    private static final String VIDEO_ADAPTIVE_GRADING_CLASS_NAME = "com.bytedance.bmf_mods.AdaptiveGrading";
    private static final int WIDTH_DEFAULT = 1440;
    private final String LOG_TAG;
    private Object mAdaptiveGradingObject;
    private float[] mBrightnessThreshold;
    private String mCacheFile;
    private float[] mContrastThreshold;
    private Method mFreeMethod;
    private Method mInitMethod;
    private int mMaxHeight;
    private int mMaxInitRetryCount;
    private int mMaxWidth;
    private Method mProcessMethod;
    private Method mProcessOesMethod;
    private float[] mSaturationThreshold;
    private int mTexType;

    private void _initObjAndMethod() {
        Class<?> r100 = TextureRenderHelper.getClzUsingPluginLoader(1, VIDEO_ADAPTIVE_GRADING_CLASS_NAME);     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        Class<?> r101 = Integer.TYPE;     // Catch: Exception -> L7
        this.mInitMethod = r100.getDeclaredMethod("Init", new Class[]{r101, r101, String.class, float[].class, float[].class, float[].class});     // Catch: Exception -> L7
        Class<?> r110 = Float.TYPE;     // Catch: Exception -> L7
        Class<?> r111 = Boolean.TYPE;     // Catch: Exception -> L7
        this.mProcessMethod = r100.getDeclaredMethod("ProcessTexture", new Class[]{r101, r101, r101, r110, r110, r110, r110, r110, r110, r111});     // Catch: Exception -> L7
        this.mProcessOesMethod = r100.getDeclaredMethod("ProcessOesTexture", new Class[]{r101, r101, r101, float[].class, r110, r110, r110, r110, r110, r110, r111});     // Catch: Exception -> L7
        this.mFreeMethod = r100.getDeclaredMethod("Free", new Class[0]);     // Catch: Exception -> L7
        this.mAdaptiveGradingObject = r100.newInstance();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "VideoOCLSR get fail:" + e.toString());
        this.mAdaptiveGradingObject = null;
        this.mInitMethod = null;
        this.mFreeMethod = null;
        this.mProcessMethod = null;
    }

    public void free() {
        _invokeMethod(this.mFreeMethod, this.mAdaptiveGradingObject, new Object[0]);
        this.mAdaptiveGradingObject = null;
        this.mInitMethod = null;
        this.mFreeMethod = null;
        this.mProcessMethod = null;
    }

    public AdaptiveGradingWrapper(int r100) {
        this.mAdaptiveGradingObject = null;
        this.mInitMethod = null;
        this.mProcessMethod = null;
        this.mProcessOesMethod = null;
        this.mFreeMethod = null;
        this.mTexType = -1;
        this.mMaxInitRetryCount = 0;
        String r101 = TextureRenderLog.getLogTag(this);
        this.LOG_TAG = r101;
        this.mTexType = r100;
        TextureRenderLog.i(r100, r101, "new AdaptiveGradingWrapper");
    }

    private Object _invokeMethod(Method r100, Object r101, Object... r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        return r100.invoke(r101, r102);
    L6:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, e.toString());
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    public boolean init(int r100, int r101, String r102, float[] r103, float[] r104, float[] r110) {
        if (this.mAdaptiveGradingObject != null) goto L5;
    L6:
        _initObjAndMethod();
    L7:
        if (r100 > 0) goto L9;
        r100 = 1440;
    L9:
        this.mMaxWidth = r100;
        if (r101 > 0) goto L12;
        r101 = 720;
    L12:
        this.mMaxHeight = r101;
        this.mCacheFile = r102;
        this.mBrightnessThreshold = r103;
        this.mContrastThreshold = r104;
        this.mSaturationThreshold = r110;
        Object r105 = _invokeMethod(this.mInitMethod, this.mAdaptiveGradingObject, new Object[]{Integer.valueOf(r100), Integer.valueOf(this.mMaxHeight), r102, r103, r104, r110});
        if (r105 != null) goto L15;
    L20:
        TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading init error:" + r105);
        free();
        return false;
    L15:
        if ((r105 instanceof Integer) == false) goto L20;
        if (((Integer) r105).intValue() < 0) goto L20;
        return true;
    L5:
        if (this.mInitMethod != null) goto L7;
        goto L6
    }

    public int process(int r100, int r101, int r102, float r103, float r110, float r111, float r112, float r113, float r114, boolean r115) {
        Object r104 = this.mAdaptiveGradingObject;
        if (r104 != null) goto L5;
    L22:
        TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading mInitMethod null");
        return r100;
    L5:
        if (this.mInitMethod == null) goto L22;
        if (r100 < 0) goto L20;
        if (r101 <= 0) goto L20;
        if (r102 <= 0) goto L20;
        Object r105 = _invokeMethod(this.mProcessMethod, r104, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Float.valueOf(r103), Float.valueOf(r110), Float.valueOf(r111), Float.valueOf(r112), Float.valueOf(r113), Float.valueOf(r114), Boolean.valueOf(r115)});
        if (r105 != null) goto L14;
        return r100;
    L14:
        if ((r105 instanceof Integer) == false) goto L25;
        Integer r106 = (Integer) r105;
        if (r106.intValue() >= 0) goto L19;
        return r100;
    L19:
        return r106.intValue();
    L25:
        return r100;
    L20:
        TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading width height = 0");
        return r100;
    }

    public int processOES(int r100, int r101, int r102, float[] r110, float r111, float r112, float r113, float r114, float r115, float r116, boolean r117) {
        Object r103 = this.mAdaptiveGradingObject;
        if (r103 != null) goto L5;
    L23:
        TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading oes mInitMethod null");
        return r100;
    L5:
        if (this.mInitMethod == null) goto L23;
        if (r100 < 0) goto L21;
        if (r101 <= 0) goto L21;
        if (r102 <= 0) goto L21;
        Object r104 = _invokeMethod(this.mProcessOesMethod, r103, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), r110, Float.valueOf(r111), Float.valueOf(r112), Float.valueOf(r113), Float.valueOf(r114), Float.valueOf(r115), Float.valueOf(r116), Boolean.valueOf(r117)});
        if (r104 != null) goto L14;
    L20:
        return r100;
    L14:
        if ((r104 instanceof Integer) == false) goto L20;
        Integer r105 = (Integer) r104;
        if (r105.intValue() < 0) goto L20;
        return r105.intValue();
    L21:
        TextureRenderLog.i(this.mTexType, "AdaptiveGrading", "AdaptiveGrading oes width height = 0");
        return r100;
    }
}
