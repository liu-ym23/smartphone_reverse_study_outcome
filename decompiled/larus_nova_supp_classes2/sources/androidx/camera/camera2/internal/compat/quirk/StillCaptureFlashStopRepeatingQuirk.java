package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class StillCaptureFlashStopRepeatingQuirk implements Quirk {
    public StillCaptureFlashStopRepeatingQuirk() {
    }

    public static boolean load() {
        String r0 = Build.MANUFACTURER;
        Locale r1 = Locale.US;
        if ("SAMSUNG".equals(r0.toUpperCase(r1)) == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.MODEL.toUpperCase(r1).startsWith("SM-A716") == false) goto L7;
        return true;
    }
}
