package v43;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w33.f<y43.a> f553051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w33.f<x43.a> f553052b;

    @Override // v43.b
    public final w33.f<y43.a> a() {
        return this.f553051a;
    }

    @Override // v43.b
    public final w33.f<x43.a> g() {
        return this.f553052b;
    }

    public d(int r100) {
        w33.f<y43.a> r101 = new w33.f(new y43.a(false, false, false, false, 31));
        w33.f<x43.a> r102 = new w33.f(new x43.a(127));
        Intrinsics.checkNotNullParameter(r101, "loadingViewModel");
        Intrinsics.checkNotNullParameter(r102, "errorViewModel");
        this.f553051a = r101;
        this.f553052b = r102;
    }
}
