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
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f521380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f521381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f521382c;

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
        this.f521381b.element = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        k.f521405a.remove(this.f521380a);
        if (this.f521381b.element == true) goto L11;
        ViewGroup.LayoutParams r101 = this.f521380a.getLayoutParams();
        if (r101 == null) goto L7;
        r101.width = 0;
        this.f521380a.setLayoutParams(r101);
    L7:
        Function0<Unit> r102 = this.f521382c;
        if (r102 == null) goto L12;
        r102.invoke();
        return;
    L12:
        return;
    }

    public b(View r100, Ref.BooleanRef r101, Function0<Unit> r102) {
        this.f521380a = r100;
        this.f521381b = r101;
        this.f521382c = r102;
    }
}
