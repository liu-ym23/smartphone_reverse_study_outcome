package nz4;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f521384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f521385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f521386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f521387d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f521385b.element = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        k.f521405a.remove(this.f521384a);
        if (this.f521385b.element == true) goto L11;
        ViewGroup.LayoutParams r101 = this.f521384a.getLayoutParams();
        if (r101 == null) goto L7;
        r101.width = this.f521386c;
        this.f521384a.setLayoutParams(r101);
    L7:
        Function0<Unit> r102 = this.f521387d;
        if (r102 == null) goto L12;
        r102.invoke();
        return;
    L12:
        return;
    }

    public d(View r100, Ref.BooleanRef r101, int r102, Function0<Unit> r103) {
        this.f521384a = r100;
        this.f521385b = r101;
        this.f521386c = r102;
        this.f521387d = r103;
    }
}
