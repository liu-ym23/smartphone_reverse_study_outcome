package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f486570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f486572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f486573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f486574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f486575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f486576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f486577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f486578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f486579k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f486580l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f486581m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f486582n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f486583o;

    public e3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e3) == true) goto L8;
        return false;
    L8:
        e3 r101 = (e3) r100;
        if (this.f486569a == r101.f486569a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486570b, r101.f486570b) == true) goto L15;
        return false;
    L15:
        if (this.f486571c == r101.f486571c) goto L18;
        return false;
    L18:
        if (this.f486572d == r101.f486572d) goto L21;
        return false;
    L21:
        if (this.f486573e == r101.f486573e) goto L24;
        return false;
    L24:
        if (this.f486574f == r101.f486574f) goto L27;
        return false;
    L27:
        if (this.f486575g == r101.f486575g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f486576h, r101.f486576h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f486577i, r101.f486577i) == true) goto L36;
        return false;
    L36:
        if (this.f486578j == r101.f486578j) goto L39;
        return false;
    L39:
        if (this.f486579k == r101.f486579k) goto L42;
        return false;
    L42:
        if (this.f486580l == r101.f486580l) goto L45;
        return false;
    L45:
        if (this.f486581m == r101.f486581m) goto L48;
        return false;
    L48:
        if (this.f486582n == r101.f486582n) goto L51;
        return false;
    L51:
        if (this.f486583o == r101.f486583o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486569a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        List<String> r103 = this.f486570b;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.f486571c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((((((((r106 + r107) * 31) + this.f486572d) * 31) + this.f486573e) * 31) + this.f486574f) * 31) + this.f486575g) * 31;
        String r109 = this.f486576h;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<String> r112 = this.f486577i;
        if (r112 == null) goto L22;
        r104 = r112.hashCode();
    L22:
        int r113 = (r111 + r104) * 31;
        if (this.f486578j == false) goto L25;
        int r114 = 1231;
    L26:
        int r115 = (r113 + r114) * 31;
        if (this.f486579k == false) goto L29;
        int r116 = 1231;
    L30:
        int r117 = (r115 + r116) * 31;
        if (this.f486580l == false) goto L33;
        int r118 = 1231;
    L34:
        int r119 = (r117 + r118) * 31;
        if (this.f486581m == false) goto L37;
        int r120 = 1231;
    L38:
        int r121 = (r119 + r120) * 31;
        if (this.f486582n == false) goto L41;
        int r122 = 1231;
    L42:
        int r123 = (r121 + r122) * 31;
        if (this.f486583o == true) goto L47;
        r100 = 1237;
    L47:
        return r123 + r100;
    L41:
        r122 = 1237;
        goto L42
    L37:
        r120 = 1237;
        goto L38
    L33:
        r118 = 1237;
        goto L34
    L29:
        r116 = 1237;
        goto L30
    L25:
        r114 = 1237;
        goto L26
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownCodeRenderConfig(enableMarkdownCodeRender=" + this.f486569a + ", canPreviewLanguage=" + this.f486570b + ", enableCodeRenderWebviewPreload=" + this.f486571c + ", appPreviewImageWidth=" + this.f486572d + ", appPreviewImageHeight=" + this.f486573e + ", padPreviewImageWidth=" + this.f486574f + ", padPreviewImageHeight=" + this.f486575g + ", previewLynxviewTemplateUrl=" + this.f486576h + ", canPreviewInLynxviewLanguage=" + this.f486577i + ", normalHtmlCodeOptimize=" + this.f486578j + ", renderHtmlCodeOptimize=" + this.f486579k + ", mindmapCodeOptimize=" + this.f486580l + ", mermaidCodeOptimize=" + this.f486581m + ", svgCodeOptimize=" + this.f486582n + ", echartCodeOptimize=" + this.f486583o + ')';
    }

    public /* synthetic */ e3(int r110) {
        this(false, null, false, 480, 480, 800, 800, null, null, false, false, false, false, false, false);
    }

    public e3(boolean r100, List<String> r101, boolean r102, int r103, int r104, int r105, int r106, String r107, List<String> r108, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115) {
        this.f486569a = r100;
        this.f486570b = r101;
        this.f486571c = r102;
        this.f486572d = r103;
        this.f486573e = r104;
        this.f486574f = r105;
        this.f486575g = r106;
        this.f486576h = r107;
        this.f486577i = r108;
        this.f486578j = r110;
        this.f486579k = r111;
        this.f486580l = r112;
        this.f486581m = r113;
        this.f486582n = r114;
        this.f486583o = r115;
    }
}
