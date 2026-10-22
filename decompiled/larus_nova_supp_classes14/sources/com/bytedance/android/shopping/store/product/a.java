package com.bytedance.android.shopping.store.product;

import com.bytedance.android.shopping.store.restore.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements com.bytedance.android.shopping.store.restore.c {
    public final int a;
    public final /* synthetic */ ECStoreProductTabFragment b;

    @Override // com.bytedance.android.shopping.store.restore.c
    public final i a() {
        return this.b.V90().exportRequestState();
    }

    @Override // com.bytedance.android.shopping.store.restore.c
    public final int getTabType() {
        return this.a;
    }

    public final void b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.b.V90().importRequestState(r2);
    }

    public a(ECStoreProductTabFragment r1, Integer r2) {
        this.b = r1;
        this.a = r2.intValue();
    }
}
