package ky8;

import com.larus.platform.api.creation.UserCreationFromIM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f506663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f506665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f506668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f506669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f506670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f506671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f506672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f506673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f506674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f506675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final UserCreationFromIM f506676o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f506677p;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f506662a, r101.f506662a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506663b, r101.f506663b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506664c, r101.f506664c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506665d, r101.f506665d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506666e, r101.f506666e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506667f, r101.f506667f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506668g, r101.f506668g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f506669h, r101.f506669h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f506670i, r101.f506670i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f506671j, r101.f506671j) == true) goto L39;
        return false;
    L39:
        if (this.f506672k == r101.f506672k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f506673l, r101.f506673l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f506674m, r101.f506674m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f506675n, r101.f506675n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f506676o, r101.f506676o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f506677p, r101.f506677p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506662a.hashCode() * 31;
        Long r101 = this.f506663b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f506664c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f506665d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f506666e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((((r110 + r112) * 31) + this.f506667f.hashCode()) * 31) + this.f506668g.hashCode()) * 31;
        String r114 = this.f506669h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f506670i;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.f506671j;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((r119 + r121) * 31) + this.f506672k) * 31;
        String r123 = this.f506673l;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Long r126 = this.f506674m;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f506675n;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        UserCreationFromIM r132 = this.f506676o;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f506677p;
        if (r135 == null) goto L51;
        r102 = r135.hashCode();
    L51:
        return r134 + r102;
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasGalleryDataItem(localId=" + this.f506662a + ", canvasId=" + this.f506663b + ", taskId=" + this.f506664c + ", canvasSubId=" + this.f506665d + ", canvasSubReplyId=" + this.f506666e + ", downloadUrl=" + this.f506667f + ", previewUrl=" + this.f506668g + ", thumbUrl=" + this.f506669h + ", width=" + this.f506670i + ", height=" + this.f506671j + ", position=" + this.f506672k + ", imageEditFunctionId=" + this.f506673l + ", createTime=" + this.f506674m + ", prompt=" + this.f506675n + ", creation=" + this.f506676o + ", messageId=" + this.f506677p + ')';
    }

    public a(String r100, Long r101, String r102, Long r103, String r110, String r111, String r112, String r113, Integer r114, Integer r115, int r116, String r117, Long r118, String r119, UserCreationFromIM r210, String r211) {
        Intrinsics.checkNotNullParameter(r100, "localId");
        Intrinsics.checkNotNullParameter(r111, "downloadUrl");
        Intrinsics.checkNotNullParameter(r112, "previewUrl");
        this.f506662a = r100;
        this.f506663b = r101;
        this.f506664c = r102;
        this.f506665d = r103;
        this.f506666e = r110;
        this.f506667f = r111;
        this.f506668g = r112;
        this.f506669h = r113;
        this.f506670i = r114;
        this.f506671j = r115;
        this.f506672k = r116;
        this.f506673l = r117;
        this.f506674m = r118;
        this.f506675n = r119;
        this.f506676o = r210;
        this.f506677p = r211;
    }
}
