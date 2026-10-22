package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AudioTimestampFramePositionIncorrectQuirk implements Quirk {
    private static final List<String> AFFECTED_OPPO_MODELS = null;

    public AudioTimestampFramePositionIncorrectQuirk() {
    }

    static {
        AFFECTED_OPPO_MODELS = Arrays.asList(new String[]{"cph1920", "cph1923", "cph2015", "cph2083"});
    }

    private static boolean isAffectedOppoDevices() {
        if ("oppo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (AFFECTED_OPPO_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT)) == false) goto L7;
        return true;
    }

    private static boolean isLgK10() {
        if ("lge".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("lg-m250".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isMotoC() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto c".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isRealmeC2() {
        if ("realme".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("rmx1941".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isRedmi6A() {
        if ("Xiaomi".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("Redmi 6A".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isVivo1820() {
        if ("vivo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("vivo 1820".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    private static boolean isVivoY17() {
        if ("vivo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("VIVO Y17".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        if (isAffectedOppoDevices() == false) goto L5;
    L18:
        return true;
    L5:
        if (isLgK10() == true) goto L18;
        if (isMotoC() == true) goto L18;
        if (isRealmeC2() == true) goto L18;
        if (isRedmi6A() == true) goto L18;
        if (isVivo1820() == true) goto L18;
        if (isVivoY17() == true) goto L18;
        return false;
    }
}
