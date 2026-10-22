package ds8;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.bmhome.top.ChatTopFloatingButtonComponent;
import com.larus.chat.core.impl.databinding.LarusPageChatTopFloatingButtonBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusPageChatTopFloatingButtonBinding f469872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatTopFloatingButtonComponent f469873b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f469872a.f324096a.setVisibility(8);
        this.f469872a.f324097b.setVisibility(8);
        ChatTopFloatingButtonComponent r101 = this.f469873b;
        int r102 = ChatTopFloatingButtonComponent.f314716z;
        r101.getClass();
        this.f469872a.f324096a.setClipToOutline(false);
    }

    public i(LarusPageChatTopFloatingButtonBinding r100, ChatTopFloatingButtonComponent r101) {
        this.f469872a = r100;
        this.f469873b = r101;
    }
}
