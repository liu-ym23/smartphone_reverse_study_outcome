package px4;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f530932a;

    public z(w r100) {
        this.f530932a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jx4.u r100 = this.f530932a.f530922b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L6
        r100.b();     // Catch: Throwable -> L6
        this.f530932a.f530922b = null;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
