package q19;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements Animator.AnimatorListener {
    public a() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.d("RefreshHeaderLayout", "fakeFinishAnimator onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.d("RefreshHeaderLayout", "fakeFinishAnimator onAnimationEnd");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.d("RefreshHeaderLayout", "fakeFinishAnimator onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.d("RefreshHeaderLayout", "fakeFinishAnimator onAnimationStart");
    }
}
