package fo5;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f478124v;

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f478124v);     // Catch: SecurityException -> L6 IllegalArgumentException -> L8 Throwable -> L12
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

    public a(Runnable r100, String r101, int r102) {
        super(r100, r101);
        this.f478124v = r102;
    }
}
