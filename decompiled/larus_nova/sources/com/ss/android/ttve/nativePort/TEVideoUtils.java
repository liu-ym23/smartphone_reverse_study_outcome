package com.ss.android.ttve.nativePort;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ttve.model.VEMusicWaveBean;
import com.ss.android.ttve.model.VETransformResult;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VEException;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.algorithm.VEBachAlgorithmParam;
import com.ss.android.vesdk.algorithm.VEBachFaceDetectResult;
import com.ss.android.vesdk.algorithm.VEBachObjectScanParam;
import com.ss.android.vesdk.algorithm.VEBachQRCodeDetectParam;
import com.ss.android.vesdk.algorithm.VEBachQRCodeParam;
import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import com.ss.android.vesdk.algorithm.VEBachSceneRecognitionParam;
import com.ss.android.vesdk.algorithm.VEBachSceneRecognitionResult;
import com.ss.android.vesdk.algorithm.VEFaceDetectCropParam;
import com.ss.android.vesdk.algorithm.VEFaceDetectCropResult;
import com.ss.android.vesdk.algorithm.VEScanResult;
import com.ss.android.vesdk.algorithm.VEThirdQRCodeDetectParam;
import com.ss.android.vesdk.runtime.VERuntime;
import com.ss.android.vesdk.utils.BitmapLoader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class TEVideoUtils {
    private static long getFrameInterval;

    public interface AVInterleaveCheckListener {
        void onInfo(int r100, boolean r101, long r102);
    }

    public interface CompileProbeListener {
        void onCompileProbeResult(int r100, int r101, float r102, int r103, int r104, int r105, int r106, float r107);
    }

    public interface CompileProbeListener2 {
        void onCompileProbeResult2(int r100, int r101, float r102, float r103, int r104, int r105, int r106, int r107, float r108);
    }

    public interface DetectQRCodeListener {
        void onDetectQRCodeResult(int r100, boolean r101);
    }

    public interface ExecuteCommandAndDumpInfoListener {
        void updateFFmpegInfo(String r100);
    }

    public interface ExecuteCommandListener {
        void onProgressChanged(int r100);
    }

    public static final enum FrameDataType extends Enum<FrameDataType> {
        public static final FrameDataType U = null;
        public static final FrameDataType V = null;
        public static final FrameDataType Y = null;
        public static final FrameDataType YUV = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FrameDataType[] f449967a = null;
        private final int value;

        static {
            FrameDataType r100 = new FrameDataType("YUV", 0, 0);
            YUV = r100;
            FrameDataType r101 = new FrameDataType("Y", 1, 1);
            Y = r101;
            FrameDataType r102 = new FrameDataType("U", 2, 2);
            U = r102;
            FrameDataType r103 = new FrameDataType("V", 3, 3);
            V = r103;
            f449967a = new FrameDataType[]{r100, r101, r102, r103};
        }

        public static FrameDataType[] values() {
            return (FrameDataType[]) f449967a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static FrameDataType valueOf(String r100) {
            return (FrameDataType) r27.a.a(FrameDataType.class, r100);
        }

        public FrameDataType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public TEVideoUtils() {
    }

    private static native int nativeAVInterleaveCheckExecute(long r100, int r101);

    private static native long nativeAVInterleaveCheckInit(String r100, long r101, AVInterleaveCheckListener r102);

    private static native boolean nativeApplyLensNightEnhance(int r100, int r101, int r102, int r103, String r104, String r105, byte[][] r106, byte[] r107);

    public static native void nativeCancelCompileProbe();

    private static native int nativeCheckAudioFile(String r100);

    private static native int nativeCheckMVResourceIntegrity(String r100);

    private static native int nativeCheckMp3File(String r100);

    private static native void nativeClearCacheDiskDir(boolean r100);

    private static native int nativeClearWavSeg(String r100, int r101, int r102);

    public static native int nativeCompileProbe(String r100, String r101, int r102, int r103, long r104, long r105, int r106, int r107, int r110, long r111, double r112, CompileProbeListener r113, CompileProbeListener2 r114, int r115);

    private static native int nativeConcat(String[] r100, String r101, int r102);

    public static native int nativeConcatRecordFrag(String[] r100, long[] r101, String[] r102, long[] r103, boolean r104, int r105, String r106, String r107, String r108, String r109);

    public static native int nativeConverBitmapToRGBA(Bitmap r100, String r101);

    public static native int nativeConverRGBAToIMG(String r100, String r101, int r102, int r103);

    public static native int nativeConvertJpegToMp4(String r100, String r101, int r102, boolean r103);

    public static native long nativeCreateCurveSpeedUtils(float[] r100, float[] r101);

    private static native long nativeCreateGetFrameHandler(String r100);

    private static native long nativeCreateRTAudioWaveformMgr(int r100, int r101, float r102, int r103);

    public static native void nativeCurveSpeedDestroy(long r100);

    public static native String nativeDecodeSpade(String r100);

    private static native int nativeDecryptVideo(String r100, String r101, String r102);

    private static native int nativeDeleteRTAudioWaveformMgr(long r100);

    public static native int nativeDetachAudioFromVideos(String r100, String[] r101, long[] r102, long[] r103, long[] r104, long[] r105, long r106, long r107, float[] r110, int r111, int r112, int r113, int r114, boolean r115);

    public static native int nativeDetachAudioFromVideosCallback(String r100, Object r101, String[] r102, long[] r103, long[] r104, long[] r105, long[] r106, long r107, long r108, float[] r110, int r111, int r112, int r113);

    private static native int nativeDetectAudioMetrics(String r100, String r101, String r102, Object r103);

    private static native byte[][] nativeDetectScanPicture(Bitmap r100, String r101, String r102, DetectQRCodeListener r103);

    private static native int nativeExecuteFFmpegCommand(String r100, ExecuteCommandListener r101);

    private static native int nativeExecuteFFmpegCommandAndDumpInfo(String r100, ExecuteCommandListener r101, ExecuteCommandAndDumpInfoListener r102);

    private static native int nativeExtractVideo(String r100, String r101);

    private static native VEFaceDetectCropResult nativeFaceDetectScanPicture(Bitmap r100, boolean r101, String r102, String r103, String r104);

    public static native byte[][] nativeFaceDetectWithPoints(Bitmap r100);

    private static native boolean nativeFileEncrypted(String r100);

    public static native int nativeFindAudioSegmentStartTimeInOrigin(String r100, int r101, String r102, int r103, int r104);

    private static native String nativeFindBestRemuxSuffix(String r100);

    private static native int nativeGenerateMuteWav(String r100, int r101, int r102, int r103);

    private static native int nativeGetAVFileInfoFromXml(String r100, int[] r101);

    private static native Object nativeGetAudioAlgorithmResult(String r100, String r101, int r102, int r103);

    private static native int nativeGetAudioFileInfo(String r100, int[] r101);

    private static native int nativeGetAudioFileInfoForAllTracks(String r100, int[][] r101);

    private static native double nativeGetAudioVolume(byte[] r100, int r101, int r102, int r103);

    private static native VEMusicWaveBean nativeGetAudioWaveData(String r100, int r101, int r102, int r103, int r104, int r105);

    private static native int nativeGetAudioWaveDataAsync(String r100, int r101, TEAudioWavePointReceivedListener r102, String r103, int r104, int r105, int r106, int r107);

    public static native double nativeGetAveCurveSpeed(long r100);

    public static native double nativeGetCurveSpeedWithSeqDelta(long r100, long r101);

    private static native void nativeGetDstBitmapSize(long r100, int r101, int r102, int[] r103);

    private static native int nativeGetFileAudio(String r100, String r101, ArrayList<String> r102, boolean r103);

    private static native Object nativeGetFileInfo(String r100, int[] r101);

    private static native String nativeGetFileName(String r100, String r101);

    private static native int nativeGetFileType(String r100);

    private static native int nativeGetFrameWithHandler(long r100, Bitmap r101, int r102, int r103, int r104, boolean r105);

    private static native int nativeGetImageThumb(String r100, int r101, int r102, boolean r103, Object r104);

    private static native String nativeGetInfostickerConvertTotemplate(String r100);

    private static native String nativeGetMD5FileName(String r100, String r101);

    private static native Object nativeGetMVAlgorithmConfigs(String r100, String[] r101, int r102);

    private static native String nativeGetMVAlgorithmConfigsWithMultiImage(String r100, String[] r101, int r102);

    private static native int nativeGetMetaData(String r100, ArrayList<String> r101);

    private static native String nativeGetMimeType(String r100);

    private static native int nativeGetMusicDefaultAlgorithm(String r100, String r101);

    private static native VEMusicWaveBean nativeGetResampleMusicWaveData(float[] r100, int r101, int r102);

    private static native int nativeGetTargetBitmapSize(String r100, int r101, int r102, int[] r103);

    private static native Object nativeGetVEFileInfo(String r100);

    private static native int nativeGetVideoFrame(String r100, int[] r101, int r102, int r103, boolean r104, Object r105, int r106, boolean r107);

    private static native int nativeGetVideoFrame2(String r100, int[] r101, int r102, int r103, boolean r104, Object r105);

    private static native int nativeGetVideoFrame3(String r100, int[] r101, int r102, int r103, boolean r104, Object r105);

    private static native int nativeGetVideoFrame4(String r100, int[] r101, int r102, int r103, boolean r104, boolean r105, Object r106, boolean r107);

    private static native int nativeGetVideoFrameData(String r100, int r101, int r102, int r103, int r104, int r105, Object r106);

    private static native int nativeGetVideoFrameMore(String r100, int[] r101, int r102, int r103, boolean r104, boolean r105, int r106, boolean r107, Object r108);

    private static native int nativeGetVideoFrameWithBitmap(String r100, Bitmap r101, int r102, int r103, int r104, boolean r105);

    private static native int nativeGetVideoThumb(String r100, int r101, Object r102, boolean r103, int r104, int r105, long r106, int r107);

    private static native int nativeInitAREffect();

    private static native long nativeInitResampleContext(int r100, int r101, int r102, int r103);

    private static native int nativeIsByteVC110Bit(byte[] r100);

    private static native int nativeIsCanImport(String r100);

    private static native int nativeIsCanImportFd(int r100, long r101, long r102);

    private static native int nativeIsCanTransCode(String r100, int r101, int r102);

    private static native int nativeIsCanTransCodeWithResult(String r100, int r101, int r102, String[] r103);

    private static native boolean nativeIsFrameCanDrop(ByteBuffer r100, int r101, boolean r102);

    private static native boolean nativeIsLivePhotoForJPEGFile(String r100, String r101, boolean r102);

    private static native boolean nativeIsSamiAutomationValid(double r100, String r101);

    private static native boolean nativeIsSupportGLES3();

    private static native long nativeLoadModel(int r100, String r101);

    public static native long nativeMapSeqDeltaToTrimDelta(long r100, long r101);

    public static native long nativeMapTrimDeltaToSeqDelta(long r100, long r101);

    private static native int nativeMixAudio(ArrayList<String> r100, String r101, Object r102);

    private static native int nativeMux(String r100, String r101, String r102);

    private static native byte[][] nativeObjectScanPicture(Bitmap r100, int r101, int r102);

    private static native int nativePcmResampleFilter(long r100, byte[] r101, byte[] r102, int r103, int r104);

    private static native int nativeProcessAudioTuning(String[] r100, int[] r101, int[] r102, float r103, float r104, String r105, String r106);

    private static native int nativeRTAudioWaveformFinish(long r100);

    private static native int nativeRTAudioWaveformGetPoints(long r100, float[] r101, int r102, int r103);

    private static native int nativeRTAudioWaveformProcess(long r100, float[][] r101, int r102, int r103);

    private static native int nativeRTAudioWaveformReset(long r100);

    private static native int nativeRegisterDecoderForEffect();

    private static native void nativeReleaseGetFrameHandler(long r100);

    private static native int nativeReleaseGetFramesReader();

    private static native void nativeReleaseResampleContext(long r100);

    public static native void nativeReleaseVEMetadataCheckCallBack();

    private static native void nativeResetModel(long r100);

    private static native int nativeResizeBitmap(Bitmap r100, String r101, int r102, int r103, int r104, int r105);

    private static native int nativeResizeImage(String r100, String r101, int r102, int r103, int r104, int r105, boolean r106);

    private static native int nativeResizeRGBAImage(String r100, int r101, int r102, String r103, int r104, int r105, int r106, int r107);

    private static native int nativeReverseAllIFrameVideoAndMuxAudio(String r100, String r101, String r102);

    private static native int nativeReverseAllIFrameVideoAndMuxAudio2(String r100, String r101, String r102, TEReverseCallback r103);

    private static native int nativeReverseAllIVideo(String r100, String r101);

    private static native int nativeReverseAllIVideo2(String r100, String r101, TEReverseCallback r102);

    private static native boolean nativeSaveTexDescToLocal(String r100, Bitmap r101, Object r102);

    private static native int nativeSaveVideoFrames(String r100, int[] r101, int r102, int r103, boolean r104, String r105, int r106, int r107);

    private static native byte[][] nativeScanPicture(Bitmap r100, String r101, boolean r102, long r103, int r104, int r105);

    private static native byte[][] nativeScanPictureThird(Bitmap r100, int r101, boolean r102);

    private static native VEBachSceneRecognitionResult nativeSceneRecognitionScanPicture(Bitmap r100, int r101, String r102, String r103, String r104);

    public static native int nativeSetCurveSpeedData(long r100, float[] r101, float[] r102);

    private static native void nativeSetFrameCacheDiskDir(String r100);

    public static native int nativeSetMetaData(String r100, String r101, Map<String, String> r102);

    private static native void nativeSetPageMode(int r100);

    public static native void nativeSetSeqDuration(long r100, long r101);

    public static native void nativeSetVEMetadataReadAllowlistConfig(boolean r100, boolean r101, String r102, String r103, Object r104);

    public static native void nativeSetVEMetadataWriteAllowlistConfig(boolean r100, boolean r101, String r102, String r103, Object r104);

    private static native int nativeSplitVideo(String r100, String[] r101, int[] r102, boolean r103);

    private static native int nativeTransCodecAudioFile(String r100, int r101, int r102, String r103, int r104, int r105, int r106);

    public static native VETransformResult nativeTransformToIFrameAllStrategy(String r100, int r101, int r102, int r103, float r104, float r105, float r106);

    private static native int nativeTrimFile(String r100, String r101, int[] r102, int[] r103);

    private static native double nativeVoiceActivityDetection(byte[] r100, long r101, int r102, int r103);

    private static native int nativeconvertVideo2Gif(String r100, String r101, String r102, int r103, float r104, int r105, int r106, int r107, int r108, String r109, ExecuteCommandListener r110);

    private static native int nativeconvertVideo2Webp(int r100, int r101, String r102, int r103, int r104, int r105, String r106, ExecuteCommandListener r107);

    private static native int nativecropAudio(String r100, String r101, long r102, long r103);

    private static native int nativecutVideo(String r100, String r101, String r102, String r103);

    private static native int nativegeneratePalettegen(String r100, int r101, int r102, String r103);

    private static native int nativereverseAudio(String r100, String r101);

    private static native int nativetransCodeAudio(String r100, String r101, int r102, int r103, int r104, String r105);

    public static native int remuxVideo(String r100, String r101);

    static {
        TENativeLibsLoader.loadLibrary();
        getFrameInterval = 1000;
    }

    public static int initAREffect() {
        return nativeInitAREffect();
    }

    public static boolean isSupportGLES3() {
        return nativeIsSupportGLES3();
    }

    public static int registerDecoderForEffect() {
        return nativeRegisterDecoderForEffect();
    }

    public static int releaseGetFramesReader() {
        return nativeReleaseGetFramesReader();
    }

    public static int checkAudioFile(String r100) {
        return nativeCheckAudioFile(r100);
    }

    public static int checkMVResourceIntegrity(String r100) {
        return nativeCheckMVResourceIntegrity(r100);
    }

    public static int checkMp3File(String r100) {
        return nativeCheckMp3File(r100);
    }

    public static void clearCacheDiskDir(boolean r100) {
        nativeClearCacheDiskDir(r100);
    }

    public static long createGetFrameHandler(String r100) {
        return nativeCreateGetFrameHandler(r100);
    }

    public static int deleteRTAudioWaveformMgr(long r100) {
        return nativeDeleteRTAudioWaveformMgr(r100);
    }

    public static boolean fileEncrypted(String r100) {
        return nativeFileEncrypted(r100);
    }

    public static String findBestRemuxSuffix(String r100) throws VEException {
        if (r100.length() <= 0) goto L10;
        String r101 = nativeFindBestRemuxSuffix(r100);
        if (r101.length() <= 0) goto L8;
        return r101;
    L8:
        throw new VEException(-205, "This file does not support re-packaging for the time being!");
    L10:
        throw new VEException(-100, "Please check the input parameters!");
    }

    public static int getFileType(String r100) {
        return nativeGetFileType(r100);
    }

    public static String getInfostickerConvertTotemplate(String r100) {
        return nativeGetInfostickerConvertTotemplate(r100);
    }

    public static HashMap<String, String> getMetaData(String r100) {
        ArrayList r101 = new ArrayList();
        if (nativeGetMetaData(r100, r101) == 0) goto L6;
        VELogUtil.e("TEVideoUtils", "failed to get MetaData");
        return null;
    L6:
        HashMap<String, String> r102 = new HashMap();
        int r103 = 0;
    L8:
        if (r103 >= (r101.size() / 2)) goto L10;
        int r104 = r103 * 2;
        r102.put((String) ListProtector.get(r101, r104), (String) ListProtector.get(r101, r104 + 1));
        r103 = r103 + 1;
        goto L8
    L10:
        return r102;
    }

    public static String getMimeType(String r100) {
        return nativeGetMimeType(r100);
    }

    public static Object getVEVideoFileInfo(String r100) {
        return nativeGetVEFileInfo(r100);
    }

    public static int isByteVC110Bit(byte[] r100) {
        return nativeIsByteVC110Bit(r100);
    }

    public static int isCanImport(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return -100;
    L7:
        return nativeIsCanImport(r100);
    }

    public static void releaseGetFrameHandler(long r100) {
        nativeReleaseGetFrameHandler(r100);
    }

    public static void releaseResampleContext(long r100) {
        nativeReleaseResampleContext(r100);
    }

    public static void resetModel(long r100) {
        nativeResetModel(r100);
    }

    public static int rtAudioWaveformFinish(long r100) {
        return nativeRTAudioWaveformFinish(r100);
    }

    public static int rtAudioWaveformReset(long r100) {
        return nativeRTAudioWaveformReset(r100);
    }

    public static VEBachQRCodeResult scanPicture(VEBachQRCodeParam r110) {
        Bitmap r100 = r110.getBitmap();
        Bitmap r101 = null;
        VEBachQRCodeResult r102 = null;
        if (r100 == null) goto L62;
        byte[][] r111 = nativeScanPicture(r110.getBitmap(), r110.getAlgorithmConfig(), true, 0, 0, 0);
        if (r111 != null) goto L7;
        return null;
    L7:
        return VEBachQRCodeResult.fromCameraParcel(r111[0], null);
    L62:
        Bitmap r103 = BitmapLoader.loadBitmap(r110.getPicturePath(), 0, 0);     // Catch: Throwable -> L34 OutOfMemoryError -> L36 Exception -> L43
        if (r103 != null) goto L60;
        Bitmap r104 = null;
    L22:
        if (r103 != null) goto L24;
    L26:
        byte[][] r112 = nativeScanPicture(r104, r110.getAlgorithmConfig(), true, 0, 0, 0);
        if (r112 == null) goto L29;
        r102 = VEBachQRCodeResult.fromCameraParcel(r112[0], null);
    L29:
        if (r104 != null) goto L31;
    L33:
        return r102;
    L31:
        if (r104.isRecycled() == true) goto L33;
        r104.recycle();
        goto L33
    L24:
        if (r103.isRecycled() == true) goto L26;
        r103.recycle();
        goto L26
    L60:
        int r105 = r103.getWidth();     // Catch: Exception -> L19 OutOfMemoryError -> L58 Throwable -> L51
        int r106 = r103.getHeight();     // Catch: Exception -> L19 OutOfMemoryError -> L58 Throwable -> L51
        if ((r105 * r106) <= 4000000) goto L13;
        float r107 = (float) (1.0d / Math.sqrt((r105 * r106) / 4000000));     // Catch: Exception -> L19 OutOfMemoryError -> L58 Throwable -> L51
        Matrix r108 = new Matrix();     // Catch: Exception -> L19 OutOfMemoryError -> L58 Throwable -> L51
        r108.postScale(r107, r107);     // Catch: Exception -> L19 OutOfMemoryError -> L58 Throwable -> L51
        Bitmap r109 = Bitmap.createBitmap(r103, 0, 0, r105, r106, r108, true);     // Catch: Exception -> L19 OutOfMemoryError -> L58 Throwable -> L51
    L15:
        if (r103.isRecycled() == true) goto L18;
        r103.recycle();     // Catch: Exception -> L19 OutOfMemoryError -> L58 Throwable -> L51
        r103 = null;
        goto L18
    L18:
        r104 = r109;
        goto L22
    L13:
        r109 = r103.copy(Bitmap.Config.ARGB_8888, true);     // Catch: Exception -> L19 OutOfMemoryError -> L58 Throwable -> L51
    L19:
        e = e;
    L45:
        VELogUtil.e("TEVideoUtils", e.getMessage());     // Catch: Throwable -> L51
        if (r103 != null) goto L48;
    L50:
        return null;
    L48:
        if (r103.isRecycled() == true) goto L50;
        r103.recycle();
    L37:
        VELogUtil.e("TEVideoUtils", "bitmap OutOfMemoryError");     // Catch: Throwable -> L51
        if (r103 != null) goto L40;
    L42:
        return null;
    L40:
        if (r103.isRecycled() == true) goto L42;
        r103.recycle();
        goto L42
    L43:
        e = e;
        r103 = null;
    L36:
        r103 = null;
    L34:
        th = th;
    L53:
        if (r101 != null) goto L55;
    L57:
        throw th;
    L55:
        if (r101.isRecycled() == true) goto L57;
        r101.recycle();
    L51:
        th = th;
        r101 = r100;
        goto L53
    }

    public static void setFrameCacheDiskDir(String r100) {
        nativeSetFrameCacheDiskDir(r100);
    }

    public static List<VEScanResult> scanPicture(VEBachAlgorithmParam r110) {
        Bitmap r100 = r110.bitmap;
        if (r100 != null) goto L5;
        r100 = BitmapLoader.loadBitmapCompat(VERuntime.getInstance().getContext().getContentResolver(), r110.picturePath, r110.reqWidth, r110.reqHeight);
    L5:
        Bitmap r101 = r100;
        int r102 = r110.getAlgorithmType();
        ArrayList r103 = new ArrayList();
        if (r102 != 12) goto L8;
        VEBachObjectScanParam r111 = (VEBachObjectScanParam) r110;
        nativeObjectScanPicture(r101, r111.scanType, r111.maxObjectNum);
    L35:
        return r103;
    L8:
        int r112 = 0;
        if (r102 != 11) goto L17;
        byte[][] r113 = nativeScanPicture(r101, ((VEBachQRCodeParam) r110).algorithmConfig, true, 0, 0, 0);
        if (r113 != null) goto L13;
    L15:
        return r103;
    L13:
        if (r112 >= r113.length) goto L15;
        r103.add(VEBachQRCodeResult.fromCameraParcel(r113[r112], null));
        r112 = r112 + 1;
        goto L13
    L17:
        if (r102 != 15) goto L22;
        VEBachSceneRecognitionParam r114 = (VEBachSceneRecognitionParam) r110;
        VEBachSceneRecognitionResult r115 = nativeSceneRecognitionScanPicture(r101, r114.getSceneType().ordinal(), r114.getAlgorithmConfig(), r114.getApplicationName(), r114.getModelPath());
        if (r115 == null) goto L35;
        r103.add(r115);
        goto L35
    L22:
        if (r102 != 25) goto L29;
        byte[][] r116 = nativeFaceDetectWithPoints(r101);
        if (r116 == null) goto L35;
    L26:
        if (r112 >= r116.length) goto L35;
        r103.add(VEBachFaceDetectResult.fromCameraParcel(r116[r112]));
        r112 = r112 + 1;
        goto L26
    L29:
        if (r102 != 16) goto L35;
        VEThirdQRCodeDetectParam r117 = (VEThirdQRCodeDetectParam) r110;
        byte[][] r118 = nativeScanPictureThird(r101, (int) r117.codeType, r117.isMultiCode);
        if (r118 == null) goto L35;
        int r104 = r118.length;
        int r105 = 0;
    L33:
        if (r105 >= r104) goto L35;
        r103.add(VEBachQRCodeResult.fromCameraParcelThirdParty(r118[r105], null, 0));
        r105 = r105 + 1;
        goto L33
    }

    public static VEFaceDetectCropResult scanPicture(VEFaceDetectCropParam r100) {
        Bitmap r101 = r100.bitmap;
        if (r101 != null) goto L10;
        if (VERuntime.getInstance().getContext() != null) goto L8;
        VELogUtil.e("TEVideoUtils", "VEFaceDetectCropResult.scanPicture VERuntime context == null, return result null");
        return null;
    L8:
        r101 = BitmapLoader.loadBitmapCompat(VERuntime.getInstance().getContext().getContentResolver(), r100.picturePath, r100.reqWidth, r100.reqHeight);
    L10:
        return nativeFaceDetectScanPicture(r101, r100.isFastPath, r100.bingoCropImgPath, r100.smashCropImgPath, r100.slowPathImgPath);
    }

    public static int AVInterleaveCheckExecute(long r100, int r101) {
        if ((-1) != r100) goto L7;
        return -112;
    L7:
        return nativeAVInterleaveCheckExecute(r100, r101);
    }

    public static int ConverBitmapToRGBA(Bitmap r100, String r101) {
        return nativeConverBitmapToRGBA(r100, r101);
    }

    public static int concat(String[] r100, String r101) {
        return nativeConcat(r100, r101, 0);
    }

    public static long createCurveSpeedUtils(float[] r100, float[] r101) {
        return nativeCreateCurveSpeedUtils(r100, r101);
    }

    public static int executeFFmpegCommand(String r100, ExecuteCommandListener r101) {
        return nativeExecuteFFmpegCommand(r100, r101);
    }

    public static int extractVideo(String r100, String r101) {
        return nativeExtractVideo(r100, r101);
    }

    public static int getAVFileInfoFromXml(String r100, int[] r101) {
        return nativeGetAVFileInfoFromXml(r100, r101);
    }

    public static int getAudioFileInfo(String r100, int[] r101) {
        return nativeGetAudioFileInfo(r100, r101);
    }

    public static int getAudioFileInfoForAllTracks(String r100, int[][] r101) {
        return nativeGetAudioFileInfoForAllTracks(r100, r101);
    }

    public static String getFileName(String r100, String r101) {
        return nativeGetFileName(r100, r101);
    }

    public static String getMD5FileName(String r100, String r101) {
        return nativeGetMD5FileName(r100, r101);
    }

    public static Object getMVAlgorithmConfigs(String r100, List<String> r101) {
        int r102 = r101.size();
        String[] r103 = new String[r102];
        r101.toArray(r103);
        return nativeGetMVAlgorithmConfigs(r100, r103, r102);
    }

    public static String getMVAlgorithmConfigsWithMultiImage(String r100, List<String> r101) {
        int r102 = r101.size();
        String[] r103 = new String[r102];
        r101.toArray(r103);
        return nativeGetMVAlgorithmConfigsWithMultiImage(r100, r103, r102);
    }

    public static int getMusicDefaultAlgorithm(String r100, String r101) {
        return nativeGetMusicDefaultAlgorithm(r100, r101);
    }

    public static Object getVideoFileInfo(String r100, int[] r101) {
        return nativeGetFileInfo(r100, r101);
    }

    public static boolean isSamiAutomationValid(double r100, String r101) {
        return nativeIsSamiAutomationValid(r100, r101);
    }

    public static long loadModel(int r100, String r101) {
        return nativeLoadModel(r100, r101);
    }

    public static int reverseAllIVideo(String r100, String r101) {
        return nativeReverseAllIVideo(r100, r101);
    }

    public static int reverseAudio(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return -100;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return -100;
    L9:
        return nativereverseAudio(r100, r101);
    }

    public static long AVInterleaveCheckInit(String r100, long r101, AVInterleaveCheckListener r102) {
        return nativeAVInterleaveCheckInit(r100, r101, r102);
    }

    public static int clearWavSeg(String r100, int r101, int r102) {
        return nativeClearWavSeg(r100, r101, r102);
    }

    public static int concat(String[] r100, String r101, int r102) {
        return nativeConcat(r100, r101, r102);
    }

    public static int decryptVideo(String r100, String r101, String r102) {
        return nativeDecryptVideo(r100, r101, r102);
    }

    public static VEBachQRCodeResult detectAndScanPicture(VEBachQRCodeDetectParam r110, VEBachQRCodeParam r111, DetectQRCodeListener r112) {
        Bitmap r100 = null;
        if (r110.getAlgorithmType() == 13) goto L6;
        VELogUtil.d("detectAndScanPicture", "AlgorithmType type error");
        return null;
    L6:
        Bitmap r101 = r110.getBitmap();
        if (r101 == null) goto L66;
        byte[][] r113 = nativeDetectScanPicture(r110.getBitmap(), r110.algorithmConfig, r111.algorithmConfig, r112);
    L31:
        if (r113 != null) goto L33;
    L36:
        VELogUtil.d("detectAndScanPicture", "picture qrcode detect ret is null");
        return null;
    L33:
        if (r113.length <= 0) goto L36;
        return VEBachQRCodeResult.fromCameraParcel(r113[0], null);
    L66:
        Bitmap r102 = BitmapLoader.loadBitmap(r110.getPicturePath(), 0, 0);     // Catch: Throwable -> L38 OutOfMemoryError -> L40 Exception -> L47
        if (r102 != null) goto L64;
        Bitmap r103 = null;
    L22:
        if (r102 != null) goto L24;
    L26:
        r113 = nativeDetectScanPicture(r103, r110.algorithmConfig, r111.algorithmConfig, r112);
        if (r103 == null) goto L31;
        if (r103.isRecycled() == true) goto L31;
        r103.recycle();
        goto L31
    L24:
        if (r102.isRecycled() == true) goto L26;
        r102.recycle();
        goto L26
    L64:
        int r104 = r102.getWidth();     // Catch: Exception -> L19 OutOfMemoryError -> L62 Throwable -> L55
        int r105 = r102.getHeight();     // Catch: Exception -> L19 OutOfMemoryError -> L62 Throwable -> L55
        if ((r104 * r105) <= 4000000) goto L14;
        float r106 = (float) (1.0d / Math.sqrt((r104 * r105) / 4000000));     // Catch: Exception -> L19 OutOfMemoryError -> L62 Throwable -> L55
        Matrix r114 = new Matrix();     // Catch: Exception -> L19 OutOfMemoryError -> L62 Throwable -> L55
        r114.postScale(r106, r106);     // Catch: Exception -> L19 OutOfMemoryError -> L62 Throwable -> L55
        r103 = Bitmap.createBitmap(r102, 0, 0, r104, r105, r114, true);     // Catch: Exception -> L19 OutOfMemoryError -> L62 Throwable -> L55
    L16:
        if (r102.isRecycled() == true) goto L22;
        r102.recycle();     // Catch: Exception -> L19 OutOfMemoryError -> L62 Throwable -> L55
        r102 = null;
        goto L22
        goto L41
    L14:
        r103 = r102.copy(Bitmap.Config.ARGB_8888, true);     // Catch: Exception -> L19 OutOfMemoryError -> L62 Throwable -> L55
    L19:
        e = e;
    L49:
        VELogUtil.e("TEVideoUtils", e.getMessage());     // Catch: Throwable -> L55
        if (r102 != null) goto L52;
    L54:
        return null;
    L52:
        if (r102.isRecycled() == true) goto L54;
        r102.recycle();
    L41:
        VELogUtil.e("TEVideoUtils", "bitmap OutOfMemoryError");     // Catch: Throwable -> L55
        if (r102 != null) goto L44;
    L46:
        return null;
    L44:
        if (r102.isRecycled() == true) goto L46;
        r102.recycle();
        goto L46
    L47:
        e = e;
        r102 = null;
    L40:
        r102 = null;
    L38:
        th = th;
    L57:
        if (r100 != null) goto L59;
    L61:
        throw th;
    L59:
        if (r100.isRecycled() == true) goto L61;
        r100.recycle();
    L55:
        th = th;
        r100 = r101;
        goto L57
    }

    public static int executeFFmpegCommandAndDumpInfo(String r100, ExecuteCommandListener r101, ExecuteCommandAndDumpInfoListener r102) {
        return nativeExecuteFFmpegCommandAndDumpInfo(r100, r101, r102);
    }

    public static VEMusicWaveBean getResampleMusicWaveData(float[] r100, int r101, int r102) {
        return nativeGetResampleMusicWaveData(r100, r101, r102);
    }

    public static int isCanImportFd(int r100, long r101, long r102) {
        if (r100 > 0) goto L6;
        return -100;
    L6:
        return nativeIsCanImportFd(r100, r101, r102);
    }

    public static int isCanTransCode(String r100, int r101, int r102) {
        return nativeIsCanTransCode(r100, r101, r102);
    }

    public static boolean isFrameCanDrop(ByteBuffer r100, int r101, boolean r102) {
        return nativeIsFrameCanDrop(r100, r101, r102);
    }

    public static boolean isLivePhotoForJPEGFile(String r100, String r101, boolean r102) {
        return nativeIsLivePhotoForJPEGFile(r100, r101, r102);
    }

    public static int mixAudio(ArrayList<String> r100, String r101, Object r102) {
        return nativeMixAudio(r100, r101, r102);
    }

    public static int mux(String r100, String r101, String r102) {
        return nativeMux(r100, r101, r102);
    }

    public static int reverseAllIVideo(String r100, String r101, TEReverseCallback r102) {
        return nativeReverseAllIVideo2(r100, r101, r102);
    }

    public static int reverseAllIVideoAndMuxAudio(String r100, String r101, String r102) {
        return nativeReverseAllIFrameVideoAndMuxAudio(r100, r101, r102);
    }

    public static boolean saveTexDescToLocal(String r100, Bitmap r101, Object r102) {
        return nativeSaveTexDescToLocal(r100, r101, r102);
    }

    public static int ConverRGBAToIMG(String r100, String r101, int r102, int r103) {
        return nativeConverRGBAToIMG(r100, r101, r102, r103);
    }

    public static int convertJpegToMp4(String r100, String r101, int r102, boolean r103) {
        return nativeConvertJpegToMp4(r100, r101, r102, r103);
    }

    public static long createRTAudioWaveformMgr(int r100, int r101, float r102, int r103) {
        return nativeCreateRTAudioWaveformMgr(r100, r101, r102, r103);
    }

    public static int cropAudio(String r100, String r101, long r102, long r103) {
        return nativecropAudio(r100, r101, r102, r103);
    }

    public static int cutVideo(String r100, String r101, String r102, String r103) {
        return nativecutVideo(r100, r101, r102, r103);
    }

    public static int detectAudioMetrics(String r100, String r101, String r102, Object r103) {
        return nativeDetectAudioMetrics(r100, r101, r102, r103);
    }

    public static int generateMuteWav(String r100, int r101, int r102, int r103) {
        return nativeGenerateMuteWav(r100, r101, r102, r103);
    }

    public static int generatePalettegen(String r100, int r101, int r102, String r103) {
        return nativegeneratePalettegen(r100, r101, r102, r103);
    }

    public static Object getAudioAlgorithmResult(String r100, String r101, int r102, int r103) {
        return nativeGetAudioAlgorithmResult(r100, r101, r102, r103);
    }

    public static double getAudioVolume(byte[] r100, int r101, int r102, int r103) {
        return nativeGetAudioVolume(r100, r101, r102, r103);
    }

    public static int getFileAudio(String r100, String r101, ArrayList<String> r102, boolean r103) {
        return nativeGetFileAudio(r100, r101, r102, r103);
    }

    public static long initResampleContext(int r100, int r101, int r102, int r103) {
        return nativeInitResampleContext(r100, r101, r102, r103);
    }

    public static int isCanTransCodeWithResult(String r100, int r101, int r102, String[] r103) {
        return nativeIsCanTransCodeWithResult(r100, r101, r102, r103);
    }

    public static int reverseAllIVideoAndMuxAudio(String r100, String r101, String r102, TEReverseCallback r103) {
        return nativeReverseAllIFrameVideoAndMuxAudio2(r100, r101, r102, r103);
    }

    public static int rtAudioWaveformGetPoints(long r100, float[] r101, int r102, int r103) {
        return nativeRTAudioWaveformGetPoints(r100, r101, r102, r103);
    }

    public static int rtAudioWaveformProcess(long r100, float[][] r101, int r102, int r103) {
        return nativeRTAudioWaveformProcess(r100, r101, r102, r103);
    }

    public static int splitVideo(String r100, String[] r101, int[] r102, boolean r103) {
        return nativeSplitVideo(r100, r101, r102, r103);
    }

    public static int trimVideoFile(String r100, int[] r101, String r102, int[] r103) {
        return nativeTrimFile(r100, r102, r101, r103);
    }

    public static double voiceActivityDetection(byte[] r100, long r101, int r102, int r103) {
        return nativeVoiceActivityDetection(r100, r101, r102, r103);
    }

    public static int findAudioSegmentStartTimeInOrigin(String r100, int r101, String r102, int r103, int r104) {
        return nativeFindAudioSegmentStartTimeInOrigin(r100, r101, r102, r103, r104);
    }

    public static Bitmap getFrameWithHandler(long r110, int r111, int r112, int r113, boolean r114) {
        int[] r100 = new int[2];
        nativeGetDstBitmapSize(r110, r112, r113, r100);
        Bitmap r101 = Bitmap.createBitmap(r100[0], r100[1], Bitmap.Config.ARGB_8888);
        if (r101 != null) goto L6;
        return null;
    L6:
        if (nativeGetFrameWithHandler(r110, r101, r111, r100[0], r100[1], r114) != 0) goto L8;
        return r101;
    L8:
        if (r101.isRecycled() == true) goto L11;
        r101.recycle();
    L11:
        return null;
    }

    public static int getImageThumb(String r100, int r101, int r102, boolean r103, Object r104) {
        return nativeGetImageThumb(r100, r101, r102, r103, r104);
    }

    public static Bitmap getVideoFrame(String r110, int r111, int r112, int r113, boolean r114) {
        int[] r100 = new int[2];
        if (nativeGetTargetBitmapSize(r110, r112, r113, r100) != 0) goto L16;
        int r101 = r100[0];
        if (r101 <= 0) goto L16;
        int r102 = r100[1];
        if (r102 <= 0) goto L16;
        Bitmap r103 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        if (r103 != null) goto L13;
        return null;
    L13:
        if (nativeGetVideoFrameWithBitmap(r110, r103, r111, r112, r113, r114) == 0) goto L15;
        return null;
    L15:
        return r103;
    L16:
        return null;
    }

    public static int pcmResampleFilter(long r100, byte[] r101, byte[] r102, int r103, int r104) {
        return nativePcmResampleFilter(r100, r101, r102, r103, r104);
    }

    public static VEMusicWaveBean getAudioWaveData(String r100, int r101, int r102, int r103, int r104, int r105) {
        return nativeGetAudioWaveData(r100, r101, r102, r103, r104, r105);
    }

    public static int getVideoFrames2(String r100, int[] r101, int r102, int r103, boolean r104, Object r105) {
        return nativeGetVideoFrame2(r100, r101, r102, r103, r104, r105);
    }

    public static int getVideoFrames3(String r100, int[] r101, int r102, int r103, boolean r104, Object r105) {
        return nativeGetVideoFrame3(r100, r101, r102, r103, r104, r105);
    }

    public static int resizeBitmap(Bitmap r100, String r101, int r102, int r103, int r104, int r105) {
        return nativeResizeBitmap(r100, r101, r102, r103, r104, r105);
    }

    public static int transCodeAudio(String r100, String r101, int r102, int r103, int r104, String r105) {
        return nativetransCodeAudio(r100, r101, r102, r103, r104, r105);
    }

    public static byte[] applyLensNightEnhance(int r110, int r111, int r112, int r113, String r114, String r115, byte[][] r116) {
        if (r110 <= 0) goto L13;
        if (r111 > 0) goto L7;
        return null;
    L7:
        if (r113 >= r116.length) goto L9;
        return null;
    L9:
        byte[] r100 = new byte[((r110 * r111) * 3) / 2];
        if (nativeApplyLensNightEnhance(r110, r111, r112, r113, r114, r115, r116, r100) == true) goto L12;
        return null;
    L12:
        return r100;
    L13:
        return null;
    }

    public static int getVideoFrameData(String r100, int r101, int r102, int r110, int r111, FrameDataType r112, Object r113) {
        return nativeGetVideoFrameData(r100, r101, r102, r110, r111, r112.getValue(), r113);
    }

    public static int processAudioTuning(String[] r100, int[] r101, int[] r102, float r103, float r104, String r105, String r106) {
        return nativeProcessAudioTuning(r100, r101, r102, r103, r104, r105, r106);
    }

    public static int resizeImage(String r100, String r101, int r102, int r103, int r104, int r105, boolean r106) {
        return nativeResizeImage(r100, r101, r102, r103, r104, r105, r106);
    }

    public static int transCodeAudioFile(String r100, int r101, int r102, String r103, int r104, int r105, int r106) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return -100;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return -100;
    L9:
        return nativeTransCodecAudioFile(r100, r101, r102, r103, r104, r105, r106);
    }

    public static int convertVideo2Webp(int r100, int r101, String r102, int r103, int r104, int r105, String r106, ExecuteCommandListener r107) {
        return nativeconvertVideo2Webp(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static int getAudioWaveDataAsync(String r100, int r101, TEAudioWavePointReceivedListener r102, String r103, int r104, int r105, int r106, int r107) {
        return nativeGetAudioWaveDataAsync(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static int getVideoFrames(String r100, int[] r101, int r102, int r103, boolean r104, Object r105, int r106, boolean r107) {
        return nativeGetVideoFrame(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static int getVideoThumb(String r100, int r101, Object r102, boolean r103, int r104, int r105, long r106, int r107) {
        return nativeGetVideoThumb(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static int resizeRGBAImage(String r100, int r101, int r102, String r103, int r104, int r105, int r106, int r107) {
        return nativeResizeRGBAImage(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static int saveVideoFrames(String r100, int[] r101, int r102, int r103, boolean r104, String r105, int r106, int r107) {
        return nativeSaveVideoFrames(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static int getVideoFrames(String r100, int[] r101, int r102, int r103, boolean r104, boolean r105, Object r106, boolean r107) {
        return nativeGetVideoFrame4(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static int getVideoFramesMore(String r100, int[] r101, int r102, int r103, boolean r104, boolean r105, int r106, boolean r107, Object r108) {
        return nativeGetVideoFrameMore(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static int concatRecordFrag(String[] r100, long[] r101, String[] r102, long[] r103, boolean r110, int r111, String r112, String r113, String r114, String r115) {
        if (TextUtils.isEmpty(r114) == false) goto L5;
    L29:
        VELogUtil.e("TEVideoUtils", "ConmatRecordFrag parameter error!");
        return -100;
    L5:
        if (TextUtils.isEmpty(r115) == true) goto L29;
        if (r100.length == 0) goto L29;
        if (r101.length != r100.length) goto L29;
        if (r100.length != r102.length) goto L29;
        if (r100.length != r103.length) goto L29;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r114.substring(0, r114.lastIndexOf(HTTP.URL_DEFAULT)));
        if (r104.exists() == false) goto L18;
    L21:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r115.substring(0, r115.lastIndexOf(HTTP.URL_DEFAULT)));
        if (r105.exists() == true) goto L28;
        if (r105.mkdirs() == true) goto L28;
        VELogUtil.e("TEVideoUtils", "create audio output dir failed. Output audio Directory: ".concat(r115));
        return -114;
    L28:
        return nativeConcatRecordFrag(r100, r101, r102, r103, r110, r111, r112, r113, r114, r115);
    L18:
        if (r104.mkdirs() == true) goto L21;
        VELogUtil.e("TEVideoUtils", "create video output dir failed. Output Video Directory: ".concat(r114));
        return -114;
    }

    public static int convertVideo2Gif(String r100, String r101, String r102, int r103, float r104, int r105, int r106, int r107, int r108, String r109, ExecuteCommandListener r110) {
        return nativeconvertVideo2Gif(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110);
    }

    public static int detachAudioFromVideos(String r110, String[] r111, long[] r112, long[] r210, long[] r211, long[] r212, long r213, long r214, float[] r215, int r216, int r217, int r310, int r311) {
        return nativeDetachAudioFromVideos(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, VEConfigCenter.getInstance().getValue("ve_enable_fix_detach_wav_format", true).booleanValue());
    }

    public static int detachAudioFromVideosCallback(String r100, Object r101, String[] r102, long[] r103, long[] r104, long[] r105, long[] r106, long r107, long r108, float[] r110, int r111, int r112, int r113) {
        return nativeDetachAudioFromVideosCallback(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113);
    }
}
