package is0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f495583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f495584d;

    @Override // is0.b
    public final int a() {
        return this.f495583c;
    }

    @Override // is0.b
    public final String b() {
        return this.f495582b;
    }

    @Override // is0.b
    public final T c() {
        return this.f495584d;
    }

    public d(String r100, int r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "_feature");
        Intrinsics.checkNotNullParameter(r102, "_value");
        this.f495582b = r100;
        this.f495583c = r101;
        this.f495584d = r102;
    }
}
