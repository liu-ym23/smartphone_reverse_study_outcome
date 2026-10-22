package ly2;

import com.larus.apm.impl.protector.RunnableProtector;
import ny2.g;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f511293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f511294b;

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f511293a, this.f511294b.f511295a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100, g r101) {
        this.f511294b = r100;
        this.f511293a = r101;
    }
}
