package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class StretchedVideoResolutionQuirk implements Quirk {
    public StretchedVideoResolutionQuirk() {
    }

    private static boolean isMotoE5Play() {
        if ("motorola".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("moto e5 play".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isMotoE5Play();
    }

    public Size getAlternativeResolution(int r3) {
        if (r3 == 4) goto L15;
        if (r3 == 5) goto L13;
        if (r3 == 6) goto L11;
        return null;
    L11:
        return new Size(1440, 1080);
    L13:
        return new Size(960, 720);
    L15:
        return new Size(640, 480);
    }
}
