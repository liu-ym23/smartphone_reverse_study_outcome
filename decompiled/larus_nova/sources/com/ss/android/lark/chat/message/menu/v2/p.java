package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f415766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f415767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MessageActionPanel f415768c;

    public p(View r100, a r101, MessageActionPanel r102) {
        this.f415766a = r100;
        this.f415767b = r101;
        this.f415768c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        this.f415766a.setTranslationY(r102);
        MessageActionPanel.h(this.f415768c, this.f415767b.f415667a.getHeight() - r102, this.f415767b);
    }
}
