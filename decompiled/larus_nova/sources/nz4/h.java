package nz4;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f521396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f521397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f521398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f521399d;

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
        if (this.f521397b != 0) goto L5;
        this.f521398c.setVisibility(8);
    L5:
        Function0<Unit> r101 = this.f521399d;
        if (r101 == null) goto L9;
        r101.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Function0<Unit> r101 = this.f521396a;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    public h(Function0<Unit> r100, int r101, View r102, Function0<Unit> r103) {
        this.f521396a = r100;
        this.f521397b = r101;
        this.f521398c = r102;
        this.f521399d = r103;
    }
}
