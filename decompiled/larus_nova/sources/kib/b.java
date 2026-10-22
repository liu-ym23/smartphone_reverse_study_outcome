package kib;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forwardv2.e;
import hib.d;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f503667a;

    public b(a.b r100) {
        this.f503667a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f503667a.getClass();     // Catch: Throwable -> L4
        d r100 = e.f424890a;     // Catch: Throwable -> L4
        e.a.a().getEventParams();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
