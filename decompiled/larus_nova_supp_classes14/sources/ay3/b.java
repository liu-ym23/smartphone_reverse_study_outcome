package ay3;

import android.animation.Animator;
import com.bytedance.awemeopen.apps.framework.base.view.xtoast.XToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ XToast a;
    public final /* synthetic */ c b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        XToast r3 = this.a;
        r3.b.removeView(r3.c);
        this.b.sendEmptyMessage(1929);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        XToast r3 = this.a;
        r3.b.removeView(r3.c);
        this.b.sendEmptyMessage(1929);
    }

    public b(c r1, XToast r2) {
        this.b = r1;
        this.a = r2;
    }
}
