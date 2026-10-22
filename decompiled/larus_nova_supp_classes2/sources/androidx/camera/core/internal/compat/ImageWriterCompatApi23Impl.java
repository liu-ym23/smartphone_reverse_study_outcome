package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ImageWriterCompatApi23Impl {
    private ImageWriterCompatApi23Impl() {
    }

    public static void close(ImageWriter r0) {
        r0.close();
    }

    public static Image dequeueInputImage(ImageWriter r0) {
        return r0.dequeueInputImage();
    }

    public static ImageWriter newInstance(Surface r0, int r1) {
        return ImageWriter.newInstance(r0, r1);
    }

    public static void queueInputImage(ImageWriter r0, Image r1) {
        r0.queueInputImage(r1);
    }
}
