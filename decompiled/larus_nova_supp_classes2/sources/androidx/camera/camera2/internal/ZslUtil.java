package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ZslUtil {
    private ZslUtil() {
    }

    public static boolean isCapabilitySupported(CameraCharacteristicsCompat r4, int r5) {
        int[] r6 = (int[]) r4.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (r6 == null) goto L11;
        int r1 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        if (r6[r2] == r5) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }
}
