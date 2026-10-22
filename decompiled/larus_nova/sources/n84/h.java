package n84;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f518317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f518318b;

    public final d a() {
        Object r100 = this.f518317a;
        monitor-enter(r100);
        d r101 = this.f518318b;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public h(d r100) {
        Intrinsics.checkNotNullParameter(r100, "initialSnapshot");
        this.f518317a = new Object();
        this.f518318b = r100;
    }

    public final void update(d r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Object r101 = this.f518317a;
        monitor-enter(r101);
        this.f518318b = r100;     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
