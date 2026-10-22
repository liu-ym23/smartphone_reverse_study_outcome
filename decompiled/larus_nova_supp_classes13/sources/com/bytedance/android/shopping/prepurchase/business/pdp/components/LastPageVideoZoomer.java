package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LastPageVideoZoomer {
    public static final /* synthetic */ int k = 0;
    public boolean a;
    public ValueAnimator b;
    public float c;
    public final Lazy d;
    public final boolean e;
    public ValueAnimator f;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> g;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j h;
    public final n83.m i;
    public final CompatFrameLayout j;

    public static final class a {
    }

    static {
    }

    public final cf.p c() {
        return (cf.p) this.d.getValue();
    }

    public final com.bytedance.android.shopping.prepurchase.business.pdp.e d() {
        return (com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.g);
    }

    public static final String a(LastPageVideoZoomer r1) {
        String r2 = r1.d().a.getNativeParams().getFractionListenerId();
        if (r2 != null) goto L5;
    L7:
        return null;
    L5:
        if (com.bytedance.android.shopping.extensions.k.c(r2) == false) goto L7;
        return r2;
    }

    public final void e(CompatFrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        ValueAnimator r0 = this.f;
        if (r0 == null) goto L7;
        if (r0.isRunning() != true) goto L7;
        return;
    L7:
        if (this.e == true) goto L11;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.c, -1.0f});
        r1.setDuration(150);
        r1.addUpdateListener(new h(this, r5));
        Unit r6 = Unit.INSTANCE;
        this.f = r1;
        r1.start();
        return;
    }

    public static final void b(LastPageVideoZoomer r2, float r3, View r4) {
        int r0 = r2.d().b.b;
        RangesKt.coerceAtMost(r3, 0.0f);
        n83.m r1 = r2.i;
        if (r1 == null) goto L6;
        r1.a();
    L6:
        if (r3 > 0) goto L8;
        int r5 = (int) (r0 * (1 + r3));
    L10:
        if (r2.e == true) goto L15;
        cf.p r6 = r2.c();
        if (r6 == null) goto L16;
        r6.d(r5, r0, r3);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r5 = (int) (r0 + ((r4.getHeight() - r0) * r3));
        goto L10
    }

    public LastPageVideoZoomer(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r2, com.bytedance.android.shopping.prepurchase.arch.container.component.j r3, n83.m r4, CompatFrameLayout r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.d = LazyKt.lazy(new LastPageVideoZoomer$listener$2(this));
        this.e = d().a.getNativeParams().getFullMode();
    }
}
