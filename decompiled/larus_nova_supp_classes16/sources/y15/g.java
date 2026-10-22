package y15;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.document.menu.OfficeTitleMenuPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ e b;
    public final /* synthetic */ ObjectAnimator c;
    public final /* synthetic */ h d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r7) {
        h r8 = this.d;
        View r0 = this.a;
        e r1 = this.b;
        r8.getClass();
        if ((r0 instanceof ImageView) == false) goto L6;
        r8.a((ImageView) r0, r1);
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
        r8.a((ImageView) r5, r1);
        goto L13
    }

    public g(OfficeTitleMenuPlugin.a r1, View r2, e r3, ObjectAnimator r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
