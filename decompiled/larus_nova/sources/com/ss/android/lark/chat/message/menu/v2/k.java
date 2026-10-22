package com.ss.android.lark.chat.message.menu.v2;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageActionPanel f415752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f415753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f415754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f415755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f415756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f415757f;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MessageActionPanel r101 = this.f415752a;
        r101.Q = false;
        r101.R.invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f415757f.setVisibility(8);
        View r101 = this.f415752a.N;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationMask");
        r101 = null;
    L5:
        r101.setVisibility(8);
        MessageActionPanel r102 = this.f415752a;
        r102.Q = false;
        r102.R.invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        MessageActionPanel r101 = this.f415752a;
        r101.Q = true;
        this.f415753b.setTranslationY(r101.f415569i - this.f415754c);
        View r102 = this.f415752a.N;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationMask");
        r102 = null;
    L5:
        r102.setVisibility(0);
        View r104 = this.f415752a.N;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("animationMask");
    L9:
        float r105 = this.f415756e;
        ViewGroup.LayoutParams r106 = r103.getLayoutParams();
        if (r106 == null) goto L14;
        r106.height = (int) r105;
        r103.setLayoutParams(r106);
        this.f415753b.setVisibility(0);
        this.f415755d.invoke();
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L8:
        r103 = r104;
        goto L9
    }

    public k(MessageActionPanel r100, UDShadowLayout r101, float r102, Function0 r103, float r104, UDShadowLayout r105) {
        this.f415752a = r100;
        this.f415753b = r101;
        this.f415754c = r102;
        this.f415755d = r103;
        this.f415756e = r104;
        this.f415757f = r105;
    }
}
