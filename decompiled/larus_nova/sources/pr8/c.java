package pr8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f530369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f530370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f530371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f530372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f530373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f530374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f530375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f530376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f530377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f530378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f530379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f530380n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f530367a, r101.f530367a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530368b, r101.f530368b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f530369c, r101.f530369c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f530370d, r101.f530370d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f530371e, r101.f530371e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f530372f, r101.f530372f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f530373g, r101.f530373g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f530374h, r101.f530374h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f530375i, r101.f530375i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f530376j, r101.f530376j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f530377k, r101.f530377k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f530378l, r101.f530378l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f530379m, r101.f530379m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f530380n, r101.f530380n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f530367a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f530368b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f530369c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f530370d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f530371e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f530372f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f530373g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f530374h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f530375i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f530376j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f530377k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f530378l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f530379m;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f530380n;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
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
        return "SearchMixedMediaCardInput(itemId=" + this.f530367a + ", coverUrl=" + this.f530368b + ", coverWidth=" + this.f530369c + ", coverHeight=" + this.f530370d + ", itemType=" + this.f530371e + ", description=" + this.f530372f + ", avatarUrl=" + this.f530373g + ", userName=" + this.f530374h + ", liked=" + this.f530375i + ", likedCountText=" + this.f530376j + ", requestId=" + this.f530377k + ", recChannelId=" + this.f530378l + ", bizTag=" + this.f530379m + ", messageId=" + this.f530380n + ')';
    }

    public c(String r100, String r101, Integer r102, Integer r103, Integer r104, String r105, String r106, String r107, Boolean r108, String r110, String r111, Integer r112, String r113, String r114) {
        this.f530367a = r100;
        this.f530368b = r101;
        this.f530369c = r102;
        this.f530370d = r103;
        this.f530371e = r104;
        this.f530372f = r105;
        this.f530373g = r106;
        this.f530374h = r107;
        this.f530375i = r108;
        this.f530376j = r110;
        this.f530377k = r111;
        this.f530378l = r112;
        this.f530379m = r113;
        this.f530380n = r114;
    }
}
