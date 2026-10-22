package com.bytedance.bdp.appbase.base.monitor;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {
    public b() {
    }

    public static void a() {
        monitor-enter(BdpAppMonitor.class);
        Iterator<BdpAppMonitor.b> r100 = BdpAppMonitor.f200606d.iterator();     // Catch: Throwable -> L26
    L6:
        if (r100.hasNext() == false) goto L23;
        int r101 = BdpAppMonitor.a.f200608a[r100.next().f200609a.ordinal()];     // Catch: Throwable -> L26
        if (r101 != 1) goto L10;
        BdpAppMonitor.f200603a.getClass();     // Catch: Throwable -> L26
        goto L6
    L10:
        if (r101 != 2) goto L12;
        BdpAppMonitor.f200603a.getClass();     // Catch: Throwable -> L26
        goto L6
    L12:
        if (r101 != 3) goto L14;
        BdpAppMonitor.f200603a.getClass();     // Catch: Throwable -> L26
        goto L6
    L14:
        if (r101 != 4) goto L16;
        BdpAppMonitor.f200603a.getClass();     // Catch: Throwable -> L26
        goto L6
    L16:
        if (r101 != 5) goto L17;
        BdpAppMonitor.f200603a.getClass();     // Catch: Throwable -> L26
        goto L6
    L17:
        g94.b.b("BdpAppMonitor", new Object[]{"unknown report type"});     // Catch: Throwable -> L26
        goto L6
    L23:
        BdpAppMonitor.f200606d.clear();     // Catch: Throwable -> L26
        BdpAppMonitor.f200606d = null;     // Catch: Throwable -> L26
        monitor-exit(BdpAppMonitor.class);
        return;
    L26:
        th = move-exception;
        throw th;
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
