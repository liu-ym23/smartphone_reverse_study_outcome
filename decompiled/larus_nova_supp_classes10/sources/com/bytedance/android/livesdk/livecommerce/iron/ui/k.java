package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k {
    public final wj2.g A;
    public final RoomContextController B;
    public final String C;
    public final String D;
    public final fi2.a a;
    public final Map<String, String> b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;
    public final int h;
    public final String i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final int s;
    public final String t;
    public final LiveRoomParams u;
    public final ml.b v;
    public final String w;
    public final JSONObject x;
    public final boolean y;
    public final String z;

    public k() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L66;
        k r4 = (k) r3;
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
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L28;
        return false;
    L28:
        if (this.l == r4.l) goto L30;
        return false;
    L30:
        if (this.m == r4.m) goto L32;
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
        if (this.s == r4.s) goto L44;
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
        if (this.y == r4.y) goto L56;
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
        if (Intrinsics.areEqual(this.D, r4.D) == true) goto L100;
        return false;
    L100:
        return true;
    L66:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v100 */
    /* JADX WARN: Type inference failed for: r2v101 */
    /* JADX WARN: Type inference failed for: r2v102 */
    /* JADX WARN: Type inference failed for: r2v103 */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v99 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        fi2.a r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.g;
        ?? r20 = 1;
        ?? r21 = r19;
        if (r19 == false) goto L29;
        r21 = 1;
    L29:
        int r22 = (((r18 + r21) * 31) + this.h) * 31;
        String r23 = this.i;
        if (r23 == null) goto L32;
        int r24 = r23.hashCode();
    L33:
        int r25 = (r22 + r24) * 31;
        String r26 = this.j;
        if (r26 == null) goto L36;
        int r27 = r26.hashCode();
    L37:
        int r28 = (r25 + r27) * 31;
        boolean r29 = this.k;
        ?? r30 = r29;
        if (r29 == false) goto L40;
        r30 = 1;
    L40:
        int r31 = (r28 + r30) * 31;
        boolean r32 = this.l;
        ?? r33 = r32;
        if (r32 == false) goto L43;
        r33 = 1;
    L43:
        int r34 = (r31 + r33) * 31;
        boolean r35 = this.m;
        ?? r36 = r35;
        if (r35 == false) goto L46;
        r36 = 1;
    L46:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.n;
        ?? r39 = r38;
        if (r38 == false) goto L49;
        r39 = 1;
    L49:
        int r40 = (r37 + r39) * 31;
        String r41 = this.o;
        if (r41 == null) goto L52;
        int r42 = r41.hashCode();
    L53:
        int r43 = (r40 + r42) * 31;
        String r44 = this.p;
        if (r44 == null) goto L56;
        int r45 = r44.hashCode();
    L57:
        int r46 = (r43 + r45) * 31;
        String r47 = this.q;
        if (r47 == null) goto L60;
        int r48 = r47.hashCode();
    L61:
        int r49 = (r46 + r48) * 31;
        String r50 = this.r;
        if (r50 == null) goto L64;
        int r51 = r50.hashCode();
    L65:
        int r52 = (((r49 + r51) * 31) + this.s) * 31;
        String r53 = this.t;
        if (r53 == null) goto L68;
        int r54 = r53.hashCode();
    L69:
        int r55 = (r52 + r54) * 31;
        LiveRoomParams r56 = this.u;
        if (r56 == null) goto L72;
        int r57 = r56.hashCode();
    L73:
        int r58 = (r55 + r57) * 31;
        ml.b r59 = this.v;
        if (r59 == null) goto L76;
        int r60 = r59.hashCode();
    L77:
        int r61 = (r58 + r60) * 31;
        String r62 = this.w;
        if (r62 == null) goto L80;
        int r63 = r62.hashCode();
    L81:
        int r64 = (r61 + r63) * 31;
        JSONObject r65 = this.x;
        if (r65 == null) goto L84;
        int r66 = r65.hashCode();
    L85:
        int r67 = (r64 + r66) * 31;
        boolean r68 = this.y;
        if (r68 == true) goto L89;
        r20 = r68;
    L89:
        int r69 = (r67 + r20) * 31;
        String r70 = this.z;
        if (r70 == null) goto L92;
        int r71 = r70.hashCode();
    L93:
        int r72 = (r69 + r71) * 31;
        wj2.g r73 = this.A;
        if (r73 == null) goto L96;
        int r74 = r73.hashCode();
    L97:
        int r75 = (r72 + r74) * 31;
        RoomContextController r76 = this.B;
        if (r76 == null) goto L100;
        int r77 = r76.hashCode();
    L101:
        int r78 = (r75 + r77) * 31;
        String r79 = this.C;
        if (r79 == null) goto L104;
        int r80 = r79.hashCode();
    L105:
        int r81 = (r78 + r80) * 31;
        String r82 = this.D;
        if (r82 == null) goto L109;
        r1 = r82.hashCode();
    L109:
        return r81 + r1;
    L104:
        r80 = 0;
        goto L105
    L100:
        r77 = 0;
        goto L101
    L96:
        r74 = 0;
        goto L97
    L92:
        r71 = 0;
        goto L93
    L84:
        r66 = 0;
        goto L85
    L80:
        r63 = 0;
        goto L81
    L76:
        r60 = 0;
        goto L77
    L72:
        r57 = 0;
        goto L73
    L68:
        r54 = 0;
        goto L69
    L64:
        r51 = 0;
        goto L65
    L60:
        r48 = 0;
        goto L61
    L56:
        r45 = 0;
        goto L57
    L52:
        r42 = 0;
        goto L53
    L36:
        r27 = 0;
        goto L37
    L32:
        r24 = 0;
        goto L33
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
        return "IronPromotionFragmentArgument(liveRoomService=" + this.a + ", generalParams=" + this.b + ", broadcastId=" + this.c + ", broadcastSecId=" + this.d + ", roomId=" + this.e + ", couponMetaId=" + this.f + ", autoApplyCoupon=" + this.g + ", listApplyCoupon=" + this.h + ", liveListChannel=" + this.i + ", promotionId=" + this.j + ", isPromotionId=" + this.k + ", isFollowed=" + this.l + ", isVsVertical=" + this.m + ", isFromLiveRoom=" + this.n + ", extraEntranceInfo=" + this.o + ", openMethod=" + this.p + ", shoppingCartTaskItemId=" + this.q + ", shoppingCartTaskMetaID=" + this.r + ", shoppingCartTaskScene=" + this.s + ", sourceBtmToken=" + this.t + ", liveRoomParams=" + this.u + ", connectRoom=" + this.v + ", containerRoomId=" + this.w + ", schemaEventParams=" + this.x + ", recommendedProductDisplayed=" + this.y + ", tabUniqueIndex=" + this.z + ", initialAction=" + this.A + ", roomContextController=" + this.B + ", cartAnimRelatedInfo=" + this.C + ", preferredCoupon=" + this.D + ")";
    }

    public k(xh2.b r24, String r25, String r26, String r27, String r28, boolean r29, int r30, String r31, String r32, boolean r33, boolean r34, String r35, String r36, String r37, String r38, int r39, String r40, LiveRoomParams r41, ml.b r42, String r43, JSONObject r44, boolean r45, String r46, wj2.g r47, RoomContextController r48, String r49, String r50, int r51) {
        if ((r51 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L5;
        int r4 = -1;
    L7:
        if ((r51 & 2048) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r51 & 8192) == 0) goto L13;
        boolean r7 = true;
    L15:
        if ((65536 & r51) == 0) goto L17;
        String r8 = null;
    L19:
        if ((131072 & r51) == 0) goto L21;
        String r10 = null;
    L23:
        if ((262144 & r51) == 0) goto L25;
        int r11 = 0;
    L27:
        if ((524288 & r51) == 0) goto L29;
        String r12 = null;
    L31:
        if ((1048576 & r51) == 0) goto L33;
        LiveRoomParams r13 = null;
    L35:
        if ((2097152 & r51) == 0) goto L37;
        ml.b r14 = null;
    L39:
        if ((4194304 & r51) == 0) goto L41;
        String r15 = null;
    L43:
        if ((r51 & 8388608) == 0) goto L45;
        JSONObject r17 = null;
    L47:
        if ((r51 & 16777216) == 0) goto L49;
        boolean r18 = false;
    L51:
        if ((r51 & 33554432) == 0) goto L53;
        String r19 = null;
    L55:
        if ((r51 & 67108864) == 0) goto L57;
        wj2.g r20 = null;
    L59:
        if ((r51 & 134217728) == 0) goto L61;
        RoomContextController r21 = null;
    L63:
        if ((r51 & 268435456) == 0) goto L65;
        String r22 = null;
    L67:
        if ((r51 & 536870912) == 0) goto L69;
        String r3 = null;
    L70:
        Intrinsics.checkNotNullParameter(r24, "liveRoomService");
        Intrinsics.checkNotNullParameter(r36, "openMethod");
        this.a = r24;
        this.b = null;
        this.c = r25;
        this.d = r26;
        this.e = r27;
        this.f = r28;
        this.g = r29;
        this.h = r4;
        this.i = r31;
        this.j = r32;
        this.k = r33;
        this.l = r5;
        this.m = false;
        this.n = r7;
        this.o = r35;
        this.p = r36;
        this.q = r8;
        this.r = r10;
        this.s = r11;
        this.t = r12;
        this.u = r13;
        this.v = r14;
        this.w = r15;
        this.x = r17;
        this.y = r18;
        this.z = r19;
        this.A = r20;
        this.B = r21;
        this.C = r22;
        this.D = r3;
        return;
    L69:
        r3 = r50;
        goto L70
    L65:
        r22 = r49;
        goto L67
    L61:
        r21 = r48;
        goto L63
    L57:
        r20 = r47;
        goto L59
    L53:
        r19 = r46;
        goto L55
    L49:
        r18 = r45;
        goto L51
    L45:
        r17 = r44;
        goto L47
    L41:
        r15 = r43;
        goto L43
    L37:
        r14 = r42;
        goto L39
    L33:
        r13 = r41;
        goto L35
    L29:
        r12 = r40;
        goto L31
    L25:
        r11 = r39;
        goto L27
    L21:
        r10 = r38;
        goto L23
    L17:
        r8 = r37;
        goto L19
    L13:
        r7 = false;
        goto L15
    L9:
        r5 = r34;
        goto L11
    L5:
        r4 = r30;
        goto L7
    }
}
