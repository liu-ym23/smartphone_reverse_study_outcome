package mp3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public final void a() {
        ?? r0 = this.a.e.invoke();     // Catch: Exception -> L14
        Object r1 = this.a.b;     // Catch: Exception -> L14
        monitor-enter(r1);     // Catch: Exception -> L14
        c r2 = this.a;     // Catch: Throwable -> L7
        if (r2.c != 0) goto L9;
        r2.c = r0;     // Catch: Throwable -> L7
        r2.b(r0);     // Catch: Throwable -> L7
    L9:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Exception -> L14
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
