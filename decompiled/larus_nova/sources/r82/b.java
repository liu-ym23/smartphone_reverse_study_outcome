package r82;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements TypeEvaluator<PointF> {
    public b() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r100, PointF r110, PointF r111) {
        PointF r112 = r110;
        PointF r113 = r111;
        Intrinsics.checkNotNullParameter(r112, "startValue");
        Intrinsics.checkNotNullParameter(r113, "endValue");
        float r114 = r113.y - r112.y;
        if (r100 >= 0.5f) goto L5;
        float r101 = 2;
        float r102 = r101 * r100;
        float r103 = r112.x;
        float r104 = 1 - r102;
        return new PointF((((r104 * r104) * r103) + (((r101 * r102) * r104) * (r103 - 8))) + ((r102 * r102) * r103), r112.y + (r114 * r100));
    L5:
        float r105 = (float) ((((double) r100) - 0.5d) * ((double) 2));
        float r106 = r112.x;
        float r107 = 1 - r105;
        return new PointF((((r107 * r107) * r106) + (((2 * r105) * r107) * (8 + r106))) + ((r105 * r105) * r106), r112.y + (r114 * r100));
    }
}
