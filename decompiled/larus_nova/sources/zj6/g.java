package zj6;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f572495a;

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f572495a;     // Catch: Throwable -> L7
        r100.A = false;     // Catch: Throwable -> L7
        Iterator<T> r101 = r100.B.iterator();     // Catch: Throwable -> L7
    L4:
        if (r101.hasNext() == false) goto L16;
        ((c) r101.next()).onTransitionEnd(this.f572495a.D);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public g(f r100) {
        this.f572495a = r100;
    }
}
