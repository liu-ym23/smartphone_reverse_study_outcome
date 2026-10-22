package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ xg2.a b;

    public d(a r1, xg2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a;     // Catch: Throwable -> L7
        xg2.a r1 = this.b;     // Catch: Throwable -> L7
        EventType r2 = EventType.RATE_FAILURE;     // Catch: Throwable -> L7
        String r4 = r0.c(r1);     // Catch: Throwable -> L7
        if (r4 == null) goto L10;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Throwable -> L7
        r1.a = r4;     // Catch: Throwable -> L7
        System.currentTimeMillis();     // Catch: Throwable -> L7
        r0.b(r1, r2, "ec_live_quality_monitor_failure", r4);     // Catch: Throwable -> L7
        r0.a(r1);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
