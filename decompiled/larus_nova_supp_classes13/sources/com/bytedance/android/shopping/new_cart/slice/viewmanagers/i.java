package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.android.ecom.arch.slice.render.elements.b<com.bytedance.android.shopping.new_cart.slice.widgets.l> {
    public final SlcTemplateContext H3;

    public i(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.H3 = r2;
    }

    public final void H0(Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "props");
        Object r0 = r13.get("gradient_colors");
        Object r2 = null;
        if ((r0 instanceof List) == true) goto L5;
        r0 = null;
    L5:
        List<String> r7 = (List) r0;
        Object r1 = r13.get("handler_color");
        if ((r1 instanceof String) == true) goto L8;
        r1 = null;
    L8:
        String r9 = (String) r1;
        float r3 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r13.get("current_progress_status"), 0.0f);
        float r4 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r13.get("last_progress_status"), 0.0f);
        Object r5 = r13.get("animate");
        if ((r5 instanceof Boolean) == true) goto L11;
        r5 = null;
    L11:
        Boolean r6 = (Boolean) r5;
        if (r6 == null) goto L14;
        boolean r8 = r6.booleanValue();
    L15:
        Object r10 = r13.get("bg_color");
        if ((r10 instanceof String) == true) goto L18;
        r10 = null;
    L18:
        String r11 = (String) r10;
        Integer r12 = CartViewExtentionsKt.a(r13.get("animation_boundary"));
        if (r12 == null) goto L21;
        int r14 = r12.intValue();
    L22:
        Object r15 = r13.get("gradient_bg_color");
        if ((r15 instanceof String) == false) goto L26;
        r2 = r15;
    L26:
        ((com.bytedance.android.shopping.new_cart.slice.widgets.l) l1()).b(Float.valueOf(r4), Float.valueOf(r3), r8, r7, r11, r9, (String) r2, r14);
        return;
    L21:
        r14 = 0;
        goto L22
    L14:
        r8 = false;
        goto L15
    }

    public final View n1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.shopping.new_cart.slice.widgets.l(r3, this.H3);
    }
}
