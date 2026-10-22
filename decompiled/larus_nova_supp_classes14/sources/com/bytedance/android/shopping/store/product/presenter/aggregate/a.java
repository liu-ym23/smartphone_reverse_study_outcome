package com.bytedance.android.shopping.store.product.presenter.aggregate;

import android.content.Context;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final JSONObject c(ShopAggregatePageProductViewModel r3) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        String r1 = null;
        if (r3.isStoreParamInit() == true) goto L6;
        r3 = null;
    L6:
        if (r3 == null) goto L8;
        ShopAggregateParam r4 = r3.getStoreParam();
    L9:
        com.bytedance.commerce.base.json.a[] r0 = new com.bytedance.commerce.base.json.a[1];
        if (r4 == null) goto L12;
        String r5 = (String) r4.getPassThroughParam("pass_through_api");
    L13:
        JSONObject r6 = k.w(r5);
        if (r6 == null) goto L16;
        r1 = r6.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L16:
        if (r1 != null) goto L18;
        r1 = "";
    L18:
        r0[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r1);
        return JsonDslUtilKt.a(r0);
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public static final String a(JSONObject r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "entranceInfo");
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        Intrinsics.checkNotNullParameter(r3, "carrierSource");
        r1.put("promotion_id", r2);
        r1.put("carrier_source", r3);
        return r1.toString();
    }

    public static final Map<String, String> b(ShopAggregatePageProductViewModel r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "entranceForm");
        Intrinsics.checkNotNullParameter(r5, "tabLabel");
        String r1 = null;
        if (r3.isStoreParamInit() == true) goto L6;
        r3 = null;
    L6:
        if (r3 == null) goto L8;
        ShopAggregateParam r6 = r3.getStoreParam();
    L9:
        Pair[] r0 = new Pair[8];
        r0[0] = TuplesKt.to("ecom_entrance_form", r4);
        r0[1] = TuplesKt.to("tab_label", r5);
        if (r6 == null) goto L12;
        String r7 = r6.getTempId();
    L13:
        r0[2] = TuplesKt.to("temp_id", r7);
        if (r6 == null) goto L18;
        ProductBasicRequestParam r8 = r6.getProductBasicRequestParam();
        if (r8 == null) goto L18;
        String r9 = r8.getMaterialId();
    L19:
        r0[3] = TuplesKt.to("customer_id", r9);
        r0[4] = TuplesKt.to("page_type", "product_list");
        if (r6 == null) goto L22;
        r1 = r6.getSearchParams();
    L22:
        r0[5] = TuplesKt.to("search_params", r1);
        r0[6] = TuplesKt.to("content_source", "shop");
        r0[7] = TuplesKt.to("bst_group_type", "product");
        Map<String, String> r10 = MapsKt.mutableMapOf(r0);
        if (r6 != null) goto L25;
    L27:
        return r10;
    L25:
        if (r6.isEcShare() != true) goto L27;
        r10.put("share_content", r6.getShareContent());
        r10.put("share_object", r6.getShareObject());
    L18:
        r9 = null;
        goto L19
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    public static final boolean d(Context r10, String r11, String r12, String r13, JSONObject r14, Map<String, Object> r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "followStatus");
        Intrinsics.checkNotNullParameter(r14, "entranceInfo");
        Intrinsics.checkNotNullParameter(r15, "adExtraData");
        Intrinsics.checkNotNullParameter(r16, "productId");
        String r6 = com.bytedance.android.ec.store.utils.b.a(r11, r12);
        if (r6 != null) goto L6;
        return false;
    L6:
        hm.b r1 = hm.b.c;
        r15.put("product_id", r16);
        Unit r0 = Unit.INSTANCE;
        com.bytedance.android.ec.store.common.starter.e.b(r1, r10, r6, r13, r14, r15, null, false, 448);
        return true;
    }
}
