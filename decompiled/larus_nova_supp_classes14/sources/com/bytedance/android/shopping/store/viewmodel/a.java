package com.bytedance.android.shopping.store.viewmodel;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.core.arch.event.c.d(this.a.a.a, new kj3.a());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
