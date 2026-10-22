package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b2 {
    public static int f;
    public final com.bytedance.ee.bear.contract.d a;
    public final List<Long> b;
    public final List<Long> c;
    public ScheduledFuture<?> d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        ScheduledFuture<?> r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L17;
        tt5.a.h("DocWebPerfMonitor", "cancel...");
        ScheduledFuture<?> r2 = this.d;     // Catch: Exception -> L15
        if (r2 == null) goto L21;
        r2.cancel(false);     // Catch: Exception -> L15
        return;
    L21:
        return;
    L15:
        e = move-exception;
        tt5.a.f("DocWebPerfMonitor", e, false);
        Unit r3 = Unit.INSTANCE;
        return;
    L17:
        tt5.a.h("DocWebPerfMonitor", "cancel already");
        return;
    L5:
        if (r0.isCancelled() == true) goto L7;
        r1 = true;
        goto L9
    }

    public b2(com.bytedance.ee.bear.contract.d r2) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        this.a = r2;
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.e = idb.f.a().isCurrentEnable("ccm.sheet.mobile_webview_memory_report");
    }

    public static final long a(b2 r2) {
        r2.getClass();
        int r0 = c05.b.b;     // Catch: Throwable -> L8
        ISandboxProcessServer r1 = c05.b.a.b();     // Catch: Throwable -> L8
        if (r1 != null) goto L13;
        tt5.a.d("DocWebPerfMonitor", "sandboxServer is null");     // Catch: Throwable -> L8
    L10:
        return 0;
    L13:
        return r1.getSandboxMemory();
    L8:
        th = move-exception;
        tt5.a.f("DocWebPerfMonitor", th, false);
        goto L10
    }
}
