package q19;

import android.animation.ValueAnimator;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SuperSwipeRefreshLayout f531315a;

    public d(SuperSwipeRefreshLayout r100) {
        this.f531315a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue()).intValue() - this.f531315a.getTargetView().getTop();
        this.f531315a.setTargetTopAndBottomOffset(r101);
    }
}
