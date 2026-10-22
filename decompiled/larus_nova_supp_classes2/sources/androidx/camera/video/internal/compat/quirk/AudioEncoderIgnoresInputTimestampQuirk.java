package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AudioEncoderIgnoresInputTimestampQuirk implements Quirk {
    public AudioEncoderIgnoresInputTimestampQuirk() {
    }

    private static boolean isSonyG3125() {
        if ("Sony".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("G3125".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isSonyG3125();
    }
}
