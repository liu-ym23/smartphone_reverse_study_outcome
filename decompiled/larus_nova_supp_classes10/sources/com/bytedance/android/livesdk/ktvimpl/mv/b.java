package com.bytedance.android.livesdk.ktvimpl.mv;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.android.livesdk.message.model.en;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public int a;
    public int b;
    public ValueAnimator c;
    public ValueAnimator d;
    public Function1<? super Integer, Unit> e;
    public final long f;
    public lb0.a g;

    public b(lb0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        this.g = r3;
        this.f = 1500;
    }

    public final void b(ed r7) {
        Intrinsics.checkNotNullParameter(r7, "colorData");
        float r0 = this.g.c();
        en r1 = r7.a();
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(KtvUtilsKt.J(r1, r0));
    L6:
        en r8 = r7.b();
        if (r8 == null) goto L9;
        r2 = Integer.valueOf(KtvUtilsKt.J(r8, r0));
    L9:
        int r9 = this.a;
        if (r3 != null) goto L13;
    L14:
        int r10 = this.b;
        if (r2 == null) goto L20;
        if (r10 != r2.intValue()) goto L20;
        return;
    L20:
        if (r3 != null) goto L22;
    L26:
        if (r2 != null) goto L28;
        return;
    L28:
        if (this.b == r2.intValue()) goto L36;
        this.b = r2.intValue();
        Integer r4 = this.g.a();
        if (r4 == null) goto L37;
        ValueAnimator r5 = a(this.d, r4.intValue(), r2.intValue());
        Intrinsics.checkNotNullParameter(r5, "$this$addUpdateListener");
        Ref.IntRef r11 = new Ref.IntRef();
        r11.element = 0;
        r5.addUpdateListener(new a(this, r11, false, true));
        this.d = r5;
        return;
    L37:
        return;
    L36:
        return;
    L22:
        if (this.a == r3.intValue()) goto L26;
        this.a = r3.intValue();
        Integer r6 = this.g.e();
        if (r6 == null) goto L26;
        ValueAnimator r12 = a(this.c, r6.intValue(), r3.intValue());
        Intrinsics.checkNotNullParameter(r12, "$this$addUpdateListener");
        Ref.IntRef r13 = new Ref.IntRef();
        r13.element = 0;
        r12.addUpdateListener(new a(this, r13, true, true));
        this.c = r12;
        goto L26
    L13:
        if (r9 != r3.intValue()) goto L14;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final ValueAnimator a(ValueAnimator r4, int r5, int r6) {
        if (r4 != null) goto L5;
    L7:
        ValueAnimator r7 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r5), Integer.valueOf(r6)});
        r7.setInterpolator(new LinearInterpolator());
        r7.setDuration(this.f);
        r7.start();
        return r7;
    L5:
        if (r4.isRunning() != true) goto L7;
        r4.cancel();
        goto L7
    }
}
