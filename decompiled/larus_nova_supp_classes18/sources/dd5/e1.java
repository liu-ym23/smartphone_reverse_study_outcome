package dd5;

import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e1 implements Runnable {
    public final /* synthetic */ SmartRefreshLayout a;

    public e1(SmartRefreshLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cqa.e r0 = this.a.getRefreshHeader();     // Catch: Throwable -> L10
        if ((r0 instanceof b1) == false) goto L5;
        b1 r1 = (b1) r0;     // Catch: Throwable -> L10
    L6:
        if (r1 == null) goto L8;
        r1.d = true;     // Catch: Throwable -> L10
        r1.c = true;     // Catch: Throwable -> L10
        r1.l();     // Catch: Throwable -> L10
    L8:
        this.a.r(0, 0, 0.0f, false);     // Catch: Throwable -> L10
        return;
    L5:
        r1 = null;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
