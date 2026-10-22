package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SurfaceViewNotCroppedByParentQuirk implements Quirk {
    private static final String RED_MI_NOTE_10_MODEL = "M2101K7AG";
    private static final String XIAOMI = "XIAOMI";

    public SurfaceViewNotCroppedByParentQuirk() {
    }

    public static boolean load() {
        if (XIAOMI.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L5;
    L7:
        return false;
    L5:
        if (RED_MI_NOTE_10_MODEL.equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }
}
