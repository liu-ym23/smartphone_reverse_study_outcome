package com.ss.android.lark.todo.impl.features.detail.at.view;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAtView f442799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f442800b;

    public a(TodoAtView r100, ValueAnimator r101) {
        this.f442799a = r100;
        this.f442800b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        TodoAtView r101 = this.f442799a;
        r101.setTranslationY(r101.getHeight() - (r101.getHeight() * this.f442800b.getAnimatedFraction()));
    }
}
