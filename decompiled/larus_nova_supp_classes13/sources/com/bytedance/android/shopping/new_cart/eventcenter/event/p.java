package com.bytedance.android.shopping.new_cart.eventcenter.event;

import android.content.Context;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements Runnable {
    public final /* synthetic */ SelfOpenHalfHybridView a;

    public p(SelfOpenHalfHybridView r1) {
        this.a = r1;
    }

    public final void a() {
        Object r0 = ((AndroidYaTaInstance) this.a.g.e.d.invoke()).i("mix_storage_param");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        Context r2 = this.a.g.getContext();
        if (r2 == null) goto L12;
        com.bytedance.ies.xbridge.base.utils.b.a(r2).e("ECOM_CART", r1);
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
