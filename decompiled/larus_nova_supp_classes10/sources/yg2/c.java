package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ xg2.d b;

    public c(a r1, xg2.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a;     // Catch: Throwable -> L4
        xg2.d r1 = this.b;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        int r2 = g.a;     // Catch: Throwable -> L4
        vg2.a r3 = g.a(r1, EventType.RATE_SINGLE, "ec_live_quality_monitor_single_event", r1.d);     // Catch: Throwable -> L4
        r0.a.a(r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
