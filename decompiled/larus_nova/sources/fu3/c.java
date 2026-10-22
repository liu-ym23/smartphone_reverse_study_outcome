package fu3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends cv3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f478884d;

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f478884d;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L4
        r100.f(new h("command_report_data", r101 - r100.f478870k));     // Catch: Throwable -> L4
        r100.f478870k = r101;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, long r101, long r102) {
        this.f478884d = r100;
        super(r101, r102);
    }
}
