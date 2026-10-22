package jx4;

import android.animation.ValueAnimator;
import com.bytedance.ee.bear.debug.LoadingView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LoadingView a;

    public v(LoadingView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        float r4 = ((Float) r3.getAnimatedValue()).floatValue();
        LoadingView r0 = this.a;
        r0.c = r4 * 360.0f;
        r0.invalidate();
    }
}
