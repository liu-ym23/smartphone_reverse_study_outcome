package fu3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f478885a;

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        b.b(this.f478885a);     // Catch: Throwable -> L4
    L4:
        com.bytedance.apm.d.j();     // Catch: Throwable -> L8
        b r100 = this.f478885a;     // Catch: Throwable -> L8
        int r101 = r100.f478874o + 1;     // Catch: Throwable -> L8
        r100.f478874o = r101;     // Catch: Throwable -> L8
        if (r101 < 5) goto L13;
        r100.j();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public d(b r100) {
        this.f478885a = r100;
    }
}
