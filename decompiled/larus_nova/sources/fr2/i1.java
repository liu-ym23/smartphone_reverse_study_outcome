package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i1 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uf2.z f478508a;

    @Override // fr2.k
    public final h1 K0() {
        uf2.z.a r100 = this.f478508a.K0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new h1(r100);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478508a;
    }

    public i1(uf2.z r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478508a = r100;
    }
}
