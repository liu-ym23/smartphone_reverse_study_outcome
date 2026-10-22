package ebc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f471986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f471987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f471988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f471989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f471990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f471991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f471992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f471993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f471994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f471995j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f471986a == r101.f471986a) goto L12;
        return false;
    L12:
        if (this.f471987b == r101.f471987b) goto L15;
        return false;
    L15:
        if (Float.compare(this.f471988c, r101.f471988c) == 0) goto L18;
        return false;
    L18:
        if (this.f471989d == r101.f471989d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f471990e, r101.f471990e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f471991f, r101.f471991f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f471992g, r101.f471992g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f471993h, r101.f471993h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f471994i, r101.f471994i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f471995j, r101.f471995j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f471986a * 31;
        int r101 = 1231;
        if (this.f471987b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + Float.floatToIntBits(this.f471988c)) * 31;
        if (this.f471989d == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        Integer r105 = this.f471990e;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        Integer r109 = this.f471991f;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Integer r112 = this.f471992g;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.f471993h;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.f471994i;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.f471995j;
        if (r121 == null) goto L35;
        r106 = r121.hashCode();
    L35:
        return r120 + r106;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommonButtonVoiceConfig(textRes=" + this.f471986a + ", enableTextMode=" + this.f471987b + ", textSizeSp=" + this.f471988c + ", isTextBold=" + this.f471989d + ", buttonHeight=" + this.f471990e + ", buttonHorizontalPadding=" + this.f471991f + ", buttonVerticalPadding=" + this.f471992g + ", buttonTopMargin=" + this.f471993h + ", buttonCornerRadiusPx=" + this.f471994i + ", backgroundColor=" + this.f471995j + ')';
    }

    public /* synthetic */ a(int r110, boolean r111, float r112, boolean r113, Integer r114, Integer r210, Integer r211, int r212) {
        if ((r212 & 2) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r212 & 8) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r212 & 16) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r212 & 64) == 0) goto L17;
        Integer r115 = null;
    L19:
        if ((r212 & 128) == 0) goto L21;
        Integer r116 = null;
    L22:
        this(r110, r100, r112, r101, r102, null, r115, r116, null, null);
        return;
    L21:
        r116 = r211;
        goto L22
    L17:
        r115 = r210;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public a(int r100, boolean r101, float r102, boolean r103, Integer r104, Integer r105, Integer r106, Integer r107, Integer r108, Integer r110) {
        this.f471986a = r100;
        this.f471987b = r101;
        this.f471988c = r102;
        this.f471989d = r103;
        this.f471990e = r104;
        this.f471991f = r105;
        this.f471992g = r106;
        this.f471993h = r107;
        this.f471994i = r108;
        this.f471995j = r110;
    }
}
