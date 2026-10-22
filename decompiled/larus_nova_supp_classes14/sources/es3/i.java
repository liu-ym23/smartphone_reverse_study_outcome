package es3;

import com.bytedance.apm.block.a;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;
    public final /* synthetic */ h c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((CopyOnWriteArrayList) this.c.d).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((a) r0.next()).e(ActivityLifeObserver.getInstance().getTopActivityClassName(), this.a, this.b);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public i(h r1, long r2, long r4) {
        this.c = r1;
        this.a = r2;
        this.b = r4;
    }
}
