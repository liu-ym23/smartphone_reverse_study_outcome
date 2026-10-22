package ww7;

import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f561692a;

    public final void a() {
        c0 r100 = c0.f561643e;
        if (r100.f561645b == true) goto L8;
        r100.f561645b = true;
        r100.f561644a = new WeakReference(this.f561692a.f561700a);
        r100.f561646c = this.f561692a.f561701b;
        r100.f561647d = new k0(this.f561692a.f561700a);
        if (r100.f561646c == false) goto L9;
        h.a(new a0(r100, new t(null, true), null));
        return;
    L9:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(r0 r100) {
        c0 r101 = c0.f561643e;
        this.f561692a = r100;
    }
}
