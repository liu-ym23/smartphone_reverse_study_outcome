package qp9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f implements rp9.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f534390a;

    @Override // rp9.c.b
    public final void b(rp9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
    }

    @Override // rp9.c.b
    public final void c(rp9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
    }

    public f(h r100) {
        this.f534390a = r100;
    }

    @Override // rp9.c.b
    public final void a(rp9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        i r101 = this.f534390a.f534392a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
