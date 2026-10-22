package lw8;

import com.larus.business.markdown.api.model.BgListItemConfig;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.ListStyle;
import com.larus.business.markdown.api.model.PhoneNumberConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import io.noties.markwon.core.spans.ListMarginInfo;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tsc.a0;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public final Integer A;
    public final ListStyle B;
    public final Boolean C;
    public final Boolean D;
    public final Boolean E;
    public final mw8.b F;
    public final boolean G;
    public final Map<Integer, Float> H;
    public final boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f511054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f511055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a0> f511056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f511057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f511058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f511059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f511060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f511061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f511062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Float f511063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f511064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Float f511065l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f511066m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f511067n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BgListItemConfig f511068o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f511069p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f511070q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function1<uvc.b, Integer> f511071r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Function1<uvc.b, Integer> f511072s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f511073t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ThematicBreakConfig f511074u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CodeBlockConfig f511075v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TableConfig f511076w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PhoneNumberConfig f511077x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ListMarginInfo f511078y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<lsc.a> f511079z;

    public d() {
        this(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f511054a == r101.f511054a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511055b, r101.f511055b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511056c, r101.f511056c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f511057d, r101.f511057d) == true) goto L21;
        return false;
    L21:
        if (this.f511058e == r101.f511058e) goto L24;
        return false;
    L24:
        if (this.f511059f == r101.f511059f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f511060g, r101.f511060g) == true) goto L30;
        return false;
    L30:
        if (this.f511061h == r101.f511061h) goto L33;
        return false;
    L33:
        if (this.f511062i == r101.f511062i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f511063j, r101.f511063j) == true) goto L39;
        return false;
    L39:
        if (Float.compare(this.f511064k, r101.f511064k) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f511065l, r101.f511065l) == true) goto L45;
        return false;
    L45:
        if (this.f511066m == r101.f511066m) goto L48;
        return false;
    L48:
        if (this.f511067n == r101.f511067n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f511068o, r101.f511068o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f511069p, r101.f511069p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f511070q, r101.f511070q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f511071r, r101.f511071r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f511072s, r101.f511072s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f511073t, r101.f511073t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f511074u, r101.f511074u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f511075v, r101.f511075v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f511076w, r101.f511076w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f511077x, r101.f511077x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f511078y, r101.f511078y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f511079z, r101.f511079z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(null, null) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.E, r101.E) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.F, r101.F) == true) goto L108;
        return false;
    L108:
        if (this.G == r101.G) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(null, null) == true) goto L117;
        return false;
    L117:
        if (this.I == r101.I) goto L119;
        return false;
    L119:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v66, types: [int] */
    /* JADX WARN: Type inference failed for: r0v72, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v107 */
    /* JADX WARN: Type inference failed for: r1v108 */
    /* JADX WARN: Type inference failed for: r1v110 */
    /* JADX WARN: Type inference failed for: r1v111 */
    /* JADX WARN: Type inference failed for: r1v112 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v86 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r100 = this.f511054a * 31;
        Integer r101 = this.f511055b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f511056c.hashCode()) * 31) + this.f511057d.hashCode()) * 31;
        boolean r104 = this.f511058e;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f511059f;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f511060g;
        if (r111 != null) goto L15;
        int r112 = 0;
    L16:
        int r113 = (((((r110 + r112) * 31) + this.f511061h) * 31) + this.f511062i) * 31;
        Float r114 = this.f511063j;
        if (r114 != null) goto L19;
        int r115 = 0;
    L20:
        int r116 = (((r113 + r115) * 31) + Float.floatToIntBits(this.f511064k)) * 31;
        Float r117 = this.f511065l;
        if (r117 != null) goto L23;
        int r118 = 0;
    L24:
        int r119 = (((((r116 + r118) * 31) + this.f511066m) * 31) + this.f511067n) * 31;
        BgListItemConfig r120 = this.f511068o;
        if (r120 != null) goto L27;
        int r121 = 0;
    L28:
        int r122 = (r119 + r121) * 31;
        Integer r123 = this.f511069p;
        if (r123 != null) goto L31;
        int r124 = 0;
    L32:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.f511070q;
        if (r126 != null) goto L35;
        int r127 = 0;
    L36:
        int r128 = (r125 + r127) * 31;
        Function1<uvc.b, Integer> r129 = this.f511071r;
        if (r129 != null) goto L39;
        int r130 = 0;
    L40:
        int r131 = (r128 + r130) * 31;
        Function1<uvc.b, Integer> r132 = this.f511072s;
        if (r132 != null) goto L43;
        int r133 = 0;
    L44:
        int r134 = (r131 + r133) * 31;
        a r135 = this.f511073t;
        if (r135 != null) goto L47;
        int r136 = 0;
    L48:
        int r137 = (r134 + r136) * 31;
        ThematicBreakConfig r138 = this.f511074u;
        if (r138 != null) goto L51;
        int r139 = 0;
    L52:
        int r140 = (r137 + r139) * 31;
        CodeBlockConfig r141 = this.f511075v;
        if (r141 != null) goto L55;
        int r142 = 0;
    L56:
        int r143 = (r140 + r142) * 31;
        TableConfig r144 = this.f511076w;
        if (r144 != null) goto L59;
        int r145 = 0;
    L60:
        int r146 = (r143 + r145) * 31;
        PhoneNumberConfig r147 = this.f511077x;
        if (r147 != null) goto L63;
        int r148 = 0;
    L64:
        int r149 = (r146 + r148) * 31;
        ListMarginInfo r150 = this.f511078y;
        if (r150 != null) goto L67;
        int r151 = 0;
    L68:
        int r152 = (r149 + r151) * 31;
        List<lsc.a> r153 = this.f511079z;
        if (r153 != null) goto L71;
        int r154 = 0;
    L72:
        int r155 = (((r152 + r154) * 31) + 0) * 31;
        Integer r156 = this.A;
        if (r156 != null) goto L75;
        int r157 = 0;
    L76:
        int r158 = (r155 + r157) * 31;
        ListStyle r159 = this.B;
        if (r159 != null) goto L79;
        int r160 = 0;
    L80:
        int r161 = (r158 + r160) * 31;
        Boolean r162 = this.C;
        if (r162 != null) goto L83;
        int r163 = 0;
    L84:
        int r164 = (r161 + r163) * 31;
        Boolean r165 = this.D;
        if (r165 != null) goto L87;
        int r166 = 0;
    L88:
        int r167 = (r164 + r166) * 31;
        Boolean r168 = this.E;
        if (r168 != null) goto L91;
        int r169 = 0;
    L92:
        int r170 = (((r167 + r169) * 31) + this.F.hashCode()) * 31;
        boolean r171 = this.G;
        ?? r172 = r171;
        if (r171 == false) goto L95;
        r172 = 1;
    L95:
        int r173 = (r170 + r172) * 31;
        Map<Integer, Float> r174 = this.H;
        if (r174 != null) goto L98;
        int r175 = 0;
    L99:
        int r176 = (((r173 + r175) * 31) + 0) * 31;
        boolean r177 = this.I;
        if (r177 == true) goto L104;
        r105 = r177;
    L104:
        return r176 + r105;
    L98:
        r175 = r174.hashCode();
        goto L99
    L91:
        r169 = r168.hashCode();
        goto L92
    L87:
        r166 = r165.hashCode();
        goto L88
    L83:
        r163 = r162.hashCode();
        goto L84
    L79:
        r160 = r159.hashCode();
        goto L80
    L75:
        r157 = r156.hashCode();
        goto L76
    L71:
        r154 = r153.hashCode();
        goto L72
    L67:
        r151 = r150.hashCode();
        goto L68
    L63:
        r148 = r147.hashCode();
        goto L64
    L59:
        r145 = r144.hashCode();
        goto L60
    L55:
        r142 = r141.hashCode();
        goto L56
    L51:
        r139 = r138.hashCode();
        goto L52
    L47:
        r136 = r135.hashCode();
        goto L48
    L43:
        r133 = r132.hashCode();
        goto L44
    L39:
        r130 = r129.hashCode();
        goto L40
    L35:
        r127 = r126.hashCode();
        goto L36
    L31:
        r124 = r123.hashCode();
        goto L32
    L27:
        r121 = r120.hashCode();
        goto L28
    L23:
        r118 = r117.hashCode();
        goto L24
    L19:
        r115 = r114.hashCode();
        goto L20
    L15:
        r112 = r111.hashCode();
        goto L16
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CustomMarkDownInfo(imgCornerRadius=" + this.f511054a + ", imgBgColor=" + this.f511055b + ", htmlTagHandlerList=" + this.f511056c + ", codeCopyTitle=" + this.f511057d + ", enableCodeCopyButton=" + this.f511058e + ", useSubscribedColor=" + this.f511059f + ", linkColor=" + this.f511060g + ", codeTitleSize=" + this.f511061h + ", listItemColor=" + this.f511062i + ", blankLineMulti=" + this.f511063j + ", tableTextSize=" + this.f511064k + ", textLineMulti=" + this.f511065l + ", diffDp=" + this.f511066m + ", minImgWidthHeight=" + this.f511067n + ", bgListItemConfig=" + this.f511068o + ", paragraphSpaceHeight=" + this.f511069p + ", listItemSpaceHeight=" + this.f511070q + ", paragraphSpaceHeightProvider=" + this.f511071r + ", paragraphTopSpaceHeightProvider=" + this.f511072s + ", blockQuoteConfig=" + this.f511073t + ", thematicBreakConfig=" + this.f511074u + ", codeBlockConfig=" + this.f511075v + ", tableConfig=" + this.f511076w + ", phoneNumberConfig=" + this.f511077x + ", listMarginInfo=" + this.f511078y + ", customListPlugin=" + this.f511079z + ", listConfig=null, headingColor=" + this.A + ", listStyle=" + this.B + ", darkMode=" + this.C + ", allowParentInterceptTouchWhenOverScroll=" + this.D + ", splitCodeBlock=" + this.E + ", latexSingleConfig=" + this.F + ", allowNonClosedTags=" + this.G + ", headingLevelTextSizeMap=" + this.H + ", linkHandler=null, noBlockSpace=" + this.I + ')';
    }

    public /* synthetic */ d(int r410, Integer r411, String r412, boolean r413, Integer r414, int r415, Float r416, float r417, Float r418, int r419, int r510, Integer r511, Integer r512, Function1 r513, a r514, ThematicBreakConfig r515, CodeBlockConfig r516, TableConfig r517, PhoneNumberConfig r518, ListMarginInfo r519, List r610, Boolean r611, mw8.b r612, Map r613, int r614, int r615) {
        if ((r614 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r614 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r614 & 4) == 0) goto L13;
        List r102 = CollectionsKt.emptyList();
    L15:
        if ((r614 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r614 & 16) == 0) goto L21;
        boolean r104 = true;
    L23:
        if ((r614 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r614 & 64) == 0) goto L29;
        Integer r110 = null;
    L31:
        if ((r614 & 128) == 0) goto L33;
        int r111 = 0;
    L35:
        if ((r614 & 512) == 0) goto L37;
        Float r112 = null;
    L39:
        if ((r614 & 1024) == 0) goto L41;
        float r113 = 0.0f;
    L43:
        if ((r614 & 2048) == 0) goto L45;
        Float r114 = null;
    L47:
        if ((r614 & 4096) == 0) goto L49;
        int r115 = 0;
    L51:
        if ((r614 & 8192) == 0) goto L53;
        int r116 = 0;
    L55:
        if ((32768 & r614) == 0) goto L57;
        Integer r117 = null;
    L59:
        if ((65536 & r614) == 0) goto L61;
        Integer r210 = null;
    L63:
        if ((262144 & r614) == 0) goto L65;
        Function1 r211 = null;
    L67:
        if ((524288 & r614) == 0) goto L69;
        a r212 = null;
    L71:
        if ((1048576 & r614) == 0) goto L73;
        ThematicBreakConfig r213 = null;
    L75:
        if ((2097152 & r614) == 0) goto L77;
        CodeBlockConfig r214 = null;
    L79:
        if ((4194304 & r614) == 0) goto L81;
        TableConfig r215 = null;
    L83:
        if ((8388608 & r614) == 0) goto L85;
        PhoneNumberConfig r216 = null;
    L87:
        if ((16777216 & r614) == 0) goto L89;
        ListMarginInfo r217 = null;
    L91:
        if ((33554432 & r614) == 0) goto L93;
        List r218 = null;
    L95:
        if ((536870912 & r614) == 0) goto L97;
        Boolean r310 = null;
    L99:
        if ((1073741824 & r614) == 0) goto L101;
        Boolean r311 = Boolean.FALSE;
    L103:
        if ((r614 & Integer.MIN_VALUE) == 0) goto L105;
        Boolean r312 = Boolean.FALSE;
    L107:
        if ((r615 & 1) == 0) goto L109;
        mw8.b r313 = new mw8.b(0);
    L111:
        if ((r615 & 4) == 0) goto L113;
        Map r314 = null;
    L114:
        this(r100, r101, r102, r103, r104, r105, r110, r111, 0, r112, r113, r114, r115, r116, null, r117, r210, null, r211, r212, r213, r214, r215, r216, r217, r218, null, null, r310, r311, r312, r313, false, r314, false);
        return;
    L113:
        r314 = r613;
        goto L114
    L109:
        r313 = r612;
        goto L111
    L105:
        r312 = null;
        goto L107
    L101:
        r311 = null;
        goto L103
    L97:
        r310 = r611;
        goto L99
    L93:
        r218 = r610;
        goto L95
    L89:
        r217 = r519;
        goto L91
    L85:
        r216 = r518;
        goto L87
    L81:
        r215 = r517;
        goto L83
    L77:
        r214 = r516;
        goto L79
    L73:
        r213 = r515;
        goto L75
    L69:
        r212 = r514;
        goto L71
    L65:
        r211 = r513;
        goto L67
    L61:
        r210 = r512;
        goto L63
    L57:
        r117 = r511;
        goto L59
    L53:
        r116 = r510;
        goto L55
    L49:
        r115 = r419;
        goto L51
    L45:
        r114 = r418;
        goto L47
    L41:
        r113 = r417;
        goto L43
    L37:
        r112 = r416;
        goto L39
    L33:
        r111 = r415;
        goto L35
    L29:
        r110 = r414;
        goto L31
    L25:
        r105 = r413;
        goto L27
    L21:
        r104 = false;
        goto L23
    L17:
        r103 = r412;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }

    public d(int r100, Integer r101, List r102, String r103, boolean r110, boolean r111, Integer r112, int r113, int r114, Float r115, float r116, Float r117, int r118, int r119, BgListItemConfig r210, Integer r211, Integer r212, Function1 r213, Function1 r214, a r215, ThematicBreakConfig r216, CodeBlockConfig r217, TableConfig r218, PhoneNumberConfig r219, ListMarginInfo r310, List r311, Integer r312, ListStyle r313, Boolean r314, Boolean r315, Boolean r316, mw8.b r317, boolean r318, Map r319, boolean r410) {
        Intrinsics.checkNotNullParameter(r102, "htmlTagHandlerList");
        Intrinsics.checkNotNullParameter(r103, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(r317, "latexSingleConfig");
        this.f511054a = r100;
        this.f511055b = r101;
        this.f511056c = r102;
        this.f511057d = r103;
        this.f511058e = r110;
        this.f511059f = r111;
        this.f511060g = r112;
        this.f511061h = r113;
        this.f511062i = r114;
        this.f511063j = r115;
        this.f511064k = r116;
        this.f511065l = r117;
        this.f511066m = r118;
        this.f511067n = r119;
        this.f511068o = r210;
        this.f511069p = r211;
        this.f511070q = r212;
        this.f511071r = r213;
        this.f511072s = r214;
        this.f511073t = r215;
        this.f511074u = r216;
        this.f511075v = r217;
        this.f511076w = r218;
        this.f511077x = r219;
        this.f511078y = r310;
        this.f511079z = r311;
        this.A = r312;
        this.B = r313;
        this.C = r314;
        this.D = r315;
        this.E = r316;
        this.F = r317;
        this.G = r318;
        this.H = r319;
        this.I = r410;
    }
}
