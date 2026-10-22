package lz4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p extends w {
    @Override // lz4.w
    public final void c() {
        ((jz4.i) this.d).d.c();
    }

    @Override // lz4.w
    public final void d() {
        super.d();
        ((jz4.i) this.d).b();
    }

    public p(n r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        super(r2);
    }
}
