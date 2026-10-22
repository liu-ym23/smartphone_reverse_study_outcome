package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Function1<View, com.bytedance.android.shopping.prepurchase.arch.exposure.c> {
    public final Rect a;
    public final Function0<View> b;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function0<? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "topSliceView");
        this.b = r2;
        this.a = new Rect();
    }

    public final Object invoke(Object r7) {
        View r8 = (View) r7;
        Intrinsics.checkNotNullParameter(r8, FreqActions.ACTION_VIEW);
        r8.getGlobalVisibleRect(this.a);
        View r0 = (View) this.b.invoke();
        if (r0 != null) goto L5;
        int r2 = r8.getHeight() * r8.getWidth();
        Rect r9 = this.a;
        return new com.bytedance.android.shopping.prepurchase.arch.exposure.c(r2, Math.max((r9.bottom - r9.top) * (r9.right - r9.left), 0));
    L5:
        int r3 = r0.getHeight();
        if (this.a.top <= r3) goto L8;
    L15:
        int r4 = r8.getHeight() * r8.getWidth();
        Rect r10 = this.a;
        return new com.bytedance.android.shopping.prepurchase.arch.exposure.c(r4, Math.max((r10.bottom - r10.top) * (r10.right - r10.left), 0));
    L8:
        if (r0.getVisibility() != 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 != true) goto L15;
        if (r0.getAlpha() < com.bytedance.android.ec.core.abtest.d.m()) goto L15;
        int r6 = r8.getHeight() * r8.getWidth();
        Rect r11 = this.a;
        int r12 = r11.bottom;
        int r13 = r11.top;
        return new com.bytedance.android.shopping.prepurchase.arch.exposure.c(r6, Math.max(((r12 - r13) - (r3 - r13)) * (r11.right - r11.left), 0));
    L10:
        r5 = false;
        goto L11
    }
}
