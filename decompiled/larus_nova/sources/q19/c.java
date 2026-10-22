package q19;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SuperSwipeRefreshLayout f531314a;

    public c(SuperSwipeRefreshLayout r100) {
        this.f531314a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        this.f531314a.c();
    }
}
