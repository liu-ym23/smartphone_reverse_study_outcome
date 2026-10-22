package pg4;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.component.lyric_v2.model.LyricAlignType;
import kotlin.jvm.internal.Intrinsics;
import ng4.i;

/* JADX INFO: loaded from: classes15.dex */
public final class c {
    public float A;
    public final boolean B;
    public final i C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f529169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f529170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f529171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f529172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f529173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f529174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f529175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f529176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f529177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f529178j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f529179k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f529180l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f529181m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f529182n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f529183o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f529184p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f529185q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f529186r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f529187s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f529188t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f529189u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f529190v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f529191w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f529192x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f529193y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LyricAlignType f529194z;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L64;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f529169a, r101.f529169a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f529170b, r101.f529170b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f529171c, r101.f529171c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f529172d, r101.f529172d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f529173e, r101.f529173e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f529174f, r101.f529174f) == true) goto L18;
        return false;
    L18:
        if (this.f529175g == r101.f529175g) goto L20;
        return false;
    L20:
        if (Float.compare(this.f529176h, r101.f529176h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.f529177i, r101.f529177i) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f529178j, r101.f529178j) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(this.f529179k, r101.f529179k) == 0) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f529180l, r101.f529180l) == true) goto L30;
        return false;
    L30:
        if (Float.compare(this.f529181m, r101.f529181m) == 0) goto L32;
        return false;
    L32:
        if (this.f529182n == r101.f529182n) goto L34;
        return false;
    L34:
        if (Float.compare(this.f529183o, r101.f529183o) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.f529184p, r101.f529184p) == 0) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f529185q, r101.f529185q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f529186r, r101.f529186r) == true) goto L42;
        return false;
    L42:
        if (Float.compare(this.f529187s, r101.f529187s) == 0) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f529188t, r101.f529188t) == true) goto L46;
        return false;
    L46:
        if (this.f529189u == r101.f529189u) goto L48;
        return false;
    L48:
        if (Float.compare(this.f529190v, r101.f529190v) == 0) goto L50;
        return false;
    L50:
        if (Float.compare(this.f529191w, r101.f529191w) == 0) goto L52;
        return false;
    L52:
        if (this.f529192x == r101.f529192x) goto L54;
        return false;
    L54:
        if (Float.compare(this.f529193y, r101.f529193y) == 0) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f529194z, r101.f529194z) == true) goto L58;
        return false;
    L58:
        if (Float.compare(this.A, r101.A) == 0) goto L60;
        return false;
    L60:
        if (this.B == r101.B) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L97;
        return false;
    L97:
        return true;
    L64:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48, types: [int] */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f529169a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f529170b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f529171c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f529172d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f529173e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f529174f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f529175g;
        ?? r120 = 1;
        ?? r121 = r119;
        if (r119 == false) goto L29;
        r121 = 1;
    L29:
        int r122 = (((((((((r118 + r121) * 31) + Float.floatToIntBits(this.f529176h)) * 31) + Float.floatToIntBits(this.f529177i)) * 31) + Float.floatToIntBits(this.f529178j)) * 31) + Float.floatToIntBits(this.f529179k)) * 31;
        String r123 = this.f529180l;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (((r122 + r124) * 31) + Float.floatToIntBits(this.f529181m)) * 31;
        boolean r126 = this.f529182n;
        ?? r127 = r126;
        if (r126 == false) goto L36;
        r127 = 1;
    L36:
        int r128 = (((((r125 + r127) * 31) + Float.floatToIntBits(this.f529183o)) * 31) + Float.floatToIntBits(this.f529184p)) * 31;
        String r129 = this.f529185q;
        if (r129 == null) goto L39;
        int r130 = r129.hashCode();
    L40:
        int r131 = (r128 + r130) * 31;
        b r132 = this.f529186r;
        if (r132 == null) goto L43;
        int r133 = r132.hashCode();
    L44:
        int r134 = (((r131 + r133) * 31) + Float.floatToIntBits(this.f529187s)) * 31;
        String r135 = this.f529188t;
        if (r135 == null) goto L47;
        int r136 = r135.hashCode();
    L48:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.f529189u;
        ?? r139 = r138;
        if (r138 == false) goto L51;
        r139 = 1;
    L51:
        int r140 = (((((((((r137 + r139) * 31) + Float.floatToIntBits(this.f529190v)) * 31) + Float.floatToIntBits(this.f529191w)) * 31) + this.f529192x) * 31) + Float.floatToIntBits(this.f529193y)) * 31;
        LyricAlignType r141 = this.f529194z;
        if (r141 == null) goto L54;
        int r142 = r141.hashCode();
    L55:
        int r143 = (((r140 + r142) * 31) + Float.floatToIntBits(this.A)) * 31;
        boolean r144 = this.B;
        if (r144 == true) goto L59;
        r120 = r144;
    L59:
        int r145 = (r143 + r120) * 31;
        i r146 = this.C;
        if (r146 == null) goto L63;
        r101 = r146.hashCode();
    L63:
        return r145 + r101;
    L54:
        r142 = 0;
        goto L55
    L47:
        r136 = 0;
        goto L48
    L43:
        r133 = 0;
        goto L44
    L39:
        r130 = 0;
        goto L40
    L32:
        r124 = 0;
        goto L33
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LyricsDisplayConfig(fontWeight=" + this.f529169a + ", fontFamily=" + this.f529170b + ", highlightFontFamily=" + this.f529171c + ", highlightFontWeight=" + this.f529172d + ", otherLinesFontFamily=" + this.f529173e + ", otherLinesFontWeight=" + this.f529174f + ", isReverse=" + this.f529175g + ", paddingLeft=" + this.f529176h + ", paddingTop=" + this.f529177i + ", paddingRight=" + this.f529178j + ", paddingBottom=" + this.f529179k + ", staticTextColor=" + this.f529180l + ", baseTextSize=" + this.f529181m + ", isTextBold=" + this.f529182n + ", charSpacing=" + this.f529183o + ", staticTextStrokeWidth=" + this.f529184p + ", highlightedTextColor=" + this.f529185q + ", highlightedTextShader=" + this.f529186r + ", otherLinesTextSize=" + this.f529187s + ", otherLinesTextColor=" + this.f529188t + ", isOtherLinesTextBold=" + this.f529189u + ", otherLinesCharSpacing=" + this.f529190v + ", otherLinesTextStrokeWidth=" + this.f529191w + ", preloadedLineCount=" + this.f529192x + ", lineSpacing=" + this.f529193y + ", textAlignType=" + this.f529194z + ", maxSingleLineWidth=" + this.A + ", isStrokeEnabled=" + this.B + ", textPainter=" + this.C + ")";
    }

    public c(float r210, float r211, String r212, float r213, String r214, float r215, float r216, float r310, i r311, int r312) {
        String r100 = "";
        if ((r312 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r312 & 32) != 0) goto L26;
        r100 = null;
    L26:
        String r110 = "#FFFFFFFF";
        if ((r312 & 2048) == 0) goto L29;
        String r111 = "#FFFFFFFF";
    L31:
        if ((r312 & 8192) == 0) goto L33;
        boolean r112 = true;
    L35:
        if ((r312 & 16384) == 0) goto L37;
        float r113 = 0.05f;
    L39:
        if ((r312 & 65536) == 0) goto L41;
        String r106 = "#FE4479";
    L43:
        if ((r312 & 524288) != 0) goto L47;
        r110 = r214;
    L47:
        if ((r312 & 1048576) == 0) goto L49;
        boolean r114 = true;
    L51:
        if ((r312 & 2097152) == 0) goto L53;
        float r217 = 0.05f;
    L55:
        if ((r312 & 8388608) == 0) goto L57;
        int r218 = 1;
    L59:
        if ((r312 & 33554432) == 0) goto L61;
        LyricAlignType r115 = LyricAlignType.RIGHT;
    L63:
        if ((r312 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L65;
        boolean r107 = true;
    L66:
        Intrinsics.checkNotNullParameter(r101, "fontWeight");
        Intrinsics.checkNotNullParameter(r102, "fontFamily");
        Intrinsics.checkNotNullParameter(r103, "highlightFontFamily");
        Intrinsics.checkNotNullParameter(r104, "highlightFontWeight");
        Intrinsics.checkNotNullParameter(r105, "otherLinesFontFamily");
        Intrinsics.checkNotNullParameter(r100, "otherLinesFontWeight");
        Intrinsics.checkNotNullParameter(r111, "staticTextColor");
        Intrinsics.checkNotNullParameter(r106, "highlightedTextColor");
        Intrinsics.checkNotNullParameter(r110, "otherLinesTextColor");
        Intrinsics.checkNotNullParameter(r115, "textAlignType");
        Intrinsics.checkNotNullParameter(r311, "textPainter");
        this.f529169a = r101;
        this.f529170b = r102;
        this.f529171c = r103;
        this.f529172d = r104;
        this.f529173e = r105;
        this.f529174f = r100;
        this.f529175g = false;
        this.f529176h = 0.0f;
        this.f529177i = 0.0f;
        this.f529178j = 0.0f;
        this.f529179k = 0.0f;
        this.f529180l = r111;
        this.f529181m = r210;
        this.f529182n = r112;
        this.f529183o = r113;
        this.f529184p = r211;
        this.f529185q = r106;
        this.f529186r = null;
        this.f529187s = r213;
        this.f529188t = r110;
        this.f529189u = r114;
        this.f529190v = r217;
        this.f529191w = r215;
        this.f529192x = r218;
        this.f529193y = r216;
        this.f529194z = r115;
        this.A = r310;
        this.B = r107;
        this.C = r311;
        return;
    L65:
        r107 = false;
        goto L66
    L61:
        r115 = null;
        goto L63
    L57:
        r218 = 0;
        goto L59
    L53:
        r217 = 0.0f;
        goto L55
    L49:
        r114 = false;
        goto L51
    L41:
        r106 = r212;
        goto L43
    L37:
        r113 = 0.0f;
        goto L39
    L33:
        r112 = false;
        goto L35
    L29:
        r111 = null;
        goto L31
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }
}
