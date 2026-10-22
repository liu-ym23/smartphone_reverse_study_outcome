package w56;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f558340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f558344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f558345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f558346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f558347h;

    public a() {
        this(0, null, null, null, null, 0, null, 255, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f558340a == r101.f558340a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558341b, r101.f558341b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558342c, r101.f558342c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558343d, r101.f558343d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558344e, r101.f558344e) == true) goto L24;
        return false;
    L24:
        if (this.f558345f == r101.f558345f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f558346g, r101.f558346g) == true) goto L30;
        return false;
    L30:
        if (this.f558347h == r101.f558347h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f558340a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f558341b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f558342c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f558343d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f558344e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (((r111 + r113) * 31) + this.f558345f) * 31;
        String r115 = this.f558346g;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        return ((r114 + r103) * 31) + this.f558347h;
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
        return "CalendarModel(id=" + this.f558340a + ", name=" + this.f558341b + ", displayName=" + this.f558342c + ", accountType=" + this.f558343d + ", accountName=" + this.f558344e + ", visible=" + this.f558345f + ", ownerAccount=" + this.f558346g + ", accessLevel=" + this.f558347h + ')';
    }

    public a(long r100, String r101, String r102, String r103, String r104, int r105, String r106, int r107) {
        this.f558340a = r100;
        this.f558341b = r101;
        this.f558342c = r102;
        this.f558343d = r103;
        this.f558344e = r104;
        this.f558345f = r105;
        this.f558346g = r106;
        this.f558347h = r107;
    }

    public /* synthetic */ a(long r110, String r111, String r112, String r113, String r114, int r115, String r116, int r210, int r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = 0;
    L6:
        String r101 = null;
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L22:
        int r106 = 0;
        if ((r210 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r210 & 64) != 0) goto L31;
        r101 = r116;
    L31:
        if ((r210 & 128) == 0) goto L33;
        r106 = -1;
    L33:
        this(r100, r102, r103, r104, r105, r107, r101, r106);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
