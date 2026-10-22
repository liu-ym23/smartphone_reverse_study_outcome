package com.bytedance.android.shopping.store.settings;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final Map<String, Object> a(ECShopABSettings r3, ECStoreParam r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$filterExperiment");
        Intrinsics.checkNotNullParameter(r4, "params");
        Map<String, Object> r5 = r3.b();
        if (r4.isCroppedStyle() == false) goto L17;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r7 = ((ConcurrentHashMap) r5).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r0 = (Map.Entry) r7.next();
        if ((!Intrinsics.areEqual((String) r0.getKey(), "ec_shop_live_tab")) == false) goto L6;
        r6.put(r0.getKey(), r0.getValue());
        goto L6
    L11:
        return TypeIntrinsics.asMutableMap(r6);
    L17:
        return r5;
    }
}
