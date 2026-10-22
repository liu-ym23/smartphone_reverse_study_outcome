package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class DynamicRangesCompat {
    private final DynamicRangeProfilesCompatImpl mImpl;

    public interface DynamicRangeProfilesCompatImpl {
        Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange r1);

        Set<DynamicRange> getSupportedDynamicRanges();

        boolean isExtraLatencyPresent(DynamicRange r1);

        DynamicRangeProfiles unwrap();
    }

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mImpl.getSupportedDynamicRanges();
    }

    public DynamicRangeProfiles toDynamicRangeProfiles() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0, "DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.");
        return this.mImpl.unwrap();
    L5:
        r0 = false;
        goto L6
    }

    public DynamicRangesCompat(DynamicRangeProfilesCompatImpl r1) {
        this.mImpl = r1;
    }

    public static DynamicRangesCompat fromCameraCharacteristics(CameraCharacteristicsCompat r2) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        DynamicRangesCompat r3 = toDynamicRangesCompat((DynamicRangeProfiles) r2.get(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES));
    L6:
        if (r3 == null) goto L8;
        return r3;
    L8:
        return DynamicRangesCompatBaseImpl.COMPAT_INSTANCE;
    L5:
        r3 = null;
        goto L6
    }

    public static DynamicRangesCompat toDynamicRangesCompat(DynamicRangeProfiles r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L8;
        boolean r0 = true;
    L9:
        Preconditions.checkState(r0, "DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.");
        return new DynamicRangesCompat(new DynamicRangesCompatApi33Impl(r2));
    L8:
        r0 = false;
        goto L9
    }

    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange r2) {
        return this.mImpl.getDynamicRangeCaptureRequestConstraints(r2);
    }

    public boolean isExtraLatencyPresent(DynamicRange r2) {
        return this.mImpl.isExtraLatencyPresent(r2);
    }
}
