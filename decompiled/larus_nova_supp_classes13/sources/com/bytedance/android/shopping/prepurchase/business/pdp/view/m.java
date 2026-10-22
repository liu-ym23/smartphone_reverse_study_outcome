package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends ViewGroup {
    public Integer a;

    public final Integer getChildMaxHeight() {
        return this.a;
    }

    public m(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void setChildMaxHeight(Integer r1) {
        this.a = r1;
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
    L13:
        int r2 = View.MeasureSpec.getSize(r4);
        measureChildren(r4, r5);
        int r6 = getChildCount();
        int r7 = 0;
    L14:
        if (r1 >= r6) goto L16;
        r7 = r7 + getChildAt(r1).getMeasuredHeight();
        r1 = r1 + 1;
        goto L14
    L16:
        setMeasuredDimension(r2, r7);
        return;
    L5:
        if (r0.intValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        r5 = View.MeasureSpec.makeMeasureSpec(r0.intValue(), Integer.MIN_VALUE);
        goto L13
    L7:
        r3 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getChildCount();
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L8;
        View r10 = getChildAt(r9);
        if (r10.getVisibility() == 8) goto L7;
        int r0 = r10.getMeasuredWidth();
        int r1 = r10.getMeasuredHeight() + r5;
        r10.layout(r4, r5, r0 + r4, r1);
        r5 = r1;
    L7:
        r9 = r9 + 1;
        goto L3
    }
}
