package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class y1 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uf2.l1 f478560a;

    @Override // xh6.c
    public final Object getReal() {
        return this.f478560a;
    }

    public y1(uf2.l1 r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478560a = r100;
    }

    @Override // fr2.w
    public final void e0(String r100, String r101) {
        this.f478560a.a();
    }
}
