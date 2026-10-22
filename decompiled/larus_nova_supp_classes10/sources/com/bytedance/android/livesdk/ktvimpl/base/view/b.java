package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ KtvAnchorLyricsDisplayView a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Ref.IntRef c;

    public b(KtvAudienceLyricsDisplayView r1, Ref.IntRef r2, Ref.IntRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        this.a.I = true;
        Ref.IntRef r0 = this.b;
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L10;
        r0.element = ((Integer) r5).intValue();
        Ref.IntRef r6 = this.c;
        int r1 = r6.element;
        Ref.IntRef r2 = this.b;
        int r3 = r2.element;
        if (r1 != r3) goto L7;
        return;
    L7:
        r6.element = r3;
        KtvAnchorLyricsDisplayView r7 = this.a;
        r7.q = r2.element;
        r7.invalidate();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
