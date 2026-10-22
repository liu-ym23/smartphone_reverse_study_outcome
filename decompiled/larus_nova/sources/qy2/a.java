package qy2;

import bz2.c;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f535184a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f535184a.run();     // Catch: Throwable -> L4 Exception -> L6
    L12:
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L6:
        c.a();     // Catch: Throwable -> L4
        goto L12
    }

    public a(Runnable r100) {
        this.f535184a = r100;
    }
}
