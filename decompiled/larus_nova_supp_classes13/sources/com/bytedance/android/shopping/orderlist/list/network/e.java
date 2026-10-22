package com.bytedance.android.shopping.orderlist.list.network;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ Throwable b;

    public e(f r1, Throwable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        OrderListRequestViewModel r0 = this.a.a;
        OrderListRequestViewModel.b<com.bytedance.android.shopping.orderlist.list.starter.a> r1 = r0.o;
        String r2 = r0.x;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r3 = new com.bytedance.kmp.ec.yata.common.protocol.data.e(null);
        r3.d(-1);
        r3.e("异常:" + this.b.getMessage());
        Unit r4 = Unit.INSTANCE;
        r1.a.addLast(new com.bytedance.android.shopping.orderlist.list.starter.a(r2, new gg3.c(r3, this.a.b.b, 4), true));
        OrderListRequestViewModel r5 = this.a.a;
        if (r5.c == false) goto L6;
        OrderListRequestViewModel.b<com.bytedance.android.shopping.orderlist.list.starter.a> r6 = r5.o;
        r6.b.invoke(r6.a.removeFirst());
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
