package fo5;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends PthreadThreadV2 {
    public final int v;

    public final void run() {
        Process.setThreadPriority(this.v);     // Catch: SecurityException -> L6 IllegalArgumentException -> L8 Throwable -> L12
    L10:
        super.run();     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    L8:
        e = move-exception;
        tt5.a.e("BearExecutorFactory", "BearThread run: ", e, false);     // Catch: Throwable -> L12
    L6:
        e = move-exception;
        tt5.a.e("BearExecutorFactory", "BearThread run: ", e, false);     // Catch: Throwable -> L12
        goto L10
    }

    public a(Runnable r1, String r2, int r3) {
        super(r1, r2);
        this.v = r3;
    }
}
