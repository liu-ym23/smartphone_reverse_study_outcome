package com.bytedance.android.shopping.new_cart.eventcenter.event;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CartObjectContainer a;

    public n(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        Map r0 = r8.q();
        if (r0 == null) goto L5;
        Object r1 = r0.get("schema");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (com.bytedance.android.shopping.extensions.k.c(r2) == false) goto L29;
        String r9 = com.bytedance.android.ec.hybrid.list.util.k.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("session_id", this.a.e.m), TuplesKt.to("node_id", r8.d.c)}));
        int r3 = this.a.g.k4();
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("session_params", r9);
        int r10 = com.bytedance.android.shopping.new_cart.utils.c.a;
        CartParams r11 = this.a.e.c;
        if (r11 == null) goto L14;
        String r12 = r11.getSplitActivityScene();
    L16:
        if (com.bytedance.android.shopping.new_cart.utils.c.a(r12) == false) goto L18;
        r4.put("ec_split_screen_width", String.valueOf(r3));
    L18:
        if (r2 == null) goto L27;
        int r13 = com.bytedance.android.shopping.new_cart.eventcenter.event.invalidrecommend.c.a;
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r4, "map");
        Intrinsics.checkNotNullParameter(r2, "$this$toUri");
        Uri r14 = UriProtector.parse(r2);
        String r5 = UriProtector.getQueryParameter(r14, "url");
        Iterator r6 = r4.entrySet().iterator();
    L21:
        if (r6.hasNext() == false) goto L26;
        Map.Entry r7 = (Map.Entry) r6.next();
        String r15 = (String) r7.getKey();
        String r16 = (String) r7.getValue();
        if (r5 != null) goto L24;
        r5 = null;
        goto L21
    L24:
        r5 = UriProtector.parse(r5).buildUpon().appendQueryParameter(r15, r16).build().toString();
        goto L21
    L26:
        Uri.Builder r17 = j1.d(r14, "url").buildUpon();
        r17.appendQueryParameter("url", r5);
        Uri r18 = r17.build();
    L28:
        int r19 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("final_schema", String.valueOf(r18))), null, 5);
    L27:
        r18 = null;
        goto L28
    L14:
        r12 = null;
        goto L16
    L29:
        int r20 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is null", null, null, 57);
    L5:
        r1 = null;
        goto L7
    }
}
