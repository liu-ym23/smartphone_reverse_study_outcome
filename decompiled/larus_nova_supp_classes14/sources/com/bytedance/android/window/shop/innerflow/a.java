package com.bytedance.android.window.shop.innerflow;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(ECWindowInnerFlowViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        LinkedHashMap r0 = new LinkedHashMap();
        String r2 = null;
        r0.put("product_source_page", ECWindowInnerFlowViewModel.getParam$default(r10, "product_source_page", null, 2, null));
        r0.put("store_source_page", ECWindowInnerFlowViewModel.getParam$default(r10, "store_source_page", null, 2, null));
        r0.put("store_source_method", ECWindowInnerFlowViewModel.getParam$default(r10, "store_source_method", null, 2, null));
        r0.put("store_group_type", ECWindowInnerFlowViewModel.getParam$default(r10, "store_group_type", null, 2, null));
        r0.put("carrier_source", r10.getParam("carrier_source", "store_page"));
        r0.put("store_type", "window");
        r0.put("product_form", "flow");
        r0.put("request_id", ECWindowInnerFlowViewModel.getParam$default(r10, "request_id", null, 2, null));
        r0.put("recommend_info", ECWindowInnerFlowViewModel.getParam$default(r10, "recommend_info", null, 2, null));
        int r5 = r10.getInnerFlowParam().c;
        if (r5 != 5) goto L5;
        r0.put("source_method", "live_top");
        r0.put("tab_name_second", "live_top_101");
    L9:
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r0.put("store_type", "window");
        r0.put("author_id", ECWindowInnerFlowViewModel.getParam$default(r10, "author_id", null, 2, null));
        r0.put("anchor_id", ECWindowInnerFlowViewModel.getParam$default(r10, "author_id", null, 2, null));
        JSONObject r1 = z1.g(ECWindowInnerFlowViewModel.getParam$default(r10, "pass_through_api", null, 2, null));
        if (r1 == null) goto L12;
        r2 = r1.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L12:
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        r0.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r2);
        r0.put("flow_type", String.valueOf(r10.getInnerFlowParam().c));
        return r0;
    L5:
        if (r5 != 6) goto L9;
        r0.put("source_method", "live_top");
        r0.put("tab_name_second", "live_top_102");
        goto L9
    }

    public static Map b(ECWindowInnerFlowViewModel r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r0.put("store_type", "window");
        r0.put("author_id", ECWindowInnerFlowViewModel.getParam$default(r5, "author_id", null, 2, null));
        r0.put("anchor_id", ECWindowInnerFlowViewModel.getParam$default(r5, "author_id", null, 2, null));
        JSONObject r1 = z1.g(ECWindowInnerFlowViewModel.getParam$default(r5, "pass_through_api", null, 2, null));
        if (r1 == null) goto L5;
        String r2 = r1.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r2);
        r0.put("flow_type", String.valueOf(r5.getInnerFlowParam().c));
        r0.put("entrance_info", ECWindowInnerFlowViewModel.getParam$default(r5, "entrance_info", null, 2, null));
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public static Map c(ECWindowInnerFlowViewModel r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "innerFlowViewModel");
        Intrinsics.checkNotNullParameter(r4, "productId");
        Map r5 = b(r2);
        r5.put("product_form", "flow");
        r5.put("product_id", r4);
        r5.put("product_orders", String.valueOf(r3));
        r5.put("bst_group_type", "product");
        return r5;
    }

    public static void d(ECWindowInnerFlowViewModel r2, String r3, Pair... r4) {
        Intrinsics.checkNotNullParameter(r2, "innerFlowViewModel");
        Intrinsics.checkNotNullParameter(r3, "area");
        Intrinsics.checkNotNullParameter(r4, "pairs");
        Map r0 = b(r2);
        r0.put("click_area", r3);
        MapsKt.putAll(r0, r4);
        r2.doEventAction("click_product_flow_other", r0, new Pair[0]);
    }
}
