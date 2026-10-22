package androidx.camera.camera2.internal.compat.workaround;

import android.graphics.PointF;
import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MeteringRegionCorrection {
    private final Quirks mCameraQuirks;

    public MeteringRegionCorrection(Quirks r1) {
        this.mCameraQuirks = r1;
    }

    public PointF getCorrectedPoint(MeteringPoint r3, int r4) {
        if (r4 != 1) goto L9;
        if (this.mCameraQuirks.contains(AfRegionFlipHorizontallyQuirk.class) == false) goto L9;
        return new PointF(1.0f - r3.getX(), r3.getY());
    L9:
        return new PointF(r3.getX(), r3.getY());
    }
}
