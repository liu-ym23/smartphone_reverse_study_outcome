package i84;

import com.bytedance.bdinstall.t0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f488650a;

    @Override // java.lang.Runnable
    public final void run() {
        t0 r100 = this.f488650a.f488645b;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.onTimeout();     // Catch: Throwable -> L7
        w.b(this.f488650a);     // Catch: Throwable -> L7
    L5:
        this.f488650a.f488645b = null;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public x(w r100) {
        this.f488650a = r100;
    }
}
