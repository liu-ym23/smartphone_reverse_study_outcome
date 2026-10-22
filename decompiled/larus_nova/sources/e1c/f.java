package e1c;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExecutorService f470790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o1c.c<?, ?> f470791b;

    public f(n1c.a r100, o1c.c r101) {
        this.f470790a = r100;
        this.f470791b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f470790a.execute(this.f470791b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
