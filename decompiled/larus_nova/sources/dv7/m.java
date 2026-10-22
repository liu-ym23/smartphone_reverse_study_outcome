package dv7;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f470185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f470186b;

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = this.f470186b.f470183b;     // Catch: Throwable -> L12
        monitor-enter(r100);     // Catch: Throwable -> L12
        OnFailureListener r101 = this.f470186b.f470184c;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.onFailure(this.f470185a.getException());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    L15:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }

    public m(l r100, Task r101) {
        this.f470186b = r100;
        this.f470185a = r101;
    }
}
