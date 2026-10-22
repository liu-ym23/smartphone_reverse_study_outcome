package kl4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements j {
    public e() {
    }

    @Override // kl4.j
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter("DoraKMPAdapter", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        pk4.j.f("DoraKMPAdapter", r100);
    }

    @Override // kl4.j
    public final void e(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter("DoraNativeInterop", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        pk4.j.c("DoraNativeInterop", r100, r101);
    }

    @Override // kl4.j
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        pk4.j.d(r100, r101);
    }
}
