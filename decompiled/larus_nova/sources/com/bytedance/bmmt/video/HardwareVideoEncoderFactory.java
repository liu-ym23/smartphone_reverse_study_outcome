package com.bytedance.bmmt.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.bytedance.bmmt.base.Logging;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class HardwareVideoEncoderFactory {
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "HwVideoEncoderFactory";

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.HardwareVideoEncoderFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard = null;

        static {
            int[] r100 = new int[BmmtVideoCodecStandard.values().length];
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard = r100;
            r100[BmmtVideoCodecStandard.H264.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[BmmtVideoCodecStandard.ByteVC1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[BmmtVideoCodecStandard.VP8.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[BmmtVideoCodecStandard.VP9.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public HardwareVideoEncoderFactory() {
    }

    public static VideoCodecDesc[] getSupportedCodecs() {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        BmmtVideoCodecStandard[] r102 = {BmmtVideoCodecStandard.ByteVC1, BmmtVideoCodecStandard.H264, BmmtVideoCodecStandard.VP8};
    L3:
        if (r101 >= 3) goto L22;
        BmmtVideoCodecStandard r103 = r102[r101];
        MediaCodecInfo r104 = findCodecForType(r103);
        if (r104 == null) goto L20;
        if (r103 != BmmtVideoCodecStandard.ByteVC1) goto L12;
        if (isSupportedCodec(r104, r103) == false) goto L12;
        r100.add(new VideoCodecDesc(r103, BmmtVideoCodecProfile.ByteVC1ProfileMain));
    L12:
        if (r103 != BmmtVideoCodecStandard.H264) goto L18;
        if (isH264HighProfileSupported(r104) == false) goto L16;
        r100.add(new VideoCodecDesc(r103, BmmtVideoCodecProfile.ProfileHigh));
    L16:
        r100.add(new VideoCodecDesc(r103, BmmtVideoCodecProfile.ProfileBaseline));
    L18:
        if (r103 != BmmtVideoCodecStandard.VP8) goto L20;
        r100.add(new VideoCodecDesc(r103, BmmtVideoCodecProfile.VP8ProfileMain));
    L20:
        r101 = r101 + 1;
        goto L3
    L22:
        return (VideoCodecDesc[]) r100.toArray(new VideoCodecDesc[r100.size()]);
    }

    public static VideoEncoder createEncoder(VideoCodecDesc r110) {
        BmmtVideoCodecStandard r100 = r110.getStandard();
        MediaCodecInfo r101 = findCodecForType(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.getName();
        String r103 = r100.mimeType();
        Integer r104 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, r101.getCapabilitiesForType(r103));
        if (r104 != null) goto L9;
        return null;
    L9:
        if (r102.contains("OMX.hisi.") == false) goto L11;
        int[] r105 = MediaCodecUtils.ENCODER_COLOR_FORMATS_FOR_HISI;
    L12:
        Integer r106 = MediaCodecUtils.selectColorFormat(r105, r101.getCapabilitiesForType(r103));
        if (r106 != null) goto L16;
        return null;
    L16:
        return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), r102, r110, r104, r106, getKeyFrameIntervalSec(r100), getForcedKeyFrameIntervalMs(r100, r102), r101.getCapabilitiesForType(r103));
    L11:
        r105 = MediaCodecUtils.ENCODER_COLOR_FORMATS;
        goto L12
    }

    private static MediaCodecInfo findCodecForType(BmmtVideoCodecStandard r100) {
        int r101 = MediaCodecList.getCodecCount();     // Catch: Exception -> L22
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L21;
        MediaCodecInfo r103 = MediaCodecList.getCodecInfoAt(r102);     // Catch: IllegalArgumentException -> L8
    L9:
        if (r103 == null) goto L20;
        if (r103.isEncoder() == false) goto L20;
        if (isSoftwareOnly(r103) == true) goto L20;
        if (isInBlackList(r103) == true) goto L20;
        if (isSupportedCodec(r103, r100) == false) goto L20;
        return r103;
    L20:
        r102 = r102 + 1;
    L8:
        r103 = null;
    L21:
        return null;
    }

    private static int getKeyFrameIntervalSec(BmmtVideoCodecStandard r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[r100.ordinal()];
        if (r101 != 1) goto L5;
    L15:
        return 720;
    L5:
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L9;
        return 100;
    L9:
        if (r101 != 4) goto L12;
        return 100;
    L12:
        throw new IllegalArgumentException("Unsupported VideoCodecType " + r100);
    }

    private static boolean isH264HighProfileSupported(MediaCodecInfo r100) {
        String r101 = DeviceInfoAndroid.GetDeviceModel();
        String r102 = DeviceInfoAndroid.GetDeviceBrand();
        if (DeviceInfoAndroid.GetCpuModel().contains("Amlogic") == false) goto L5;
        return false;
    L5:
        if (r101.equalsIgnoreCase("T730") == false) goto L10;
        if (r102.equalsIgnoreCase("VHD") == false) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT <= 23) goto L14;
        return true;
    L14:
        return false;
    }

    private static boolean isHardwareSupportedInCurrentSdkByteVC1(MediaCodecInfo r100) {
        String r101 = r100.getName();
        if (r101.startsWith("OMX.qcom.") == false) goto L5;
        return true;
    L5:
        r101.startsWith("OMX.Exynos.");
        return true;
    }

    private static boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo r100) {
        String r101 = r100.getName();
        if (r101.startsWith("OMX.qcom.") == false) goto L6;
        return true;
    L6:
        if (r101.startsWith("OMX.sprd.") == false) goto L8;
        return true;
    L8:
        r101.startsWith("OMX.Exynos.");
        return true;
    }

    private static boolean isHardwareSupportedInCurrentSdkVP8(MediaCodecInfo r100) {
        String r101 = r100.getName();
        if (r101.startsWith("OMX.qcom.") == false) goto L6;
        return true;
    L6:
        if (r101.startsWith("OMX.Exynos.") == true) goto L8;
        r101.startsWith("OMX.Intel.");
        return true;
    L8:
        if (Build.VERSION.SDK_INT >= 23) goto L14;
        return false;
    L14:
        return true;
    }

    private static boolean isInBlackList(MediaCodecInfo r100) {
        String r101 = r100.getName();
        if (r101.startsWith("OMX.Nvidia") == false) goto L5;
    L10:
        return true;
    L5:
        if (r101.startsWith("OMX.Intel") == true) goto L10;
        if (r101.startsWith("OMX.TI.DUCATI1.VIDEO.H264E") == true) goto L10;
        return false;
    }

    private static boolean isSoftwareOnly(MediaCodecInfo r100) {
    L31:
        e = move-exception;
        Logging.e(TAG, "check encoder softonly error.", e);
        return false;
    L4:
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        String r101 = r100.getName();     // Catch: Exception -> L31
        if (r101 != null) goto L10;
        return false;
    L10:
        String r102 = r101.toLowerCase();     // Catch: Exception -> L31
        if (r102.startsWith("arc.") == false) goto L14;
        return false;
    L14:
        if (r102.startsWith("omx.google.") == false) goto L16;
    L29:
        return true;
    L16:
        if (r102.startsWith("omx.ffmpeg.") == true) goto L29;
        if (r102.startsWith("omx.sec.") == false) goto L22;
        if (r102.contains(".sw.") == true) goto L29;
    L22:
        if (r102.startsWith("c2.android.") == true) goto L29;
        if (r102.startsWith("c2.google.") == true) goto L29;
        if (r102.startsWith("omx.") == false) goto L28;
        return false;
    L28:
        if (r102.startsWith("c2.") == false) goto L29;
        return false;
    L6:
        return r100.isSoftwareOnly();
    }

    private static int getForcedKeyFrameIntervalMs(BmmtVideoCodecStandard r100, String r101) {
        if (r100 == BmmtVideoCodecStandard.VP8) goto L5;
        return 0;
    L5:
        if (r101.startsWith("OMX.qcom.") == false) goto L19;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 != 21) goto L9;
    L16:
        return 15000;
    L9:
        if (r102 == 22) goto L16;
        if (r102 != 23) goto L15;
        return 20000;
    L15:
        if (r102 > 23) goto L16;
        return 0;
    L19:
        return 0;
    }

    private static boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo r100, BmmtVideoCodecStandard r101) {
        int r102 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[r101.ordinal()];
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L13;
        if (r102 == 3) goto L11;
        return false;
    L11:
        return isHardwareSupportedInCurrentSdkVP8(r100);
    L13:
        return isHardwareSupportedInCurrentSdkByteVC1(r100);
    L15:
        return isHardwareSupportedInCurrentSdkH264(r100);
    }

    private static boolean isSupportedCodec(MediaCodecInfo r100, BmmtVideoCodecStandard r101) {
        if (MediaCodecUtils.codecSupportsType(r100, r101) == true) goto L11;
        return false;
    L11:
        MediaCodecInfo.CodecCapabilities r102 = r100.getCapabilitiesForType(r101.mimeType());     // Catch: IllegalArgumentException -> L10
        if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, r102) != null) goto L9;
        return false;
    L9:
        return isHardwareSupportedInCurrentSdk(r100, r101);
    L10:
        return false;
    }

    public static boolean isBitrateModeSupported(MediaCodecInfo r100, BmmtVideoCodecStandard r101, int r102) {
        MediaCodecInfo.CodecCapabilities r103 = r100.getCapabilitiesForType(r101.mimeType());
        if (r103 != null) goto L6;
        Logging.e(TAG, "get capability return null.");
        return false;
    L6:
        MediaCodecInfo.EncoderCapabilities r104 = r103.getEncoderCapabilities();
        if (r104 != null) goto L11;
        Logging.e(TAG, "get EncoderCapabilities return null.");
        return false;
    L11:
        return r104.isBitrateModeSupported(r102);
    }
}
