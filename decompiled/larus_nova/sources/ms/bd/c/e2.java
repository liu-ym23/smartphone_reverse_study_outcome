package ms.bd.c;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;

/* JADX INFO: loaded from: classes5.dex */
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f515136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f515137b;

    public e2() {
    }

    public final void a(String r110, int r111) {
        monitor-enter(z3.class);
        z3 r100 = z3.f515450b;     // Catch: Throwable -> L13
        monitor-exit(z3.class);
        if (r100 != null) goto L8;
        return;
    L8:
        long r101 = System.currentTimeMillis();
        long r102 = this.f515136a;
        long r103 = r101 - r102;
        String r104 = this.f515137b;
        SDKMonitor r105 = r100.f515451a;
        if (r105 == null) goto L19;
        r105.monitorApiError(r103, r102, r104, null, r110, r111, null);
        return;
    L19:
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
