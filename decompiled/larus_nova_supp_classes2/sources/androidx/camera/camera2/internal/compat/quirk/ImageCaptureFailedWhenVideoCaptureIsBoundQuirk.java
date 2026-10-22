package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ImageCaptureFailedWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk, SurfaceProcessingQuirk {
    public ImageCaptureFailedWhenVideoCaptureIsBoundQuirk() {
    }

    public static boolean isBluStudioX10() {
        if ("blu".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("studio x10".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean isItelW6004() {
        if ("itel".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("itel w6004".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean isMotoE13() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto e13".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isPixel4XLApi29() {
        if ("pixel 4 xl".equalsIgnoreCase(Build.MODEL) == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT != 29) goto L7;
        return true;
    }

    public static boolean isPositivoTwist2Pro() {
        if ("positivo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("twist 2 pro".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean isSamsungTabA8() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == false) goto L9;
        String r0 = Build.DEVICE;
        if ("gta8".equalsIgnoreCase(r0) == false) goto L7;
    L8:
        return true;
    L7:
        if ("gta8wifi".equalsIgnoreCase(r0) == true) goto L8;
    L9:
        return false;
    }

    public static boolean isVivo1805() {
        if ("vivo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("vivo 1805".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        if (isBluStudioX10() == false) goto L5;
    L18:
        return true;
    L5:
        if (isItelW6004() == true) goto L18;
        if (isVivo1805() == true) goto L18;
        if (isPositivoTwist2Pro() == true) goto L18;
        if (isPixel4XLApi29() == true) goto L18;
        if (isMotoE13() == true) goto L18;
        if (isSamsungTabA8() == true) goto L18;
        return false;
    }

    @Override // androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk
    public boolean workaroundByCaptureIntentPreview() {
        if (isBluStudioX10() == false) goto L5;
    L12:
        return true;
    L5:
        if (isItelW6004() == true) goto L12;
        if (isVivo1805() == true) goto L12;
        if (isPositivoTwist2Pro() == true) goto L12;
        return false;
    }

    @Override // androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk
    public boolean workaroundBySurfaceProcessing() {
        if (isBluStudioX10() == false) goto L5;
    L18:
        return true;
    L5:
        if (isItelW6004() == true) goto L18;
        if (isVivo1805() == true) goto L18;
        if (isPositivoTwist2Pro() == true) goto L18;
        if (isPixel4XLApi29() == true) goto L18;
        if (isMotoE13() == true) goto L18;
        if (isSamsungTabA8() == true) goto L18;
        return false;
    }
}
