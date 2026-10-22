package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public f(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        LayoutTypes r6 = (LayoutTypes) r5;
        ECShopHybridProductListPresenter r0 = this.a;
        if (r0.r == true) goto L6;
        r0.r = true;
        return;
    L6:
        if (r0.q == true) goto L46;
        r0.q = true;
        ECHybridListEngine r1 = r0.n;
        if (r1 == null) goto L11;
        com.bytedance.android.ec.hybrid.list.entity.k r2 = r1.c.g;
    L12:
        ArrayList r3 = new ArrayList();
        if (r2 == null) goto L31;
        ArrayList r4 = r2.c;
        if (r4 == null) goto L31;
        Iterator r7 = r4.iterator();     // Catch: Exception -> L29
    L18:
        if (r7.hasNext() == false) goto L22;
        com.bytedance.android.ec.hybrid.list.entity.i r8 = (com.bytedance.android.ec.hybrid.list.entity.i) r7.next();     // Catch: Exception -> L29
        if (ShopHybridTabExtKt.a(r8, r6) == false) goto L18;
        r3.add(r8);     // Catch: Exception -> L29
        goto L18
    L22:
        Iterator r9 = r3.iterator();     // Catch: Exception -> L29
    L23:
        if (r9.hasNext() == false) goto L31;
        com.bytedance.android.ec.hybrid.list.entity.i r10 = (com.bytedance.android.ec.hybrid.list.entity.i) r9.next();     // Catch: Exception -> L29
        ECHybridListEngine r11 = this.a.n;     // Catch: Exception -> L29
        if (r11 == null) goto L23;
        ECHybridListEngine.s(r11, r10, Boolean.FALSE, 4);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L31:
        this.a.q = false;
        return;
    L11:
        r2 = null;
        goto L12
    }
}
