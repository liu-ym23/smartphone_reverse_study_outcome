package ul9;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f550622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f550623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f550624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f550625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f550626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f550627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f550628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Pair<Integer, Integer> f550629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f550630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f550631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f550632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f550633l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f550622a, r101.f550622a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550623b, r101.f550623b) == true) goto L15;
        return false;
    L15:
        if (this.f550624c == r101.f550624c) goto L18;
        return false;
    L18:
        if (this.f550625d == r101.f550625d) goto L21;
        return false;
    L21:
        if (this.f550626e == r101.f550626e) goto L24;
        return false;
    L24:
        if (this.f550627f == r101.f550627f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f550628g, r101.f550628g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f550629h, r101.f550629h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f550630i, r101.f550630i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f550631j, r101.f550631j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f550632k, r101.f550632k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f550633l, r101.f550633l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.f550622a.hashCode() * 31) + this.f550623b.hashCode()) * 31) + this.f550624c) * 31) + this.f550625d) * 31) + this.f550626e) * 31) + this.f550627f) * 31) + this.f550628g.hashCode()) * 31) + this.f550629h.hashCode()) * 31;
        String r101 = this.f550630i;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f550631j;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f550632k;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f550633l;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaiduNaviRoutePlanParam(startPoint=" + this.f550622a + ", endPoint=" + this.f550623b + ", coordType=" + this.f550624c + ", reCoordType=" + this.f550625d + ", routePlanType=" + this.f550626e + ", routePrefer=" + this.f550627f + ", verbalMode=" + this.f550628g + ", guidanceRange=" + this.f550629h + ", startUid=" + this.f550630i + ", startName=" + this.f550631j + ", endUid=" + this.f550632k + ", endName=" + this.f550633l + ')';
    }

    public /* synthetic */ g(a r110, a r111, int r112, int r113, String r114, Pair r115, String r116, String r117, int r210) {
        if ((r210 & 1024) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r210 & 2048) == 0) goto L9;
        String r118 = null;
    L10:
        this(r110, r111, r112, r113, r114, r115, null, null, r100, r118);
        return;
    L9:
        r118 = r117;
        goto L10
    L5:
        r100 = r116;
        goto L7
    }

    public g(a r100, a r101, int r102, int r103, String r104, Pair r105, String r106, String r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "startPoint");
        Intrinsics.checkNotNullParameter(r101, "endPoint");
        Intrinsics.checkNotNullParameter(r104, "verbalMode");
        Intrinsics.checkNotNullParameter(r105, "guidanceRange");
        this.f550622a = r100;
        this.f550623b = r101;
        this.f550624c = 3;
        this.f550625d = 3;
        this.f550626e = r102;
        this.f550627f = r103;
        this.f550628g = r104;
        this.f550629h = r105;
        this.f550630i = r106;
        this.f550631j = r107;
        this.f550632k = r110;
        this.f550633l = r111;
    }
}
