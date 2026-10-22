package com.bytedance.android.shopping.orderlist.list.network;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ OrderListRequestViewModel$doChunkRequest$2$1 a;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.common.protocol.data.e b;
    public final /* synthetic */ boolean c;

    public c(OrderListRequestViewModel$doChunkRequest$2$1 r1, com.bytedance.kmp.ec.yata.common.protocol.data.e r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        d r0 = this.a.a;
        OrderListRequestViewModel r1 = r0.a;
        OrderListRequestViewModel.b<com.bytedance.android.shopping.orderlist.list.starter.a> r2 = r1.o;
        com.bytedance.android.shopping.orderlist.list.starter.a r3 = new com.bytedance.android.shopping.orderlist.list.starter.a(r1.x, new gg3.c(this.b, r0.d.b, this.c), true);
        r2.a.addLast(r3);
        OrderListRequestViewModel r4 = this.a.a.a;
        if (r4.c == false) goto L6;
        OrderListRequestViewModel.b<com.bytedance.android.shopping.orderlist.list.starter.a> r5 = r4.o;
        r5.b.invoke(r5.a.removeFirst());
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
