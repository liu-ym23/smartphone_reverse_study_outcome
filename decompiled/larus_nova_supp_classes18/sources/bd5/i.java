package bd5;

import android.animation.Animator;
import com.bytedance.ee.bear.list.homepage.title.MainTabTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements Animator.AnimatorListener {
    public final /* synthetic */ MainTabTitleBar a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    public i(MainTabTitleBar r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        this.a.f = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        MainTabTitleBar r3 = this.a;
        if (r3.g == true) goto L5;
        r3.setVisibility(8);
    L5:
        this.a.f = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        MainTabTitleBar r3 = this.a;
        if (r3.g == false) goto L6;
        r3.setVisibility(0);
        return;
    }
}
