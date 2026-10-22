package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public m(qf3.d r3) {
        Intrinsics.checkNotNullParameter(r3, "mallJsbContext");
        Intrinsics.checkNotNullParameter("ec.mallUpdateFilters", "name");
        super(r3);
        this.d = "ec.mallUpdateFilters";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r7, IBDXBridgeContext r8, Map<String, ? extends Object> r9, Map<String, Object> r10) {
        Intrinsics.checkNotNullParameter(r7, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "result");
        Object r11 = r9.get("type");
        if (r11 == null) goto L5;
        Object r0 = r9.get("filters");
        if ((r0 instanceof List) == true) goto L9;
        r0 = null;
    L9:
        List r1 = (List) r0;
        Object r12 = r9.get("tab_id");
        if ((r12 instanceof Integer) == true) goto L12;
        r12 = null;
    L12:
        Integer r13 = (Integer) r12;
        if (r13 == null) goto L15;
        String r14 = String.valueOf(r13.intValue());
    L16:
        ECMallFavoriteSectionHelper r15 = r7.b.V;
        if (Intrinsics.areEqual(r11, 1) == false) goto L31;
        if (r1 == null) goto L64;
        Iterator r16 = r1.iterator();
    L21:
        if (r16.hasNext() == false) goto L64;
        Object r17 = r16.next();
        if ((r17 instanceof String) == true) goto L25;
        r17 = null;
    L25:
        String r18 = (String) r17;
        if (r18 == null) goto L21;
        r15.c(r18);
        if (r14 == null) goto L21;
        r15.d(r14, r14);
    L64:
        return TuplesKt.to(Boolean.TRUE, null);
    L31:
        if (Intrinsics.areEqual(r11, 2) == false) goto L54;
        if (r1 == null) goto L64;
        Iterator r19 = r1.iterator();
    L35:
        if (r19.hasNext() == false) goto L64;
        Object r2 = r19.next();
        if ((r2 instanceof String) == true) goto L39;
        r2 = null;
    L39:
        String r3 = (String) r2;
        if (r3 == null) goto L35;
        if (r3.length() <= 0) goto L44;
        boolean r4 = true;
    L45:
        if (r4 == false) goto L35;
        r15.z(r3);
        if (r14 == null) goto L35;
        Intrinsics.checkNotNullParameter(r14, "tabId");
        Intrinsics.checkNotNullParameter("filters", "key");
        Intrinsics.checkNotNullParameter(r14, "filter");
        Map r5 = (Map) ((LinkedHashMap) r15.d).get(r14);
        if (r5 == null) goto L35;
        com.bytedance.android.shopping.mall.homepage.tools.s r6 = (com.bytedance.android.shopping.mall.homepage.tools.s) r5.get("filters");
        if (r6 == null) goto L35;
        r6.remove(r14);
        goto L35
    L44:
        r4 = false;
        goto L45
    L54:
        if (Intrinsics.areEqual(r11, 3) == false) goto L61;
        r15.getClass();
        Intrinsics.checkNotNullParameter("filters", "key");
        r15.a.remove("filters");
        r15.b.remove("filters");
        if (r14 == null) goto L64;
        Intrinsics.checkNotNullParameter(r14, "tabId");
        Intrinsics.checkNotNullParameter("filters", "key");
        Map r20 = (Map) ((LinkedHashMap) r15.d).get(r14);
        if (r20 == null) goto L64;
        com.bytedance.android.shopping.mall.homepage.tools.s r21 = (com.bytedance.android.shopping.mall.homepage.tools.s) r20.remove("filters");
        goto L64
    L61:
        if (Intrinsics.areEqual(r11, 4) == false) goto L64;
        ((LinkedHashMap) r15.a).clear();
        ((LinkedHashMap) r15.b).clear();
        ((LinkedHashMap) r15.d).clear();
        ((LinkedHashMap) r15.e).clear();
        goto L64
    L15:
        r14 = null;
        goto L16
    L5:
        return TuplesKt.to(Boolean.FALSE, "type is need");
    }
}
