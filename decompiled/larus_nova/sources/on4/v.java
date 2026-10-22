package on4;

import android.animation.Animator;
import com.bytedance.ee.bear.basesdk.LarkLoadingView;

/* JADX INFO: loaded from: classes15.dex */
public final class v implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkLoadingView f524348a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public v(LarkLoadingView r100) {
        this.f524348a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        LarkLoadingView r101 = this.f524348a;
        if (r101.f206478d == false) goto L6;
        r101.f206491q.start();
        return;
    }
}
