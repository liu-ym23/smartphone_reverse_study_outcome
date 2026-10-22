package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.utils.EncoderProfilesUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ExtraSupportedQualityQuirk implements Quirk {
    private static final String MOTO_C_FRONT_CAM_ID = "1";

    public ExtraSupportedQualityQuirk() {
    }

    private static boolean isMotoC() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto c".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isMotoC();
    }

    private static Range<Integer> getSupportedBitrateRange(EncoderProfilesProxy.VideoProfileProxy r0, Function<VideoEncoderConfig, VideoEncoderInfo> r1) {
        VideoEncoderInfo r2 = r1.apply(VideoConfigUtil.toVideoEncoderConfig(r0));
        if (r2 == null) goto L6;
        return r2.getSupportedBitrateRange();
    L6:
        return VideoSpec.BITRATE_RANGE_AUTO;
    }

    private Map<Integer, EncoderProfilesProxy> getExtraEncoderProfilesForMotoC(CameraInfoInternal r6, EncoderProfilesProvider r7, Function<VideoEncoderConfig, VideoEncoderInfo> r8) {
        if (MOTO_C_FRONT_CAM_ID.equals(r6.getCameraId()) == true) goto L5;
    L14:
        return null;
    L5:
        if (r7.hasProfile(4) == true) goto L14;
        EncoderProfilesProxy r9 = r7.getAll(1);
        EncoderProfilesProxy.VideoProfileProxy r2 = EncoderProfilesUtil.getFirstVideoProfile(r9);
        if (r2 != null) goto L10;
        return null;
    L10:
        Range<Integer> r10 = getSupportedBitrateRange(r2, r8);
        Size r0 = SizeUtil.RESOLUTION_480P;
        EncoderProfilesProxy.VideoProfileProxy r11 = EncoderProfilesUtil.deriveVideoProfile(r2, r0, r10);
        EncoderProfilesProxy.ImmutableEncoderProfilesProxy r12 = EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r9.getDefaultDurationSeconds(), r9.getRecommendedFileFormat(), r9.getAudioProfiles(), Collections.singletonList(r11));
        HashMap r13 = new HashMap();
        r13.put(4, r12);
        Size r14 = new Size(r2.getWidth(), r2.getHeight());
        if (SizeUtil.getArea(r0) <= SizeUtil.getArea(r14)) goto L13;
        r13.put(1, r12);
    L13:
        return r13;
    }

    public Map<Integer, EncoderProfilesProxy> getExtraEncoderProfiles(CameraInfoInternal r2, EncoderProfilesProvider r3, Function<VideoEncoderConfig, VideoEncoderInfo> r4) {
        if (isMotoC() == false) goto L7;
        return getExtraEncoderProfilesForMotoC(r2, r3, r4);
    L7:
        return Collections.emptyMap();
    }
}
