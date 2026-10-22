package xi4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.scroller.a f563939a;

    public o(com.bytedance.creativex.mediaimport.view.internal.scroller.a r100) {
        this.f563939a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        com.bytedance.creativex.mediaimport.view.internal.scroller.a r101 = this.f563939a;
        r101.f204047n = false;
        ValueAnimator r102 = r101.f204043j;
        if (r102 == null) goto L6;
        r102.removeAllListeners();
        r102.removeAllUpdateListeners();
        r101.f204043j = null;
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        com.bytedance.creativex.mediaimport.view.internal.scroller.a r101 = this.f563939a;
        r101.f204047n = false;
        ValueAnimator r102 = r101.f204043j;
        if (r102 == null) goto L6;
        r102.removeAllListeners();
        r102.removeAllUpdateListeners();
        r101.f204043j = null;
        return;
    }
}
