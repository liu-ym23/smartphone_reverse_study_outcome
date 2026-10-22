package jl8;

import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolViewStage;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f499542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f499543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GenericToolViewStage f499544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pair<Integer, Integer> f499545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f499546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f499547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f499548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f499549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f499550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f499551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f499552l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f499553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f499554n;

    public f() {
        this(null, null, null, null, null, null, 0, null, false, false, false, 0, 0, 0, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f499541a, r101.f499541a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499542b, r101.f499542b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f499543c, r101.f499543c) == true) goto L18;
        return false;
    L18:
        if (this.f499544d == r101.f499544d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f499545e, r101.f499545e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f499546f, r101.f499546f) == true) goto L27;
        return false;
    L27:
        if (this.f499547g == r101.f499547g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f499548h, r101.f499548h) == true) goto L33;
        return false;
    L33:
        if (this.f499549i == r101.f499549i) goto L36;
        return false;
    L36:
        if (this.f499550j == r101.f499550j) goto L39;
        return false;
    L39:
        if (this.f499551k == r101.f499551k) goto L42;
        return false;
    L42:
        if (this.f499552l == r101.f499552l) goto L45;
        return false;
    L45:
        if (this.f499553m == r101.f499553m) goto L48;
        return false;
    L48:
        if (this.f499554n == r101.f499554n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f499541a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f499542b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f499543c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f499544d.hashCode()) * 31;
        Pair<Integer, Integer> r110 = this.f499545e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f499546f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.f499547g) * 31;
        Integer r116 = this.f499548h;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        int r118 = 1231;
        if (this.f499549i == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r117 + r119) * 31;
        if (this.f499550j == false) goto L33;
        int r121 = 1231;
    L34:
        int r122 = (r120 + r121) * 31;
        if (this.f499551k == true) goto L39;
        r118 = 1237;
    L39:
        return ((((((r122 + r118) * 31) + this.f499552l) * 31) + this.f499553m) * 31) + this.f499554n;
    L33:
        r121 = 1237;
        goto L34
    L29:
        r119 = 1237;
        goto L30
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
        return "GenericToolViewInput(iconUrl=" + this.f499541a + ", iconUrlDark=" + this.f499542b + ", title=" + this.f499543c + ", stage=" + this.f499544d + ", topAndBottomMarginPair=" + this.f499545e + ", messageId=" + this.f499546f + ", cardPosition=" + this.f499547g + ", backgroundRes=" + this.f499548h + ", showArrow=" + this.f499549i + ", arrowExpanded=" + this.f499550j + ", iconRoundAsCircle=" + this.f499551k + ", iconSize=" + this.f499552l + ", iconStartPadding=" + this.f499553m + ", iconTitleSpacing=" + this.f499554n + ')';
    }

    public f(String r110, String r111, String r112, GenericToolViewStage r210, Pair r211, String r212, int r213, Integer r214, boolean r215, boolean r216, boolean r217, int r218, int r219, int r310, int r311) {
        Integer r100 = null;
        if ((r311 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r311 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        GenericToolViewStage r104 = GenericToolViewStage.LOADING;
    L19:
        if ((r311 & 16) == 0) goto L21;
        Pair r105 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        String r106 = null;
    L26:
        int r113 = 0;
        if ((r311 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r311 & 128) != 0) goto L35;
        r100 = r214;
    L35:
        if ((r311 & 256) == 0) goto L37;
        boolean r114 = false;
    L39:
        if ((r311 & 512) == 0) goto L41;
        boolean r115 = false;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        boolean r116 = false;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        int r117 = i5.E();
    L51:
        if ((r311 & 4096) != 0) goto L55;
        r113 = r219;
    L55:
        if ((r311 & 8192) == 0) goto L57;
        int r108 = i5.Y();
    L58:
        Intrinsics.checkNotNullParameter(r104, "stage");
        this.f499541a = r101;
        this.f499542b = r102;
        this.f499543c = r103;
        this.f499544d = r104;
        this.f499545e = r105;
        this.f499546f = r106;
        this.f499547g = r107;
        this.f499548h = r100;
        this.f499549i = r114;
        this.f499550j = r115;
        this.f499551k = r116;
        this.f499552l = r117;
        this.f499553m = r113;
        this.f499554n = r108;
        return;
    L57:
        r108 = r310;
        goto L58
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L26
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
