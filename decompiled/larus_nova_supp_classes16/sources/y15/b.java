package y15;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ e b;
    public final /* synthetic */ ObjectAnimator c;
    public final /* synthetic */ c d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r7) {
        c r8 = this.d;
        View r0 = this.a;
        e r1 = this.b;
        r8.getClass();
        if ((r0 instanceof ImageView) == false) goto L6;
        r8.d((ImageView) r0, r1);
    L13:
        this.c.start();
        return;
    L6:
        if ((r0 instanceof ViewGroup) == false) goto L13;
        ViewGroup r2 = (ViewGroup) r0;
        int r3 = r2.getChildCount();
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L13;
        View r5 = r2.getChildAt(r4);
        if ((r5 instanceof ImageView) == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r8.d((ImageView) r5, r1);
        goto L13
    }

    public b(c r1, View r2, e r3, ObjectAnimator r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
