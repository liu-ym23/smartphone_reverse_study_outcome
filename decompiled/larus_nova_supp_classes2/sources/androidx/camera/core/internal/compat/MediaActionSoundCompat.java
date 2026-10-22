package androidx.camera.core.internal.compat;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class MediaActionSoundCompat {
    public static boolean mustPlayShutterSound() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return MediaActionSoundCompatApi33Impl.mustPlayShutterSound();
    L7:
        return MediaActionSoundCompatBaseImpl.mustPlayShutterSound();
    }

    private MediaActionSoundCompat() {
    }
}
