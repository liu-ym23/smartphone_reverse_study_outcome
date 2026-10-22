package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.InitializationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraIdUtil {
    private CameraIdUtil() {
    }

    public static boolean isBackwardCompatible(CameraManagerCompat r4, String r5) throws InitializationException {
        if ("robolectric".equals(Build.FINGERPRINT) == false) goto L18;
        return true;
    L18:
        int[] r6 = (int[]) r4.getCameraCharacteristicsCompat(r5).get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);     // Catch: CameraAccessExceptionCompat -> L15
        if (r6 == null) goto L14;
        int r0 = r6.length;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L14;
        if (r6[r2] == 0) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    L15:
        e = move-exception;
        throw new InitializationException(CameraUnavailableExceptionHelper.createFrom(e));
    }
}
