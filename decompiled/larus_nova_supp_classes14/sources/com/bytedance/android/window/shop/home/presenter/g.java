package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements ECWindowOverScrollExpandBehavior.c {
    public final /* synthetic */ int a;
    public final /* synthetic */ e b;

    public final boolean d() {
        return true;
    }

    public final void e() {
    }

    public final long f() {
        return 400;
    }

    public final int a() {
        return com.bytedance.android.shopping.extensions.b.b(150);
    }

    public final void b() {
        View r0 = this.b.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
    L5:
        wg.a.d(r0, this.b.p);
    }

    public final void c(int r4) {
        View r0 = this.b.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
    L5:
        wg.a.d(r0, this.b.p + (r4 - this.a));
    }

    public final void onRelease(int r4) {
        if ((r4 - this.a) <= com.bytedance.android.shopping.extensions.b.b(90)) goto L8;
        Function3<String, Boolean, String, Unit> r5 = this.b.O().getJump2Live();
        if (r5 == null) goto L9;
        Unit r6 = (Unit) r5.invoke("live_cell_head", Boolean.FALSE, "a1.b7635.c2240.d0");
        return;
    L9:
        return;
    }

    public g(int r1, e r2) {
        this.a = r1;
        this.b = r2;
    }
}
