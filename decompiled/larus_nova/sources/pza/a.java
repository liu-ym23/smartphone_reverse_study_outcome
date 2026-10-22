package pza;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f531134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f531135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f531136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f531137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f531138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f531139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f531140g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f531134a == r101.f531134a) goto L12;
        return false;
    L12:
        if (this.f531135b == r101.f531135b) goto L15;
        return false;
    L15:
        if (this.f531136c == r101.f531136c) goto L18;
        return false;
    L18:
        if (this.f531137d == r101.f531137d) goto L21;
        return false;
    L21:
        if (this.f531138e == r101.f531138e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f531139f, r101.f531139f) == true) goto L27;
        return false;
    L27:
        if (this.f531140g == r101.f531140g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f531134a;
        int r101 = ((((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f531135b) * 31) + this.f531136c) * 31) + this.f531137d) * 31) + this.f531138e) * 31) + this.f531139f.hashCode()) * 31;
        long r102 = this.f531140g;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "HumanFeedsDisplayItem(timestamp=" + this.f531134a + ", badgeCount=" + this.f531135b + ", badgeCountWithoutDoubao=" + this.f531136c + ", badgeCountWithoutDoubaoOnTop=" + this.f531137d + ", badgeCountWithoutDoubaoNotOnTop=" + this.f531138e + ", description=" + this.f531139f + ", version=" + this.f531140g + ')';
    }

    public a(long r100, int r101, int r102, int r103, int r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r105, "description");
        this.f531134a = r100;
        this.f531135b = r101;
        this.f531136c = r102;
        this.f531137d = r103;
        this.f531138e = r104;
        this.f531139f = r105;
        this.f531140g = r106;
    }
}
