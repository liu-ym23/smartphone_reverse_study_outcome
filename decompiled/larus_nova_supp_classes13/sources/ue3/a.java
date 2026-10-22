package ue3;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public a(View r1, int r2, int r3) {
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
        int r5 = this.c;
        r2.layout(r3 + r9, r5, (r3 + r9) + r0, r1 + r5);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
