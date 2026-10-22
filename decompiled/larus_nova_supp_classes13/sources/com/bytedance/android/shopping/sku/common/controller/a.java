package com.bytedance.android.shopping.sku.common.controller;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.extensions.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final boolean a;
    public final Map<String, Pair<String, Map<String, Object>>> b;
    public final HashSet<String> c;
    public Long d;
    public Long e;
    public final List<String> f;

    public a() {
        ECSettingKeys.j.getClass();
        this.a = ECSettingKeys.o();
        this.b = new LinkedHashMap();
        this.c = new HashSet();
        this.f = CollectionsKt.listOf(new String[]{"wallet_cashier_bytepay_imp", "wallet_cashier_fxh_imp", "wallet_cashier_superpay_imp", "wallet_cashier_wx_imp", "wallet_cashier_alipay_imp", "page_view", "valid_page_view", "ec_payment_freight_insurance_button_show"});
    }

    public final void b(BuyNowViewModel r5) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Iterator r0 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        r5.getTracker().b((String) ((Pair) r1.getValue()).getFirst(), MapsKt.toMutableMap((Map) ((Pair) r1.getValue()).getSecond()));
        goto L4
    L6:
        ((LinkedHashMap) this.b).clear();
        this.c.clear();
    }

    public final boolean a(Map<String, ? extends Object> r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        if (this.a == true) goto L6;
        return false;
    L6:
        Boolean r0 = null;
        if (r3 == null) goto L9;
        Object r5 = r3.get("async_delay_list");
    L10:
        List r6 = com.bytedance.android.ecom.arch.slice.render.util.b.s(r5);
        if (r6 == null) goto L14;
        r0 = Boolean.valueOf(((ArrayList) r6).contains(r4));
    L14:
        return k.i(r0);
    L9:
        r5 = null;
        goto L10
    }

    public final void c(BuyNowViewModel r3, String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "buyNowViewModel");
        Intrinsics.checkNotNullParameter(r4, "cacheKey");
        Intrinsics.checkNotNullParameter(r5, "params");
        Pair r0 = (Pair) ((LinkedHashMap) this.b).get(r4);
        if (r0 == null) goto L6;
        Map<String, ? extends Object> r1 = MapsKt.toMutableMap((Map) r0.getSecond());
        r1.putAll(r5);
        r3.getTracker().b((String) r0.getFirst(), r1);
        Pair<String, Map<String, Object>> r6 = this.b.remove(r4);
        return;
    }
}
