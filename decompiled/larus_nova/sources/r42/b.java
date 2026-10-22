package r42;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.c f536031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f536032b;

    public b(a.c r100, Throwable r101) {
        this.f536031a = r100;
        this.f536032b = r101;
    }

    public final void a() {
        Throwable r100 = this.f536032b;
        if ((r100 instanceof TimeoutException) == false) goto L5;
        a.c("fetch first history messages timeout");
        this.f536031a.f536030a.a(new n(null, "timeout"));
        return;
    L5:
        o r101 = this.f536031a.f536030a;
        String r102 = r100.getMessage();
        if (r102 != null) goto L8;
        r102 = "Unknown";
    L8:
        r101.a(new n(null, r102));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
