package rm7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f538593a;

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f538593a;     // Catch: Throwable -> L4
        String r101 = r100.c(r100.e());     // Catch: Throwable -> L4
        i r102 = this.f538593a;     // Catch: Throwable -> L4
        r102.g(r102.e(), r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(i r100) {
        this.f538593a = r100;
    }
}
