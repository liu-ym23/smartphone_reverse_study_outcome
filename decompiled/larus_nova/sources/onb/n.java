package onb;

import com.bytedance.map.api.monitor.MapMonitorConst;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f524438a;

    public n() {
    }

    public final synchronized Executor a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f524438a != null) goto L6;
        this.f524438a = qnb.b.a().b();     // Catch: Throwable -> L14
    L6:
        Executor r100 = this.f524438a;     // Catch: Throwable -> L14
        if ((r100 instanceof ExecutorService) == true) goto L9;
    L11:
        Executor r101 = this.f524438a;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r101;
    L9:
        if (((ExecutorService) r100).isShutdown() == false) goto L11;
        this.f524438a = qnb.b.a().b();     // Catch: Throwable -> L14
        goto L11
    }

    @Override // onb.c
    public final void destroy() {
        rnb.c.c("RnReceiveDispatch", MapMonitorConst.EVENT_DESTROY);
        Executor r100 = this.f524438a;
        if ((r100 instanceof ExecutorService) == false) goto L6;
        ((ExecutorService) r100).shutdown();
        return;
    }

    @Override // onb.c
    public final void submit(Runnable r100) {
        a().execute(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        rnb.c.f538745a.e("RnReceiveDispatch", th);
    }
}
