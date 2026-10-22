package n84;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    public final Object a;
    public d b;

    public final d a() {
        Object r0 = this.a;
        monitor-enter(r0);
        d r1 = this.b;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public h(d r2) {
        Intrinsics.checkNotNullParameter(r2, "initialSnapshot");
        this.a = new Object();
        this.b = r2;
    }

    public final void update(d r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        Object r0 = this.a;
        monitor-enter(r0);
        this.b = r2;     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
