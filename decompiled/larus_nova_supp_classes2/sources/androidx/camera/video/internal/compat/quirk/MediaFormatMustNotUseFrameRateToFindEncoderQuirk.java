package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MediaFormatMustNotUseFrameRateToFindEncoderQuirk implements Quirk {
    public MediaFormatMustNotUseFrameRateToFindEncoderQuirk() {
    }

    public static boolean load() {
        if (Build.VERSION.SDK_INT != 21) goto L5;
        return true;
    L5:
        return false;
    }
}
