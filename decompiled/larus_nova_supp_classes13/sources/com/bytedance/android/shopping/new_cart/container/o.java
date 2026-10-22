package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.shopping.new_cart.components.CartPageCallBackComponent;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements Runnable {
    public final /* synthetic */ CartFragment a;

    public o(CartFragment r1) {
        this.a = r1;
    }

    public final void a() {
        if (this.a.w.get() == false) goto L9;
        CartPageCallBackComponent r0 = this.a.U90();
        if (r0 != null) goto L7;
    L8:
        CartViewModel.doQuery$default(this.a.W90(), false, "page_back", null, 4, null);
        goto L9
    L7:
        if (r0.f != true) goto L8;
    L9:
        Iterator<T> r1 = CartFragment.S90(this.a).e.e.iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        ((v) r1.next()).onResume();
        goto L11
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
