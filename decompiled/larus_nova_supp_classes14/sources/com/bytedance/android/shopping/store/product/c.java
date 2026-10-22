package com.bytedance.android.shopping.store.product;

import com.bytedance.android.ec.store.repository.vo.h;
import com.bytedance.android.shopping.store.restore.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements com.bytedance.android.shopping.store.restore.b {
    public final int a;
    public final /* synthetic */ ECStoreProductTabFragment b;

    @Override // com.bytedance.android.shopping.store.restore.b
    public final g a() {
        h r0 = this.b.V90().getMiddleCouponFilterVO();
        com.bytedance.android.ec.store.repository.vo.g r1 = this.b.V90().getCachedCouponPanelInfo();
        Map<String, h> r2 = this.b.V90().getCachedCouponMapData();
        if (r0 != null) goto L9;
        if (r1 != null) goto L9;
        if (r2 != null) goto L9;
        return null;
    L9:
        return new g(r0, r1, r2);
    }

    @Override // com.bytedance.android.shopping.store.restore.b
    public final int getTabType() {
        return this.a;
    }

    public final void b(g r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        this.b.V90().setMiddleCouponFilterVO(r3.a);
        this.b.V90().setCachedCouponPanelInfo(r3.b);
        this.b.V90().setCachedCouponMapData(r3.c);
        h r4 = this.b.V90().getMiddleCouponFilterVO();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.i() != null) goto L8;
        r4.q(this.b.V90().getCachedCouponPanelInfo());
    L8:
        if (r4.g() != null) goto L12;
        r4.o(this.b.V90().getCachedCouponMapData());
        return;
    }

    public c(ECStoreProductTabFragment r1, Integer r2) {
        this.b = r1;
        this.a = r2.intValue();
    }
}
