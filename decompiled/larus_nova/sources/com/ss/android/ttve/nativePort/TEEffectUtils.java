package com.ss.android.ttve.nativePort;

import android.graphics.Bitmap;
import com.ss.android.vesdk.d0;
import com.ss.android.vesdk.lens.VEModelDownload;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class TEEffectUtils {
    public static final String NAME_AUDIO_TIME_ALIGN_MODEL = "time_align_44k.model";
    public static final String REQUIREMENT_AUDIO_AEC_MODEL = "AudioAECModel";
    public static final String REQUIREMENT_AUDIO_TIME_ALIGN_MODEL = "AudioTimeAlignModel";
    public static final String REQUIREMENT_TAINT_SCENE_DETECT_MODEL = "TaintSceneDetectModel";

    public interface ImageListener {
        void onData(int[] r100, int r101, int r102, int r103);
    }

    public interface QrImageListener {
        void onData(int[] r100, int r101, int r102, int r103);
    }

    public TEEffectUtils() {
    }

    public static native String getAudioAECModelName();

    public static native String getAudioAECResnet44KModelName();

    public static native String getEffectVersion();

    public static String getTaintSceneDetectModelName() {
        return VEModelDownload.MODELNAME_TAINT_SCENE_DETECT;
    }

    private static native int nativeClearDiskCache(int r100, int r101);

    private static native int nativeGetQREncodedData(String r100, int[] r101, ImageListener r102);

    private static native int nativeGetQREncodedDataWithWH(String r100, int r101, int r102, int[] r103, QrImageListener r104);

    private static native String nativeGetScriptSegmentPreload(String r100);

    public static native boolean nativeResizeImageWithEffect2(Bitmap r100, Bitmap r101, boolean r102);

    private static native int nativeSetDiskCacheDirectory(String r100);

    private static native int nativeSetGlobalAllowedPaths(String[] r100);

    static {
        TENativeLibsLoader.loadLibrary();
    }

    public static int clearDiskCache(d0 r100) {
        throw null;
    }

    public static String getScriptSegmentPreload(String r100) {
        return nativeGetScriptSegmentPreload(r100);
    }

    public static int setDiskCacheDirectory(String r100) {
        return nativeSetDiskCacheDirectory(r100);
    }

    public static int setGlobalAllowedPaths(String[] r100) {
        return nativeSetGlobalAllowedPaths(r100);
    }

    public static int getQREncodedData(String r100, Map<Integer, Integer> r101, ImageListener r102) {
        if (r101 == null) goto L7;
        int[] r103 = new int[r101.size() * 2];
        Iterator<Map.Entry<Integer, Integer>> r104 = r101.entrySet().iterator();
        int r105 = 0;
    L5:
        if (r104.hasNext() == false) goto L9;
        Map.Entry<Integer, Integer> r106 = r104.next();
        r103[r105] = r106.getKey().intValue();
        r103[r105 + 1] = r106.getValue().intValue();
        r105 = r105 + 2;
    L9:
        return nativeGetQREncodedData(r100, r103, r102);
    L7:
        r103 = null;
        goto L9
    }

    public static boolean resizeImageWithEffect(Bitmap r100, Bitmap r101, boolean r102) {
        return nativeResizeImageWithEffect2(r100, r101, r102);
    }

    public static int getQREncodedData(String r100, int r101, int r102, Map<Integer, Integer> r103, QrImageListener r104) {
        if (r103 == null) goto L7;
        int[] r105 = new int[r103.size() * 2];
        Iterator<Map.Entry<Integer, Integer>> r106 = r103.entrySet().iterator();
        int r107 = 0;
    L5:
        if (r106.hasNext() == false) goto L9;
        Map.Entry<Integer, Integer> r108 = r106.next();
        r105[r107] = r108.getKey().intValue();
        r105[r107 + 1] = r108.getValue().intValue();
        r107 = r107 + 2;
    L9:
        return nativeGetQREncodedDataWithWH(r100, r101, r102, r105, r104);
    L7:
        r105 = null;
        goto L9
    }
}
