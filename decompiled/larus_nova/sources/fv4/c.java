package fv4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.toast.b f478957a;

    public c(com.bytedance.ee.bear.bitable.toast.b r100) {
        this.f478957a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        if (com.bytedance.ee.util.ui.b.a(this.f478957a.f215980a) == true) goto L5;
        return;
    L5:
        if ((this.f478957a.f215983d.getParent() instanceof ViewGroup) == false) goto L11;
        ViewParent r101 = this.f478957a.f215983d.getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r101).removeView(this.f478957a.f215983d);
        Runnable r102 = this.f478957a.f215988i;
        if (r102 == null) goto L12;
        r102.run();
        return;
    L12:
        return;
    }
}
