package androidx.camera.video.internal.utils;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class EncoderProfilesUtil {
    private EncoderProfilesUtil() {
    }

    public static EncoderProfilesProxy.VideoProfileProxy getFirstVideoProfile(EncoderProfilesProxy r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.getVideoProfiles().isEmpty() == false) goto L6;
        return null;
    L6:
        return (EncoderProfilesProxy.VideoProfileProxy) ListProtector.get(r1.getVideoProfiles(), 0);
    }

    public static EncoderProfilesProxy.VideoProfileProxy deriveVideoProfile(EncoderProfilesProxy.VideoProfileProxy r19, Size r20, Range<Integer> r21) {
        int r11 = VideoConfigUtil.scaleAndClampBitrate(r19.getBitrate(), r19.getBitDepth(), r19.getBitDepth(), r19.getFrameRate(), r19.getFrameRate(), r20.getWidth(), r19.getWidth(), r20.getHeight(), r19.getHeight(), r21);
        return EncoderProfilesProxy.VideoProfileProxy.create(r19.getCodec(), r19.getMediaType(), r11, r19.getFrameRate(), r20.getWidth(), r20.getHeight(), r19.getProfile(), r19.getBitDepth(), r19.getChromaSubsampling(), r19.getHdrFormat());
    }
}
