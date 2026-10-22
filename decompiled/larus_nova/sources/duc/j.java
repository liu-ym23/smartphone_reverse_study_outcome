package duc;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlinx.coroutines.b0;

/* JADX INFO: loaded from: classes.dex */
public final class j extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f470069c;

    @Override // java.lang.Runnable
    public final void run() {
        this.f470069c.run();     // Catch: Throwable -> L4
        this.f470067b.a();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L4:
        th = move-exception;
        this.f470067b.a();     // Catch: Throwable -> L7
        throw th;     // Catch: Throwable -> L7
    }

    public final String toString() {
        return "Task[" + this.f470069c.getClass().getSimpleName() + '@' + b0.a(this.f470069c) + ", " + this.f470066a + ", " + this.f470067b + ']';
    }

    public j(Runnable r100, long r101, h r102) {
        super(r101, r102);
        this.f470069c = r100;
    }
}
