package com.bytedance.android.shopping.new_cart.eventcenter.event;

import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CartViewModel a;
    public final AndroidYaTaInstance b;

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        com.bytedance.kmp.ec.yata.store.node.c r8 = r7.j();
        if (r8 == null) goto L5;
        String r9 = r8.getKey();
    L6:
        com.bytedance.android.shopping.new_cart.yata.customdata.a r1 = this.a.getCustomDataCenter();
        if (r9 == null) goto L15;
        if (r1 == null) goto L15;
        Boolean r2 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r9, "nodeKey");
        Intrinsics.checkNotNullParameter("counter_active", "name");
        Intrinsics.checkNotNullParameter(r2, "value");
        if (((LinkedHashMap) r1.b).get(r9) != null) goto L12;
        r1.b.put(r9, new HashMap());
    L12:
        Map r10 = (Map) ((LinkedHashMap) r1.b).get(r9);
        if (r10 == null) goto L15;
        r10.put("counter_active", r2);
    L15:
        bg3.a r11 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(this.a, "CartChangeCounterActive", new a(this), null);
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        r9 = null;
        goto L6
    }

    public b(CartViewModel r2, AndroidYaTaInstance r3) {
        Intrinsics.checkNotNullParameter(r2, "cartViewModel");
        Intrinsics.checkNotNullParameter(r3, "instance");
        this.a = r2;
        this.b = r3;
    }
}
