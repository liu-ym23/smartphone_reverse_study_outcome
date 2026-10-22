package com.bytedance.ee.bear.wikiv2.route;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<V> implements Callable {
    public g() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        up5.a r0 = (up5.a) WikiRouteTable.b.getValue();
        if (r0.a.get() == false) goto L20;
        return;
    L20:
        r0.b.lock();     // Catch: Throwable -> L11
        if (r0.a.get() == true) goto L13;
        r0.c.a();     // Catch: Throwable -> L11
        r0.a.compareAndSet(false, true);     // Catch: Throwable -> L11
    L13:
        r0.b.unlock();
        return;
    L11:
        th = move-exception;
        tt5.a.f("AtomicInit", th, false);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.b.unlock();
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
