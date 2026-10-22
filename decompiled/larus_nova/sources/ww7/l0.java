package ww7;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public final class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f561677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m0 f561678b;

    public final void a() {
        Object r100 = this.f561678b.f561681c;
        monitor-enter(r100);
        Object r101 = this.f561678b.f561680b;     // Catch: Throwable -> L11
        if (r101 == null) goto L14;
        e r102 = this.f561677a;     // Catch: Throwable -> L11
        f r103 = (f) r101;     // Catch: Throwable -> L11
        if (r102.f() == false) goto L13;
        c r104 = (c) r102.d();     // Catch: Throwable -> L11
        if (r104 == null) goto L14;
        r103.f561655a.b(r104);     // Catch: Throwable -> L11
        goto L14
    L13:
        boolean r105 = r102.c() instanceof JSONException;     // Catch: Throwable -> L11
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
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

    public l0(m0 r100, e r101) {
        this.f561678b = r100;
        this.f561677a = r101;
    }
}
