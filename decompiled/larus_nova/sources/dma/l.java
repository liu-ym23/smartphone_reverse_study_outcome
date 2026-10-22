package dma;

import android.animation.Animator;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OIndexScrollbar f469257a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "arg0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "arg0");
    }

    public l(OIndexScrollbar r100) {
        this.f469257a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "arg0");
        OIndexScrollbar r101 = this.f469257a;
        int r102 = OIndexScrollbar.E;
        r101.getClass();
        OIndexScrollbar.a(this.f469257a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "arg0");
        OIndexScrollbar r101 = this.f469257a;
        int r102 = OIndexScrollbar.E;
        r101.getClass();
        OIndexScrollbar.b(this.f469257a);
    }
}
