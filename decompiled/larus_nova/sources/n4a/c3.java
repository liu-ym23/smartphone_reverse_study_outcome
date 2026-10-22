package n4a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class c3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d3 f517205a;

    public c3(d3 r100) {
        this.f517205a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d3 r100 = this.f517205a;     // Catch: Throwable -> L9
        if (r100.f517229f == null) goto L19;
        s3 r101 = r100.f517227d;     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.f517722o == false) goto L12;
        r101.d(true);     // Catch: Throwable -> L9
    L12:
        q2.e(r101.f517710c);     // Catch: Throwable -> L9
        return;
    L19:
        return;
    L9:
        th = move-exception;
        c4.g(th, "cl", "upwr");     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L26;
        throw th;
    }
}
