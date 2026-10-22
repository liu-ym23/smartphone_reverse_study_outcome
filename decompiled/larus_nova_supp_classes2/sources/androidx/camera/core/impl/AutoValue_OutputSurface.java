package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_OutputSurface extends OutputSurface {
    private final int imageFormat;
    private final Size size;
    private final Surface surface;

    public int hashCode() {
        return ((((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.imageFormat;
    }

    public String toString() {
        return "OutputSurface{surface=" + this.surface + ", size=" + this.size + ", imageFormat=" + this.imageFormat + "}";
    }

    @Override // androidx.camera.core.impl.OutputSurface
    public int getImageFormat() {
        return this.imageFormat;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    public Surface getSurface() {
        return this.surface;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof OutputSurface) == false) goto L16;
        OutputSurface r6 = (OutputSurface) r5;
        if (this.surface.equals(r6.getSurface()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.size.equals(r6.getSize()) == false) goto L14;
        if (this.imageFormat != r6.getImageFormat()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_OutputSurface(Surface r1, Size r2, int r3) {
        if (r1 == null) goto L11;
        this.surface = r1;
        if (r2 == null) goto L9;
        this.size = r2;
        this.imageFormat = r3;
        return;
    L9:
        throw new NullPointerException("Null size");
    L11:
        throw new NullPointerException("Null surface");
    }
}
