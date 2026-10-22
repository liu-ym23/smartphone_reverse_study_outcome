package hn8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f486141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f486145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f486146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f486147g;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f486141a, r101.f486141a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486142b, r101.f486142b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486143c, r101.f486143c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486144d, r101.f486144d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486145e, r101.f486145e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f486146f, r101.f486146f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f486147g, r101.f486147g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f486141a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f486142b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f486143c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f486144d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f486145e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f486146f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f486147g;
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
        return "VideoCardData(id=" + this.f486141a + ", itemId=" + this.f486142b + ", hostPageUrl=" + this.f486143c + ", sourceAppIcon=" + this.f486144d + ", sourceAppIconV2=" + this.f486145e + ", albumImage=" + this.f486146f + ", videoDescription=" + this.f486147g + ')';
    }

    public j(Long r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.f486141a = r100;
        this.f486142b = r101;
        this.f486143c = r102;
        this.f486144d = r103;
        this.f486145e = r104;
        this.f486146f = r105;
        this.f486147g = r106;
    }
}
