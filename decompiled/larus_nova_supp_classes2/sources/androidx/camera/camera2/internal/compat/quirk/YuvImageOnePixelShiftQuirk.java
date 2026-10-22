package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class YuvImageOnePixelShiftQuirk implements OnePixelShiftQuirk {
    public YuvImageOnePixelShiftQuirk() {
    }

    private static boolean isMotorolaMotoG3() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("MotoG3".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungSMA920F() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SM-A920F".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungSMG532F() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SM-G532F".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungSMJ415F() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SM-J415F".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isSamsungSMJ700F() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("SM-J700F".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isXiaomiMiA1() {
        if ("xiaomi".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("Mi A1".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load(CameraCharacteristicsCompat r0) {
        if (isMotorolaMotoG3() == false) goto L5;
    L16:
        return true;
    L5:
        if (isSamsungSMG532F() == true) goto L16;
        if (isSamsungSMJ700F() == true) goto L16;
        if (isSamsungSMA920F() == true) goto L16;
        if (isSamsungSMJ415F() == true) goto L16;
        if (isXiaomiMiA1() == true) goto L16;
        return false;
    }
}
