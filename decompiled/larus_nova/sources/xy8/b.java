package xy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f565417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f565418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f565419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f565420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f565421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f565422j;

    public b() {
        this(null, null, null, null, null, false, null, 0, 0, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f565413a, r101.f565413a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565414b, r101.f565414b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565415c, r101.f565415c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565416d, r101.f565416d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f565417e, r101.f565417e) == true) goto L24;
        return false;
    L24:
        if (this.f565418f == r101.f565418f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f565419g, r101.f565419g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f565420h, r101.f565420h) == true) goto L33;
        return false;
    L33:
        if (this.f565421i == r101.f565421i) goto L36;
        return false;
    L36:
        if (this.f565422j == r101.f565422j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f565413a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f565414b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f565415c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f565416d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f565417e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f565418f == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        String r118 = this.f565419g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f565420h;
        if (r121 == null) goto L35;
        r101 = r121.hashCode();
    L35:
        return ((((r120 + r101) * 31) + this.f565421i) * 31) + this.f565422j;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
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
        return "ImageContent(uri=" + this.f565413a + ", thumbUri=" + this.f565414b + ", originUri=" + this.f565415c + ", rawUri=" + this.f565416d + ", aiCreationImage=" + this.f565417e + ", noWatermarkSelected=" + this.f565418f + ", noWatermarkDownloadUri=" + this.f565419g + ", resourceKey=" + this.f565420h + ", width=" + this.f565421i + ", height=" + this.f565422j + ')';
    }

    public b(String r100, String r101, String r102, String r103, Boolean r104, boolean r105, String r110, int r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = false;
    L21:
        if ((r113 & 128) == 0) goto L24;
        r110 = null;
    L24:
        if ((r113 & 256) == 0) goto L27;
        r111 = 0;
    L27:
        if ((r113 & 512) == 0) goto L29;
        r112 = 0;
    L29:
        this.f565413a = r100;
        this.f565414b = r101;
        this.f565415c = r102;
        this.f565416d = r103;
        this.f565417e = r104;
        this.f565418f = r105;
        this.f565419g = null;
        this.f565420h = r110;
        this.f565421i = r111;
        this.f565422j = r112;
    }
}
