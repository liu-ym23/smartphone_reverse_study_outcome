package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w {
    public static final Map<String, String> a(ECShopHybridProductViewModel r6) {
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Pair[] r0 = new Pair[10];
        r0[0] = TuplesKt.to("store_type", "shop");
        r0[1] = TuplesKt.to("author_id", r6.getStoreParam().getStoreAccountParam().getUserId());
        r0[2] = TuplesKt.to("shop_id", r6.getStoreParam().getShopId());
        r0[3] = TuplesKt.to("follow_status", String.valueOf(r6.getStoreParam().getFollowStatus()));
        r0[4] = TuplesKt.to("entrance_location", r6.getStoreParam().getEntranceLocation());
        r0[5] = TuplesKt.to("store_source_page", r6.getStoreParam().getStoreSourcePage());
        r0[6] = TuplesKt.to("store_source_method", r6.getStoreParam().getStoreSourceMethod());
        r0[7] = TuplesKt.to("store_group_type", r6.getStoreParam().getStoreGroupType());
        LayoutTypes r7 = (LayoutTypes) r6.getLayoutType().getValue();
        if (r7 == null) goto L9;
        int r8 = v.a[r7.ordinal()];
        if (r8 == 1) goto L12;
        if (r8 == 2) goto L11;
        if (r8 != 3) goto L9;
        String r9 = "clothes_preview";
    L13:
        r0[8] = TuplesKt.to("switch_type", r9);
        r0[9] = TuplesKt.to("tab_name", "products");
        return MapsKt.mapOf(r0);
    L11:
        r9 = "double_product";
        goto L13
    L12:
        r9 = "single_product";
    L9:
        r9 = null;
        goto L13
    }
}
