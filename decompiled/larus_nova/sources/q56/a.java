package q56;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f531737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f531739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f531740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f531741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f531742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f531743g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f531737a == r101.f531737a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f531738b, r101.f531738b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f531739c, r101.f531739c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f531740d, r101.f531740d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f531741e, r101.f531741e) == true) goto L24;
        return false;
    L24:
        if (this.f531742f == r101.f531742f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f531743g, r101.f531743g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f531737a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f531738b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f531739c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f531740d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f531741e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (((r111 + r113) * 31) + this.f531742f) * 31;
        String r115 = this.f531743g;
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
        return "CalendarModel(id=" + this.f531737a + ", name=" + this.f531738b + ", displayName=" + this.f531739c + ", accountType=" + this.f531740d + ", accountName=" + this.f531741e + ", visible=" + this.f531742f + ", ownerAccount=" + this.f531743g + ')';
    }

    public a() {
        this(0, null, null, null, null, 0, null);
    }

    public a(long r100, String r101, String r102, String r103, String r104, int r105, String r106) {
        this.f531737a = r100;
        this.f531738b = r101;
        this.f531739c = r102;
        this.f531740d = r103;
        this.f531741e = r104;
        this.f531742f = r105;
        this.f531743g = r106;
    }
}
