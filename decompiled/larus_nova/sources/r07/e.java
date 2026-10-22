package r07;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f535495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f535496b;

    @Override // java.lang.Runnable
    public final void run() {
        c r100 = this.f535496b.f535502f.remove(this.f535495a);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.c(false, "UserTimeout");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public e(f r100, String r101) {
        this.f535496b = r100;
        this.f535495a = r101;
    }
}
