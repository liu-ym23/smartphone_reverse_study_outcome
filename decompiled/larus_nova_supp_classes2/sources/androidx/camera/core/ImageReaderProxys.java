package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImageReaderProxys {
    private ImageReaderProxys() {
    }

    public static ImageReaderProxy createIsolatedReader(int r0, int r1, int r2, int r3) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(r0, r1, r2, r3));
    }
}
