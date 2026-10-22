package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ImageCaptureFailedForVideoSnapshotQuirk implements Quirk {
    private static final Set<String> PROBLEMATIC_UNI_SOC_MODELS = null;

    public ImageCaptureFailedForVideoSnapshotQuirk() {
    }

    static {
        PROBLEMATIC_UNI_SOC_MODELS = new HashSet(Arrays.asList(new String[]{"itel l6006", "itel w6004", "moto g(20)", "moto e13", "moto e20", "rmx3231", "rmx3511", "sm-a032f", "sm-a035m", "tecno mobile bf6"}));
    }

    private static boolean isHuaweiPSmart() {
        if ("HUAWEI".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("FIG-LX1".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isUniSocChipsetDevice() {
        Set<String> r0 = PROBLEMATIC_UNI_SOC_MODELS;
        String r1 = Build.MODEL;
        Locale r2 = Locale.US;
        if (r0.contains(r1.toLowerCase(r2)) == false) goto L5;
    L16:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L7;
    L8:
        String r3 = Build.HARDWARE;
        if (r3.toLowerCase(r2).startsWith("ums") == true) goto L16;
        if ("itel".equalsIgnoreCase(Build.BRAND) == true) goto L13;
    L15:
        return false;
    L13:
        if (r3.toLowerCase(r2).startsWith("sp") == false) goto L15;
    L7:
        if ("Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER) == true) goto L16;
        goto L8
    }

    public static boolean load() {
        if (isUniSocChipsetDevice() == false) goto L5;
    L8:
        return true;
    L5:
        if (isHuaweiPSmart() == true) goto L8;
        return false;
    }
}
