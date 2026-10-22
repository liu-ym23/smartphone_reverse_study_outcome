package id8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f489392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f489393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f489394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Float f489395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f489396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f489397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f489398i;

    public h() {
        this(null, null, null, null, "", null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f489390a, r101.f489390a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489391b, r101.f489391b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489392c, r101.f489392c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489393d, r101.f489393d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489394e, r101.f489394e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489395f, r101.f489395f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f489396g, r101.f489396g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f489397h, r101.f489397h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f489398i, r101.f489398i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f489390a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f489391b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.f489392c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f489393d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f489394e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.f489395f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f489396g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f489397h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f489398i;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "ImmutableVideoExtension(vid=" + this.f489390a + ", path=" + this.f489391b + ", cover=" + this.f489392c + ", format=" + this.f489393d + ", downloadUrl=" + this.f489394e + ", duration=" + this.f489395f + ", height=" + this.f489396g + ", width=" + this.f489397h + ", source=" + this.f489398i + ')';
    }

    public h(String r100, String r101, a r102, String r103, String r104, Float r105, Integer r106, Integer r107, String r108) {
        this.f489390a = r100;
        this.f489391b = r101;
        this.f489392c = r102;
        this.f489393d = r103;
        this.f489394e = r104;
        this.f489395f = r105;
        this.f489396g = r106;
        this.f489397h = r107;
        this.f489398i = r108;
    }
}
