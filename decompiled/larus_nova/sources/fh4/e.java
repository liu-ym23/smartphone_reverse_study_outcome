package fh4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f477010a;

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f477010a;     // Catch: Throwable -> L6
        r100.a();     // Catch: Throwable -> L6
        if (r100.f477019c.size() < f.f477012f) goto L9;
        r100.h();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public e(f r100) {
        this.f477010a = r100;
    }
}
