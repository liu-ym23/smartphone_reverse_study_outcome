package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MediaStoreVideoCannotWrite implements Quirk {
    public MediaStoreVideoCannotWrite() {
    }

    public static boolean isItelW6004() {
        if ("itel".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("itel w6004".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean isPositivoTwist2Pro() {
        if ("positivo".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if ("twist 2 pro".equalsIgnoreCase(Build.MODEL) == false) goto L7;
        return true;
    }

    public static boolean load() {
        if (isPositivoTwist2Pro() == false) goto L5;
    L8:
        return true;
    L5:
        if (isItelW6004() == true) goto L8;
        return false;
    }
}
