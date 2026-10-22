package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class w1 implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uf2.r0 f478549a;

    public final int b() {
        return this.f478549a.getStatus();
    }

    @Override // fr2.s
    public final boolean isEnable() {
        return this.f478549a.isEnable();
    }

    @Override // fr2.s
    public final w j0() {
        uf2.l1 r100 = this.f478549a.j0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new y1(r100);
    }

    @Override // fr2.s
    public final void release() {
        this.f478549a.release();
    }

    @Override // fr2.s
    public final boolean y0() {
        return this.f478549a.y0();
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478549a;
    }

    public w1(uf2.r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478549a = r100;
    }

    public final void e(boolean r100) {
        this.f478549a.b();
    }

    public final void l(boolean r100) {
        this.f478549a.a();
    }

    public final void m(boolean r100) {
        this.f478549a.g();
    }

    @Override // fr2.s
    public final void M3(int r100, int r101) {
        this.f478549a.f();
    }
}
