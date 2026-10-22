package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TorchFlashRequiredFor3aUpdateQuirk implements Quirk {
    private static final List<String> AFFECTED_PIXEL_MODELS = null;
    private final CameraCharacteristicsCompat mCameraCharacteristics;

    static {
        AFFECTED_PIXEL_MODELS = Arrays.asList(new String[]{"PIXEL 6A", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7A", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO"});
    }

    private static boolean isAffectedPixelModel() {
        Iterator<String> r0 = AFFECTED_PIXEL_MODELS.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();
        if (Build.MODEL.toUpperCase(Locale.US).equals(r1) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean isFlashModeTorchRequired() {
        return !isExternalFlashAeModeSupported(this.mCameraCharacteristics);
    }

    public TorchFlashRequiredFor3aUpdateQuirk(CameraCharacteristicsCompat r1) {
        this.mCameraCharacteristics = r1;
    }

    private static boolean isAffectedModel(CameraCharacteristicsCompat r1) {
        if (isAffectedPixelModel() == true) goto L5;
    L7:
        return false;
    L5:
        if (isFrontCamera(r1) == false) goto L7;
        return true;
    }

    private static boolean isExternalFlashAeModeSupported(CameraCharacteristicsCompat r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        return false;
    L6:
        if (Camera2CameraControlImpl.getSupportedAeMode(r3, 5) != 5) goto L9;
        return true;
    L9:
        return false;
    }

    private static boolean isFrontCamera(CameraCharacteristicsCompat r1) {
        if (((Integer) r1.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean load(CameraCharacteristicsCompat r0) {
        return isAffectedModel(r0);
    }
}
