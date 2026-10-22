package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class x1 implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uf2.b1 f478554a;

    @Override // fr2.j0
    public final void release() {
        this.f478554a.release();
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478554a;
    }

    public x1(uf2.b1 r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478554a = r100;
    }

    @Override // fr2.j0
    public final void P3(int r100) {
        Intrinsics.checkNotNullParameter("audioBitrate", "s");
        this.f478554a.b();
    }
}
