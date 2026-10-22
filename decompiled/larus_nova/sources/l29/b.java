package l29;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f507163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f507164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f507165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f507166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f507167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f507168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f507169h;

    public b() {
        this(null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f507162a, r101.f507162a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f507163b, r101.f507163b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f507164c, r101.f507164c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f507165d, r101.f507165d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f507166e, r101.f507166e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f507167f, r101.f507167f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f507168g, r101.f507168g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f507169h, r101.f507169h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f507162a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f507163b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f507164c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f507165d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f507166e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f507167f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f507168g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f507169h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "CreationNewUserLandingTrackParams(currentPage=" + this.f507162a + ", recommendFrom=" + this.f507163b + ", botId=" + this.f507164c + ", conversationId=" + this.f507165d + ", chatType=" + this.f507166e + ", previousPage=" + this.f507167f + ", enterMethod=" + this.f507168g + ", aiCreationRecommendFrom=" + this.f507169h + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        this.f507162a = null;
        this.f507163b = r100;
        this.f507164c = r101;
        this.f507165d = r102;
        this.f507166e = r103;
        this.f507167f = r104;
        this.f507168g = r105;
        this.f507169h = null;
    }
}
