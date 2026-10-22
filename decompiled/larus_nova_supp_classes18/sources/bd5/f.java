package bd5;

import android.animation.Animator;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ HomeMainTitleBar a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    public f(HomeMainTitleBar r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        this.a.k = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        HomeMainTitleBar r3 = this.a;
        if (r3.l == true) goto L5;
        r3.setVisibility(8);
    L5:
        this.a.k = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        HomeMainTitleBar r3 = this.a;
        if (r3.l == false) goto L6;
        r3.setVisibility(0);
        return;
    }
}
