package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements ECHybridListEngine.c {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public m(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void a(int r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionId");
        if (r3 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        this.a.N.getCouldShowMarquee().setValue(Boolean.FALSE);
        return;
    L11:
        this.a.N.getCouldShowMarquee().setValue(Boolean.TRUE);
        return;
    L5:
        if (Intrinsics.areEqual(r2, "__PRODUCTS_END_SECTION__") == false) goto L7;
        r4 = true;
        goto L8
    }
}
