package fv4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b f478956a;

    public b(com.bytedance.ee.bear.bitable.toast.b r100) {
        this.f478956a = r100;
    }

    public final void a() {
        if (com.bytedance.ee.util.ui.b.a(this.f478956a.f215980a) == true) goto L7;
        tt5.a.k("STClickableToast", "activity is not active");
        return;
    L7:
        if ((this.f478956a.f215983d.getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r100 = this.f478956a.f215983d.getParent();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r100).removeView(this.f478956a.f215983d);
    L9:
        this.f478956a.f215983d.setAlpha(0.0f);
        View r101 = this.f478956a.f215980a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L14:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        com.bytedance.ee.bear.bitable.toast.b r103 = this.f478956a;
        ((ViewGroup) r101).addView(r103.f215983d, r103.f215985f);
        com.bytedance.ee.bear.bitable.toast.b r104 = this.f478956a;
        r104.f215983d.animate().setDuration(200).alpha(1.0f).start();
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r104.f215983d, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r104.f215983d, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{n.d(28), 0.0f});
        r104.f215983d.getTranslationY();
        AnimatorSet r107 = new AnimatorSet();
        r107.setDuration(200);
        r107.setInterpolator(new DecelerateInterpolator());
        r107.playTogether(new Animator[]{r105, r106});
        r107.start();
        com.bytedance.ee.bear.bitable.toast.b r108 = this.f478956a;
        com.bytedance.ee.bear.bitable.toast.c r109 = r108.f215987h;
        Long r110 = r108.f215981b;
        if (r110 == null) goto L17;
        long r111 = r110.longValue();
    L18:
        j.d(r109, r111);
        return;
    L17:
        r111 = 4000;
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
