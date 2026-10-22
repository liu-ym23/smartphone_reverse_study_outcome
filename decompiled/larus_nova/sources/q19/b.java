package q19;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements Animator.AnimatorListener {
    public b() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.d("RefreshHeaderLayout", "fakeRefreshingAnimator onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.d("RefreshHeaderLayout", "fakeRefreshingAnimator onAnimationEnd");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.d("RefreshHeaderLayout", "fakeRefreshingAnimator onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FLogger.f375446a.d("RefreshHeaderLayout", "fakeRefreshingAnimator onAnimationStart");
    }
}
