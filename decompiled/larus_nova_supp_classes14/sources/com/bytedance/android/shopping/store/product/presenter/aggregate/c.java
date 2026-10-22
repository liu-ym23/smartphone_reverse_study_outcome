package com.bytedance.android.shopping.store.product.presenter.aggregate;

import com.bytedance.android.ec.store.product.presenter.utils.ECProductCardFunctionUtils;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final void a(StoreV2ProductItemVO r2, QContext r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "qContext");
        Pair[] r0 = new Pair[3];
        if (r4 != null) goto L5;
        r4 = "store_page";
    L5:
        r0[0] = TuplesKt.to("enter_from_merge", r4);
        if (r5 != null) goto L8;
        r5 = "mini_window";
    L8:
        r0[1] = TuplesKt.to("enter_method", r5);
        r0[2] = TuplesKt.to("data_type", "commerce_data");
        ECProductCardFunctionUtils.b(r2, r3, MapsKt.hashMapOf(r0));
    }
}
