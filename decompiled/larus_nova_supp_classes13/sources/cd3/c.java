package cd3;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SlcScrollingView a;
    public final /* synthetic */ int b;

    public c(SlcScrollingView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        View r0 = this.a.getChildAt(0);
        if (r0 != null) goto L5;
    L16:
        this.a.c();
        return;
    L5:
        if (r0.getMeasuredWidth() != this.b) goto L16;
        if ((!Intrinsics.areEqual(r3, this.a.b)) == false) goto L10;
        return;
    L10:
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L15;
        this.a.b(((Float) r4).floatValue());
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
