package jd1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements zt0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f498212a;

    public b(e r100) {
        this.f498212a = r100;
    }

    @Override // zt0.b
    public final void a(String r100) {
        jy0.b.d("GetDressInfoMethod", "fetchDressById " + r100 + " success. autoFetch " + this.f498212a.J6() + ", dressId " + r100);
    }

    @Override // zt0.b
    public final void b(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "version");
        jy0.b.d("GetDressInfoMethod", "fetchDressById " + r100 + " failed. autoFetch " + this.f498212a.J6() + ", dressId " + r100);
    }
}
