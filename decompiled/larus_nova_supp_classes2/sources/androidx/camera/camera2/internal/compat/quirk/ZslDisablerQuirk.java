package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ZslDisablerQuirk implements Quirk {
    private static final List<String> AFFECTED_SAMSUNG_MODEL = null;
    private static final List<String> AFFECTED_XIAOMI_MODEL = null;

    public ZslDisablerQuirk() {
    }

    static {
        AFFECTED_SAMSUNG_MODEL = Arrays.asList(new String[]{"SM-F936", "SM-S901U", "SM-S908U", "SM-S908U1"});
        AFFECTED_XIAOMI_MODEL = Arrays.asList(new String[]{"MI 8"});
    }

    private static boolean isAffectedSamsungDevices() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (isAffectedModel(AFFECTED_SAMSUNG_MODEL) == false) goto L7;
        return true;
    }

    private static boolean isAffectedXiaoMiDevices() {
        if ("xiaomi".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (isAffectedModel(AFFECTED_XIAOMI_MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        if (isAffectedSamsungDevices() == false) goto L5;
    L8:
        return true;
    L5:
        if (isAffectedXiaoMiDevices() == true) goto L8;
        return false;
    }

    private static boolean isAffectedModel(List<String> r3) {
        Iterator<String> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        String r0 = r4.next();
        if (Build.MODEL.toUpperCase(Locale.US).startsWith(r0) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
