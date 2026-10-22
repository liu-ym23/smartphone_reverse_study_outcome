package km3;

import android.animation.ValueAnimator;
import com.bytedance.android.uicomponent.loading.CircularProgressView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CircularProgressView a;

    public b(CircularProgressView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        CircularProgressView r0 = this.a;
        r0.k = ((Float) r2.getAnimatedValue()).floatValue();
    }
}
