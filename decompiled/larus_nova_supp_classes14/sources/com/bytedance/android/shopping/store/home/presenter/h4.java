package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.home.entity.ShopValueInfoItem;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h4 {
    public static final Pair<String, String>[] a(ECStoreViewModel r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "shopInfoPosition");
        Pair<String, String>[] r0 = new Pair[8];
        r0[0] = TuplesKt.to("position", r3);
        r0[1] = TuplesKt.to("shop_id", r2.getStoreParam().getShopId());
        r0[2] = TuplesKt.to("author_id", r2.getStoreParam().getStoreAccountParam().getUserId());
        r0[3] = TuplesKt.to("store_source_method", r2.getStoreParam().getStoreSourceMethod());
        r0[4] = TuplesKt.to("store_group_type", r2.getStoreParam().getStoreGroupType());
        r0[5] = TuplesKt.to("store_source_page", r2.getStoreParam().getStoreSourcePage());
        r0[6] = TuplesKt.to("follow_status", String.valueOf(r2.getStoreParam().getFollowStatus()));
        com.bytedance.android.shopping.store.home.entity.n r4 = (com.bytedance.android.shopping.store.home.entity.n) r2.getHeaderArea().getValue();
        if (r4 == null) goto L11;
        com.bytedance.android.shopping.store.home.entity.e r5 = r4.b;
        if (r5 == null) goto L11;
        Map<String, ShopValueInfoItem> r6 = r5.f;
        if (r6 == null) goto L11;
        ShopValueInfoItem r7 = r6.get("fans");
        if (r7 == null) goto L11;
        String r8 = Intrinsics.stringPlus(r7.getNumberText(), r7.getSuffix());
    L12:
        r0[7] = TuplesKt.to("fans_text", r8);
        return r0;
    L11:
        r8 = null;
        goto L12
    }
}
