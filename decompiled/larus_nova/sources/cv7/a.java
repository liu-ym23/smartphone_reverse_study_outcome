package cv7;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends PthreadThreadV2 {
    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(19);     // Catch: Throwable -> L13
        monitor-enter(this);     // Catch: Throwable -> L13
    L19:
        wait();     // Catch: Throwable -> L7 InterruptedException -> L9
    L9:
    L16:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }

    public a(ThreadGroup r100) {
        super(r100, "GmsDynamite");
    }
}
