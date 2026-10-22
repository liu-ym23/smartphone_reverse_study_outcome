package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AspectRatioLegacyApi21Quirk implements Quirk {
    public AspectRatioLegacyApi21Quirk() {
    }

    public int getCorrectedAspectRatio() {
        return 2;
    }

    public static boolean load(CameraCharacteristicsCompat r1) {
        Integer r2 = (Integer) r1.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r2 != null) goto L5;
    L9:
        return false;
    L5:
        if (r2.intValue() != 2) goto L9;
        if (Build.VERSION.SDK_INT != 21) goto L9;
        return true;
    }
}
