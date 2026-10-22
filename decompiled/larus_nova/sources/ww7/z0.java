package ww7;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f561735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f561736b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f561735a.b(this.f561736b.call());     // Catch: Throwable -> L4 Exception -> L6
    L16:
        return;
    L6:
        e = move-exception;
        this.f561735a.a(e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public z0(f0 r100, i0 r101) {
        this.f561735a = r100;
        this.f561736b = r101;
    }
}
