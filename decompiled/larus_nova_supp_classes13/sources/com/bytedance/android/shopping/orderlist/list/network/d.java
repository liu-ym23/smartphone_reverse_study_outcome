package com.bytedance.android.shopping.orderlist.list.network;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ OrderListRequestViewModel a;
    public final /* synthetic */ long b;
    public final /* synthetic */ com.bytedance.android.shopping.orderlist.list.tab.a c;
    public final /* synthetic */ b d;

    public d(OrderListRequestViewModel r1, long r2, com.bytedance.android.shopping.orderlist.list.tab.a r4, b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r2) {
        com.bytedance.android.chunkstreamprediction.network.b r3 = (com.bytedance.android.chunkstreamprediction.network.b) r2;
        if (r3 == null) goto L6;
        r3.a(new OrderListRequestViewModel$doChunkRequest$2$1(this));
        return;
    }
}
