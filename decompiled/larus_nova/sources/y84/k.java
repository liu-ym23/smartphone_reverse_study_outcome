package y84;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class k implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f566904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f566905b;

    @Override // y84.i
    public final j b() {
        Object r100 = this.f566904a;
        monitor-enter(r100);
        j r101 = this.f566905b;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public k() {
        this.f566904a = new Object();
    }

    @Override // y84.i
    public final void a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "yawConfig");
        Object r101 = this.f566904a;
        monitor-enter(r101);
        this.f566905b = r100;     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
