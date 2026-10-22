package vp1;

import androidx.lifecycle.Lifecycle;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.c f556606a;

    public i(g.c r100) {
        this.f556606a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f556606a.f556596a.f556590l.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L9;
        this.f556606a.f556597b.run();     // Catch: Throwable -> L6
        return;
    }
}
