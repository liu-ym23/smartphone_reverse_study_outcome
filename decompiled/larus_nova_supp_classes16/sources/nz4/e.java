package nz4;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ float c;

    public e(View r1, int r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "valueAnimator");
        Object r0 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
        int r1 = ((Integer) r0).intValue();
        ViewGroup.LayoutParams r2 = this.a.getLayoutParams();
        r2.width = r1;
        this.a.setLayoutParams(r2);
        this.a.setX(this.c - (r3.getAnimatedFraction() * this.b));
    }
}
