package d2a;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Animator, Unit> f466560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animator f466561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Animator, Unit> f466562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<Animator, Unit> f466563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1<Animator, Unit> f466564e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f466561b.removeListener(this);
        this.f466563d.invoke(r100);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f466561b.removeListener(this);
        this.f466562c.invoke(r100);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f466560a.invoke(r100);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Function1<Animator, Unit> r101 = this.f466562c;
        e r102 = g.f466565a;
        if (Intrinsics.areEqual(r101, r102) == true) goto L5;
    L9:
        this.f466564e.invoke(r100);
        return;
    L5:
        if (Intrinsics.areEqual(this.f466563d, r102) == false) goto L9;
        if (Intrinsics.areEqual(this.f466560a, r102) == false) goto L9;
        this.f466561b.removeListener(this);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super Animator, Unit> r100, Animator r101, Function1<? super Animator, Unit> r102, Function1<? super Animator, Unit> r103, Function1<? super Animator, Unit> r104) {
        this.f466560a = r100;
        this.f466561b = r101;
        this.f466562c = r102;
        this.f466563d = r103;
        this.f466564e = r104;
    }
}
