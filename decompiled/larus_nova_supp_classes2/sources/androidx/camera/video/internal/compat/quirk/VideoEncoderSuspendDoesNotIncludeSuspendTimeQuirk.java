package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk implements Quirk {
    public VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk() {
    }

    public static boolean load() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        return true;
    }
}
