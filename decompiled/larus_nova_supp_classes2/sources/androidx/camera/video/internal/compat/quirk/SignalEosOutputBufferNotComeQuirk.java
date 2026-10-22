package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SignalEosOutputBufferNotComeQuirk implements Quirk {
    public SignalEosOutputBufferNotComeQuirk() {
    }

    private static boolean isNokia1() {
        if ("Nokia".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("Nokia 1".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isNokia1();
    }
}
