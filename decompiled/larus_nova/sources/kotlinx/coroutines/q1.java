package kotlinx.coroutines;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes42.dex */
public final class q1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f505007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<Unit> f505008b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f505008b.f(this.f505007a, Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q1(CoroutineDispatcher r100, j r101) {
        this.f505007a = r100;
        this.f505008b = r101;
    }
}
