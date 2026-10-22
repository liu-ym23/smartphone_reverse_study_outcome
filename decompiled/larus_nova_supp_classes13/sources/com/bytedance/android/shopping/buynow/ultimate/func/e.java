package com.bytedance.android.shopping.buynow.ultimate.func;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowFragment a;
    public final AndroidYaTaInstance b;
    public final LinearLayout c;

    public static final class a {
    }

    static {
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r10, "chainNextCallback");
        Map r11 = r9.q();
        if (r11 == null) goto L6;
        Map r12 = MapsKt.toMutableMap(r11);
        if (r12 == null) goto L6;
    L7:
        String r0 = String.valueOf(r12.get("slice_key"));
        List r1 = this.b.n("footer");
        if (r1 == null) goto L23;
        Iterator r2 = r1.iterator();
        int r5 = 0;
    L11:
        if (r2.hasNext() == false) goto L23;
        com.bytedance.kmp.ec.yata.store.node.e r6 = ((com.bytedance.kmp.ec.yata.store.node.c) r2.next()).b;
        if (r6 == null) goto L19;
        String r7 = r6.a;
        if (r7 == null) goto L19;
        if (StringsKt.contains$default(r7, r0, false, 2, null) != true) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L24;
        r5 = r5 + 1;
    L24:
        if (r5 >= 0) goto L27;
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "targetIndex<0", null, null, 57));
        return;
    L27:
        String r3 = String.valueOf(r12.get("event_name"));
        Object r14 = r12.get("params");
        if ((r14 instanceof Map) == true) goto L30;
        r14 = null;
    L30:
        Map r15 = (Map) r14;
        if (r15 == null) goto L34;
        Map<String, ? extends Object> r16 = MapsKt.toMutableMap(r15);
        if (r16 == null) goto L34;
    L35:
        View r17 = (View) CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(this.c), r5);
        if (r17 != null) goto L40;
        int r18 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "targetView is null", null, null, 57));
        return;
    L40:
        if (this.a.r == null) goto L42;
        View r4 = SlcRenderContext.f(r17, r0);
    L44:
        if ((r4 instanceof com.bytedance.android.ecom.arch.slice.render.elements.text.b) == true) goto L46;
        r4 = null;
    L46:
        com.bytedance.android.ecom.arch.slice.render.elements.text.b r19 = (com.bytedance.android.ecom.arch.slice.render.elements.text.b) r4;
        if (r19 == null) goto L49;
        Integer r20 = Integer.valueOf(r19.n());
    L51:
        if (com.bytedance.android.shopping.extensions.k.f(r20) <= 1) goto L53;
        r16.put("is_new_line", 1);
    L53:
        com.bytedance.android.shopping.buynow.tracker.a r21 = this.a.W90().getTracker();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r16, "params");
        r21.b(r3, r16);
        int r22 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L49:
        r20 = null;
        goto L51
    L42:
        r4 = null;
    L34:
        r16 = new LinkedHashMap();
    L19:
        r8 = false;
    L23:
        r5 = -1;
    L6:
        r12 = new LinkedHashMap();
        goto L7
    }

    public e(BuyNowFragment r2, AndroidYaTaInstance r3, LinearLayout r4) {
        Intrinsics.checkNotNullParameter(r2, "buyNowFragment");
        Intrinsics.checkNotNullParameter(r3, "yataInstance");
        Intrinsics.checkNotNullParameter(r4, "footerContainer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
