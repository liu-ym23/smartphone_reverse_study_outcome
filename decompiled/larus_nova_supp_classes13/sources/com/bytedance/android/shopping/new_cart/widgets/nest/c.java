package com.bytedance.android.shopping.new_cart.widgets.nest;

import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ AndroidYaTaInstance c;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.store.node.c d;

    public c(String r1, boolean r2, AndroidYaTaInstance r3, com.bytedance.kmp.ec.yata.store.node.c r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        this.c.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.c, null, this.d.getKey(), "cartTabOnScreen", MapsKt.mapOf(TuplesKt.to("cart_tab_on_screen", Boolean.valueOf(this.b))), this.a));
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
