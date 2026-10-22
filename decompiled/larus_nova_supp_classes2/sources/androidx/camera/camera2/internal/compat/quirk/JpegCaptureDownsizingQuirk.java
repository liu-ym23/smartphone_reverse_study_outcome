package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class JpegCaptureDownsizingQuirk implements SoftwareJpegEncodingPreferredQuirk {
    private static final Set<String> KNOWN_AFFECTED_FRONT_CAMERA_DEVICES = null;

    public JpegCaptureDownsizingQuirk() {
    }

    static {
        KNOWN_AFFECTED_FRONT_CAMERA_DEVICES = new HashSet(Arrays.asList(new String[]{"redmi note 8 pro"}));
    }

    public static boolean load(CameraCharacteristicsCompat r3) {
        if (KNOWN_AFFECTED_FRONT_CAMERA_DEVICES.contains(Build.MODEL.toLowerCase(Locale.US)) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) r3.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L7;
        return true;
    }
}
