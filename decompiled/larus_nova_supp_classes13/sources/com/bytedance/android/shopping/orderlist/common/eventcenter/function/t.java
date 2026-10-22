package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t extends com.bytedance.kmp.ec.yata.event.common.b {
    public static final /* synthetic */ int c = 0;
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;
    public final AndroidYaTaInstance b;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r0.element = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        OrderCommonErrorMonitorKt.d(this.a.E0(), "OrderCommonSelfUIActionFunction-doExecuteSync", new OrderCommonSelfUIActionFunction$onExecuteSync$1(this, r5, r0), new OrderCommonSelfUIActionFunction$onExecuteSync$2(r0));
        return (com.bytedance.kmp.ec.yata.chain.event.b) r0.element;
    }

    public t(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2, AndroidYaTaInstance r3) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
        this.b = r3;
    }

    public final k0 e(String r5, View r6, String r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        View r1 = r6;
    L6:
        if (r1 == null) goto L14;
        if ((r1 instanceof SlcTemplateView) == true) goto L9;
        Object r2 = r1.getParent();
        if ((r2 instanceof View) == true) goto L13;
        r2 = null;
    L13:
        r1 = (View) r2;
        goto L6
    L9:
        View r3 = (SlcTemplateView) r1;
    L15:
        if (r3 == null) goto L17;
        r6 = r3;
    L17:
        if (r3 == null) goto L19;
        SlcTemplateContext r4 = r3.getTemplateContext();
    L20:
        SlcRenderContext r8 = this.a.f();
        if (r4 != null) goto L23;
    L26:
        if (r8 == null) goto L28;
        View r9 = SlcRenderContext.f(r6, r7);
    L29:
        if (r9 != null) goto L31;
        return null;
    L31:
        if (r4 != null) goto L36;
        BaseSlcViewManager r10 = SlcViewExtensionsKt.g(r9);
        if (r10 == null) goto L35;
        r4 = r10.a;
        goto L36
    L35:
        r4 = null;
    L36:
        if (r4 != null) goto L39;
        return null;
    L39:
        return new k0(r5, r4);
    L28:
        r9 = null;
        goto L29
    L23:
        if (r4.w == null) goto L26;
        r9 = SlcRenderContext.f(r6, r7);
        if (r9 != null) goto L29;
    L19:
        r4 = null;
        goto L20
    L14:
        r3 = null;
        goto L15
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b d(String r8, String r9, String r10, Map<String, ? extends Object> r11, String r12, Map<String, ? extends Object> r13) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r8);
        r0.append(" slice_key:");
        String r14 = "";
        if (r9 != null) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        r0.append(" action_type:");
        if (r10 == null) goto L10;
        r14 = r10;
    L10:
        r0.append(r14);
        r0.append(" action_fields:");
        r0.append(r11);
        r0.append(" render_node_key:");
        r0.append(r12);
        String r3 = r0.toString();
        OrderCommonErrorMonitorKt.a(this.a.E0(), "SELF_FUN_ERROR", "OrderCommonSelfUIActionFunction " + r3, MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("slice_key", r9), TuplesKt.to("type", r10), TuplesKt.to("fields", r11), TuplesKt.to("render_node_key", r12)}), r13));
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r3, null, null, 57);
    L5:
        r1 = r9;
        goto L6
    }
}
