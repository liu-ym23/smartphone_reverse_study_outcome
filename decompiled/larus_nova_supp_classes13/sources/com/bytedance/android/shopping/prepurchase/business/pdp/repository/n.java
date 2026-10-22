package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottomnav.BottomNavVO;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryVO;
import com.bytedance.android.shopping.anchorv4.components.PendantsComponentVO;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandVO;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public final Map<String, PendantsComponentVO> A;
    public final e73.a B;
    public final JSONObject C;
    public final List<String> D;
    public final Map<String, Object> E;
    public final TopNavVO F;
    public final BottomNavVO G;
    public final TopBannerVO H;
    public final GalleryVO I;
    public final String J;
    public final String K;
    public final HeadMoreVideo L;
    public final Map<String, IAction> M;
    public PageMeta a;
    public final Control b;
    public final String c;
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> d;
    public final Map<String, SlcElement> e;
    public final com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d f;
    public final List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> g;
    public final List<d63.d> h;
    public final List<j63.c> i;
    public final j63.a j;
    public final BottomButtonVO k;
    public final TopRightControlsVO l;
    public final HalfStrandVO m;
    public final l73.c n;
    public final PendantContainerVO o;
    public final SmallVideoWindowVO p;
    public final ShopFloatEntryVO q;
    public final BackToTopEntryVO r;
    public final PlayBackEntryVO s;
    public final AnchorV4HeadV2VO t;
    public final PromotionRecommendResponse u;
    public final com.bytedance.android.shopping.anchorv4.dto.business.d v;
    public final com.bytedance.android.shopping.anchorv3.i w;
    public final List<ScrollNode> x;
    public final com.bytedance.android.shopping.anchorv4.vm.a y;
    public final String z;

    public n() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L84;
        n r4 = (n) r3;
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
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
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
        if (Intrinsics.areEqual(this.v, r4.v) == true) goto L50;
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
        if (Intrinsics.areEqual(this.D, r4.D) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.E, r4.E) == true) goto L68;
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
        if (Intrinsics.areEqual(this.I, r4.I) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.J, r4.J) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.K, r4.K) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.L, r4.L) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.M, r4.M) == true) goto L127;
        return false;
    L127:
        return true;
    L84:
        return false;
    }

    public final int hashCode() {
        PageMeta r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Control r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, SlcElement> r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        List<d63.d> r22 = this.h;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        List<j63.c> r25 = this.i;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        j63.a r28 = this.j;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        BottomButtonVO r31 = this.k;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        TopRightControlsVO r34 = this.l;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        HalfStrandVO r37 = this.m;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        l73.c r40 = this.n;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        PendantContainerVO r43 = this.o;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        SmallVideoWindowVO r46 = this.p;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        ShopFloatEntryVO r49 = this.q;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        BackToTopEntryVO r52 = this.r;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        PlayBackEntryVO r55 = this.s;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        AnchorV4HeadV2VO r58 = this.t;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        PromotionRecommendResponse r61 = this.u;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.d r64 = this.v;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        com.bytedance.android.shopping.anchorv3.i r67 = this.w;
        if (r67 == null) goto L93;
        int r68 = r67.hashCode();
    L94:
        int r69 = (r66 + r68) * 31;
        List<ScrollNode> r70 = this.x;
        if (r70 == null) goto L97;
        int r71 = r70.hashCode();
    L98:
        int r72 = (r69 + r71) * 31;
        com.bytedance.android.shopping.anchorv4.vm.a r73 = this.y;
        if (r73 == null) goto L101;
        int r74 = r73.hashCode();
    L102:
        int r75 = (r72 + r74) * 31;
        String r76 = this.z;
        if (r76 == null) goto L105;
        int r77 = r76.hashCode();
    L106:
        int r78 = (r75 + r77) * 31;
        Map<String, PendantsComponentVO> r79 = this.A;
        if (r79 == null) goto L109;
        int r80 = r79.hashCode();
    L110:
        int r81 = (r78 + r80) * 31;
        e73.a r82 = this.B;
        if (r82 == null) goto L113;
        int r84 = r82.hashCode();
    L114:
        int r85 = (r81 + r84) * 31;
        JSONObject r86 = this.C;
        if (r86 == null) goto L117;
        int r87 = r86.hashCode();
    L118:
        int r88 = (r85 + r87) * 31;
        List<String> r89 = this.D;
        if (r89 == null) goto L121;
        int r90 = r89.hashCode();
    L122:
        int r91 = (r88 + r90) * 31;
        Map<String, Object> r92 = this.E;
        if (r92 == null) goto L125;
        int r94 = r92.hashCode();
    L126:
        int r95 = (r91 + r94) * 31;
        TopNavVO r96 = this.F;
        if (r96 == null) goto L129;
        int r97 = r96.hashCode();
    L130:
        int r98 = (r95 + r97) * 31;
        BottomNavVO r99 = this.G;
        if (r99 == null) goto L133;
        int r100 = r99.hashCode();
    L134:
        int r101 = (r98 + r100) * 31;
        TopBannerVO r102 = this.H;
        if (r102 == null) goto L137;
        int r103 = r102.hashCode();
    L138:
        int r104 = (r101 + r103) * 31;
        GalleryVO r105 = this.I;
        if (r105 == null) goto L141;
        int r106 = r105.hashCode();
    L142:
        int r107 = (r104 + r106) * 31;
        String r108 = this.J;
        if (r108 == null) goto L145;
        int r109 = r108.hashCode();
    L146:
        int r110 = (r107 + r109) * 31;
        String r111 = this.K;
        if (r111 == null) goto L149;
        int r112 = r111.hashCode();
    L150:
        int r113 = (r110 + r112) * 31;
        HeadMoreVideo r114 = this.L;
        if (r114 == null) goto L153;
        int r115 = r114.hashCode();
    L154:
        int r116 = (r113 + r115) * 31;
        Map<String, IAction> r117 = this.M;
        if (r117 == null) goto L158;
        r1 = r117.hashCode();
    L158:
        return r116 + r1;
    L153:
        r115 = 0;
        goto L154
    L149:
        r112 = 0;
        goto L150
    L145:
        r109 = 0;
        goto L146
    L141:
        r106 = 0;
        goto L142
    L137:
        r103 = 0;
        goto L138
    L133:
        r100 = 0;
        goto L134
    L129:
        r97 = 0;
        goto L130
    L125:
        r94 = 0;
        goto L126
    L121:
        r90 = 0;
        goto L122
    L117:
        r87 = 0;
        goto L118
    L113:
        r84 = 0;
        goto L114
    L109:
        r80 = 0;
        goto L110
    L105:
        r77 = 0;
        goto L106
    L101:
        r74 = 0;
        goto L102
    L97:
        r71 = 0;
        goto L98
    L93:
        r68 = 0;
        goto L94
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
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
        return "PdpNetworkData(pageMeta=" + this.a + ", control=" + this.b + ", logId=" + this.c + ", componentVOS=" + this.d + ", templates=" + this.e + ", detailHeadVO=" + this.f + ", detailImageVOS=" + this.g + ", unifiedTipsVOS=" + this.h + ", guessUVOS=" + this.i + ", showGuessULike=" + this.j + ", bottomButtonVO=" + this.k + ", topRightControlsVO=" + this.l + ", halfStrandVO=" + this.m + ", questionnaireEntrance=" + this.n + ", pendantContainerVO=" + this.o + ", smallVideoWindowVO=" + this.p + ", shopFloatEntry=" + this.q + ", backToTopEntry=" + this.r + ", playBackEntryVO=" + this.s + ", headV2=" + this.t + ", shopRecommends=" + this.u + ", findSameGoods=" + this.v + ", searchSuggest=" + this.w + ", scrollNodes=" + this.x + ", collapseInfo=" + this.y + ", backgroundColor=" + this.z + ", pendantsVOS=" + this.A + ", globalAction=" + this.B + ", pdpLynxDataAfterPack=" + this.C + ", detailImageList=" + this.D + ", supermarketCartBarData=" + this.E + ", topNavVO=" + this.F + ", bottomNavVO=" + this.G + ", topBannerVO=" + this.H + ", galleryVO=" + this.I + ", commentPreloadData=" + this.J + ", mcpData=" + this.K + ", moreVideo=" + this.L + ", actionStorage=" + this.M + ")";
    }

    public /* synthetic */ n(int r41) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public n(PageMeta r3, Control r4, String r5, List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r6, Map<String, SlcElement> r7, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r8, List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r9, List<d63.d> r10, List<j63.c> r11, j63.a r12, BottomButtonVO r13, TopRightControlsVO r14, HalfStrandVO r15, l73.c r16, PendantContainerVO r17, SmallVideoWindowVO r18, ShopFloatEntryVO r19, BackToTopEntryVO r20, PlayBackEntryVO r21, AnchorV4HeadV2VO r22, PromotionRecommendResponse r23, com.bytedance.android.shopping.anchorv4.dto.business.d r24, com.bytedance.android.shopping.anchorv3.i r25, List<ScrollNode> r26, com.bytedance.android.shopping.anchorv4.vm.a r27, String r28, Map<String, PendantsComponentVO> r29, e73.a r30, JSONObject r31, List<String> r32, Map<String, ? extends Object> r33, TopNavVO r34, BottomNavVO r35, TopBannerVO r36, GalleryVO r37, String r38, String r39, HeadMoreVideo r40, Map<String, ? extends IAction> r41) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
        this.E = r33;
        this.F = r34;
        this.G = r35;
        this.H = r36;
        this.I = r37;
        this.J = r38;
        this.K = r39;
        this.L = r40;
        this.M = r41;
    }

    public static n a(n r39, PageMeta r40, Control r41, String r42, List r43, Map r44, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r45, List r46, List r47, List r48, BottomButtonVO r49, TopRightControlsVO r50, HalfStrandVO r51, l73.c r52, PendantContainerVO r53, SmallVideoWindowVO r54, ShopFloatEntryVO r55, BackToTopEntryVO r56, PlayBackEntryVO r57, AnchorV4HeadV2VO r58, PromotionRecommendResponse r59, com.bytedance.android.shopping.anchorv4.dto.business.d r60, com.bytedance.android.shopping.anchorv3.i r61, List r62, com.bytedance.android.shopping.anchorv4.vm.a r63, String r64, Map r65, e73.a r66, JSONObject r67, List r68, Map r69, TopNavVO r70, BottomNavVO r71, TopBannerVO r72, GalleryVO r73, String r74, String r75, HeadMoreVideo r76, Map r77, int r78, int r79) {
        if ((r78 & 1) == 0) goto L5;
        PageMeta r2 = r39.a;
    L7:
        if ((r78 & 2) == 0) goto L9;
        Control r3 = r39.b;
    L11:
        if ((r78 & 4) == 0) goto L13;
        String r4 = r39.c;
    L15:
        if ((r78 & 8) == 0) goto L17;
        List r5 = r39.d;
    L19:
        if ((r78 & 16) == 0) goto L21;
        Map r6 = r39.e;
    L23:
        if ((r78 & 32) == 0) goto L25;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r7 = r39.f;
    L27:
        if ((r78 & 64) == 0) goto L29;
        List r8 = r39.g;
    L31:
        if ((r78 & 128) == 0) goto L33;
        List r9 = r39.h;
    L35:
        if ((r78 & 256) == 0) goto L37;
        List r10 = r39.i;
    L39:
        if ((r78 & 512) == 0) goto L41;
        j63.a r11 = r39.j;
    L43:
        if ((r78 & 1024) == 0) goto L45;
        BottomButtonVO r12 = r39.k;
    L47:
        if ((r78 & 2048) == 0) goto L49;
        TopRightControlsVO r13 = r39.l;
    L51:
        if ((r78 & 4096) == 0) goto L53;
        HalfStrandVO r14 = r39.m;
    L55:
        if ((r78 & 8192) == 0) goto L57;
        l73.c r15 = r39.n;
    L58:
        l73.c r16 = r15;
        if ((r78 & 16384) == 0) goto L61;
        PendantContainerVO r17 = r39.o;
    L63:
        if ((r78 & 32768) == 0) goto L65;
        SmallVideoWindowVO r18 = r39.p;
    L67:
        if ((r78 & 65536) == 0) goto L69;
        ShopFloatEntryVO r19 = r39.q;
    L71:
        if ((r78 & 131072) == 0) goto L73;
        BackToTopEntryVO r110 = r39.r;
    L75:
        if ((r78 & 262144) == 0) goto L77;
        PlayBackEntryVO r111 = r39.s;
    L79:
        if ((r78 & 524288) == 0) goto L81;
        AnchorV4HeadV2VO r112 = r39.t;
    L83:
        if ((r78 & 1048576) == 0) goto L85;
        PromotionRecommendResponse r113 = r39.u;
    L87:
        if ((r78 & 2097152) == 0) goto L89;
        com.bytedance.android.shopping.anchorv4.dto.business.d r114 = r39.v;
    L91:
        if ((r78 & 4194304) == 0) goto L93;
        com.bytedance.android.shopping.anchorv3.i r115 = r39.w;
    L95:
        if ((r78 & 8388608) == 0) goto L97;
        List r116 = r39.x;
    L99:
        if ((r78 & 16777216) == 0) goto L101;
        com.bytedance.android.shopping.anchorv4.vm.a r117 = r39.y;
    L103:
        if ((r78 & 33554432) == 0) goto L105;
        String r118 = r39.z;
    L107:
        if ((r78 & 67108864) == 0) goto L109;
        Map r119 = r39.A;
    L111:
        if ((r78 & 134217728) == 0) goto L113;
        e73.a r120 = r39.B;
    L115:
        if ((r78 & 268435456) == 0) goto L117;
        JSONObject r121 = r39.C;
    L119:
        if ((r78 & 536870912) == 0) goto L121;
        List r122 = r39.D;
    L123:
        if ((r78 & 1073741824) == 0) goto L125;
        Map r123 = r39.E;
    L127:
        if ((r78 & Integer.MIN_VALUE) == 0) goto L129;
        TopNavVO r1 = r39.F;
    L130:
        TopNavVO r710 = r1;
        if ((r79 & 1) == 0) goto L133;
        BottomNavVO r20 = r39.G;
    L135:
        if ((r79 & 2) == 0) goto L137;
        TopBannerVO r21 = r39.H;
    L139:
        if ((r79 & 4) == 0) goto L141;
        GalleryVO r22 = r39.I;
    L143:
        if ((r79 & 8) == 0) goto L145;
        String r23 = r39.J;
    L147:
        if ((r79 & 16) == 0) goto L149;
        String r24 = r39.K;
    L151:
        if ((r79 & 32) == 0) goto L153;
        HeadMoreVideo r25 = r39.L;
    L155:
        if ((r79 & 64) == 0) goto L157;
        Map r26 = r39.M;
    L158:
        r39.getClass();
        return new n(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r710, r20, r21, r22, r23, r24, r25, r26);
    L157:
        r26 = r77;
        goto L158
    L153:
        r25 = r76;
        goto L155
    L149:
        r24 = r75;
        goto L151
    L145:
        r23 = r74;
        goto L147
    L141:
        r22 = r73;
        goto L143
    L137:
        r21 = r72;
        goto L139
    L133:
        r20 = r71;
        goto L135
    L129:
        r1 = r70;
        goto L130
    L125:
        r123 = r69;
        goto L127
    L121:
        r122 = r68;
        goto L123
    L117:
        r121 = r67;
        goto L119
    L113:
        r120 = r66;
        goto L115
    L109:
        r119 = r65;
        goto L111
    L105:
        r118 = r64;
        goto L107
    L101:
        r117 = r63;
        goto L103
    L97:
        r116 = r62;
        goto L99
    L93:
        r115 = r61;
        goto L95
    L89:
        r114 = r60;
        goto L91
    L85:
        r113 = r59;
        goto L87
    L81:
        r112 = r58;
        goto L83
    L77:
        r111 = r57;
        goto L79
    L73:
        r110 = r56;
        goto L75
    L69:
        r19 = r55;
        goto L71
    L65:
        r18 = r54;
        goto L67
    L61:
        r17 = r53;
        goto L63
    L57:
        r15 = r52;
        goto L58
    L53:
        r14 = r51;
        goto L55
    L49:
        r13 = r50;
        goto L51
    L45:
        r12 = r49;
        goto L47
    L41:
        r11 = null;
        goto L43
    L37:
        r10 = r48;
        goto L39
    L33:
        r9 = r47;
        goto L35
    L29:
        r8 = r46;
        goto L31
    L25:
        r7 = r45;
        goto L27
    L21:
        r6 = r44;
        goto L23
    L17:
        r5 = r43;
        goto L19
    L13:
        r4 = r42;
        goto L15
    L9:
        r3 = r41;
        goto L11
    L5:
        r2 = r40;
        goto L7
    }
}
