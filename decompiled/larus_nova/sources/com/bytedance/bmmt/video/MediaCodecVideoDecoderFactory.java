package com.bytedance.bmmt.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.bytedance.bmmt.base.Logging;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
class MediaCodecVideoDecoderFactory {
    private static final String TAG = "MediaCodecVideoDecoderFactory";
    private boolean enableAgfxSurfaceTextureHelper;

    public static VideoCodecDesc[] getSupportedCodecs() {
        ArrayList r100 = new ArrayList();
        BmmtVideoCodecStandard r101 = BmmtVideoCodecStandard.H264;
        MediaCodecInfo r102 = findCodecForType(r101);
        if (r102 == null) goto L9;
        if (isH264HighProfileSupported(r102, r101) == false) goto L7;
        r100.add(new VideoCodecDesc(r101, BmmtVideoCodecProfile.ProfileHigh));
    L7:
        r100.add(new VideoCodecDesc(r101, BmmtVideoCodecProfile.ProfileBaseline));
    L9:
        return (VideoCodecDesc[]) r100.toArray(new VideoCodecDesc[r100.size()]);
    }

    public MediaCodecVideoDecoderFactory() {
        this.enableAgfxSurfaceTextureHelper = false;
    }

    public static VideoDecoder createDecoder(VideoCodecDesc r100) {
        BmmtVideoCodecStandard r101 = r100.getStandard();
        MediaCodecInfo r102 = findCodecForType(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        MediaCodecInfo.CodecCapabilities r103 = r102.getCapabilitiesForType(r101.mimeType());
        int[] r104 = r103.colorFormats;
        int r105 = r104.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L8;
        Logging.w(TAG, "support codecColorFormat:" + r104[r106]);
        r106 = r106 + 1;
        goto L6
    L8:
        Integer r107 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, r103);
        if (r107 != null) goto L12;
        return null;
    L12:
        return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), r102.getName(), r101, r107.intValue());
    }

    public static void enableEglLock(boolean r100) {
        Logging.e(TAG, "MediaCodecVideoDecoderFactory enableEglLock:" + r100);
        EglBase.EglLock.enableEglLock = r100;
    }

    private static MediaCodecInfo findCodecForType(BmmtVideoCodecStandard r100) {
        int r101 = 0;
    L23:
        if (r101 >= MediaCodecList.getCodecCount()) goto L22;
        MediaCodecInfo r102 = MediaCodecList.getCodecInfoAt(r101);     // Catch: IllegalArgumentException -> L8 Exception -> L20
    L10:
        if (r102 == null) goto L19;
        if (r102.isEncoder() == true) goto L19;
        if (isSoftwareDecoder(r102) == true) goto L19;
        if (isSupportedCodec(r102, r100) == false) goto L19;
        return r102;
    L19:
        r101 = r101 + 1;
        goto L23
    L8:
        e = move-exception;
        Logging.e(TAG, "Cannot retrieve decoder codec info", e);     // Catch: Exception -> L20
        r102 = null;
    L22:
        return null;
    L20:
        e = move-exception;
        Logging.e(TAG, "findCodecForType got system error:", e);
        goto L22
    }

    private static boolean isSoftwareDecoder(MediaCodecInfo r100) {
    L33:
        e = move-exception;
        Logging.e(TAG, "check decoder softonly error.", e);
        return false;
    L4:
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        String r101 = r100.getName();     // Catch: Exception -> L33
        if (r101 != null) goto L10;
        return false;
    L10:
        String r102 = r101.toLowerCase();     // Catch: Exception -> L33
        if (r102.startsWith("arc.") == false) goto L14;
        return false;
    L14:
        if (r102.startsWith("omx.google.") == false) goto L16;
    L31:
        return true;
    L16:
        if (r102.startsWith("omx.ffmpeg.") == true) goto L31;
        if (r102.startsWith("omx.sec.") == false) goto L22;
        if (r102.contains(".sw.") == true) goto L31;
    L22:
        if (r102.startsWith("c2.android.") == true) goto L31;
        if (r102.equals("omx.qcom.video.decoder.hevcswvdec") == true) goto L31;
        if (r102.startsWith("c2.google.") == true) goto L31;
        if (r102.startsWith("omx.") == false) goto L30;
        return false;
    L30:
        if (r102.startsWith("c2.") == false) goto L31;
        return false;
    L6:
        return r100.isSoftwareOnly();
    }

    private static boolean isH264HighProfileSupported(MediaCodecInfo r100, BmmtVideoCodecStandard r101) {
        String r102 = r100.getName();
        int r103 = Build.VERSION.SDK_INT;
        if (r102.startsWith("OMX.qcom.") == false) goto L6;
        return true;
    L6:
        if (r103 >= 23) goto L8;
    L10:
        MediaCodecInfo.CodecCapabilities r104 = r100.getCapabilitiesForType(r101.mimeType());
        int r105 = 0;
    L11:
        MediaCodecInfo.CodecProfileLevel[] r106 = r104.profileLevels;
        if (r105 >= r106.length) goto L17;
        if (8 == r106[r105].profile) goto L15;
        r105 = r105 + 1;
        goto L11
    L15:
        return true;
    L17:
        return false;
    L8:
        if (r102.startsWith("OMX.Exynos.") == false) goto L10;
        return true;
    }

    private static boolean isSupportedCodec(MediaCodecInfo r100, BmmtVideoCodecStandard r101) {
        r100.getName();
        if (MediaCodecUtils.codecSupportsType(r100, r101) == true) goto L6;
        return false;
    L6:
        if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, r100.getCapabilitiesForType(r101.mimeType())) != null) goto L8;
        return false;
    L8:
        return true;
    }
}
