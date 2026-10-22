package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnLayoutChangeListener {
    public final /* synthetic */ CouponButtonElementViewV2 a;

    public a(CouponButtonElementViewV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        TextWithOneIconElementView r10 = this.a.b;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L7;
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r11;
        r12.height = this.a.c.getHeight();
        Unit r13 = Unit.INSTANCE;
        r10.setLayoutParams(r12);
        this.a.c.removeOnLayoutChangeListener(this);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
