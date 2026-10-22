package dd5;

import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class e1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f467954a;

    public e1(SmartRefreshLayout r100) {
        this.f467954a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cqa.e r100 = this.f467954a.getRefreshHeader();     // Catch: Throwable -> L10
        if ((r100 instanceof b1) == false) goto L5;
        b1 r101 = (b1) r100;     // Catch: Throwable -> L10
    L6:
        if (r101 == null) goto L8;
        r101.f467939d = true;     // Catch: Throwable -> L10
        r101.f467938c = true;     // Catch: Throwable -> L10
        r101.l();     // Catch: Throwable -> L10
    L8:
        this.f467954a.r(0, 0, 0.0f, false);     // Catch: Throwable -> L10
        return;
    L5:
        r101 = null;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
