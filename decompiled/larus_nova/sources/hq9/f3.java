package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f486590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f486591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f486592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f486593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f486594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f486595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f486596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f486597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f486598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f486599l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f486600m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f486601n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f486602o;

    public f3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f3) == true) goto L8;
        return false;
    L8:
        f3 r101 = (f3) r100;
        if (this.f486588a == r101.f486588a) goto L12;
        return false;
    L12:
        if (this.f486589b == r101.f486589b) goto L15;
        return false;
    L15:
        if (this.f486590c == r101.f486590c) goto L18;
        return false;
    L18:
        if (this.f486591d == r101.f486591d) goto L21;
        return false;
    L21:
        if (this.f486592e == r101.f486592e) goto L24;
        return false;
    L24:
        if (this.f486593f == r101.f486593f) goto L27;
        return false;
    L27:
        if (this.f486594g == r101.f486594g) goto L30;
        return false;
    L30:
        if (this.f486595h == r101.f486595h) goto L33;
        return false;
    L33:
        if (this.f486596i == r101.f486596i) goto L36;
        return false;
    L36:
        if (this.f486597j == r101.f486597j) goto L39;
        return false;
    L39:
        if (this.f486598k == r101.f486598k) goto L42;
        return false;
    L42:
        if (this.f486599l == r101.f486599l) goto L45;
        return false;
    L45:
        if (this.f486600m == r101.f486600m) goto L48;
        return false;
    L48:
        if (this.f486601n == r101.f486601n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f486602o, r101.f486602o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486588a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486589b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((((r102 + r103) * 31) + this.f486590c) * 31) + this.f486591d) * 31) + this.f486592e) * 31;
        if (this.f486593f == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f486594g == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f486595h == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f486596i == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f486597j == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (((r112 + r113) * 31) + this.f486598k) * 31;
        if (this.f486599l == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.f486600m == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (r116 + r117) * 31;
        if (this.f486601n == true) goto L42;
        r100 = 1237;
    L42:
        int r119 = (r118 + r100) * 31;
        String r120 = this.f486602o;
        if (r120 != null) goto L45;
        int r121 = 0;
    L47:
        return r119 + r121;
    L45:
        r121 = r120.hashCode();
        goto L47
    L37:
        r117 = 1237;
        goto L38
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownOptimizeConfig(isDisableLatexSplit=" + this.f486588a + ", isLatexSplitOptimize=" + this.f486589b + ", drawableLruCacheSize=" + this.f486590c + ", botAutoLinkMaxLimit=" + this.f486591d + ", userAutoLinkMaxLimit=" + this.f486592e + ", enableMarkdownNewCodeStyle=" + this.f486593f + ", markdownCodeRenderAsync=" + this.f486594g + ", htmlNameEntityOptimize=" + this.f486595h + ", enableMarkdownCodeDefaultScroll=" + this.f486596i + ", enableUseLatexBitmapCache=" + this.f486597j + ", latexBitmapCacheSize=" + this.f486598k + ", enableOptimizeWidgetCompare=" + this.f486599l + ", isDisableMentionLinkify=" + this.f486600m + ", enableIncrementalTextNode=" + this.f486601n + ", incrementalNodeSyntaxChars=" + this.f486602o + ')';
    }

    public /* synthetic */ f3(int r110) {
        this(false, false, 20, -1, -1, false, false, false, false, false, 0, false, false, false, null);
    }

    public f3(boolean r100, boolean r101, int r102, int r103, int r104, boolean r105, boolean r106, boolean r107, boolean r108, boolean r110, int r111, boolean r112, boolean r113, boolean r114, String r115) {
        this.f486588a = r100;
        this.f486589b = r101;
        this.f486590c = r102;
        this.f486591d = r103;
        this.f486592e = r104;
        this.f486593f = r105;
        this.f486594g = r106;
        this.f486595h = r107;
        this.f486596i = r108;
        this.f486597j = r110;
        this.f486598k = r111;
        this.f486599l = r112;
        this.f486600m = r113;
        this.f486601n = r114;
        this.f486602o = r115;
    }
}
