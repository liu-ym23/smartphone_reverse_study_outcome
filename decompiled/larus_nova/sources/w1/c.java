package w1;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes39.dex */
public final class c extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f557880a;

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        b r100 = this.f557880a;     // Catch: Throwable -> L6
        int r101 = r100.S + 1;     // Catch: Throwable -> L6
        r100.S = r101;     // Catch: Throwable -> L6
        if (r101 <= 5) goto L9;
        r100.E();     // Catch: Throwable -> L6
        b r102 = this.f557880a;     // Catch: Throwable -> L6
        r102.f562083d.a(r102.f562081b.getDevice());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public c(b r100) {
        this.f557880a = r100;
    }
}
