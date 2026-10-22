package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ImageWriterCompatApi29Impl {
    private ImageWriterCompatApi29Impl() {
    }

    public static ImageWriter newInstance(Surface r0, int r1, int r2) {
        return ImageWriter.newInstance(r0, r1, r2);
    }
}
