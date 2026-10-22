package xi4;

import android.animation.FloatEvaluator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m extends FloatEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.scroller.a f563937a;

    public m(com.bytedance.creativex.mediaimport.view.internal.scroller.a r100) {
        this.f563937a = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.animation.FloatEvaluator
    public final Float evaluate(float r100, Number r101, Number r102) {
        Intrinsics.checkNotNullParameter(r101, "startValue");
        Intrinsics.checkNotNullParameter(r102, "endValue");
        Float r103 = super.evaluate(r100, r101, r102);
        View r104 = this.f563937a.g();
        Intrinsics.checkNotNull(r103);
        com.bytedance.creativex.mediaimport.view.internal.scroller.a.i(r104, r103.floatValue());
        return r103;
    }

    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Number evaluate(float r100, Number r101, Number r102) {
        return evaluate(r100, r101, r102);
    }
}
