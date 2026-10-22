package km3;

import android.animation.ValueAnimator;
import com.bytedance.android.uicomponent.loading.CircularProgressView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ CircularProgressView c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        CircularProgressView r0 = this.c;
        r0.p = ((Float) r3.getAnimatedValue()).floatValue();
        CircularProgressView r4 = this.c;
        r4.j = (this.a - r4.p) + this.b;
        r4.invalidate();
    }

    public c(CircularProgressView r1, float r2, float r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
