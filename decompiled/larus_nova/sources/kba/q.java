package kba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class q extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f502349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f502350b;

    public q(o r100) {
        this.f502350b = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f502349a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        o r101 = this.f502350b;
        if (r101.f502345p == r100) goto L5;
        return;
    L5:
        r101.f502345p = null;
        if (this.f502349a == false) goto L8;
        return;
    L8:
        if (r101.f502339j == false) goto L12;
        r101.c();
        return;
    }
}
