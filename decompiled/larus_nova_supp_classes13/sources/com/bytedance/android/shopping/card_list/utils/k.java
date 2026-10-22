package com.bytedance.android.shopping.card_list.utils;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ViewTreeObserver a;
    public final /* synthetic */ HalfPanelHelper b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        com.bytedance.android.shopping.card_list.components.i r0 = (com.bytedance.android.shopping.card_list.components.i) this.b.m.getValue();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.g());
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.intValue() > 0) goto L10;
        return;
    L10:
        if (this.a.isAlive() == false) goto L12;
        this.a.removeOnGlobalLayoutListener(this);
    L12:
        LinearLayout r2 = this.b.e;
        if (r2 == null) goto L20;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L21;
        r3.height = r1.intValue();
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public k(ViewTreeObserver r1, HalfPanelHelper r2) {
        this.a = r1;
        this.b = r2;
    }
}
