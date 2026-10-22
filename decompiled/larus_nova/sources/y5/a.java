package y5;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.view.popup.anim.AnimController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f566176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f566177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f566178c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f566176a.f566181c.a(AnimController.AnimProcessType.DONE, false, null);
        Function0<Unit> r101 = this.f566178c;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f566176a.f566181c.a(AnimController.AnimProcessType.DONE, false, null);
        Function0<Unit> r101 = this.f566178c;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f566176a.f566181c.a(AnimController.AnimProcessType.DOING, false, this.f566177b.element);
    }

    public a(b r100, Ref.ObjectRef r101, com.bytedance.ai.view.popup.a r102) {
        this.f566176a = r100;
        this.f566177b = r101;
        this.f566178c = r102;
    }
}
