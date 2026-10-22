package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class FovUtil {
    private static final String TAG = "FovUtil";

    private FovUtil() {
    }

    public static float getDefaultFocalLength(CameraCharacteristicsCompat r1) {
        float[] r2 = (float[]) r1.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        Preconditions.checkNotNull(r2, "The focal lengths can not be empty.");
        return r2[0];
    }

    public static float getSensorHorizontalLength(CameraCharacteristicsCompat r4) {
        SizeF r0 = (SizeF) r4.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        Rect r1 = (Rect) r4.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        Size r2 = (Size) r4.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        Integer r5 = (Integer) r4.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(r0, "The sensor size can't be null.");
        Preconditions.checkNotNull(r5, "The sensor orientation can't be null.");
        Preconditions.checkNotNull(r1, "The active array size can't be null.");
        Preconditions.checkNotNull(r2, "The pixel array size can't be null.");
        Size r3 = TransformUtils.rectToSize(r1);
        if (TransformUtils.is90or270(r5.intValue()) == false) goto L6;
        r0 = TransformUtils.reverseSizeF(r0);
        r3 = TransformUtils.reverseSize(r3);
        r2 = TransformUtils.reverseSize(r2);
    L6:
        return (r0.getWidth() * r3.getWidth()) / r2.getWidth();
    }

    public static int focalLengthToViewAngleDegrees(float r5, float r6) {
        boolean r0 = true;
        if (r5 <= MenuKt.ClosedAlphaTarget) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkArgument(r3, "Focal length should be positive.");
        if (r6 > MenuKt.ClosedAlphaTarget) goto L10;
        r0 = false;
    L10:
        Preconditions.checkArgument(r0, "Sensor length should be positive.");
        int r7 = (int) Math.toDegrees(Math.atan(r6 / (r5 * 2.0f)) * 2.0d);
        Preconditions.checkArgumentInRange(r7, 0, 360, "The provided focal length and sensor length result in an invalid view angle degrees.");
        return r7;
    L5:
        r3 = false;
        goto L6
    }

    public static int getDeviceDefaultViewAngleDegrees(CameraManagerCompat r6, int r7) {
        String[] r0 = r6.getCameraIdList();     // Catch: CameraAccessExceptionCompat -> L11
        int r1 = r0.length;     // Catch: CameraAccessExceptionCompat -> L11
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        CameraCharacteristicsCompat r3 = r6.getCameraCharacteristicsCompat(r0[r2]);     // Catch: CameraAccessExceptionCompat -> L11
        Integer r4 = (Integer) r3.get(CameraCharacteristics.LENS_FACING);     // Catch: CameraAccessExceptionCompat -> L11
        Preconditions.checkNotNull(r4, "Lens facing can not be null");     // Catch: CameraAccessExceptionCompat -> L11
        if (r4.intValue() == LensFacingUtil.getLensFacingInt(r7)) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return focalLengthToViewAngleDegrees(getDefaultFocalLength(r3), getSensorHorizontalLength(r3));
    L10:
        throw new IllegalArgumentException("Unable to get the default focal length with the specified lens facing.");
    L12:
        throw new IllegalArgumentException("Unable to get the default focal length.");
    }
}
