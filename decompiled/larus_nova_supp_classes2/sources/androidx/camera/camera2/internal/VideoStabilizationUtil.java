package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class VideoStabilizationUtil {
    private VideoStabilizationUtil() {
    }

    public static boolean isPreviewStabilizationSupported(CameraCharacteristicsCompat r5) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        int[] r6 = (int[]) r5.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (r6 != null) goto L8;
    L17:
        return false;
    L8:
        if (r6.length == 0) goto L17;
        int r0 = r6.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L17;
        if (r6[r1] == 2) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return true;
    }
}
