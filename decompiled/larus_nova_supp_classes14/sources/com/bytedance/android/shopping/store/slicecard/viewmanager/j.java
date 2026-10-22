package com.bytedance.android.shopping.store.slicecard.viewmanager;

import com.bytedance.android.ec.store.view.ECTagListView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements Runnable {
    public final /* synthetic */ i a;

    public j(i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gk3.a r0 = this.a.o1();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.d((ECTagListView) this.a.k1());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
