package com.bytedance.android.shopping.buynow.controller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BuyNowElevatorGuideController a;
    public final /* synthetic */ RecyclerView b;

    public d(BuyNowElevatorGuideController r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        BuyNowElevatorGuideController r9 = this.a;
        RecyclerView r0 = this.b;
        com.bytedance.kmp.ec.yata.store.node.c r1 = r9.b();
        if (r1 == null) goto L43;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r2 = r1.b.b;
        String r3 = null;
        Object r4 = null;
        if (r2 == null) goto L11;
        Object r5 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r2, Reflection.getOrCreateKotlinClass(String.class), "target_yata_key");
        if ((r5 instanceof String) == true) goto L10;
        r5 = null;
    L10:
        String r6 = (String) r5;
    L12:
        if (r6 == null) goto L44;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r7 = r1.b.b;
        if (r7 == null) goto L20;
        Object r10 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r7, Reflection.getOrCreateKotlinClass(String.class), "target_component_name");
        if ((r10 instanceof String) == true) goto L19;
        r10 = null;
    L19:
        String r11 = (String) r10;
    L21:
        if (r11 == null) goto L45;
        int r12 = com.bytedance.android.shopping.buynow.utils.h.b(r9.c.getYataInstance(), r11, r6);
        if (r12 < 0) goto L46;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r13 = r1.b.b;
        if (r13 == null) goto L34;
        Object r14 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r13, Reflection.getOrCreateKotlinClass(String.class), "click_elevator_event_name");
        if ((r14 instanceof String) == false) goto L32;
        r4 = r14;
    L32:
        r3 = (String) r4;
    L34:
        if (r3 != null) goto L36;
    L41:
        r9.b.setVisibility(8);
        r9.c(r1, "hide_elevator_event_name", "onClickDisappear");
        r9.c(r1, "click_elevator_event_name", "onElevatorGuideClicked");
        r9.a = false;
        return;
    L36:
        if (r3.length() <= 0) goto L38;
        boolean r15 = true;
    L39:
        if (r15 != true) goto L41;
        r0.smoothScrollToPosition(r12);
        goto L41
    L38:
        r15 = false;
        goto L39
    L46:
        return;
    L45:
        return;
    L20:
        r11 = null;
        goto L21
    L44:
        return;
    L11:
        r6 = null;
        goto L12
    }
}
