package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int degreesToSurfaceRotation(int r3) {
        if (r3 != 0) goto L4;
        return 0;
    L4:
        if (r3 != 90) goto L6;
        return 1;
    L6:
        if (r3 != 180) goto L8;
        return 2;
    L8:
        if (r3 != 270) goto L11;
        return 3;
    L11:
        throw new IllegalStateException("Invalid sensor rotation: " + r3);
    }

    public static int surfaceRotationToDegrees(int r3) {
        if (r3 != 0) goto L4;
        return 0;
    L4:
        if (r3 != 1) goto L6;
        return 90;
    L6:
        if (r3 != 2) goto L8;
        return 180;
    L8:
        if (r3 != 3) goto L11;
        return 270;
    L11:
        throw new IllegalArgumentException("Unsupported surface rotation: " + r3);
    }

    public static int getRelativeImageRotation(int r4, int r5, boolean r6) {
        if (r6 == false) goto L4;
        int r0 = ((r5 - r4) + 360) % 360;
    L6:
        if (Logger.isVerboseEnabled(TAG) == false) goto L8;
        Logger.d(TAG, String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", new Object[]{Integer.valueOf(r4), Integer.valueOf(r5), Boolean.valueOf(r6), Integer.valueOf(r0)}));
    L8:
        return r0;
    L4:
        r0 = (r5 + r4) % 360;
        goto L6
    }
}
