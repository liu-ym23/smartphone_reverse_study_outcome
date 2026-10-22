package com.bytedance.component.lyric_v2.painter;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f203074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f203075b;

    public c(d r100, Function0 r101) {
        this.f203074a = r100;
        this.f203075b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L11;
        float r102 = ((Float) r101).floatValue();
        d r103 = this.f203074a;
        if (r102 == r103.f203078c) goto L12;
        r103.f203078c = r102;
        if (r102 == r103.f203079d) goto L13;
        r103.f203079d = r102;
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
