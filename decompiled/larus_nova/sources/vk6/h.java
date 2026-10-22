package vk6;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f555529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f555530b;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f555529a == true) goto L9;
        this.f555529a = true;     // Catch: Throwable -> L6
        this.f555530b.run();     // Catch: Throwable -> L6
        return;
    }

    public h(Runnable r100) {
        this.f555530b = r100;
    }
}
