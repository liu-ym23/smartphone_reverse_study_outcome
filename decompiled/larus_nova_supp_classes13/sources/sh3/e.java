package sh3;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements TypeEvaluator<PointF> {
    public final PointF a;

    public e(PointF r2) {
        Intrinsics.checkNotNullParameter(r2, "controlPoint");
        this.a = r2;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r7, PointF r8, PointF r9) {
        PointF r10 = r8;
        PointF r11 = r9;
        Intrinsics.checkNotNullParameter(r10, "startValue");
        Intrinsics.checkNotNullParameter(r11, "endValue");
        PointF r0 = new PointF();
        float r1 = 1 - r7;
        float r2 = r1 * r1;
        float r3 = r10.x * r2;
        float r4 = (2 * r7) * r1;
        PointF r5 = this.a;
        float r12 = r7 * r7;
        r0.x = (r3 + (r5.x * r4)) + (r11.x * r12);
        r0.y = ((r2 * r10.y) + (r4 * r5.y)) + (r12 * r11.y);
        return r0;
    }
}
