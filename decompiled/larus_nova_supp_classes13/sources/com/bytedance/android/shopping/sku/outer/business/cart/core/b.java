package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(JSONObject r5, String r6, boolean r7) {
        if (r5 != null) goto L5;
        JSONObject r8 = new JSONObject();
        r8.put("sku_session_id", r6);
        JSONObject r9 = new JSONObject();
        r9.put("status_code", 2);
        Unit r10 = Unit.INSTANCE;
        r8.put("response", r9);
        ECLiveHybridUtil.f("ecom.sku.add.cart", r8);
        return;
    L5:
        r5.put("status_msg", r5.optString("msg"));
        JSONObject r3 = new JSONObject();
        r3.put("sku_session_id", r6);
        r3.put("response", r5);
        r3.put("success", r7);
        Unit r11 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r3);
    }

    public static void a(JSONObject r6, Integer r7, String r8, String r9) {
        if (r6 != null) goto L5;
        JSONObject r10 = new JSONObject();
        r10.put("status_code", 2);
        r10.put("scene_type", r7);
        r10.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r9);
        r10.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r8);
        Unit r11 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r10);
        return;
    L5:
        String r4 = r6.optString("msg");
        r6.put("scene_type", r7);
        r6.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r9);
        r6.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r8);
        r6.put("status_msg", r4);
        Unit r12 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.add.cart", r6);
    }

    public static void c(String r2, String r3, String r4, Integer r5, Map r6) {
        Intrinsics.checkNotNullParameter(r3, "btmShowId");
        JSONObject r0 = new JSONObject();
        r0.put("btm_show_id", r3);     // Catch: Throwable -> L16
        r0.put("cart_id", r4);     // Catch: Throwable -> L16
        r0.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r2);     // Catch: Throwable -> L16
        r0.put("scene_type", r5);     // Catch: Throwable -> L16
        Iterator r7 = ((LinkedHashMap) r6).entrySet().iterator();     // Catch: Throwable -> L16
    L4:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r8 = (Map.Entry) r7.next();     // Catch: Throwable -> L16
        if (r8.getValue() == null) goto L4;
        String r9 = (String) r8.getKey();     // Catch: Throwable -> L16
        Object r10 = r8.getValue();     // Catch: Throwable -> L16
        if (r10 == null) goto L11;
        String r11 = r10.toString();     // Catch: Throwable -> L16
    L12:
        r0.put(r9, r11);     // Catch: Throwable -> L16
        goto L4
    L11:
        r11 = null;
    L14:
        com.bytedance.android.ec.sdk.helper.g.a.logV3("add_cart_success", r0);
    }
}
