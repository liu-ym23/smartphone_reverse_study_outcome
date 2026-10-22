package y81;

import android.animation.ValueAnimator;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f566759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f566760b;

    public g(ValueAnimator r100, c r101) {
        this.f566759a = r100;
        this.f566760b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = this.f566759a.getAnimatedValue();
        if (r101 == null) goto L7;
        int r102 = ((Integer) r101).intValue();
        c r103 = this.f566760b;
        c.k(r103, r103.f566681q, ColorProtector.parseColor("#26000000"), r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
