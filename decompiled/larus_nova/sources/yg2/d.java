package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f567491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xg2.a f567492b;

    public d(a r100, xg2.a r101) {
        this.f567491a = r100;
        this.f567492b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f567491a;     // Catch: Throwable -> L7
        xg2.a r101 = this.f567492b;     // Catch: Throwable -> L7
        EventType r102 = EventType.RATE_FAILURE;     // Catch: Throwable -> L7
        String r103 = r100.c(r101);     // Catch: Throwable -> L7
        if (r103 == null) goto L10;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");     // Catch: Throwable -> L7
        r101.f563596a = r103;     // Catch: Throwable -> L7
        System.currentTimeMillis();     // Catch: Throwable -> L7
        r100.b(r101, r102, "ec_live_quality_monitor_failure", r103);     // Catch: Throwable -> L7
        r100.a(r101);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
