package w66;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f558427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f558431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f558432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f558433g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f558427a == r101.f558427a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558428b, r101.f558428b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558429c, r101.f558429c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558430d, r101.f558430d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558431e, r101.f558431e) == true) goto L24;
        return false;
    L24:
        if (this.f558432f == r101.f558432f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f558433g, r101.f558433g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f558427a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f558428b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f558429c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f558430d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f558431e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (((r111 + r113) * 31) + this.f558432f) * 31;
        String r115 = this.f558433g;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        return r114 + r103;
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "CalendarModel(id=" + this.f558427a + ", name=" + this.f558428b + ", displayName=" + this.f558429c + ", accountType=" + this.f558430d + ", accountName=" + this.f558431e + ", visible=" + this.f558432f + ", ownerAccount=" + this.f558433g + ')';
    }

    public a() {
        this(0, null, null, null, null, 0, null);
    }

    public a(long r100, String r101, String r102, String r103, String r104, int r105, String r106) {
        this.f558427a = r100;
        this.f558428b = r101;
        this.f558429c = r102;
        this.f558430d = r103;
        this.f558431e = r104;
        this.f558432f = r105;
        this.f558433g = r106;
    }
}
