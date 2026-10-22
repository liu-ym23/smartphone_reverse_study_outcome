package com.bytedance.android.shopping.store.hybridproduct.module;

import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public static final x a(ECShopHybridProductViewModel r1, StoreV2ProductItemVO r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r2, "itemVO");
        if (r3 == true) goto L6;
        dm.a.a("prefetchShopHybridInsertion").i("prefetchShopHybridInsertion disable");
        return null;
    L6:
        x r4 = new x(r1);
        String r5 = r2.a;
        Intrinsics.checkNotNullParameter(r5, "currentProductId");
        r4.a.prefetchInsertData(r5);
        return r4;
    }
}
