package f27;

import com.bytedance.monitor.util.thread.AsyncTaskType;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsyncTaskType f475223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f475224b;

    @Override // java.lang.Runnable
    public final void run() {
        Runnable r100 = this.f475224b;     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        r100.run();     // Catch: Throwable -> L6
        Object r101 = d.f475214f;     // Catch: Throwable -> L6
        d r102 = d.a.f475222a;     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        Object r103 = d.f475214f;
        d.a.f475222a.a(th, "APM_INNER_ERROR_async_task");
    }

    @Override // f27.g
    public final AsyncTaskType getTaskType() {
        return this.f475223a;
    }

    public e(String r100, AsyncTaskType r101, Runnable r102) {
        this.f475223a = r101;
        this.f475224b = r102;
    }
}
