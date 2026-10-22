package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.headercard.HeaderCardViewHolder;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallDrawToolItemToCenter extends qf3.a {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public ECMallDrawToolItemToCenter(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallDrawToolItemToCenter";
    }

    @Override // qf3.a
    public final void e(IBDXBridgeContext r9, qf3.d r10, Map<String, ? extends Object> r11, final IDLXBridgeMethod.a r12) {
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        final LinkedHashMap r13 = new LinkedHashMap();
        Object r14 = r11.get("componentID");
        Object r1 = null;
        if ((r14 instanceof String) == true) goto L5;
        r14 = null;
    L5:
        String r15 = (String) r14;
        if (r15 != null) goto L8;
    L11:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        r13.put("code", 0);
        r13.put("data", MapsKt.mapOf(TuplesKt.to("err_message", "componentID is null or empty.")));
        r12.invoke(r13);
        return;
    L16:
        ECHybridListEngine r16 = r10.b.J;
        if (r16 == null) goto L19;
        BaseViewHolder r17 = r16.e("multi_in_one_section", "multi_in_one_item");
    L21:
        if ((r17 instanceof HeaderCardViewHolder) == false) goto L32;
        HeaderCardViewHolder r18 = (HeaderCardViewHolder) r17;
        r18.getClass();
        Intrinsics.checkNotNullParameter("TOOL_AREA", "name");
        Iterator r19 = ((ArrayList) r18.q).iterator();
    L24:
        if (r19.hasNext() == false) goto L28;
        Object r0 = r19.next();
        if (Intrinsics.areEqual(((ef3.e) r0).getName(), "TOOL_AREA") == false) goto L24;
        r1 = r0;
    L28:
        ef3.c r2 = (ef3.e) r1;
        if ((r2 instanceof ef3.d) == false) goto L31;
        ((ef3.d) r2).b(r15, new ECMallDrawToolItemToCenter$handleCall$1(r13, r12));
        return;
    L31:
        r13.put("code", 1);
        r13.put("data", MapsKt.mapOf(TuplesKt.to("err_message", "can't find native toolAreaComponent")));
        r12.invoke(r13);
        return;
    L32:
        r13.put("code", 1);
        r13.put("data", MapsKt.mapOf(TuplesKt.to("err_message", "can't find native header card")));
        r12.invoke(r13);
        return;
    L19:
        r17 = null;
        goto L21
    L8:
        if (r15.length() == 0) goto L11;
        r3 = false;
        goto L13
    }
}
