package sh3;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements TypeEvaluator<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f541962a;

    public e(PointF r100) {
        Intrinsics.checkNotNullParameter(r100, "controlPoint");
        this.f541962a = r100;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r100, PointF r101, PointF r102) {
        PointF r103 = r101;
        PointF r104 = r102;
        Intrinsics.checkNotNullParameter(r103, "startValue");
        Intrinsics.checkNotNullParameter(r104, "endValue");
        PointF r105 = new PointF();
        float r106 = 1 - r100;
        float r107 = r106 * r106;
        float r108 = r103.x * r107;
        float r109 = (2 * r100) * r106;
        PointF r110 = this.f541962a;
        float r111 = r100 * r100;
        r105.x = (r108 + (r110.x * r109)) + (r104.x * r111);
        r105.y = ((r107 * r103.y) + (r109 * r110.y)) + (r111 * r104.y);
        return r105;
    }
}
