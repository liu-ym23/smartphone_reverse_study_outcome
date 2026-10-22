package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.view.View;
import android.widget.HorizontalScrollView;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x extends com.bytedance.kmp.ec.yata.event.common.b {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public x(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        com.bytedance.kmp.ec.yata.common.platform.o r0 = r10.d.b;
        if (r0 == null) goto L5;
        View r1 = r0.a;
    L6:
        Object r2 = r10.p(Reflection.getOrCreateKotlinClass(String.class), "orientation");
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r1 != null) goto L13;
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.getTracker(), "selfScrollItemToCenter", "touch view is null", r10);
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L13:
        HorizontalScrollView r6 = d(r1);
        if (r6 != null) goto L17;
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.getTracker(), "selfScrollItemToCenter", "parent scrollview is null", r10);
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L17:
        if (r3 != null) goto L20;
    L25:
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.getTracker(), "selfScrollItemToCenter", "orientation is not support", r10);
    L26:
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L20:
        if (r3.hashCode() != 1387629604) goto L25;
        if (r3.equals("horizontal") == false) goto L25;
        com.bytedance.android.shopping.buynow.utils.q.c(r1, r6);
        goto L26
    L5:
        r1 = null;
        goto L6
    }

    public final HorizontalScrollView d(View r3) {
        Object r4 = r3.getParent();
        if ((r4 instanceof View) == true) goto L5;
        r4 = null;
    L5:
        View r5 = (View) r4;
        if (r5 != null) goto L9;
        return null;
    L9:
        if ((r5 instanceof HorizontalScrollView) == false) goto L13;
        return (HorizontalScrollView) r5;
    L13:
        return d(r5);
    }
}
