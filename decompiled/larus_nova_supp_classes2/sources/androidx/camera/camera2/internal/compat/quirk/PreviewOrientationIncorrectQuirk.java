package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class PreviewOrientationIncorrectQuirk implements Quirk {
    public PreviewOrientationIncorrectQuirk() {
    }

    public static boolean load(CameraCharacteristicsCompat r1) {
        Integer r2 = (Integer) r1.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.intValue() != 2) goto L7;
        return true;
    }
}
