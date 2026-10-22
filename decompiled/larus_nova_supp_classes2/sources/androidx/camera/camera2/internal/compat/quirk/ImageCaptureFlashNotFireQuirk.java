package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ImageCaptureFlashNotFireQuirk implements UseTorchAsFlashQuirk {
    private static final List<String> BUILD_MODELS = null;
    private static final List<String> BUILD_MODELS_FRONT_CAMERA = null;

    public ImageCaptureFlashNotFireQuirk() {
    }

    static {
        BUILD_MODELS = Arrays.asList(new String[]{"itel w6004"});
        BUILD_MODELS_FRONT_CAMERA = Arrays.asList(new String[]{"sm-j700f", "sm-j710f"});
    }

    public static boolean load(CameraCharacteristicsCompat r5) {
        List<String> r0 = BUILD_MODELS_FRONT_CAMERA;
        String r1 = Build.MODEL;
        Locale r2 = Locale.US;
        if (r0.contains(r1.toLowerCase(r2)) == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        boolean r3 = BUILD_MODELS.contains(r1.toLowerCase(r2));
        if (r6 == true) goto L14;
        if (r3 == true) goto L15;
        return false;
    L15:
        return true;
    L14:
        return true;
    L5:
        if (((Integer) r5.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L7;
        r6 = true;
        goto L8
    }
}
