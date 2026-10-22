package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Nexus4AndroidLTargetAspectRatioQuirk implements Quirk {
    private static final List<String> DEVICE_MODELS = null;

    public Nexus4AndroidLTargetAspectRatioQuirk() {
    }

    public int getCorrectedAspectRatio() {
        return 2;
    }

    static {
        DEVICE_MODELS = Arrays.asList(new String[]{"NEXUS 4"});
    }

    public static boolean load() {
        if ("GOOGLE".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L9:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        if (DEVICE_MODELS.contains(Build.MODEL.toUpperCase(Locale.US)) == false) goto L9;
        return true;
    }
}
