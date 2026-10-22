package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface VideoCapabilities {
    public static final VideoCapabilities EMPTY = null;

    /* JADX INFO: renamed from: androidx.camera.video.VideoCapabilities$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static VideoValidatedEncoderProfilesProxy $default$findNearestHigherSupportedEncoderProfilesFor(VideoCapabilities r0, Size r1, DynamicRange r2) {
            return null;
        }

        public static VideoValidatedEncoderProfilesProxy $default$getProfiles(VideoCapabilities r0, Quality r1, DynamicRange r2) {
            return null;
        }

        public static boolean $default$isStabilizationSupported(VideoCapabilities r0) {
            return false;
        }

        public static Quality $default$findNearestHigherSupportedQualityFor(VideoCapabilities r0, Size r1, DynamicRange r2) {
            return Quality.NONE;
        }
    }

    VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size r1, DynamicRange r2);

    Quality findNearestHigherSupportedQualityFor(Size r1, DynamicRange r2);

    VideoValidatedEncoderProfilesProxy getProfiles(Quality r1, DynamicRange r2);

    Set<DynamicRange> getSupportedDynamicRanges();

    List<Quality> getSupportedQualities(DynamicRange r1);

    boolean isQualitySupported(Quality r1, DynamicRange r2);

    boolean isStabilizationSupported();

    static {
        EMPTY = new AnonymousClass1();
    }
}
