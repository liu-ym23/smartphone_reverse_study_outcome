package ej9;

import android.animation.Animator;
import com.larus.livetutor.impl.base.BaseBottomDialog;

/* JADX INFO: loaded from: classes30.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBottomDialog f472895a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public i(BaseBottomDialog r100) {
        this.f472895a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        BaseBottomDialog r101 = this.f472895a;
        int r102 = BaseBottomDialog.f355878m;
        r101.L0();
    }
}
