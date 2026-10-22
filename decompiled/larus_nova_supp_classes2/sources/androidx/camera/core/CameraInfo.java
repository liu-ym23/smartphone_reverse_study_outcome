package androidx.camera.core;

import android.util.Range;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.internal.compat.MediaActionSoundCompat;
import androidx.lifecycle.LiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraInfo {
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";
    public static final float INTRINSIC_ZOOM_RATIO_UNKNOWN = 1.0f;

    /* JADX INFO: renamed from: androidx.camera.core.CameraInfo$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static float $default$getIntrinsicZoomRatio(CameraInfo r0) {
            return 1.0f;
        }

        public static int $default$getLensFacing(CameraInfo r0) {
            return -1;
        }

        public static boolean $default$isFocusMeteringSupported(CameraInfo r0, FocusMeteringAction r1) {
            return false;
        }

        public static boolean $default$isLogicalMultiCameraSupported(CameraInfo r0) {
            return false;
        }

        public static boolean $default$isPrivateReprocessingSupported(CameraInfo r0) {
            return false;
        }

        public static boolean $default$isZslSupported(CameraInfo r0) {
            return false;
        }

        public static boolean mustPlayShutterSound() {
            return MediaActionSoundCompat.mustPlayShutterSound();
        }

        public static Set $default$getPhysicalCameraInfos(CameraInfo r0) {
            return Collections.emptySet();
        }

        public static Set $default$getSupportedFrameRateRanges(CameraInfo r0) {
            return Collections.emptySet();
        }

        public static Set $default$querySupportedDynamicRanges(CameraInfo r0, Set r1) {
            return DynamicRanges.findAllPossibleMatches(r1, Collections.singleton(DynamicRange.SDR));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImplementationType {
    }

    CameraSelector getCameraSelector();

    LiveData<CameraState> getCameraState();

    ExposureState getExposureState();

    String getImplementationType();

    float getIntrinsicZoomRatio();

    int getLensFacing();

    Set<CameraInfo> getPhysicalCameraInfos();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int r1);

    Set<Range<Integer>> getSupportedFrameRateRanges();

    LiveData<Integer> getTorchState();

    LiveData<ZoomState> getZoomState();

    boolean hasFlashUnit();

    boolean isFocusMeteringSupported(FocusMeteringAction r1);

    boolean isLogicalMultiCameraSupported();

    boolean isPrivateReprocessingSupported();

    boolean isZslSupported();

    Set<DynamicRange> querySupportedDynamicRanges(Set<DynamicRange> r1);
}
