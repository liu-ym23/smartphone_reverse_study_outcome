package u2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f548368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f548369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f548371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f548372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f548373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f548374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f548375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f548376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f548377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f548378k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f548368a, r101.f548368a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548369b, r101.f548369b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548370c, r101.f548370c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f548371d, r101.f548371d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f548372e, r101.f548372e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f548373f, r101.f548373f) == true) goto L27;
        return false;
    L27:
        if (this.f548374g == r101.f548374g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f548375h, r101.f548375h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f548376i, r101.f548376i) == true) goto L36;
        return false;
    L36:
        if (this.f548377j == r101.f548377j) goto L39;
        return false;
    L39:
        if (this.f548378k == r101.f548378k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f548368a.hashCode() * 31) + this.f548369b.hashCode()) * 31) + this.f548370c.hashCode()) * 31) + this.f548371d.hashCode()) * 31) + this.f548372e.hashCode()) * 31) + this.f548373f.hashCode()) * 31;
        int r101 = 1231;
        if (this.f548374g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f548375h.hashCode()) * 31) + this.f548376i.hashCode()) * 31;
        if (this.f548377j == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f548378k == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppletGrantingCardData(msgData=" + this.f548368a + ", grantingType=" + this.f548369b + ", icon=" + this.f548370c + ", sourceName=" + this.f548371d + ", title=" + this.f548372e + ", subTitle=" + this.f548373f + ", showOperateButton=" + this.f548374g + ", agreeTitle=" + this.f548375h + ", rejectedTitle=" + this.f548376i + ", agreeLoading=" + this.f548377j + ", rejectedLoading=" + this.f548378k + ')';
    }

    public static a a(a r110, boolean r111, boolean r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        b r101 = r110.f548368a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        h r102 = r110.f548369b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = r110.f548370c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r104 = r110.f548371d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r105 = r110.f548372e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        String r114 = r110.f548373f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        boolean r115 = r110.f548374g;
    L31:
        if ((r113 & 128) == 0) goto L33;
        String r116 = r110.f548375h;
    L35:
        if ((r113 & 256) == 0) goto L37;
        r100 = r110.f548376i;
    L37:
        String r117 = r100;
        if ((r113 & 512) == 0) goto L40;
        boolean r118 = r110.f548377j;
    L42:
        if ((r113 & 1024) == 0) goto L44;
        boolean r119 = r110.f548378k;
    L45:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "msgData");
        Intrinsics.checkNotNullParameter(r102, "grantingType");
        Intrinsics.checkNotNullParameter(r103, "icon");
        Intrinsics.checkNotNullParameter(r104, "sourceName");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r114, "subTitle");
        Intrinsics.checkNotNullParameter(r116, "agreeTitle");
        Intrinsics.checkNotNullParameter(r117, "rejectedTitle");
        return new a(r101, r102, r103, r104, r105, r114, r115, r116, r117, r118, r119);
    L44:
        r119 = r112;
        goto L45
    L40:
        r118 = r111;
        goto L42
    L33:
        r116 = null;
        goto L35
    L29:
        r115 = false;
        goto L31
    L25:
        r114 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public a(b r100, h r101, String r102, String r103, String r104, String r105, boolean r106, String r107, String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "msgData");
        Intrinsics.checkNotNullParameter(r101, "grantingType");
        Intrinsics.checkNotNullParameter(r102, "icon");
        Intrinsics.checkNotNullParameter(r103, "sourceName");
        Intrinsics.checkNotNullParameter(r104, "title");
        Intrinsics.checkNotNullParameter(r105, "subTitle");
        Intrinsics.checkNotNullParameter(r107, "agreeTitle");
        Intrinsics.checkNotNullParameter(r110, "rejectedTitle");
        this.f548368a = r100;
        this.f548369b = r101;
        this.f548370c = r102;
        this.f548371d = r103;
        this.f548372e = r104;
        this.f548373f = r105;
        this.f548374g = r106;
        this.f548375h = r107;
        this.f548376i = r110;
        this.f548377j = r111;
        this.f548378k = r112;
    }
}
