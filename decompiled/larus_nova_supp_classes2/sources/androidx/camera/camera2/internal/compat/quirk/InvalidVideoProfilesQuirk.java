package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class InvalidVideoProfilesQuirk implements Quirk {
    private static final List<String> AFFECTED_ONE_PLUS_MODELS = null;
    private static final List<String> AFFECTED_OPPO_MODELS = null;
    private static final List<String> AFFECTED_PIXEL_MODELS = null;

    public InvalidVideoProfilesQuirk() {
    }

    static {
        AFFECTED_PIXEL_MODELS = Arrays.asList(new String[]{"pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro"});
        AFFECTED_ONE_PLUS_MODELS = Arrays.asList(new String[]{"cph2417", "cph2451"});
        AFFECTED_OPPO_MODELS = Arrays.asList(new String[]{"cph2437", "cph2525", "pht110"});
    }

    private static boolean isAPI33() {
        if (Build.VERSION.SDK_INT != 33) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isAffectedOnePlusModel() {
        return AFFECTED_ONE_PLUS_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedOppoModel() {
        return AFFECTED_OPPO_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedPixelModel() {
        return AFFECTED_PIXEL_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedSamsungDevices() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (isTp1aBuild() == false) goto L7;
        return true;
    }

    private static boolean isAffectedXiaomiDevices() {
        String r0 = Build.BRAND;
        if ("redmi".equalsIgnoreCase(r0) == true) goto L7;
        if ("xiaomi".equalsIgnoreCase(r0) == true) goto L7;
    L11:
        return false;
    L7:
        if (isTkq1Build() == false) goto L9;
    L12:
        return true;
    L9:
        if (isTp1aBuild() == false) goto L11;
        goto L11
    }

    private static boolean isTd1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("td1a");
    }

    private static boolean isTkq1Build() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tkq1");
    }

    private static boolean isTp1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a");
    }

    private static boolean isAffectedOnePlusDevices() {
        if (isAffectedOnePlusModel() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAPI33() == false) goto L7;
        return true;
    }

    private static boolean isAffectedOppoDevices() {
        if (isAffectedOppoModel() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAPI33() == false) goto L7;
        return true;
    }

    private static boolean isAffectedPixelBuild() {
        if (isTp1aBuild() == false) goto L5;
    L8:
        return true;
    L5:
        if (isTd1aBuild() == true) goto L8;
        return false;
    }

    private static boolean isAffectedPixelDevices() {
        if (isAffectedPixelModel() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAffectedPixelBuild() == false) goto L7;
        return true;
    }

    public static boolean load() {
        if (isAffectedSamsungDevices() == false) goto L5;
    L14:
        return true;
    L5:
        if (isAffectedPixelDevices() == true) goto L14;
        if (isAffectedXiaomiDevices() == true) goto L14;
        if (isAffectedOnePlusDevices() == true) goto L14;
        if (isAffectedOppoDevices() == true) goto L14;
        return false;
    }
}
