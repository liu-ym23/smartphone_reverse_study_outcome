package j53;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f497450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f497451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f497452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f497453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f497454e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f497450a, r101.f497450a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f497451b, r101.f497451b) == true) goto L10;
        return false;
    L10:
        if (this.f497452c == r101.f497452c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f497453d, r101.f497453d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f497454e, r101.f497454e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f497450a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f497451b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f497452c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f497453d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f497454e;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AuctionOfferRecordItem(userName=" + this.f497450a + ", avatar=" + this.f497451b + ", priceInFen=" + this.f497452c + ", time=" + this.f497453d + ", status=" + this.f497454e + ")";
    }

    public a(String r100, String r101, long r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "userName");
        Intrinsics.checkNotNullParameter(r101, "avatar");
        Intrinsics.checkNotNullParameter(r103, "time");
        Intrinsics.checkNotNullParameter(r104, "status");
        this.f497450a = r100;
        this.f497451b = r101;
        this.f497452c = r102;
        this.f497453d = r103;
        this.f497454e = r104;
    }
}
