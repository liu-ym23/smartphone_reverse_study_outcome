package i42;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f488204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f488205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f488206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f488207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f488208e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f488204a == r101.f488204a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f488205b, r101.f488205b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f488206c, r101.f488206c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488207d, r101.f488207d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f488208e, r101.f488208e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f488204a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f488205b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f488206c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f488207d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Long r112 = this.f488208e;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return r111 + r103;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "MicroAppPinContent(msgId=" + this.f488204a + ", commenterId=" + this.f488205b + ", miniAppId=" + this.f488206c + ", miniAppSchema=" + this.f488207d + ", microAppPinId=" + this.f488208e + ")";
    }

    public a(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "commenterId");
        this.f488204a = r100;
        this.f488205b = r101;
        this.f488206c = r102;
        this.f488207d = r103;
        this.f488208e = null;
    }
}
