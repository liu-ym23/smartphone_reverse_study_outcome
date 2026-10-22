package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class OutputSurface {
    public OutputSurface() {
    }

    public abstract int getImageFormat();

    public abstract Size getSize();

    public abstract Surface getSurface();

    public static OutputSurface create(Surface r1, Size r2, int r3) {
        return new AutoValue_OutputSurface(r1, r2, r3);
    }
}
