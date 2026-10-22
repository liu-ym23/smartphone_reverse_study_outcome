package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f567489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xg2.d f567490b;

    public c(a r100, xg2.d r101) {
        this.f567489a = r100;
        this.f567490b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f567489a;     // Catch: Throwable -> L4
        xg2.d r101 = this.f567490b;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        int r102 = g.f567498a;     // Catch: Throwable -> L4
        vg2.a r103 = g.a(r101, EventType.RATE_SINGLE, "ec_live_quality_monitor_single_event", r101.f563599d);     // Catch: Throwable -> L4
        r100.f567483a.a(r103);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
