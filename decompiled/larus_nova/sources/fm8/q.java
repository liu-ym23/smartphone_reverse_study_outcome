package fm8;

import android.graphics.RectF;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f477855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f477856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f477857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f477858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f477859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f477860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f477861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f477862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f477863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f477864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f477865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f477866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f477867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f477868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f477869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f477870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f477871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f477872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Block f477873s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final lw8.d f477874t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final fh8.f f477875u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f477876v;

    public q() {
        this(0, -1, -1, false, false, null, 0, -1, false, false, "markdown_text_container_default", null, false, false, false, false, null, "", null, null, new fh8.g().a(), null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f477855a == r101.f477855a) goto L12;
        return false;
    L12:
        if (this.f477856b == r101.f477856b) goto L15;
        return false;
    L15:
        if (this.f477857c == r101.f477857c) goto L18;
        return false;
    L18:
        if (this.f477858d == r101.f477858d) goto L21;
        return false;
    L21:
        if (this.f477859e == r101.f477859e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f477860f, r101.f477860f) == true) goto L27;
        return false;
    L27:
        if (this.f477861g == r101.f477861g) goto L30;
        return false;
    L30:
        if (this.f477862h == r101.f477862h) goto L33;
        return false;
    L33:
        if (this.f477863i == r101.f477863i) goto L36;
        return false;
    L36:
        if (this.f477864j == r101.f477864j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f477865k, r101.f477865k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f477866l, r101.f477866l) == true) goto L45;
        return false;
    L45:
        if (this.f477867m == r101.f477867m) goto L48;
        return false;
    L48:
        if (this.f477868n == r101.f477868n) goto L51;
        return false;
    L51:
        if (this.f477869o == r101.f477869o) goto L54;
        return false;
    L54:
        if (this.f477870p == r101.f477870p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f477871q, r101.f477871q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f477872r, r101.f477872r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f477873s, r101.f477873s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f477874t, r101.f477874t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f477875u, r101.f477875u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f477876v, r101.f477876v) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f477855a * 31) + this.f477856b) * 31) + this.f477857c) * 31;
        int r101 = 1231;
        if (this.f477858d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f477859e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        Integer r106 = this.f477860f;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r105 + r108) * 31) + this.f477861g) * 31) + this.f477862h) * 31;
        if (this.f477863i == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f477864j == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (((r111 + r112) * 31) + this.f477865k.hashCode()) * 31;
        String r114 = this.f477866l;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        if (this.f477867m == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        if (this.f477868n == false) goto L33;
        int r119 = 1231;
    L34:
        int r120 = (r118 + r119) * 31;
        if (this.f477869o == false) goto L37;
        int r121 = 1231;
    L38:
        int r122 = (r120 + r121) * 31;
        if (this.f477870p == true) goto L42;
        r101 = 1237;
    L42:
        int r123 = (r122 + r101) * 31;
        Boolean r124 = this.f477871q;
        if (r124 != null) goto L45;
        int r125 = 0;
    L46:
        int r126 = (((r123 + r125) * 31) + this.f477872r.hashCode()) * 31;
        Block r127 = this.f477873s;
        if (r127 != null) goto L49;
        int r128 = 0;
    L50:
        int r129 = (r126 + r128) * 31;
        lw8.d r130 = this.f477874t;
        if (r130 != null) goto L53;
        int r131 = 0;
    L54:
        int r132 = (((r129 + r131) * 31) + this.f477875u.hashCode()) * 31;
        RectF r133 = this.f477876v;
        if (r133 == null) goto L59;
        r107 = r133.hashCode();
    L59:
        return r132 + r107;
    L53:
        r131 = r130.hashCode();
        goto L54
    L49:
        r128 = r127.hashCode();
        goto L50
    L45:
        r125 = r124.hashCode();
        goto L46
    L37:
        r121 = 1237;
        goto L38
    L33:
        r119 = 1237;
        goto L34
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownTextContainerInput(textColor=" + this.f477855a + ", textSize=" + this.f477856b + ", lineHeight=" + this.f477857c + ", isImmerse=" + this.f477858d + ", isSelectMode=" + this.f477859e + ", boxType=" + this.f477860f + ", maxContentWidth=" + this.f477861g + ", marginHorizontal=" + this.f477862h + ", failOrInterrupt=" + this.f477863i + ", isStreaming=" + this.f477864j + ", viewAlphaTag=" + this.f477865k + ", forceRefreshId=" + this.f477866l + ", isDeepThinkArea=" + this.f477867m + ", useSubscribedColor=" + this.f477868n + ", enableCodeBlockStroke=" + this.f477869o + ", enableCodeBlockHeaderBackground=" + this.f477870p + ", enableTableHeader=" + this.f477871q + ", content=" + this.f477872r + ", block=" + this.f477873s + ", customMarkdownInfo=" + this.f477874t + ", commonInputData=" + this.f477875u + ", marginRectF=" + this.f477876v + ')';
    }

    public q(int r100, int r101, int r102, boolean r103, boolean r110, Integer r111, int r112, int r113, boolean r114, boolean r115, String r116, String r117, boolean r118, boolean r119, boolean r210, boolean r211, Boolean r212, String r213, Block r214, lw8.d r215, fh8.f r216, RectF r217) {
        Intrinsics.checkNotNullParameter(r116, "viewAlphaTag");
        Intrinsics.checkNotNullParameter(r213, "content");
        Intrinsics.checkNotNullParameter(r216, "commonInputData");
        this.f477855a = r100;
        this.f477856b = r101;
        this.f477857c = r102;
        this.f477858d = r103;
        this.f477859e = r110;
        this.f477860f = r111;
        this.f477861g = r112;
        this.f477862h = r113;
        this.f477863i = r114;
        this.f477864j = r115;
        this.f477865k = r116;
        this.f477866l = r117;
        this.f477867m = r118;
        this.f477868n = r119;
        this.f477869o = r210;
        this.f477870p = r211;
        this.f477871q = r212;
        this.f477872r = r213;
        this.f477873s = r214;
        this.f477874t = r215;
        this.f477875u = r216;
        this.f477876v = r217;
    }
}
