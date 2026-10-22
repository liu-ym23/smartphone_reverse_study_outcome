package dg5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ a0 b;

    public b0(a0 r1) {
        this.b = r1;
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        this.b.e(this.a);
    }
}
