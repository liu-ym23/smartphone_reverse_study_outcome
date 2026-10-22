package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ LivingIconComponent a;

    public c(LivingIconComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View, android.widget.FrameLayout, com.bytedance.android.shopping.prepurchase.business.pdp.view.AnchorV4PlaybackAreaV2] */
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r10) {
        float r11 = ((Number) r10).floatValue();
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.a, "draggableOffset == " + r11 + ' ' + this.a.m);
        LivingIconComponent r0 = this.a;
        ?? r1 = r0.m;
        if (r1 == 0) goto L32;
        int r2 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.O1())).b.b;
        Integer r3 = r1.r;
        Integer r4 = r1.s;
        boolean r5 = false;
        if (r3 == null) goto L17;
        if (r4 == null) goto L17;
        int r6 = r4.intValue();
        int r7 = r3.intValue();
        ViewGroup.LayoutParams r8 = r1.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r8 = null;
    L10:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        if (r9 == null) goto L17;
        float r12 = r6 + ((r7 - r6) * (1 - r11));
        if (r11 >= 0) goto L15;
        r12 = r7 + (r2 * Math.abs(r11));
    L15:
        r9.topMargin = (int) r12;
        r1.setLayoutParams(r9);
    L17:
        if (r1.getVisibility() != 0) goto L19;
        r5 = true;
    L19:
        if (r5 == true) goto L21;
        return;
    L21:
        if (r1.y == true) goto L23;
        return;
    L23:
        if (r11 == 1.0f) goto L25;
    L27:
        if (r11 < 1.0f) goto L29;
        return;
    L29:
        if (r1.getAlpha() == 0.0f) goto L37;
        r1.setAlpha(0.0f);
        return;
    L37:
        return;
    L25:
        if (r1.getAlpha() == 1.0f) goto L27;
        r1.setAlpha(1.0f);
        return;
    }
}
