package com.bytedance.android.shopping.store.home.slice;

import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final Map<String, ShopSliceItemConfig> a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getItemConfigMap");
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, ECStoreHeaderInfoSliceConfig> r4 = r3.a;
        if (r4 == null) goto L10;
        Iterator<Map.Entry<String, ECStoreHeaderInfoSliceConfig>> r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<String, ECStoreHeaderInfoSliceConfig> r1 = r5.next();
        ShopSliceItemConfig r2 = r1.getValue().getSliceItemConfig();
        if (r2 == null) goto L6;
        r0.put(r1.getKey(), r2);
    L10:
        return r0;
    }
}
