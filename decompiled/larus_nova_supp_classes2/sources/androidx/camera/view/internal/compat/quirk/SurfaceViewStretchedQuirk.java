package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SurfaceViewStretchedQuirk implements Quirk {
    private static final String GALAXY_Z_FOLD_2 = "F2Q";
    private static final String GALAXY_Z_FOLD_3 = "Q2Q";
    private static final String LENOVO = "LENOVO";
    private static final String LENOVO_TAB_P12_PRO = "Q706F";
    private static final String OPPO = "OPPO";
    private static final String OPPO_FIND_N = "OP4E75L1";
    private static final String SAMSUNG = "SAMSUNG";

    public SurfaceViewStretchedQuirk() {
    }

    private static boolean isLenovoTablet() {
        if (LENOVO.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if (LENOVO_TAB_P12_PRO.equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isOppoFoldable() {
        if (OPPO.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if (OPPO_FIND_N.equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return true;
    }

    private static boolean isSamsungFold2OrFold3() {
        if (SAMSUNG.equalsIgnoreCase(Build.MANUFACTURER) == false) goto L9;
        String r0 = Build.DEVICE;
        if (GALAXY_Z_FOLD_2.equalsIgnoreCase(r0) == false) goto L7;
    L8:
        return true;
    L7:
        if (GALAXY_Z_FOLD_3.equalsIgnoreCase(r0) == true) goto L8;
    L9:
        return false;
    }

    public static boolean load() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
    L11:
        return false;
    L5:
        if (isSamsungFold2OrFold3() == false) goto L7;
    L10:
        return true;
    L7:
        if (isOppoFoldable() == true) goto L10;
        if (isLenovoTablet() == false) goto L11;
        goto L10
    }
}
