package e77;

import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess because timeout");     // Catch: Throwable -> L4
        com.bytedance.push.b.f266751a.d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a() {
    }
}
