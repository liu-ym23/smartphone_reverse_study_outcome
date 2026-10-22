package dv7;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f470208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f470209b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f470208a.setResult(this.f470209b.call());     // Catch: Throwable -> L4 Exception -> L6
    L16:
        return;
    L6:
        e = move-exception;
        this.f470208a.a(e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public w(v r100, Callable r101) {
        this.f470208a = r100;
        this.f470209b = r101;
    }
}
