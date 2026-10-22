package cu8;

import com.bytedance.sysoptimizer.anr.AnrListener;
import com.bytedance.sysoptimizer.anr.AnrManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements AnrListener {
    public b() {
    }

    @Override // com.bytedance.sysoptimizer.anr.AnrListener
    public final void onAnrChange(boolean r110, int r111, AnrManager.AnrReason r112) {
        Intrinsics.checkNotNullParameter(r112, "anrReason");
        if (r110 == false) goto L18;
        nu8.a.a("FlowAnrMonitor", "anr coming soon...   level: " + r111 + ", anrReason: " + r112);     // Catch: Throwable -> L20
        int r100 = c.f465445d;     // Catch: Throwable -> L20
        if (r100 != 0) goto L7;
        nu8.a.e("FlowAnrMonitor", "anr stuck first time... currentAnrLevel: " + c.f465445d);     // Catch: Throwable -> L20
        c.f465446e = System.currentTimeMillis();     // Catch: Throwable -> L20
    L11:
        int r101 = c.f465445d + 1;     // Catch: Throwable -> L20
        c.f465445d = r101;     // Catch: Throwable -> L20
        if (r101 < c.f465444c) goto L25;
        nu8.a.b("FlowAnrMonitor", "anr coming really...   currentAnrLevel: " + c.f465445d + ", totalAnrLevel: " + r111 + ", anrReason: " + r112);     // Catch: Throwable -> L20
        long r102 = c.f465446e;     // Catch: Throwable -> L20
        String r103 = iu8.b.a();     // Catch: Throwable -> L20
        Iterator r104 = ((CopyOnWriteArrayList) c.f465442a).iterator();     // Catch: Throwable -> L20
    L15:
        if (r104.hasNext() == false) goto L17;
        ((a) r104.next()).a(r102, r103);     // Catch: Throwable -> L20
        goto L15
    L17:
        c.f465445d = 0;     // Catch: Throwable -> L20
        c.f465446e = 0;     // Catch: Throwable -> L20
        return;
    L25:
        return;
    L7:
        if (r100 < 1) goto L11;
        if (r100 == ((System.currentTimeMillis() - c.f465446e) / ((long) 1000))) goto L11;
        nu8.a.e("FlowAnrMonitor", "anr stuck level reset to first...   currentAnrLevel: " + c.f465445d + " -> 0");     // Catch: Throwable -> L20
        c.f465445d = 0;     // Catch: Throwable -> L20
        c.f465446e = System.currentTimeMillis();     // Catch: Throwable -> L20
        goto L11
    L18:
        nu8.a.a("FlowAnrMonitor", "anr restore...   level: " + r111 + ", anrReason: " + r112);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        nu8.a.b("FlowAnrMonitor", "onAnrChange, error: " + th);
    }
}
