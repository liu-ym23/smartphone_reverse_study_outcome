package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class PreviewViewMeteringPointFactory extends MeteringPointFactory {
    static final PointF INVALID_POINT = null;
    private Matrix mMatrix;
    private final PreviewTransformation mPreviewTransformation;
    private Rect mSensorRect;

    static {
        INVALID_POINT = new PointF(2.0f, 2.0f);
    }

    public PreviewViewMeteringPointFactory(PreviewTransformation r2) {
        this.mSensorRect = null;
        this.mPreviewTransformation = r2;
    }

    public void setSensorRect(Rect r4) {
        setSurfaceAspectRatio(new Rational(r4.width(), r4.height()));
        monitor-enter(this);
        this.mSensorRect = r4;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.MeteringPointFactory
    public PointF convertPoint(float r3, float r4) {
        float[] r0 = {r3, r4};
        monitor-enter(this);
        Matrix r5 = this.mMatrix;     // Catch: Throwable -> L13
        if (r5 != null) goto L9;
        PointF r6 = INVALID_POINT;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r6;
    L9:
        r5.mapPoints(r0);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return new PointF(r0[0], r0[1]);
    L13:
        th = move-exception;
        throw th;
    }

    public void recalculate(Size r3, int r4) {
        Threads.checkMainThread();
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r3.getWidth() != 0) goto L7;
    L14:
        this.mMatrix = null;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L7:
        if (r3.getHeight() == 0) goto L14;
        Rect r0 = this.mSensorRect;     // Catch: Throwable -> L17
        if (r0 == null) goto L14;
        this.mMatrix = this.mPreviewTransformation.getPreviewViewToNormalizedSensorMatrix(r3, r4, r0);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    }
}
