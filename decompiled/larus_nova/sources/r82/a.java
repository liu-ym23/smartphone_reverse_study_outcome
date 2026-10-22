package r82;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements TypeEvaluator<PointF> {
    public a() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r110, PointF r111, PointF r112) {
        PointF r113 = r111;
        PointF r114 = r112;
        Intrinsics.checkNotNullParameter(r113, "startValue");
        Intrinsics.checkNotNullParameter(r114, "endValue");
        float r100 = r114.y - r113.y;
        float r115 = r114.x - r113.x;
        if (r110 >= 0.5f) goto L5;
        float r101 = 2;
        float r102 = r101 * r110;
        float r103 = r113.x;
        float r104 = 1 - r102;
        return new PointF((((r104 * r104) * r103) + (((r101 * r102) * r104) * (r103 - 8))) + ((r102 * r102) * r103), r113.y + (r100 * r110));
    L5:
        double r105 = (((double) r110) - 0.5d) * ((double) 2);
        float r106 = (float) r105;
        float r107 = r113.x;
        float r108 = 1 - r106;
        return new PointF((float) (((double) ((((r108 * r108) * r107) + (((2 * r106) * r108) * (8 + r107))) + ((r106 * r106) * r107))) + (r105 * ((double) r115))), r113.y + (r100 * r110));
    }
}
