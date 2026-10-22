package ad5;

import android.animation.Animator;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ boolean b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        tt5.a.h("HomeSubMenuView", "onAnimationCancel()...");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        tt5.a.h("HomeSubMenuView", "onAnimationEnd()...");
        View r3 = this.a;
        if (this.b == false) goto L5;
        int r0 = 0;
    L6:
        r3.setVisibility(r0);
        return;
    L5:
        r0 = 8;
        goto L6
    }

    public a(AppCompatImageView r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
