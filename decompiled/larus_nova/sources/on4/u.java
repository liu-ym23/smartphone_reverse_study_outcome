package on4;

import android.animation.ValueAnimator;
import com.bytedance.ee.bear.basesdk.LarkLoadingView;

/* JADX INFO: loaded from: classes15.dex */
public final class u implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkLoadingView f524347a;

    public u(LarkLoadingView r100) {
        this.f524347a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        LarkLoadingView r101 = this.f524347a;
        r101.f206485k = ((Integer) r100.getAnimatedValue()).intValue();
        this.f524347a.postInvalidate();
    }
}
