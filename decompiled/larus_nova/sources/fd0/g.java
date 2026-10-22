package fd0;

import android.animation.Animator;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveAnimator f476456a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    public g(LiveAnimator r100) {
        this.f476456a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        b r101 = this.f476456a.f71425i;
        if (r101 == null) goto L5;
        r101.onStop();
    L5:
        this.f476456a.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        a r101 = this.f476456a.f71424h;
        if (r101 == null) goto L6;
        r101.onStart();
        return;
    }
}
