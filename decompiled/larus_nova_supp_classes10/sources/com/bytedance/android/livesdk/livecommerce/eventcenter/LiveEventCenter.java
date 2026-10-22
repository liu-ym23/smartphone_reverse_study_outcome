package com.bytedance.android.livesdk.livecommerce.eventcenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveEventCenter implements d {
    public static final Lazy b = null;
    public final CopyOnWriteArrayList<d.a> a;

    public static final class a {
        public static d a() {
            return (d) LiveEventCenter.b.getValue();
        }
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, LiveEventCenter$Companion$INSTANCE$2.INSTANCE);
    }

    public LiveEventCenter() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final synchronized void a(d.a r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L8
        if (this.a.contains(r2) == false) goto L6;
        this.a.remove(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final synchronized void b(d.a r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L8
        if (this.a.contains(r2) == true) goto L6;
        this.a.add(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final void sendEvent(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        if (i.a.contains(r5) == true) goto L5;
        xh.a r1 = xh.c.a("Live");
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("eventName", r5), TuplesKt.to("params", r6)});
        xh.b r2 = new xh.b();
        r2.c(null);
        r2.b("LiveEventCenter");
        r2.a(r0);
        r1.f(3, r2);
    L5:
        Iterator r3 = CollectionsKt.toMutableList(this.a).iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        ((d.a) r3.next()).a(r5, r6);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }
}
