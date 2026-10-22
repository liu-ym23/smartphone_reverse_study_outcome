package ue3;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public c(View r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        Object r8 = r7.getAnimatedValue();
        if (r8 == null) goto L7;
        int r9 = ((Integer) r8).intValue();
        int r0 = this.a.getWidth();
        int r1 = this.a.getHeight();
        View r2 = this.a;
        int r3 = this.b;
        int r4 = this.c;
        r2.layout(r3, r4 + r9, r0 + r3, (r4 + r9) + r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
