package com.bytedance.ug.sdk.luckycat.impl.manager;

/* JADX INFO: loaded from: classes22.dex */
public final class o implements hn7.b<zl7.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f271353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f271354b;

    @Override // hn7.b
    public final void a(hn7.a r100) {
        zl7.i r101 = (zl7.i) r100;
        if (r101 == null) goto L6;
        r101.c0(this.f271353a, this.f271354b);
        return;
    }

    public o(long r100, long r101) {
        this.f271353a = r100;
        this.f271354b = r101;
    }
}
