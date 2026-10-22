package com.bytedance.android.shopping.cart_common.repo;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartCommonRepository {
    public static final Keva a = null;
    public static final Keva b = null;

    static {
        a = Keva.getRepo("ecom_cart_search_storage", 1);
        b = Keva.getRepo("ecom_cart_common_storage", 1);
    }

    public static List a(final String r4) {
        String[] r0 = a.getStringArray("search_history", new String[0]);
        if (r0 == null) goto L6;
        List r1 = ArraysKt.toMutableList(r0);
        if (r1 == null) goto L6;
    L7:
        CollectionsKt.removeAll(r1, new CartCommonRepository$storgeSearchHistoryKey$$inlined$let$lambda$1(r4));
        ListProtector.add(r1, 0, r4);
        if (r1.size() <= 10) goto L11;
        CollectionsKt.removeLastOrNull(r1);
    L11:
        return CollectionsKt.toList(r1);
    L6:
        r1 = new ArrayList();
        goto L7
    }
}
