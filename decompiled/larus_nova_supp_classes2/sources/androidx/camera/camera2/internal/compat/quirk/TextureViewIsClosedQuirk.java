package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TextureViewIsClosedQuirk implements Quirk {
    public TextureViewIsClosedQuirk() {
    }

    public static boolean load() {
        if (Build.VERSION.SDK_INT > 23) goto L5;
        return true;
    L5:
        return false;
    }
}
