package com.bytedance.android.shopping.store.router.hybridpage.holder;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.store.home.c0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        s0.a(new c0());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
