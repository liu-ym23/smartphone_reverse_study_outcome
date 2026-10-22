package lta;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f510719a;

    @Override // java.lang.Runnable
    public final void run() {
        h r100 = this.f510719a;     // Catch: Throwable -> L12
        monitor-enter(r100);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L5:
        if (this.f510719a.f510742m == null) goto L7;
        this.f510719a.f510742m.onTimeout();     // Catch: Throwable -> L9
        this.f510719a.f510742m = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }

    public f(e r100) {
        this.f510719a = r100;
    }
}
