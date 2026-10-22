package com.ss.android.lark.feed.cardcomponent.preview;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f420957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f420958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<ValueAnimator, Unit> f420959c;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Ref.LongRef r100, long r101, Function1<? super ValueAnimator, Unit> r102) {
        this.f420957a = r100;
        this.f420958b = r101;
        this.f420959c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        long r101 = SystemClock.uptimeMillis();
        Ref.LongRef r102 = this.f420957a;
        if ((r101 - r102.element) < this.f420958b) goto L6;
        r102.element = r101;
        this.f420959c.invoke(r100);
        return;
    }
}
