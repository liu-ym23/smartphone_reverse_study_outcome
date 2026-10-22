package mp3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f514709a;

    public b(c r100) {
        this.f514709a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public final void a() {
        ?? r100 = this.f514709a.f514714e.invoke();     // Catch: Exception -> L14
        Object r101 = this.f514709a.f514711b;     // Catch: Exception -> L14
        monitor-enter(r101);     // Catch: Exception -> L14
        c r102 = this.f514709a;     // Catch: Throwable -> L7
        if (r102.f514712c != 0) goto L9;
        r102.f514712c = r100;     // Catch: Throwable -> L7
        r102.b(r100);     // Catch: Throwable -> L7
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Exception -> L14
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
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
