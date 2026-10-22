package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f465835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f465836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f465837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f465838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f465839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f465840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f465841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f465842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f465843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f465844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f465845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f465846m;

    public i() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f465834a, r101.f465834a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465835b, r101.f465835b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465836c, r101.f465836c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465837d, r101.f465837d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465838e, r101.f465838e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465839f, r101.f465839f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465840g, r101.f465840g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f465841h, r101.f465841h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f465842i, r101.f465842i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f465843j, r101.f465843j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f465844k, r101.f465844k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f465845l, r101.f465845l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f465846m, r101.f465846m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465834a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        j r104 = this.f465835b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        j r107 = this.f465836c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        j r110 = this.f465837d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        j r113 = this.f465838e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        j r116 = this.f465839f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        j r119 = this.f465840g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f465841h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f465842i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f465843j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f465844k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f465845l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f465846m;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
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
        return "CanvasImageData(key=" + this.f465834a + ", imageThumb=" + this.f465835b + ", imageOrigin=" + this.f465836c + ", imagePreview=" + this.f465837d + ", imageThumbRaw=" + this.f465838e + ", imageOriRaw=" + this.f465839f + ", imagePreviewResize=" + this.f465840g + ", status=" + this.f465841h + ", tips=" + this.f465842i + ", feedback=" + this.f465843j + ", requestId=" + this.f465844k + ", taskId=" + this.f465845l + ", imageUri=" + this.f465846m + ')';
    }

    public i(String r100, j r101, j r102, j r103, j r104, j r105, j r106, Integer r107, String r108, String r110, String r111, String r112, String r113) {
        this.f465834a = r100;
        this.f465835b = r101;
        this.f465836c = r102;
        this.f465837d = r103;
        this.f465838e = r104;
        this.f465839f = r105;
        this.f465840g = r106;
        this.f465841h = r107;
        this.f465842i = r108;
        this.f465843j = r110;
        this.f465844k = r111;
        this.f465845l = r112;
        this.f465846m = r113;
    }
}
