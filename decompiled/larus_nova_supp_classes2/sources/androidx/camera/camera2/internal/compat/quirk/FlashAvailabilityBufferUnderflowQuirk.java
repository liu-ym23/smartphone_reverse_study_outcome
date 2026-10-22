package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.Quirk;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class FlashAvailabilityBufferUnderflowQuirk implements Quirk {
    private static final Set<Pair<String, String>> KNOWN_AFFECTED_MODELS = null;

    public FlashAvailabilityBufferUnderflowQuirk() {
    }

    static {
        KNOWN_AFFECTED_MODELS = new HashSet();
        addAffectedDevice("sprd", "lemp");
        addAffectedDevice("sprd", "DM20C");
    }

    public static boolean load() {
        Set<Pair<String, String>> r0 = KNOWN_AFFECTED_MODELS;
        String r2 = Build.MANUFACTURER;
        Locale r3 = Locale.US;
        return r0.contains(new Pair(r2.toLowerCase(r3), Build.MODEL.toLowerCase(r3)));
    }

    private static void addAffectedDevice(String r3, String r4) {
        Set<Pair<String, String>> r0 = KNOWN_AFFECTED_MODELS;
        Locale r2 = Locale.US;
        r0.add(new Pair(r3.toLowerCase(r2), r4.toLowerCase(r2)));
    }
}
