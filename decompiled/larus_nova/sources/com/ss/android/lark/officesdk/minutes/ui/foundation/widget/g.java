package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f435756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f435757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<ValueAnimator, Unit> f435758c;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Ref.LongRef r100, long r101, Function1<? super ValueAnimator, Unit> r102) {
        this.f435756a = r100;
        this.f435757b = r101;
        this.f435758c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        long r101 = SystemClock.uptimeMillis();
        Ref.LongRef r102 = this.f435756a;
        if ((r101 - r102.element) < this.f435757b) goto L6;
        r102.element = r101;
        this.f435758c.invoke(r100);
        return;
    }
}
