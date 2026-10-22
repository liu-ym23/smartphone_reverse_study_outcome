package com.bytedance.android.shopping.new_cart.components;

import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ CartPageCallBackComponent a;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.store.node.c b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ String e;

    public h(CartPageCallBackComponent r1, com.bytedance.kmp.ec.yata.store.node.c r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = null;
        this.e = r4;
    }

    public final void a() {
        AndroidYaTaInstance r2 = (AndroidYaTaInstance) this.a.x.e.d.invoke();
        r2.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r2, null, this.b.getKey(), this.c, this.d, this.e));
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
