package gs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f482455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f482456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f482457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f482458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f482459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f482460g;

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f482454a, r101.f482454a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f482455b, r101.f482455b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f482456c, r101.f482456c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f482457d, r101.f482457d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f482458e, r101.f482458e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f482459f, r101.f482459f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f482460g, r101.f482460g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f482454a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f482455b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f482456c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f482457d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f482458e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f482459f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f482460g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationEnterFromTrackParams(detailPageName=" + this.f482454a + ", recommendFrom=" + this.f482455b + ", isSearchCard=" + this.f482456c + ", enterMethod=" + this.f482457d + ", enterFrom=" + this.f482458e + ", conversationId=" + this.f482459f + ", aiCreationRecommendFrom=" + this.f482460g + ')';
    }

    public /* synthetic */ b(String r110, Boolean r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        Boolean r101 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        String r102 = null;
    L14:
        this(r100, null, r101, r102, null, null, null);
        return;
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, Boolean r102, String r103, String r104, String r105, String r106) {
        this.f482454a = r100;
        this.f482455b = r101;
        this.f482456c = r102;
        this.f482457d = r103;
        this.f482458e = r104;
        this.f482459f = r105;
        this.f482460g = r106;
    }
}
