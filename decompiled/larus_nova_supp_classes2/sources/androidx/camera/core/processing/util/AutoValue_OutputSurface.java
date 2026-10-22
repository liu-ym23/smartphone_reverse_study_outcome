package androidx.camera.core.processing.util;

import android.opengl.EGLSurface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_OutputSurface extends OutputSurface {
    private final EGLSurface eglSurface;
    private final int height;
    private final int width;

    public int hashCode() {
        return ((((this.eglSurface.hashCode() ^ 1000003) * 1000003) ^ this.width) * 1000003) ^ this.height;
    }

    public String toString() {
        return "OutputSurface{eglSurface=" + this.eglSurface + ", width=" + this.width + ", height=" + this.height + "}";
    }

    @Override // androidx.camera.core.processing.util.OutputSurface
    public EGLSurface getEglSurface() {
        return this.eglSurface;
    }

    @Override // androidx.camera.core.processing.util.OutputSurface
    public int getHeight() {
        return this.height;
    }

    @Override // androidx.camera.core.processing.util.OutputSurface
    public int getWidth() {
        return this.width;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof OutputSurface) == false) goto L16;
        OutputSurface r6 = (OutputSurface) r5;
        if (this.eglSurface.equals(r6.getEglSurface()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.width != r6.getWidth()) goto L14;
        if (this.height != r6.getHeight()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_OutputSurface(EGLSurface r1, int r2, int r3) {
        if (r1 == null) goto L7;
        this.eglSurface = r1;
        this.width = r2;
        this.height = r3;
        return;
    L7:
        throw new NullPointerException("Null eglSurface");
    }
}
