package fv4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b a;

    public c(com.bytedance.ee.bear.bitable.toast.b r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        if (com.bytedance.ee.util.ui.b.a(this.a.a) == true) goto L5;
        return;
    L5:
        if ((this.a.d.getParent() instanceof ViewGroup) == false) goto L11;
        ViewParent r3 = this.a.d.getParent();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r3).removeView(this.a.d);
        Runnable r4 = this.a.i;
        if (r4 == null) goto L12;
        r4.run();
        return;
    L12:
        return;
    }
}
