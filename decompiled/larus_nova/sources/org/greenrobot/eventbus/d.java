package org.greenrobot.eventbus;

import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes42.dex */
public final class d extends n implements Runnable {
    @Override // org.greenrobot.eventbus.n
    public final synchronized void a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f525822f == null) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw null;     // Catch: Throwable -> L9
    }

    @Override // org.greenrobot.eventbus.n
    public final Method b() {
        Method r100 = this.f525817a;
        r100.getClass();
        return r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        EventBus.lookupAllEventTypes(this.f525819c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // org.greenrobot.eventbus.n
    public final int hashCode() {
        throw null;
    }
}
