package sl6;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d implements at6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f542471a = null;

    static {
        f542471a = new d();
    }

    public d() {
    }

    @Override // at6.b
    public final void a(at6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<at6.c> r101 = b.f542469a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<at6.c> r102 = b.f542469a;
        r102.remove(r100);
        r100.hashCode();
        if (r102.isEmpty() == true) goto L5;
        return;
    L5:
        monitor-enter(c.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r102.isEmpty() == false) goto L9;
        c r103 = c.f542470a;     // Catch: Throwable -> L12
        r103.getClass();     // Catch: Throwable -> L12
        vn6.b.c(r103);     // Catch: Throwable -> L12
        r100.hashCode();     // Catch: Throwable -> L12
    L9:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(c.class);
    }

    @Override // at6.b
    public final void b(at6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<at6.c> r101 = b.f542469a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<at6.c> r102 = b.f542469a;
        if (r102.isEmpty() == true) goto L5;
        r102.add(r100);
    L16:
        r100.hashCode();
        return;
    L5:
        monitor-enter(c.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r102.isEmpty() == false) goto L9;
        c r103 = c.f542470a;     // Catch: Throwable -> L12
        r103.getClass();     // Catch: Throwable -> L12
        vn6.b.b(r103);     // Catch: Throwable -> L12
        r100.hashCode();     // Catch: Throwable -> L12
    L9:
        r102.add(r100);     // Catch: Throwable -> L12
        monitor-exit(c.class);
        goto L16
    }
}
