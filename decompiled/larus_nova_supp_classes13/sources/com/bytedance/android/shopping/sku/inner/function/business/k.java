package com.bytedance.android.shopping.sku.inner.function.business;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.kmp.ec.yata.event.common.b {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Object r0 = r5.p(Reflection.getOrCreateKotlinClass(String.class), "event_name");
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        if (((String) r0) == null) goto L20;
        Object r1 = r5.p(Reflection.getOrCreateKotlinClass(String.class), "event_name");
        if ((r1 instanceof String) == true) goto L10;
        r1 = null;
    L10:
        String r2 = (String) r1;
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        Map r6 = r5.q();
        if (r6 == null) goto L18;
        Object r7 = r6.get("params");
        if (r7 == null) goto L18;
        JSONObject r8 = com.bytedance.android.ec.hybrid.list.util.k.b(r7);
    L19:
        ECLiveHybridUtil.f(r2, r8);
    L18:
        r8 = new JSONObject();
    L20:
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
