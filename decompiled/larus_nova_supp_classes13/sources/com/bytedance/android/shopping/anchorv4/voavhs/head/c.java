package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.graphics.drawable.Drawable;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.FeaturedComment;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final HashMap<Integer, String> J = null;
    public final List<KolReviewElement> A;
    public final h83.a B;
    public final m C;
    public final boolean D;
    public final boolean E;
    public final GaussianBlurConfig F;
    public final String G;
    public final String H;
    public final p I;
    public final String a;
    public final ECUrlModel b;
    public final ECUrlModel c;
    public final ECUrlModel d;
    public final Link e;
    public final Drawable f;
    public final CombinationVO g;
    public final ECUrlModel h;
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b i;
    public final String j;
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.view.w k;
    public final FeaturedComment l;
    public final String m;
    public final int n;
    public final Boolean o;
    public final String p;
    public final String q;
    public final CommonFindSameElement r;
    public com.bytedance.android.shopping.anchorv4.dto.business.d s;
    public final ScrollMoreText t;
    public final String u;
    public final boolean v;
    public final GaussianBlurConfig w;
    public final List<ECUrlModel> x;
    public final List<String> y;
    public final List<String> z;

    public static final class a {
        public static int a(String r7) {
            if (r7 == null) goto L9;
            String r8 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r7, new String[]{"_"}, false, 0, 6, null));
            if (r8 == null) goto L9;
            Integer r9 = StringsKt.toIntOrNull(r8);
            if (r9 == null) goto L9;
            return r9.intValue();
        L9:
            return 0;
        }
    }

    public c() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -1, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L76;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (this.n == r4.n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r4.r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r4.s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.t, r4.t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.u, r4.u) == true) goto L48;
        return false;
    L48:
        if (this.v == r4.v) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.w, r4.w) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.x, r4.x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.y, r4.y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.z, r4.z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r4.A) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.B, r4.B) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r4.C) == true) goto L64;
        return false;
    L64:
        if (this.D == r4.D) goto L66;
        return false;
    L66:
        if (this.E == r4.E) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.F, r4.F) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.G, r4.G) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.H, r4.H) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.I, r4.I) == true) goto L115;
        return false;
    L115:
        return true;
    L76:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v105 */
    /* JADX WARN: Type inference failed for: r2v125 */
    /* JADX WARN: Type inference failed for: r2v126 */
    /* JADX WARN: Type inference failed for: r2v59, types: [int] */
    /* JADX WARN: Type inference failed for: r2v82, types: [int] */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECUrlModel r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Link r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Drawable r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        CombinationVO r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        ECUrlModel r22 = this.h;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r25 = this.i;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r31 = this.k;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        FeaturedComment r34 = this.l;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (((r36 + r38) * 31) + this.n) * 31;
        Boolean r40 = this.o;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.p;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.q;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        CommonFindSameElement r49 = this.r;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.d r52 = this.s;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        ScrollMoreText r55 = this.t;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.u;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        boolean r61 = this.v;
        ?? r62 = 1;
        ?? r63 = r61;
        if (r61 == false) goto L85;
        r63 = 1;
    L85:
        int r64 = (r60 + r63) * 31;
        GaussianBlurConfig r65 = this.w;
        if (r65 == null) goto L88;
        int r66 = r65.hashCode();
    L89:
        int r67 = (r64 + r66) * 31;
        List<ECUrlModel> r68 = this.x;
        if (r68 == null) goto L92;
        int r69 = r68.hashCode();
    L93:
        int r70 = (r67 + r69) * 31;
        List<String> r71 = this.y;
        if (r71 == null) goto L96;
        int r72 = r71.hashCode();
    L97:
        int r73 = (r70 + r72) * 31;
        List<String> r74 = this.z;
        if (r74 == null) goto L100;
        int r75 = r74.hashCode();
    L101:
        int r76 = (r73 + r75) * 31;
        List<KolReviewElement> r77 = this.A;
        if (r77 == null) goto L104;
        int r78 = r77.hashCode();
    L105:
        int r79 = (r76 + r78) * 31;
        h83.a r80 = this.B;
        if (r80 == null) goto L108;
        int r81 = r80.hashCode();
    L109:
        int r82 = (r79 + r81) * 31;
        m r84 = this.C;
        if (r84 == null) goto L112;
        int r85 = r84.hashCode();
    L113:
        int r86 = (r82 + r85) * 31;
        boolean r87 = this.D;
        ?? r88 = r87;
        if (r87 == false) goto L116;
        r88 = 1;
    L116:
        int r89 = (r86 + r88) * 31;
        boolean r90 = this.E;
        if (r90 == true) goto L120;
        r62 = r90;
    L120:
        int r91 = (r89 + r62) * 31;
        GaussianBlurConfig r92 = this.F;
        if (r92 == null) goto L123;
        int r94 = r92.hashCode();
    L124:
        int r95 = (r91 + r94) * 31;
        String r96 = this.G;
        if (r96 == null) goto L127;
        int r97 = r96.hashCode();
    L128:
        int r98 = (r95 + r97) * 31;
        String r99 = this.H;
        if (r99 == null) goto L131;
        int r100 = r99.hashCode();
    L132:
        int r101 = (r98 + r100) * 31;
        p r102 = this.I;
        if (r102 == null) goto L136;
        r1 = r102.hashCode();
    L136:
        return r101 + r1;
    L131:
        r100 = 0;
        goto L132
    L127:
        r97 = 0;
        goto L128
    L123:
        r94 = 0;
        goto L124
    L112:
        r85 = 0;
        goto L113
    L108:
        r81 = 0;
        goto L109
    L104:
        r78 = 0;
        goto L105
    L100:
        r75 = 0;
        goto L101
    L96:
        r72 = 0;
        goto L97
    L92:
        r69 = 0;
        goto L93
    L88:
        r66 = 0;
        goto L89
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4HeadNodeVO(type=" + this.a + ", image=" + this.b + ", atmosphereImage=" + this.c + ", entryIcon=" + this.d + ", specialLink=" + this.e + ", headerImagePlaceHolder=" + this.f + ", combinationVO=" + this.g + ", videoCoverImage=" + this.h + ", playInfo=" + this.i + ", videoSource=" + this.j + ", featuredShowVO=" + this.k + ", featuredCommentVO=" + this.l + ", nodeGroupType=" + this.m + ", itemType=" + this.n + ", supportPreview=" + this.o + ", linkSubType=" + this.p + ", findSameGoodsSchema=" + this.q + ", findSameGoodsTab=" + this.r + ", IFindSameResp=" + this.s + ", scrollMoreText=" + this.t + ", contentDescription=" + this.u + ", fullscreen=" + this.v + ", blurConfig=" + this.w + ", skuImageList=" + this.x + ", skuTitleList=" + this.y + ", skuFindSameSchemaList=" + this.z + ", kolReviewList=" + this.A + ", kolAuthorInfo=" + this.B + ", kolVideoExtraInfo=" + this.C + ", supportKolVideoDetail=" + this.D + ", isLengthenedPicture=" + this.E + ", pictureBlurCompatConfig=" + this.F + ", productId=" + this.G + ", tabTypeName=" + this.H + ", slice=" + this.I + ")";
    }

    static {
        J = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(0, "product"), TuplesKt.to(1, "size"), TuplesKt.to(2, "3d"), TuplesKt.to(3, "AR"), TuplesKt.to(4, "matching"), TuplesKt.to(5, "test"), TuplesKt.to(6, "comment"), TuplesKt.to(7, "similar"), TuplesKt.to(9, "inflow")});
    }

    public final String getType() {
        return this.a;
    }

    public static c a(c r40, Drawable r41, String r42, int r43, Boolean r44, String r45, CommonFindSameElement r46, ScrollMoreText r47, boolean r48, String r49, String r50, int r51, int r52) {
        p r3 = null;
        if ((r51 & 1) == 0) goto L5;
        String r5 = r40.a;
    L7:
        if ((r51 & 2) == 0) goto L9;
        ECUrlModel r6 = r40.b;
    L11:
        if ((r51 & 4) == 0) goto L13;
        ECUrlModel r7 = r40.c;
    L15:
        if ((r51 & 8) == 0) goto L17;
        ECUrlModel r8 = r40.d;
    L19:
        if ((r51 & 16) == 0) goto L21;
        Link r9 = r40.e;
    L23:
        if ((r51 & 32) == 0) goto L25;
        Drawable r10 = r40.f;
    L27:
        if ((r51 & 64) == 0) goto L29;
        CombinationVO r11 = r40.g;
    L31:
        if ((r51 & 128) == 0) goto L33;
        ECUrlModel r12 = r40.h;
    L35:
        if ((r51 & 256) == 0) goto L37;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r13 = r40.i;
    L39:
        if ((r51 & 512) == 0) goto L41;
        String r14 = r40.j;
    L43:
        if ((r51 & 1024) == 0) goto L45;
        com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r15 = r40.k;
    L47:
        if ((r51 & 2048) == 0) goto L49;
        FeaturedComment r16 = r40.l;
    L51:
        if ((r51 & 4096) == 0) goto L53;
        String r2 = r40.m;
    L55:
        if ((r51 & 8192) == 0) goto L57;
        int r18 = r40.n;
    L59:
        if ((r51 & 16384) == 0) goto L61;
        Boolean r19 = r40.o;
    L63:
        if ((32768 & r51) == 0) goto L65;
        String r20 = r40.p;
    L67:
        if ((65536 & r51) == 0) goto L69;
        String r21 = r40.q;
    L71:
        if ((131072 & r51) == 0) goto L73;
        CommonFindSameElement r22 = r40.r;
    L75:
        if ((262144 & r51) == 0) goto L77;
        com.bytedance.android.shopping.anchorv4.dto.business.d r23 = r40.s;
    L79:
        if ((524288 & r51) == 0) goto L81;
        ScrollMoreText r24 = r40.t;
    L83:
        if ((1048576 & r51) == 0) goto L85;
        String r25 = r40.u;
    L87:
        if ((2097152 & r51) == 0) goto L89;
        boolean r26 = r40.v;
    L91:
        if ((4194304 & r51) == 0) goto L93;
        GaussianBlurConfig r27 = r40.w;
    L95:
        if ((8388608 & r51) == 0) goto L97;
        List<ECUrlModel> r28 = r40.x;
    L99:
        if ((16777216 & r51) == 0) goto L101;
        List<String> r29 = r40.y;
    L103:
        if ((33554432 & r51) == 0) goto L105;
        List<String> r30 = r40.z;
    L107:
        if ((67108864 & r51) == 0) goto L109;
        List<KolReviewElement> r31 = r40.A;
    L111:
        if ((134217728 & r51) == 0) goto L113;
        h83.a r32 = r40.B;
    L115:
        if ((268435456 & r51) == 0) goto L117;
        m r33 = r40.C;
    L119:
        if ((536870912 & r51) == 0) goto L121;
        boolean r34 = r40.D;
    L123:
        if ((1073741824 & r51) == 0) goto L125;
        boolean r35 = r40.E;
    L127:
        if ((r51 & Integer.MIN_VALUE) == 0) goto L129;
        GaussianBlurConfig r36 = r40.F;
    L131:
        if ((r52 & 1) == 0) goto L133;
        String r37 = r40.G;
    L135:
        if ((r52 & 2) == 0) goto L137;
        String r38 = r40.H;
    L139:
        if ((r52 & 4) == 0) goto L141;
        r3 = r40.I;
    L141:
        r40.getClass();
        Intrinsics.checkNotNullParameter(r2, "nodeGroupType");
        return new c(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r2, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r3);
    L137:
        r38 = r50;
        goto L139
    L133:
        r37 = r49;
        goto L135
    L129:
        r36 = null;
        goto L131
    L125:
        r35 = r48;
        goto L127
    L121:
        r34 = false;
        goto L123
    L117:
        r33 = null;
        goto L119
    L113:
        r32 = null;
        goto L115
    L109:
        r31 = null;
        goto L111
    L105:
        r30 = null;
        goto L107
    L101:
        r29 = null;
        goto L103
    L97:
        r28 = null;
        goto L99
    L93:
        r27 = null;
        goto L95
    L89:
        r26 = false;
        goto L91
    L85:
        r25 = null;
        goto L87
    L81:
        r24 = r47;
        goto L83
    L77:
        r23 = null;
        goto L79
    L73:
        r22 = r46;
        goto L75
    L69:
        r21 = r45;
        goto L71
    L65:
        r20 = null;
        goto L67
    L61:
        r19 = r44;
        goto L63
    L57:
        r18 = r43;
        goto L59
    L53:
        r2 = r42;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = r41;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ c(String r40, ECUrlModel r41, ECUrlModel r42, Link r43, CombinationVO r44, ECUrlModel r45, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r46, String r47, com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r48, FeaturedComment r49, String r50, String r51, CommonFindSameElement r52, String r53, GaussianBlurConfig r54, List r55, List r56, List r57, List r58, h83.a r59, m r60, boolean r61, p r62, int r63, int r64) {
        if ((r63 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r63 & 2) == 0) goto L9;
        ECUrlModel r5 = null;
    L11:
        if ((r63 & 8) == 0) goto L13;
        ECUrlModel r7 = null;
    L15:
        if ((r63 & 16) == 0) goto L17;
        Link r8 = null;
    L19:
        if ((r63 & 64) == 0) goto L21;
        CombinationVO r10 = null;
    L23:
        if ((r63 & 128) == 0) goto L25;
        ECUrlModel r11 = null;
    L27:
        if ((r63 & 256) == 0) goto L29;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r12 = null;
    L31:
        if ((r63 & 512) == 0) goto L33;
        String r13 = null;
    L35:
        if ((r63 & 1024) == 0) goto L37;
        com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r14 = null;
    L39:
        if ((r63 & 2048) == 0) goto L41;
        FeaturedComment r15 = null;
    L43:
        if ((r63 & 4096) == 0) goto L45;
        String r16 = "0";
    L47:
        if ((32768 & r63) == 0) goto L49;
        String r19 = null;
    L51:
        if ((131072 & r63) == 0) goto L53;
        CommonFindSameElement r21 = null;
    L55:
        if ((1048576 & r63) == 0) goto L57;
        String r24 = null;
    L59:
        if ((2097152 & r63) == 0) goto L61;
        boolean r25 = true;
    L63:
        if ((4194304 & r63) == 0) goto L65;
        GaussianBlurConfig r26 = null;
    L67:
        if ((8388608 & r63) == 0) goto L69;
        List r27 = null;
    L71:
        if ((16777216 & r63) == 0) goto L73;
        List r28 = null;
    L75:
        if ((33554432 & r63) == 0) goto L77;
        List r29 = null;
    L79:
        if ((67108864 & r63) == 0) goto L81;
        List r30 = null;
    L83:
        if ((134217728 & r63) == 0) goto L85;
        h83.a r31 = null;
    L87:
        if ((268435456 & r63) == 0) goto L89;
        m r32 = null;
    L91:
        if ((536870912 & r63) == 0) goto L93;
        boolean r33 = false;
    L95:
        if ((r63 & Integer.MIN_VALUE) == 0) goto L97;
        GaussianBlurConfig r35 = new GaussianBlurConfig(null, null, null, 7, null);
    L99:
        if ((r64 & 4) == 0) goto L101;
        p r38 = null;
    L102:
        this(r4, r5, null, r7, r8, null, r10, r11, r12, r13, r14, r15, r16, 0, null, r19, null, r21, null, null, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, false, r35, null, null, r38);
        return;
    L101:
        r38 = r62;
        goto L102
    L97:
        r35 = null;
        goto L99
    L93:
        r33 = r61;
        goto L95
    L89:
        r32 = r60;
        goto L91
    L85:
        r31 = r59;
        goto L87
    L81:
        r30 = r58;
        goto L83
    L77:
        r29 = r57;
        goto L79
    L73:
        r28 = r56;
        goto L75
    L69:
        r27 = r55;
        goto L71
    L65:
        r26 = r54;
        goto L67
    L61:
        r25 = false;
        goto L63
    L57:
        r24 = r53;
        goto L59
    L53:
        r21 = r52;
        goto L55
    L49:
        r19 = r51;
        goto L51
    L45:
        r16 = r50;
        goto L47
    L41:
        r15 = r49;
        goto L43
    L37:
        r14 = r48;
        goto L39
    L33:
        r13 = r47;
        goto L35
    L29:
        r12 = r46;
        goto L31
    L25:
        r11 = r45;
        goto L27
    L21:
        r10 = r44;
        goto L23
    L17:
        r8 = r43;
        goto L19
    L13:
        r7 = r42;
        goto L15
    L9:
        r5 = r41;
        goto L11
    L5:
        r4 = r40;
        goto L7
    }

    public c(String r4, ECUrlModel r5, ECUrlModel r6, ECUrlModel r7, Link r8, Drawable r9, CombinationVO r10, ECUrlModel r11, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r12, String r13, com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r14, FeaturedComment r15, String r16, int r17, Boolean r18, String r19, String r20, CommonFindSameElement r21, com.bytedance.android.shopping.anchorv4.dto.business.d r22, ScrollMoreText r23, String r24, boolean r25, GaussianBlurConfig r26, List<? extends ECUrlModel> r27, List<String> r28, List<String> r29, List<KolReviewElement> r30, h83.a r31, m r32, boolean r33, boolean r34, GaussianBlurConfig r35, String r36, String r37, p r38) {
        Intrinsics.checkNotNullParameter(r16, "nodeGroupType");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
        this.z = r29;
        this.A = r30;
        this.B = r31;
        this.C = r32;
        this.D = r33;
        this.E = r34;
        this.F = r35;
        this.G = r36;
        this.H = r37;
        this.I = r38;
    }
}
