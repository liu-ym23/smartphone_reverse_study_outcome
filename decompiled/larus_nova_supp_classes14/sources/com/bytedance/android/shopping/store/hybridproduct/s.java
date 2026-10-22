package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s implements Runnable {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public s(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void a() {
        ECHybridListEngine r0 = this.a.n;
        if (r0 == null) goto L9;
        ECHybridRecyclerView r1 = r0.b;
        if (r1 == null) goto L9;
        VirtualLayoutManager r2 = r1.getLayoutManager();
        if (r2 == null) goto L9;
        r2.scrollToPositionWithOffset(0, 0);
    L9:
        this.a.y.addAll(k0.a);
        ECHybridListEngine r3 = this.a.n;
        if (r3 == null) goto L34;
        com.bytedance.android.ec.hybrid.list.entity.k r4 = r3.c.g;
        if (r4 == null) goto L36;
        ArrayList r5 = r4.c;
        if (r5 == null) goto L22;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L18:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        if (CollectionsKt.contains(this.a.y, ((com.bytedance.android.ec.hybrid.list.entity.i) r8).a) == false) goto L18;
        r6.add(r8);
    L23:
        if (r6 == null) goto L37;
        ECHybridListEngine r9 = this.a.n;
        if (r9 == null) goto L35;
        com.bytedance.android.ec.hybrid.list.entity.k r10 = new com.bytedance.android.ec.hybrid.list.entity.k();
        r10.c = new ArrayList(r6);
        r10.a = r4.a;
        r10.b = r4.b;
        r10.d = r4.d;
        Unit r11 = Unit.INSTANCE;
        ECHybridListEngine.p(r9, r10, 6);
        return;
    L35:
        return;
    L37:
        return;
    L22:
        r6 = null;
        goto L23
    L36:
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
