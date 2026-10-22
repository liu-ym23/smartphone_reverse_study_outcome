package com.bytedance.android.shopping.store.shopfeed;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(IAction r3, View r4, r r5) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "targetView");
        Map r6 = r3.getParams();
        Object r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.get(":updated_states") == null) goto L23;
        BaseSlcViewManager r7 = SlcViewExtensionsKt.g(r4);
        if (r7 == null) goto L9;
        Map r8 = r7.l();
    L10:
        if (r5 == null) goto L16;
        SlcTemplateContext r9 = r5.b;
        if (r9 == null) goto L16;
        SlcRenderContext r10 = r9.w;
        if (r10 == null) goto L16;
        SlcExprContext r11 = r10.m0;
    L17:
        if (r11 == null) goto L22;
        String r12 = String.valueOf(r6.get(":updated_states"));
        if (r8 != null) goto L21;
        r8 = new HashMap();
    L21:
        int r1 = SlcExprContext.g;
        r0 = r11.a(r12, r8, null);
    L22:
        Map r13 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r0);
    L25:
        return r13;
    L16:
        r11 = null;
        goto L17
    L9:
        r8 = null;
        goto L10
    L23:
        r13 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r6.get("updated_states"));
        goto L25
    }
}
