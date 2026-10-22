package dj4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements vhc.b.InterfaceC8010b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f468909a;

    @Override // vhc.b.InterfaceC8010b
    public final void b(vhc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
    }

    @Override // vhc.b.InterfaceC8010b
    public final void c(vhc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
    }

    public c(e r100) {
        this.f468909a = r100;
    }

    @Override // vhc.b.InterfaceC8010b
    public final void a(vhc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        f r101 = this.f468909a.f468911a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
