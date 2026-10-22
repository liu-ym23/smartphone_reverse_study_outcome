package ld8;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonComponent;
import com.larus.bmhome.databinding.LarusPageChatBottomFloatingButtonBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusPageChatBottomFloatingButtonBinding f508778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomFloatingButtonComponent f508779b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f508779b.f299582v = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f508778a.f311110a.setVisibility(0);
        this.f508778a.f311114e.setVisibility(0);
        this.f508778a.f311111b.b();
    }

    public l(LarusPageChatBottomFloatingButtonBinding r100, BottomFloatingButtonComponent r101) {
        this.f508778a = r100;
        this.f508779b = r101;
    }
}
