package ds8;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.top.ChatTopFloatingButtonComponent;
import com.larus.chat.core.impl.databinding.LarusPageChatTopFloatingButtonBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusPageChatTopFloatingButtonBinding f469875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatTopFloatingButtonComponent f469876b;

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
        ChatTopFloatingButtonComponent r101 = this.f469876b;
        int r102 = ChatTopFloatingButtonComponent.f314716z;
        r101.getClass();
        this.f469875a.f324096a.setClipToOutline(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f469875a.f324096a.setVisibility(0);
        this.f469875a.f324097b.setVisibility(0);
    }

    public k(LarusPageChatTopFloatingButtonBinding r100, ChatTopFloatingButtonComponent r101) {
        this.f469875a = r100;
        this.f469876b = r101;
    }
}
