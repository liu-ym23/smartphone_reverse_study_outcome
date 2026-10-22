package fv4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b a;

    public b(com.bytedance.ee.bear.bitable.toast.b r1) {
        this.a = r1;
    }

    public final void a() {
        if (com.bytedance.ee.util.ui.b.a(this.a.a) == true) goto L7;
        tt5.a.k("STClickableToast", "activity is not active");
        return;
    L7:
        if ((this.a.d.getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r0 = this.a.d.getParent();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r0).removeView(this.a.d);
    L9:
        this.a.d.setAlpha(0.0f);
        View r1 = this.a.a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L14:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        com.bytedance.ee.bear.bitable.toast.b r2 = this.a;
        ((ViewGroup) r1).addView(r2.d, r2.f);
        com.bytedance.ee.bear.bitable.toast.b r4 = this.a;
        r4.d.animate().setDuration(200).alpha(1.0f).start();
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4.d, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r4.d, "translationY", new float[]{n.d(28), 0.0f});
        r4.d.getTranslationY();
        AnimatorSet r7 = new AnimatorSet();
        r7.setDuration(200);
        r7.setInterpolator(new DecelerateInterpolator());
        r7.playTogether(new Animator[]{r5, r6});
        r7.start();
        com.bytedance.ee.bear.bitable.toast.b r8 = this.a;
        com.bytedance.ee.bear.bitable.toast.c r9 = r8.h;
        Long r10 = r8.b;
        if (r10 == null) goto L17;
        long r11 = r10.longValue();
    L18:
        j.d(r9, r11);
        return;
    L17:
        r11 = 4000;
        goto L18
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
