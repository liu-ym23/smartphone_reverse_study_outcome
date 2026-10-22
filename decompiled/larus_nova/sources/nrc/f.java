package nrc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f520278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f520279e;

    public final int hashCode() {
        return (((((((this.f520275a.hashCode() * 31) + this.f520276b.hashCode()) * 31) + this.f520277c.hashCode()) * 31) + this.f520278d) * 31) + this.f520279e;
    }

    public final String toString() {
        return "LottieImageSpec(id='" + this.f520275a + "', path='" + this.f520276b + "', name='" + this.f520277c + "', width=" + this.f520278d + ", height=" + this.f520279e + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (f.class != r100.getClass()) goto L26;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f520275a, r101.f520275a) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f520276b, r101.f520276b) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.f520277c, r101.f520277c) == true) goto L20;
        return false;
    L20:
        if (this.f520278d == r101.f520278d) goto L23;
        return false;
    L23:
        if (this.f520279e == r101.f520279e) goto L25;
        return false;
    L25:
        return true;
    }

    public f(String r100, String r101, String r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "name");
        this.f520275a = r100;
        this.f520276b = r101;
        this.f520277c = r102;
        this.f520278d = r103;
        this.f520279e = r104;
    }
}
