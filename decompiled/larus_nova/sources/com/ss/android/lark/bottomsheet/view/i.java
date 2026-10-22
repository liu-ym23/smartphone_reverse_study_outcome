package com.ss.android.lark.bottomsheet.view;

import android.animation.ValueAnimator;
import com.ss.android.lark.bottomsheet.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExpandValueAnimatorInForseti.a f410763a;

    public i(q r100) {
        this.f410763a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ExpandValueAnimatorInForseti.a r101 = this.f410763a;
        if (r101 == null) goto L6;
        r101.d(r100.getAnimatedFraction());
        return;
    }
}
