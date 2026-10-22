package l19;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes27.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f507038a;

    @Override // java.lang.Runnable
    public final void run() {
        l r100 = this.f507038a;     // Catch: Throwable -> L7
        r100.C = false;     // Catch: Throwable -> L7
        Iterator<T> r101 = r100.D.iterator();     // Catch: Throwable -> L7
    L4:
        if (r101.hasNext() == false) goto L16;
        ((f) r101.next()).onTransitionEnd(r100.E);     // Catch: Throwable -> L7
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

    public m(l r100) {
        this.f507038a = r100;
    }
}
