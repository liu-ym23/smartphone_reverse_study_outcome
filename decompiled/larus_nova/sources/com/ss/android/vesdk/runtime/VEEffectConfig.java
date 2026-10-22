package com.ss.android.vesdk.runtime;

import android.content.res.AssetManager;
import com.bef.effectsdk.FileResourceFinder;
import com.bef.effectsdk.ResourceFinder;
import com.ss.android.ttve.nativePort.TENativeLibsLoader;
import com.ss.android.vesdk.VEException;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class VEEffectConfig {
    private static final String TAG = null;
    private static String sCacheDir;
    private static com.ss.android.vesdk.a sCommonFinder;
    private static AssetManager sEffectAssetManager;
    private static ResourceFinder sFinder;

    public VEEffectConfig() {
    }

    private static native void nativeConfigEffect(boolean r100, AssetManager r101, String r102, String r103);

    private static native void nativeEnableAlgoParamisForce(boolean r100, boolean r101);

    private static native void nativeEnableEffectAudioManagerCallback(boolean r100);

    private static native void nativeEnableEffectRT(boolean r100);

    private static native void nativeEnableMakeupSegmentation(boolean r100);

    private static native String nativeGetABConfigList();

    private static native void nativeSetABConfigValue(String r100, boolean r101, int r102, float r103, String r104, int r105);

    private static native void nativeSetABbUseBuildinAmazing(boolean r100);

    private static native void nativeSetCacheDir(String r100);

    private static native void nativeSetEffectAsynAPI(boolean r100);

    private static native void nativeSetEffectForceDetectFace(boolean r100);

    private static native void nativeSetEffectJsonConfig(String r100);

    private static native void nativeSetEffectLogLevel(int r100);

    private static native void nativeSetEffectMaxMemoryCache(int r100);

    private static native void nativeSetEffectSyncTimeDomain(boolean r100);

    private static native void nativeSetEnableStickerAmazing(boolean r100);

    private static native void nativeSetShareDir(String r100);

    private static native void nativeSetSysFontPaths(String[] r100);

    private static native void nativeUseNewEffectAlgorithmApi(boolean r100);

    private static native void nativesetEnableStickerReleaseTexture(boolean r100);

    public static void setCommonResourceFinder(com.ss.android.vesdk.a r100) {
    }

    static {
        TENativeLibsLoader.loadLibrary();
        TAG = "VEEffectConfig";
        sEffectAssetManager = null;
        sFinder = new FileResourceFinder("");
        sCacheDir = "";
    }

    public static String getABConfigList() {
        return nativeGetABConfigList();
    }

    public static String getCacheDir() {
        return sCacheDir;
    }

    public static boolean enableAssetManager(AssetManager r100) {
        sEffectAssetManager = r100;
        return true;
    }

    public static void enableEffectAudioManagerCallback(boolean r100) {
        nativeEnableEffectAudioManagerCallback(r100);
    }

    public static boolean enableEffectRT(boolean r100) {
        nativeEnableEffectRT(r100);
        return true;
    }

    public static void enableMakeupSegmentation(boolean r100) {
        nativeEnableMakeupSegmentation(r100);
    }

    public static String getNativeCommonResourceDir(long r100) {
        VELogUtil.e(TAG, "getNativeFinder is null");
        return "";
    }

    public static long getNativeCommonResourceFinder(long r100) {
        VELogUtil.e(TAG, "[CommonResource]getNativeFinder is null");
        return 0;
    }

    public static long getNativeFinder(long r100) {
        ResourceFinder r101 = sFinder;
        if (r101 == null) goto L7;
        return r101.createNativeResourceFinder(r100);
    L7:
        throw new VEException(-1, "Error call finder related interface.");
    }

    public static void releaseNativeCommonResourceFinder(long r100) {
        if (r100 != 0) goto L6;
        VELogUtil.e(TAG, "getNativeFinder effectHandler is null");
        return;
    L6:
        VELogUtil.e(TAG, "getNativeFinder is null");
    }

    public static void releaseNativeFinder(long r100) {
        if (r100 != 0) goto L7;
        VELogUtil.e(TAG, "getNativeFinder effectHandler is null");
        return;
    L7:
        if (sFinder == null) goto L11;
        VELogUtil.i(TAG, "getNativeFinder effectHandler " + sFinder.getClass().getCanonicalName());
        sFinder.release(r100);
        return;
    L11:
        throw new VEException(-1, "Error call finder related interface.");
    }

    public static boolean setABbUseBuildinAmazing(boolean r100) {
        nativeSetABbUseBuildinAmazing(r100);
        return true;
    }

    public static void setCacheDir(String r100) {
        sCacheDir = r100;
        nativeSetCacheDir(r100);
    }

    public static void setEffectAsynAPI(boolean r100) {
        nativeSetEffectAsynAPI(r100);
    }

    public static void setEffectForceDetectFace(boolean r100) {
        nativeSetEffectForceDetectFace(r100);
    }

    public static boolean setEffectJsonConfig(String r100) {
        nativeSetEffectJsonConfig(r100);
        return true;
    }

    public static boolean setEffectLogLevel(int r100) {
        nativeSetEffectLogLevel(r100);
        return true;
    }

    public static boolean setEffectMaxMemoryCache(int r100) {
        nativeSetEffectMaxMemoryCache(r100);
        return true;
    }

    public static void setEffectSyncTimeDomain(boolean r100) {
        nativeSetEffectSyncTimeDomain(r100);
    }

    public static void setEnableStickerAmazing(boolean r100) {
        nativeSetEnableStickerAmazing(r100);
    }

    public static void setEnableStickerReleaseTexture(boolean r100) {
        nativesetEnableStickerReleaseTexture(r100);
    }

    public static void setResourceFinder(ResourceFinder r100) {
        sFinder = r100;
    }

    public static boolean setShareDir(String r100) {
        nativeSetShareDir(r100);
        return true;
    }

    public static void setSysFontPaths(String[] r100) {
        nativeSetSysFontPaths(r100);
    }

    public static void setUseNewEffectAlgorithmApi(boolean r100) {
        nativeUseNewEffectAlgorithmApi(r100);
    }

    public static void configEffect(String r100, String r101) {
        if (sFinder == null) goto L5;
        boolean r102 = true;
    L6:
        nativeConfigEffect(r102, sEffectAssetManager, r100, r101);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static void enableAlgoParamIsForce(boolean r100, boolean r101) {
        nativeEnableAlgoParamisForce(r100, r101);
    }

    public static void setABConfigValue(String r100, Object r101, int r102) {
        if (r102 == 0) goto L24;
        if (r102 == 1) goto L19;
        if (r102 == 2) goto L14;
        if (r102 == 3) goto L11;
        return;
    L11:
        if ((r101 instanceof String) == false) goto L27;
        nativeSetABConfigValue(r100, false, 0, 0.0f, (String) r101, r102);
        return;
    L27:
        return;
    L14:
        if ((r101 instanceof Float) == false) goto L16;
    L17:
        nativeSetABConfigValue(r100, false, 0, ((Number) r101).floatValue(), null, r102);
        return;
    L16:
        if ((r101 instanceof Double) == true) goto L17;
        return;
    L19:
        if ((r101 instanceof Integer) == false) goto L21;
    L22:
        nativeSetABConfigValue(r100, false, ((Number) r101).intValue(), 0.0f, null, r102);
        return;
    L21:
        if ((r101 instanceof Long) == true) goto L22;
        return;
    L24:
        if ((r101 instanceof Boolean) == false) goto L33;
        nativeSetABConfigValue(r100, ((Boolean) r101).booleanValue(), 0, 0.0f, null, r102);
        return;
    }
}
