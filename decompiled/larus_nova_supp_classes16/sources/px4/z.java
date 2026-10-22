package px4;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z implements Runnable {
    public final /* synthetic */ w a;

    public z(w r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jx4.u r0 = this.a.b;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
        r0.b();     // Catch: Throwable -> L6
        this.a.b = null;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
