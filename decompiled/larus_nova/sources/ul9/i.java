package ul9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f550634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f550636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f550637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f550638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f550639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f550640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f550641h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f550634a == r101.f550634a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550635b, r101.f550635b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f550636c, r101.f550636c) == true) goto L18;
        return false;
    L18:
        if (this.f550637d == r101.f550637d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f550638e, r101.f550638e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f550639f, r101.f550639f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f550640g, r101.f550640g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f550641h, r101.f550641h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f550634a * 31;
        String r101 = this.f550635b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f550636c.hashCode()) * 31) + this.f550637d) * 31;
        String r105 = this.f550638e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        a r108 = this.f550639f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f550640g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        e r114 = this.f550641h;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "BaiduNaviUpdate(status=" + this.f550634a + ", message=" + this.f550635b + ", sessionId=" + this.f550636c + ", routePlanType=" + this.f550637d + ", routeId=" + this.f550638e + ", mmLocation=" + this.f550639f + ", mmDirection=" + this.f550640g + ", route=" + this.f550641h + ')';
    }

    public i(int r100, String r101, String r102, int r103, String r104, a r105, Integer r106, e r107) {
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        this.f550634a = r100;
        this.f550635b = r101;
        this.f550636c = r102;
        this.f550637d = r103;
        this.f550638e = r104;
        this.f550639f = r105;
        this.f550640g = r106;
        this.f550641h = r107;
    }
}
