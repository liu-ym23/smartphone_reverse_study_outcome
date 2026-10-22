package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CaptureSessionShouldUseMrirQuirk implements Quirk {
    public CaptureSessionShouldUseMrirQuirk() {
    }

    public static boolean load() {
        if ("google".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 35) goto L7;
        return true;
    }
}
