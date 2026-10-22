package androidx.camera.core.processing.util;

import android.opengl.EGLSurface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class OutputSurface {
    public OutputSurface() {
    }

    public abstract EGLSurface getEglSurface();

    public abstract int getHeight();

    public abstract int getWidth();

    public static OutputSurface of(EGLSurface r1, int r2, int r3) {
        return new AutoValue_OutputSurface(r1, r2, r3);
    }
}
