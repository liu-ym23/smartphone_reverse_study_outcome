package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.common.floatelement.StoreCartEntryConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2.c a;
    public final /* synthetic */ StoreCartEntryConfig b;

    public z(ECShopFloatCartEntryPresenterV2.c r1, StoreCartEntryConfig r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ((z3) this.a.a.g.getValue()).onClick();
        int r5 = com.bytedance.android.ec.store.utils.b.a;
        StoreCartEntryConfig r6 = this.b;
        Intrinsics.checkNotNull(r6);
        String r7 = com.bytedance.android.ec.store.utils.b.b(r6.getJumpUrl(), "a1.b6269.c2429.d72866", PageFinder.via(this.a.a.y()), null);
        if (r7 != null) goto L5;
        return;
    L5:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.a.u().c(), r7);
    }
}
