package uo5;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.tts.view.FloatViewContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FrameLayout.LayoutParams a;
    public final /* synthetic */ FloatViewContainer b;

    public a(FrameLayout.LayoutParams r1, FloatViewContainer r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FrameLayout.LayoutParams r0 = this.a;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        r0.rightMargin = ((Integer) r4).intValue();
        this.b.requestLayout();
    }
}
