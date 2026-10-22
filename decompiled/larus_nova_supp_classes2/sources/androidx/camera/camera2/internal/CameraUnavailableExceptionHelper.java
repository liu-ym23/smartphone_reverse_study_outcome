package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraUnavailableExceptionHelper {
    private CameraUnavailableExceptionHelper() {
    }

    public static CameraUnavailableException createFrom(CameraAccessExceptionCompat r2) {
        int r0 = r2.getReason();
        int r1 = 1;
        if (r0 == 1) goto L17;
        r1 = 2;
        if (r0 == 2) goto L17;
        r1 = 3;
        if (r0 == 3) goto L17;
        r1 = 4;
        if (r0 == 4) goto L17;
        r1 = 5;
        if (r0 == 5) goto L17;
        if (r0 == 10001) goto L15;
        r1 = 0;
        goto L17
    L15:
        r1 = 6;
    L17:
        return new CameraUnavailableException(r1, r2);
    }
}
