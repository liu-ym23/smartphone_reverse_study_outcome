package com.bytedance.android.shopping.orderlist.list.tab;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListTabParamsCache {
    public static final OrderListTabParamsCache a = null;

    public OrderListTabParamsCache() {
    }

    static {
        a = new OrderListTabParamsCache();
    }

    public static String a() {
        String r0 = r.a.getCurrentUserId();
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return "order_list_cache_tab_params_".concat(r0);
    }

    public static void b(Context r5, final a r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = a();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r6 == null) goto L19;
        String r2 = r6.c;
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L17:
        if ((!r3) == false) goto L19;
    L20:
        if (r6 != null) goto L23;
        r5.getSharedPreferences("js_kv_methods_20191113", 0).edit().remove(r0).apply();
        return;
    L23:
        JSONObject r1 = new JSONObject();
        r1.put("time", System.currentTimeMillis());
        r1.put("tab_mode", r6.c);
        r1.put("tab_id", r6.b);
        Integer r4 = r6.a;
        if (r4 == null) goto L26;
        r1.put("biz_tab_id", r4.intValue());
    L26:
        String r7 = r1.toString();
        Lazy r8 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListTabParamsCache", new OrderListTabParamsCache$save$1(r6));
        ka3.b.b(r5, r0, r7);
        return;
    L12:
        if (StringsKt.isBlank(r2) == true) goto L15;
        r3 = false;
    L19:
        r6 = null;
        goto L20
    }
}
