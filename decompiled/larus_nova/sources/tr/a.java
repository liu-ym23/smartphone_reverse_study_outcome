package tr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f547266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f547268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f547269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f547270e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f547266a == r101.f547266a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f547267b, r101.f547267b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f547268c, r101.f547268c) == true) goto L12;
        return false;
    L12:
        if (this.f547269d == r101.f547269d) goto L14;
        return false;
    L14:
        if (this.f547270e == r101.f547270e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f547266a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f547267b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f547268c;
        if (r106 == null) goto L9;
        r103 = r106.hashCode();
    L9:
        int r107 = (r105 + r103) * 31;
        long r108 = this.f547269d;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f547270e;
        return r109 + ((int) (r110 ^ (r110 >>> 32)));
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftInfo(giftId=" + this.f547266a + ", giftName=" + this.f547267b + ", giftIconUrl=" + this.f547268c + ", effectId=" + this.f547269d + ", duration=" + this.f547270e + ")";
    }

    public a(long r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r101, "giftName");
        Intrinsics.checkNotNullParameter(r102, "giftIconUrl");
        this.f547266a = r100;
        this.f547267b = r101;
        this.f547268c = r102;
        this.f547269d = r103;
        this.f547270e = 0;
    }
}
