package fr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h1 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uf2.z.a f478507a;

    @Override // fr2.l
    public final z1 Y() {
        uf2.m1.b r100 = this.f478507a.Y();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new z1(r100);
    }

    public final String b() {
        String r100 = this.f478507a.name();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final void e() {
        this.f478507a.pause();
    }

    public final int getHeight() {
        return this.f478507a.getHeight();
    }

    public final int getWidth() {
        return this.f478507a.getWidth();
    }

    public final void l() {
        this.f478507a.resume();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("MainLayer{");
        r100.append("w=" + getWidth() + ",h=" + getHeight());
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478507a;
    }

    public h1(uf2.z.a r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478507a = r100;
    }

    @Override // fr2.l
    public final void Y4(k0 r100) {
        if ((r100 instanceof z1) == true) goto L5;
        r100 = null;
    L5:
        z1 r101 = (z1) r100;
        this.f478507a.b();
    }
}
