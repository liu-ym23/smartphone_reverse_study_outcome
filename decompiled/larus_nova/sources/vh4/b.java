package vh4;

import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.util.p;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        p.a("VmMonitor: recover");     // Catch: Throwable -> L4
        c.f554959k.f554966d = 5;     // Catch: Throwable -> L4
        c.g(0, 0, NativeResourceMonitor.i(0, 1));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b() {
    }
}
