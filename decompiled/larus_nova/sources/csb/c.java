package csb;

import com.ss.android.lark.monitor.cpu.CpuThreadMetrics;
import com.ss.android.lark.monitor.i;
import com.ss.android.lark.monitor.y;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends com.ss.android.lark.monitor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f465230a;

    public c(i r100) {
        this.f465230a = new d(r100.f432402f);
    }

    @Override // com.ss.android.lark.monitor.a
    public final void a(y r100, int r101) {
        if (b.f465227c == null) goto L5;
    L14:
        b.f465227c.getClass();
        CpuThreadMetrics r102 = new CpuThreadMetrics();
        r102.switchType = r101;
        if (b.a().b(r102) == false) goto L20;
        this.f465230a.a(r102, r100);
        return;
    L20:
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.f465227c != null) goto L9;
        b.f465227c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
        goto L14
    }
}
