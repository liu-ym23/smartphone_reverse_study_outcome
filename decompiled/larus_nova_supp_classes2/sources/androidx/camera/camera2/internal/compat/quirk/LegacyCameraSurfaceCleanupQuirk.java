package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class LegacyCameraSurfaceCleanupQuirk implements Quirk {
    public LegacyCameraSurfaceCleanupQuirk() {
    }

    public static boolean isLegacyDevice(CameraCharacteristicsCompat r1) {
        Integer r2 = (Integer) r1.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.intValue() != 2) goto L7;
        return true;
    }

    public static boolean load(CameraCharacteristicsCompat r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 23) goto L5;
    L9:
        return false;
    L5:
        if (r0 >= 29) goto L9;
        if (isLegacyDevice(r2) == false) goto L9;
        return true;
    }
}
