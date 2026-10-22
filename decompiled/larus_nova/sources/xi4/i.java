package xi4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.scroller.a f563933a;

    public i(com.bytedance.creativex.mediaimport.view.internal.scroller.a r100) {
        this.f563933a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        com.bytedance.creativex.mediaimport.view.internal.scroller.a r101 = this.f563933a;
        ci4.a.b(r101.d(), false);
        r101.f204045l = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        com.bytedance.creativex.mediaimport.view.internal.scroller.a r101 = this.f563933a;
        ci4.a.b(r101.d(), false);
        r101.f204045l = null;
    }
}
