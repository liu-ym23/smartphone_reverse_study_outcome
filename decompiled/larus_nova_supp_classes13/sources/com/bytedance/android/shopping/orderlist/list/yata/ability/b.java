package com.bytedance.android.shopping.orderlist.list.yata.ability;

import android.content.Context;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import pd.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void a() {
        if (com.bytedance.android.shopping.orderlist.list.utils.a.a.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L21;
        OrderListFragment r1 = this.a.c.get();
        if (r1 == null) goto L22;
        Context r2 = r1.getContext();
        if (r2 == null) goto L23;
        Intrinsics.checkNotNullParameter(r2, "context");
        boolean r3 = ECServiceManager.a;     // Catch: Throwable -> L16
        e r4 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();     // Catch: Throwable -> L16
        if (r4 == null) goto L24;
        int r5 = p0.a;     // Catch: Throwable -> L16
        String r6 = p0.d(com.bytedance.android.shopping.orderlist.list.utils.a.a, "prerender_cache_key", "order_detail_prerender_key_order_list");     // Catch: Throwable -> L16
        com.bytedance.android.shopping.orderlist.list.utils.a.a = r6;     // Catch: Throwable -> L16
        r4.prerenderAnnieWithSchema(r2, r6, "webcast", 120, "onidle", null);     // Catch: Throwable -> L16
        return;
    L24:
        return;
    L16:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r0 = false;
        goto L6
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
