package o69;

import com.bytedance.keva.Keva;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import yj4.i;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements i {
    public a() {
    }

    @Override // yj4.i
    public final /* synthetic */ void a() {
    }

    @Override // yj4.i
    public final /* synthetic */ void b(int r100) {
    }

    @Override // yj4.i
    public final /* synthetic */ void c() {
    }

    @Override // yj4.i
    public final /* synthetic */ void d(yj4.b r100) {
    }

    @Override // yj4.i
    public final /* synthetic */ void e() {
    }

    @Override // yj4.i
    public final /* synthetic */ void f(int r100) {
    }

    @Override // yj4.i
    public final /* synthetic */ void g(yj4.a r100) {
    }

    @Override // yj4.i
    public final /* synthetic */ void h(int r100) {
    }

    @Override // yj4.i
    public final void i(String r100, long r101, int r102) {
        g49.d.d("DoraGTimeSyncManager", "onPowerCycleInfo: cycleSessionId=" + r100 + ", utcTimeStamp=" + r101 + ", bootTimeMs=" + r102);
        String r103 = b.f522208a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        b.f522208a = r100;
        if (r100.length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L13;
        g49.d.d("DoraGTimeSyncManager", "onPowerCycleInfo: powerCycleSessionId is empty");
        return;
    L13:
        if (e.b() > 0) goto L16;
        g49.d.d("DoraGTimeSyncManager", "onPowerCycleInfo: maxSessionLimit = " + e.b() + " is invalid");
        return;
    L16:
        String r105 = b.f522208a;
        long r106 = r101 - ((long) r102);
        Intrinsics.checkNotNullParameter(r105, "sessionId");
        Object r107 = e.f522212d;     // Catch: Exception -> L33
        monitor-enter(r107);     // Catch: Exception -> L33
        CopyOnWriteArrayList<String> r108 = e.f522210b;     // Catch: Throwable -> L30
        if (r108.contains(r105) == false) goto L25;
        e.e(r105, r106);     // Catch: Throwable -> L30
        monitor-exit(r107);     // Catch: Exception -> L33
        return;
    L25:
        if (r108.size() < e.b()) goto L27;
        String r109 = r108.get(0);     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L30
        e.a(r109);     // Catch: Throwable -> L30
    L27:
        r108.add(r105);     // Catch: Throwable -> L30
        ((Keva) e.f522209a.getValue()).storeLong("dora_g_time_sync_session_" + r105, r106);     // Catch: Throwable -> L30
        e.d();     // Catch: Throwable -> L30
        monitor-exit(r107);     // Catch: Exception -> L33
        return;
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L33:
        e = move-exception;
        g49.d.d("DoraGTimeSyncRepo", "Error adding time deviation: " + e.getMessage());
        return;
    L8:
        r104 = false;
        goto L9
    }
}
