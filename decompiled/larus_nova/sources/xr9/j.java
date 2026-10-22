package xr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j implements wr9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wr9.j f564895a;

    @Override // wr9.i
    public final void G8(com.larus.avlink.gallery.power.monitor.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // wr9.i
    public final void Gb(com.larus.avlink.gallery.power.monitor.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // wr9.i, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // wr9.i
    public final void start() {
    }

    @Override // wr9.i
    public final wr9.j o() {
        return this.f564895a;
    }

    public j(wr9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        this.f564895a = r100;
    }
}
