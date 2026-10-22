package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ExtraSupportedOutputSizeQuirk implements Quirk {
    public ExtraSupportedOutputSizeQuirk() {
    }

    private Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(1440, 1080), new Size(960, 720)};
    }

    private static boolean isMotoE5Play() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto e5 play".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isMotoE5Play();
    }

    public <T> Size[] getExtraSupportedResolutions(Class<T> r1) {
        if (StreamConfigurationMap.isOutputSupportedFor(r1) == false) goto L9;
        if (isMotoE5Play() == false) goto L9;
        return getMotoE5PlayExtraSupportedResolutions();
    L9:
        return new Size[0];
    }

    public Size[] getExtraSupportedResolutions(int r2) {
        if (r2 != 34) goto L9;
        if (isMotoE5Play() == false) goto L9;
        return getMotoE5PlayExtraSupportedResolutions();
    L9:
        return new Size[0];
    }
}
