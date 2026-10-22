package y84;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class k implements i {
    public final Object a;
    public j b;

    @Override // y84.i
    public final j b() {
        Object r0 = this.a;
        monitor-enter(r0);
        j r1 = this.b;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public k() {
        this.a = new Object();
    }

    @Override // y84.i
    public final void a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "yawConfig");
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
