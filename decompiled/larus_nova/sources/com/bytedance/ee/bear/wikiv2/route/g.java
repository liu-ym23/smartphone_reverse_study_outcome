package com.bytedance.ee.bear.wikiv2.route;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes18.dex */
public final class g<V> implements Callable {
    public g() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        up5.a r100 = (up5.a) WikiRouteTable.f241041b.getValue();
        if (r100.f551044a.get() == false) goto L20;
        return;
    L20:
        r100.f551045b.lock();     // Catch: Throwable -> L11
        if (r100.f551044a.get() == true) goto L13;
        r100.f551046c.a();     // Catch: Throwable -> L11
        r100.f551044a.compareAndSet(false, true);     // Catch: Throwable -> L11
    L13:
        r100.f551045b.unlock();
        return;
    L11:
        th = move-exception;
        tt5.a.f("AtomicInit", th, false);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r100.f551045b.unlock();
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
