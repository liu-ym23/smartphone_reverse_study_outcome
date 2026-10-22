package ti2;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements TypeEvaluator<PointF> {
    public e() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r6, PointF r7, PointF r8) {
        PointF r9 = r7;
        PointF r10 = r8;
        Intrinsics.checkNotNullParameter(r9, "startValue");
        Intrinsics.checkNotNullParameter(r10, "endValue");
        PointF r0 = new PointF();
        float r1 = r9.x;
        float r4 = 1.0f - r6;
        r0.x = r1 + ((r10.x - r1) * (1.0f - (r4 * r4)));
        float r11 = r9.y;
        r0.y = r11 + ((r10.y - r11) * (r6 * r6));
        return r0;
    }
}
