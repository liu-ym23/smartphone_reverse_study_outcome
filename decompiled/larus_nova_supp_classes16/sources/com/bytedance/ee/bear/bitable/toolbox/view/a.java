package com.bytedance.ee.bear.bitable.toolbox.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ BitableToolboxFragment a;

    public a(BitableToolboxFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        Integer r10 = (Integer) r9;
        BitableToolboxFragment r0 = this.a;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.intValue();
        if (r0.f != null) goto L5;
        tt5.a.k("BitableToolbarFragment", "updateToolboxBottomPadding skipped, fab container is not initialized");
        return;
    L5:
        int r1 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r11, 0), r0.m);
        LinearLayout r3 = r0.f;
        LinearLayout r5 = null;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r3 = null;
    L8:
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r4;
    L12:
        if (r6 != null) goto L15;
        tt5.a.k("BitableToolbarFragment", "updateToolboxBottomPadding skipped, layoutParams is not MarginLayoutParams");
        return;
    L15:
        if (r6.bottomMargin == r1) goto L25;
        tt5.a.h("BitableToolbarFragment", "updateToolboxBottomPadding height=" + r11 + ", marginBottom=" + r1);
        r6.bottomMargin = r1;
        LinearLayout r12 = r0.f;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
    L21:
        r5.setLayoutParams(r6);
        return;
    L20:
        r5 = r12;
        goto L21
    L25:
        return;
    L11:
        r6 = null;
        goto L12
    }
}
