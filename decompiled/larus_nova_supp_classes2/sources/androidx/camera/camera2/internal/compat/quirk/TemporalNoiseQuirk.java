package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TemporalNoiseQuirk implements CaptureIntentPreviewQuirk {
    public TemporalNoiseQuirk() {
    }

    @Override // androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk
    public final /* synthetic */ boolean workaroundByCaptureIntentPreview() {
        return CaptureIntentPreviewQuirk.CC.$default$workaroundByCaptureIntentPreview(this);
    }

    private static boolean isPixel8() {
        return "Pixel 8".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load(CameraCharacteristicsCompat r1) {
        if (isPixel8() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) r1.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L7;
        return true;
    }
}
