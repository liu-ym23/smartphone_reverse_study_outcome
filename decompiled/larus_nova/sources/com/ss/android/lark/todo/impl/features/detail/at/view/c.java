package com.ss.android.lark.todo.impl.features.detail.at.view;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoAtView f442815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f442816b;

    public c(TodoAtView r100, ValueAnimator r101) {
        this.f442815a = r100;
        this.f442816b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        TodoAtView r101 = this.f442815a;
        r101.setTranslationY(r101.getHeight() * this.f442816b.getAnimatedFraction());
    }
}
