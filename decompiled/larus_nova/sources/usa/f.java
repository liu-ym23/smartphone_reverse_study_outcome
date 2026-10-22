package usa;

import android.animation.Animator;
import com.ss.android.bytedcert.view.ScrollTextView;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView f551565a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public f(ScrollTextView r100) {
        this.f551565a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        ScrollTextView r101 = this.f551565a;
        r101.setTextColor(r101.f407782a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        ScrollTextView r101 = this.f551565a;
        int r102 = ScrollTextView.f407781e;
        r101.getClass();
        ScrollTextView r103 = this.f551565a;
        r103.setTextColor(r103.f407783b);
        this.f551565a.getClass();
    }
}
