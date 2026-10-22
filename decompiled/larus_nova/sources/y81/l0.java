package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f566809a;

    public l0(d0 r100) {
        this.f566809a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        d0 r101 = this.f566809a;
        d0.k(r101, r101.f566717l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        d0 r102 = this.f566809a;
        d0.k(r102, r102.f566717l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#80000000"));
    }
}
