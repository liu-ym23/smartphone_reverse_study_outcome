package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public volatile int a;
    public String b;
    public int c;
    public boolean d;
    public boolean e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public boolean k;
    public final boolean l;
    public final String m;
    public boolean n;
    public int o;
    public final String p;
    public final String q;
    public final boolean r;
    public final String s;
    public boolean t;
    public final int u;
    public final int v;
    public String w;
    public final boolean x;
    public final String y;
    public final String z;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L48;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L16;
        return false;
    L16:
        if (this.k == r4.k) goto L18;
        return false;
    L18:
        if (this.l == r4.l) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L22;
        return false;
    L22:
        if (this.n == r4.n) goto L24;
        return false;
    L24:
        if (this.o == r4.o) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L30;
        return false;
    L30:
        if (this.r == r4.r) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.s, r4.s) == true) goto L34;
        return false;
    L34:
        if (this.t == r4.t) goto L36;
        return false;
    L36:
        if (this.u == r4.u) goto L38;
        return false;
    L38:
        if (this.v == r4.v) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.w, r4.w) == true) goto L42;
        return false;
    L42:
        if (this.x == r4.x) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.y, r4.y) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.z, r4.z) == true) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.g;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.h;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.i;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.j;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.k;
        ?? r17 = 1;
        ?? r18 = r16;
        if (r16 == false) goto L25;
        r18 = 1;
    L25:
        int r19 = (r15 + r18) * 31;
        boolean r20 = this.l;
        ?? r21 = r20;
        if (r20 == false) goto L28;
        r21 = 1;
    L28:
        int r22 = (r19 + r21) * 31;
        String r23 = this.m;
        if (r23 == null) goto L31;
        int r24 = r23.hashCode();
    L32:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.n;
        ?? r27 = r26;
        if (r26 == false) goto L35;
        r27 = 1;
    L35:
        int r28 = (((r25 + r27) * 31) + this.o) * 31;
        String r29 = this.p;
        if (r29 == null) goto L38;
        int r30 = r29.hashCode();
    L39:
        int r31 = (r28 + r30) * 31;
        String r32 = this.q;
        if (r32 == null) goto L42;
        int r33 = r32.hashCode();
    L43:
        int r34 = (r31 + r33) * 31;
        boolean r35 = this.r;
        ?? r36 = r35;
        if (r35 == false) goto L46;
        r36 = 1;
    L46:
        int r37 = (r34 + r36) * 31;
        String r38 = this.s;
        if (r38 == null) goto L49;
        int r39 = r38.hashCode();
    L50:
        int r40 = (r37 + r39) * 31;
        boolean r41 = this.t;
        ?? r42 = r41;
        if (r41 == false) goto L53;
        r42 = 1;
    L53:
        int r43 = (((((r40 + r42) * 31) + this.u) * 31) + this.v) * 31;
        String r44 = this.w;
        if (r44 == null) goto L56;
        int r45 = r44.hashCode();
    L57:
        int r46 = (r43 + r45) * 31;
        boolean r47 = this.x;
        if (r47 == true) goto L61;
        r17 = r47;
    L61:
        int r48 = (r46 + r17) * 31;
        String r49 = this.y;
        if (r49 == null) goto L64;
        int r50 = r49.hashCode();
    L65:
        int r51 = (r48 + r50) * 31;
        String r52 = this.z;
        if (r52 == null) goto L69;
        r1 = r52.hashCode();
    L69:
        return r51 + r1;
    L64:
        r50 = 0;
        goto L65
    L56:
        r45 = 0;
        goto L57
    L49:
        r39 = 0;
        goto L50
    L42:
        r33 = 0;
        goto L43
    L38:
        r30 = 0;
        goto L39
    L31:
        r24 = 0;
        goto L32
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
        return "LivePromotionListPageRequestParam(authorId=" + this.f + ", secAuthorId=" + this.g + ", roomId=" + this.h + ", containerRoomId=" + this.i + ", roomUniqueKey=" + this.j + ", isLinkmic=" + this.k + ", isDefaultTab=" + this.l + ", liveListChannel=" + this.m + ", autoApplyCoupon=" + this.n + ", listApplyCoupon=" + this.o + ", extraEntranceInfo=" + this.p + ", monitorName=" + this.q + ", closeOrderBanner=" + this.r + ", relatedInfo=" + this.s + ", recommendedProductDisplayed=" + this.t + ", pageSize=" + this.u + ", prefetchDistance=" + this.v + ", anchorTabUniqueIndex=" + this.w + ", isInSplit=" + this.x + ", cartAnimRelatedInfo=" + this.y + ", preferredCoupon=" + this.z + ")";
    }

    public final String b() {
        return ECEventUtilsV2.c(ECEventUtilsV2.b, "live_list_card", this.m, this.p);
    }

    public static c a(c r24) {
        String r1 = r24.f;
        String r2 = r24.g;
        String r3 = r24.h;
        String r4 = r24.i;
        String r5 = r24.j;
        boolean r6 = r24.k;
        boolean r7 = r24.l;
        String r8 = r24.m;
        boolean r9 = r24.n;
        int r10 = r24.o;
        String r11 = r24.p;
        String r12 = r24.q;
        boolean r13 = r24.r;
        String r14 = r24.s;
        boolean r15 = r24.t;
        int r16 = r24.u;
        int r17 = r24.v;
        String r18 = r24.w;
        boolean r19 = r24.x;
        String r110 = r24.y;
        String r111 = r24.z;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r1, "authorId");
        Intrinsics.checkNotNullParameter(r2, "secAuthorId");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "containerRoomId");
        Intrinsics.checkNotNullParameter(r5, "roomUniqueKey");
        return new c(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111);
    }

    public /* synthetic */ c(String r26, String r27, String r28, String r29, String r30, boolean r31, boolean r32, String r33, boolean r34, int r35, String r36, String r37, boolean r38, String r39, boolean r40, String r41, boolean r42, String r43, String r44, int r45) {
        if ((r45 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r45 & 2048) == 0) goto L9;
        String r15 = null;
    L11:
        if ((r45 & 8192) == 0) goto L13;
        String r17 = null;
    L15:
        if ((r45 & 16384) == 0) goto L17;
        boolean r18 = false;
    L19:
        if ((32768 & r45) == 0) goto L21;
        int r19 = EComABUtils.liveListLoadPageSize();
    L23:
        if ((65536 & r45) == 0) goto L25;
        int r20 = EComABUtils.liveListLoadPagePrefetchDistance();
    L27:
        if ((131072 & r45) == 0) goto L29;
        String r21 = null;
    L31:
        if ((262144 & r45) == 0) goto L33;
        boolean r22 = false;
    L35:
        if ((524288 & r45) == 0) goto L37;
        String r23 = null;
    L39:
        if ((r45 & 1048576) == 0) goto L41;
        String r24 = null;
    L42:
        this(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r14, r15, r38, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L41:
        r24 = r44;
        goto L42
    L37:
        r23 = r43;
        goto L39
    L33:
        r22 = r42;
        goto L35
    L29:
        r21 = r41;
        goto L31
    L25:
        r20 = 0;
        goto L27
    L21:
        r19 = 0;
        goto L23
    L17:
        r18 = r40;
        goto L19
    L13:
        r17 = r39;
        goto L15
    L9:
        r15 = r37;
        goto L11
    L5:
        r14 = r36;
        goto L7
    }

    public c(String r8, String r9, String r10, String r11, String r12, boolean r13, boolean r14, String r15, boolean r16, int r17, String r18, String r19, boolean r20, String r21, boolean r22, int r23, int r24, String r25, boolean r26, String r27, String r28) {
        Intrinsics.checkNotNullParameter(r8, "authorId");
        Intrinsics.checkNotNullParameter(r9, "secAuthorId");
        Intrinsics.checkNotNullParameter(r10, "roomId");
        Intrinsics.checkNotNullParameter(r11, "containerRoomId");
        Intrinsics.checkNotNullParameter(r12, "roomUniqueKey");
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
    }
}
