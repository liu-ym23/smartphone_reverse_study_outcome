package yy4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f569475a;

    public f(b r100) {
        this.f569475a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.f569451a.removeObserver(this.f569475a.f569458g);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
