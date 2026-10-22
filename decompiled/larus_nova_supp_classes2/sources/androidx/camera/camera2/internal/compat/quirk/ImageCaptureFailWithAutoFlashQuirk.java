package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ImageCaptureFailWithAutoFlashQuirk implements Quirk {
    private static final List<String> BUILD_MODELS_FRONT_CAMERA = null;

    public ImageCaptureFailWithAutoFlashQuirk() {
    }

    static {
        BUILD_MODELS_FRONT_CAMERA = Arrays.asList(new String[]{"sm-j700f", "sm-j710f"});
    }

    public static boolean load(CameraCharacteristicsCompat r3) {
        if (BUILD_MODELS_FRONT_CAMERA.contains(Build.MODEL.toLowerCase(Locale.US)) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) r3.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L7;
        return true;
    }
}
