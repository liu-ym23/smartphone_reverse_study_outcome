package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import android.util.Size;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SurfaceOrientedMeteringPointFactory extends MeteringPointFactory {
    private final float mHeight;
    private final float mWidth;

    private static Rational getUseCaseAspectRatio(UseCase r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Size r0 = r3.getAttachedSurfaceResolution();
        if (r0 == null) goto L10;
        return new Rational(r0.getWidth(), r0.getHeight());
    L10:
        throw new IllegalStateException("UseCase " + r3 + " is not bound.");
    }

    public SurfaceOrientedMeteringPointFactory(float r1, float r2) {
        this.mWidth = r1;
        this.mHeight = r2;
    }

    @Override // androidx.camera.core.MeteringPointFactory
    public PointF convertPoint(float r3, float r4) {
        return new PointF(r3 / this.mWidth, r4 / this.mHeight);
    }

    public SurfaceOrientedMeteringPointFactory(float r1, float r2, UseCase r3) {
        super(getUseCaseAspectRatio(r3));
        this.mWidth = r1;
        this.mHeight = r2;
    }
}
