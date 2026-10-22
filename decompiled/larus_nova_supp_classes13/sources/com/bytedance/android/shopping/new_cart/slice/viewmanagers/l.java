package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends BaseSlcViewManager<com.bytedance.android.shopping.new_cart.slice.widgets.c> {
    public final SlcTemplateContext H3;

    public l(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.H3 = r2;
    }

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.shopping.new_cart.slice.widgets.c(r3, this.H3);
    }

    public final void H0(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        com.bytedance.android.shopping.new_cart.slice.widgets.c r1 = (com.bytedance.android.shopping.new_cart.slice.widgets.c) getView();
        String r2 = m.a(r10, new String[]{"last_number", "old_number", "pre_number"});
        String r3 = m.a(r10, new String[]{"number", "current_number", "value", "text"});
        Object r0 = r10.get("animate");
        if ((r0 instanceof Boolean) == true) goto L5;
        r0 = null;
    L5:
        Boolean r4 = (Boolean) r0;
        if (r4 == null) goto L8;
        boolean r5 = r4.booleanValue();
    L9:
        r1.a(r2, r3, r5, m.a(r10, new String[]{"text_color", "color"}), Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r10.get("font_size"), 14.0f)), CartViewExtentionsKt.a(r10.get("font_weight")), m.a(r10, new String[]{"text_align", "align"}));
        return;
    L8:
        r5 = true;
        goto L9
    }
}
