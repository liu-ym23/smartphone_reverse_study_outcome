package qb4;

import com.bytedance.bdturing.TuringVerifyWebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringVerifyWebView f532387a;

    @Override // java.lang.Runnable
    public final void run() {
        g0 r100 = this.f532387a.f201705a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public u(TuringVerifyWebView r100) {
        this.f532387a = r100;
    }
}
