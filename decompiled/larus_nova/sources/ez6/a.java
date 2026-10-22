package ez6;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<String, String> f474890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pair<String, String> f474891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pair<String, String> f474892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Pair<String, String> f474893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f474894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474895f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f474890a, r101.f474890a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474891b, r101.f474891b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474892c, r101.f474892c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474893d, r101.f474893d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474894e, r101.f474894e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474895f, r101.f474895f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f474890a.hashCode() * 31) + this.f474891b.hashCode()) * 31) + this.f474892c.hashCode()) * 31) + this.f474893d.hashCode()) * 31) + this.f474894e.hashCode()) * 31) + this.f474895f.hashCode();
    }

    public final String toString() {
        return "FilterData(floor=" + this.f474890a + ", category=" + this.f474891b + ", subCategory=" + this.f474892c + ", sort=" + this.f474893d + ", filterSessionId=" + this.f474894e + ", pageSessionId=" + this.f474895f + ')';
    }

    public a(Pair<String, String> r100, Pair<String, String> r101, Pair<String, String> r102, Pair<String, String> r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "floor");
        Intrinsics.checkNotNullParameter(r101, "category");
        Intrinsics.checkNotNullParameter(r102, "subCategory");
        Intrinsics.checkNotNullParameter(r103, "sort");
        Intrinsics.checkNotNullParameter(r104, "filterSessionId");
        Intrinsics.checkNotNullParameter(r105, "pageSessionId");
        this.f474890a = r100;
        this.f474891b = r101;
        this.f474892c = r102;
        this.f474893d = r103;
        this.f474894e = r104;
        this.f474895f = r105;
    }
}
