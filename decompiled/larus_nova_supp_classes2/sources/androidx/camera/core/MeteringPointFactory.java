package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class MeteringPointFactory {
    private Rational mSurfaceAspectRatio;

    public MeteringPointFactory() {
        this(null);
    }

    public static float getDefaultPointSize() {
        return 0.15f;
    }

    public abstract PointF convertPoint(float r1, float r2);

    public MeteringPointFactory(Rational r1) {
        this.mSurfaceAspectRatio = r1;
    }

    public void setSurfaceAspectRatio(Rational r1) {
        this.mSurfaceAspectRatio = r1;
    }

    public final MeteringPoint createPoint(float r2, float r3) {
        return createPoint(r2, r3, getDefaultPointSize());
    }

    public final MeteringPoint createPoint(float r3, float r4, float r5) {
        PointF r6 = convertPoint(r3, r4);
        return new MeteringPoint(r6.x, r6.y, r5, this.mSurfaceAspectRatio);
    }
}
