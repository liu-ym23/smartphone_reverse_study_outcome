package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f219143f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f219144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f219145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f219146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledFuture<?> f219147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f219148e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        ScheduledFuture<?> r100 = this.f219147d;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L17;
        tt5.a.h("DocWebPerfMonitor", "cancel...");
        ScheduledFuture<?> r102 = this.f219147d;     // Catch: Exception -> L15
        if (r102 == null) goto L21;
        r102.cancel(false);     // Catch: Exception -> L15
        return;
    L21:
        return;
    L15:
        e = move-exception;
        tt5.a.f("DocWebPerfMonitor", e, false);
        Unit r103 = Unit.INSTANCE;
        return;
    L17:
        tt5.a.h("DocWebPerfMonitor", "cancel already");
        return;
    L5:
        if (r100.isCancelled() == true) goto L7;
        r101 = true;
        goto L9
    }

    public b2(com.bytedance.ee.bear.contract.d r100) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        this.f219144a = r100;
        this.f219145b = new CopyOnWriteArrayList();
        this.f219146c = new CopyOnWriteArrayList();
        this.f219148e = idb.f.a().isCurrentEnable("ccm.sheet.mobile_webview_memory_report");
    }

    public static final long a(b2 r100) {
        r100.getClass();
        int r101 = c05.b.f21942b;     // Catch: Throwable -> L8
        ISandboxProcessServer r102 = c05.b.a.b();     // Catch: Throwable -> L8
        if (r102 != null) goto L13;
        tt5.a.d("DocWebPerfMonitor", "sandboxServer is null");     // Catch: Throwable -> L8
    L10:
        return 0;
    L13:
        return r102.getSandboxMemory();
    L8:
        th = move-exception;
        tt5.a.f("DocWebPerfMonitor", th, false);
        goto L10
    }
}
