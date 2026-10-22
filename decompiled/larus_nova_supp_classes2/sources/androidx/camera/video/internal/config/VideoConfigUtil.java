package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderDataSpace;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class VideoConfigUtil {
    private static final Timebase DEFAULT_TIME_BASE = null;
    private static final Map<String, Map<Integer, VideoEncoderDataSpace>> MIME_TO_DATA_SPACE_MAP = null;
    private static final String TAG = "VideoConfigUtil";

    static {
        HashMap r0 = new HashMap();
        MIME_TO_DATA_SPACE_MAP = r0;
        DEFAULT_TIME_BASE = Timebase.UPTIME;
        HashMap r1 = new HashMap();
        VideoEncoderDataSpace r3 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
        r1.put(1, r3);
        VideoEncoderDataSpace r5 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG;
        r1.put(2, r5);
        VideoEncoderDataSpace r7 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ;
        r1.put(4096, r7);
        r1.put(8192, r7);
        HashMap r9 = new HashMap();
        r9.put(1, r3);
        r9.put(2, r5);
        r9.put(4096, r7);
        r9.put(8192, r7);
        HashMap r10 = new HashMap();
        r10.put(1, r3);
        r10.put(4, r5);
        r10.put(4096, r7);
        r10.put(16384, r7);
        r10.put(2, r3);
        r10.put(8, r5);
        r10.put(8192, r7);
        r10.put(Integer.valueOf(BiometricManager$Authenticators.DEVICE_CREDENTIAL), r7);
        HashMap r2 = new HashMap();
        r2.put(256, r5);
        r2.put(512, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT709);
        r0.put("video/hevc", r1);
        r0.put("video/av01", r9);
        r0.put("video/x-vnd.on2.vp9", r10);
        r0.put("video/dolby-vision", r2);
    }

    private VideoConfigUtil() {
    }

    private static String getDynamicRangeDefaultMime(DynamicRange r3) {
        int r0 = r3.getEncoding();
        if (r0 != 1) goto L5;
        return "video/avc";
    L5:
        if (r0 != 3) goto L7;
        return "video/hevc";
    L7:
        if (r0 != 4) goto L9;
        return "video/hevc";
    L9:
        if (r0 != 5) goto L11;
        return "video/hevc";
    L11:
        if (r0 != 6) goto L15;
        return "video/dolby-vision";
    L15:
        throw new UnsupportedOperationException("Unsupported dynamic range: " + r3 + "\nNo supported default mime type available.");
    }

    public static VideoEncoderConfig toVideoEncoderConfig(EncoderProfilesProxy.VideoProfileProxy r4) {
        return VideoEncoderConfig.builder().setMimeType(r4.getMediaType()).setProfile(r4.getProfile()).setResolution(new Size(r4.getWidth(), r4.getHeight())).setFrameRate(r4.getFrameRate()).setBitrate(r4.getBitrate()).setInputTimebase(DEFAULT_TIME_BASE).build();
    }

    public static VideoEncoderDataSpace mimeAndProfileToEncoderDataSpace(String r2, int r3) {
        Map<Integer, VideoEncoderDataSpace> r0 = MIME_TO_DATA_SPACE_MAP.get(r2);
        if (r0 == null) goto L7;
        VideoEncoderDataSpace r1 = r0.get(Integer.valueOf(r3));
        if (r1 == null) goto L7;
        return r1;
    L7:
        Logger.w(TAG, String.format("Unsupported mime type %s or profile level %d. Data space is unspecified.", new Object[]{r2, Integer.valueOf(r3)}));
        return VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
    }

    public static VideoMimeInfo resolveVideoMimeInfo(MediaSpec r11, DynamicRange r12, VideoValidatedEncoderProfilesProxy r13) {
        Preconditions.checkState(r12.isFullySpecified(), "Dynamic range must be a fully specified dynamic range [provided dynamic range: " + r12 + "]");
        String r0 = MediaSpec.outputFormatToVideoMime(r11.getOutputFormat());
        if (r13 == null) goto L19;
        Set<Integer> r5 = DynamicRangeUtil.dynamicRangeToVideoProfileHdrFormats(r12);
        Set<Integer> r6 = DynamicRangeUtil.dynamicRangeToVideoProfileBitDepth(r12);
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r7 = r13.getVideoProfiles().iterator();
    L6:
        if (r7.hasNext() == false) goto L19;
        EncoderProfilesProxy.VideoProfileProxy r8 = r7.next();
        if (r5.contains(Integer.valueOf(r8.getHdrFormat())) == false) goto L6;
        if (r6.contains(Integer.valueOf(r8.getBitDepth())) == false) goto L6;
        String r9 = r8.getMediaType();
        if (Objects.equals(r0, r9) == true) goto L14;
        if (r11.getOutputFormat() != (-1)) goto L6;
        Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + r0 + ", dynamic range: " + r12 + "]");
    L18:
        r0 = r9;
    L20:
        if (r8 == null) goto L22;
    L27:
        VideoMimeInfo.Builder r14 = VideoMimeInfo.builder(r0);
        if (r8 == null) goto L31;
        r14.setCompatibleVideoProfile(r8);
    L31:
        return r14.build();
    L22:
        if (r11.getOutputFormat() != (-1)) goto L24;
        r0 = getDynamicRangeDefaultMime(r12);
    L24:
        if (r13 != null) goto L26;
        Logger.d(TAG, "No EncoderProfiles present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + r0 + ", dynamic range: " + r12 + "]");
        goto L27
    L26:
        Logger.d(TAG, "No video EncoderProfile is compatible with requested output format and dynamic range. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + r0 + ", dynamic range: " + r12 + "]");
        goto L27
    L14:
        Logger.d(TAG, "MediaSpec video mime matches EncoderProfiles. Using EncoderProfiles to derive VIDEO settings [mime type: " + r0 + "]");
    L19:
        r8 = null;
        goto L20
    }

    public static VideoEncoderConfig resolveVideoEncoderConfig(VideoMimeInfo r16, Timebase r17, VideoSpec r18, Size r19, DynamicRange r20, Range<Integer> r21) {
        EncoderProfilesProxy.VideoProfileProxy r5 = r16.getCompatibleVideoProfile();
        if (r5 == null) goto L5;
        Supplier r8 = new VideoEncoderConfigVideoProfileResolver(r16.getMimeType(), r17, r18, r19, r5, r20, r21);
    L7:
        return (VideoEncoderConfig) r8.get();
    L5:
        r8 = new VideoEncoderConfigDefaultResolver(r16.getMimeType(), r17, r18, r19, r20, r21);
        goto L7
    }

    public static int scaleAndClampBitrate(int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, Range<Integer> r27) {
        int r1 = (int) ((((((double) r18) * new Rational(r19, r20).doubleValue()) * new Rational(r21, r22).doubleValue()) * new Rational(r23, r24).doubleValue()) * new Rational(r25, r26).doubleValue());
        if (Logger.isDebugEnabled(TAG) == false) goto L5;
        String r2 = String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) * Frame Rate Ratio(%d / %d) * Width Ratio(%d / %d) * Height Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(r18), Integer.valueOf(r19), Integer.valueOf(r20), Integer.valueOf(r21), Integer.valueOf(r22), Integer.valueOf(r23), Integer.valueOf(r24), Integer.valueOf(r25), Integer.valueOf(r26), Integer.valueOf(r1)});
    L7:
        if (VideoSpec.BITRATE_RANGE_AUTO.equals(r27) == true) goto L11;
        r1 = ((Integer) r27.clamp(Integer.valueOf(r1))).intValue();
        if (Logger.isDebugEnabled(TAG) == false) goto L11;
        r2 = r2 + String.format("\nClamped to range %s -> %dbps", new Object[]{r27, Integer.valueOf(r1)});
    L11:
        Logger.d(TAG, r2);
        return r1;
    L5:
        r2 = "";
        goto L7
    }
}
