package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    public static void close(ImageWriter r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L7;
        ImageWriterCompatApi23Impl.close(r3);
        return;
    L7:
        throw new RuntimeException("Unable to call close() on API " + r0 + ". Version 23 or higher required.");
    }

    public static Image dequeueInputImage(ImageWriter r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L7;
        return ImageWriterCompatApi23Impl.dequeueInputImage(r3);
    L7:
        throw new RuntimeException("Unable to call dequeueInputImage() on API " + r0 + ". Version 23 or higher required.");
    }

    public static ImageWriter newInstance(Surface r2, int r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L7;
        return ImageWriterCompatApi23Impl.newInstance(r2, r3);
    L7:
        throw new RuntimeException("Unable to call newInstance(Surface, int) on API " + r0 + ". Version 23 or higher required.");
    }

    public static void queueInputImage(ImageWriter r2, Image r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L7;
        ImageWriterCompatApi23Impl.queueInputImage(r2, r3);
        return;
    L7:
        throw new RuntimeException("Unable to call queueInputImage() on API " + r0 + ". Version 23 or higher required.");
    }

    public static ImageWriter newInstance(Surface r2, int r3, int r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L7;
        return ImageWriterCompatApi29Impl.newInstance(r2, r3, r4);
    L7:
        if (r0 < 26) goto L11;
        return ImageWriterCompatApi26Impl.newInstance(r2, r3, r4);
    L11:
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + r0 + ". Version 26 or higher required.");
    }
}
