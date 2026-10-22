package n8a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f518364a;

    @Override // java.lang.Runnable
    public final void run() {
        a.c(this.f518364a);     // Catch: Throwable -> L4
        a r100 = this.f518364a;     // Catch: Throwable -> L4
        r100.f(r100.getWidth(), this.f518364a.getHeight());     // Catch: Throwable -> L4
        this.f518364a.updateBlur();     // Catch: Throwable -> L4
        this.f518364a.invalidate();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(a r100) {
        this.f518364a = r100;
    }
}
