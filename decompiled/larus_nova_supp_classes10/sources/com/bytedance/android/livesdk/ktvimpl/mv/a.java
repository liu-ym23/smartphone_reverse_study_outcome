package com.bytedance.android.livesdk.ktvimpl.mv;

import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;

    public a(b r1, Ref.IntRef r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L17;
        int r5 = ((Integer) r4).intValue();
        if (this.b.element != r5) goto L7;
        return;
    L7:
        if (this.c == false) goto L11;
        this.a.g.b(Integer.valueOf(r5));
        Function1<? super Integer, Unit> r0 = this.a.e;
        if (r0 == null) goto L12;
        Unit r1 = (Unit) r0.invoke(Integer.valueOf(r5));
    L12:
        this.b.element = r5;
        if (this.d == false) goto L19;
        b r6 = this.a;
        r6.getClass();
        r6.g.invalidateSelf();
        return;
    L19:
        return;
    L11:
        this.a.g.d(Integer.valueOf(r5));
        goto L12
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
