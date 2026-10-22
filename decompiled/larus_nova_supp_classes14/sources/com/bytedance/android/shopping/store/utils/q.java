package com.bytedance.android.shopping.store.utils;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final Integer k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final boolean t;
    public final String u;
    public final String v;
    public final String w;

    public static final class a {
    }

    static {
    }

    public q() {
        this(null, null, null, null, null, null, null, null, null, 8388607);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof q) == false) goto L52;
        q r4 = (q) r3;
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
        if (this.f == r4.f) goto L18;
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
        if (this.t == r4.t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.u, r4.u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.v, r4.v) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.w, r4.w) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v81 */
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
        String r4 = this.b;
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
        boolean r16 = this.f;
        ?? r17 = 1;
        ?? r18 = r16;
        if (r16 == false) goto L25;
        r18 = 1;
    L25:
        int r19 = (r15 + r18) * 31;
        String r20 = this.g;
        if (r20 == null) goto L28;
        int r21 = r20.hashCode();
    L29:
        int r22 = (r19 + r21) * 31;
        String r23 = this.h;
        if (r23 == null) goto L32;
        int r24 = r23.hashCode();
    L33:
        int r25 = (r22 + r24) * 31;
        String r26 = this.i;
        if (r26 == null) goto L36;
        int r27 = r26.hashCode();
    L37:
        int r28 = (r25 + r27) * 31;
        String r29 = this.j;
        if (r29 == null) goto L40;
        int r30 = r29.hashCode();
    L41:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.k;
        if (r32 == null) goto L44;
        int r33 = r32.hashCode();
    L45:
        int r34 = (r31 + r33) * 31;
        String r35 = this.l;
        if (r35 == null) goto L48;
        int r36 = r35.hashCode();
    L49:
        int r37 = (r34 + r36) * 31;
        String r38 = this.m;
        if (r38 == null) goto L52;
        int r39 = r38.hashCode();
    L53:
        int r40 = (r37 + r39) * 31;
        String r41 = this.n;
        if (r41 == null) goto L56;
        int r42 = r41.hashCode();
    L57:
        int r43 = (r40 + r42) * 31;
        String r44 = this.o;
        if (r44 == null) goto L60;
        int r45 = r44.hashCode();
    L61:
        int r46 = (r43 + r45) * 31;
        String r47 = this.p;
        if (r47 == null) goto L64;
        int r48 = r47.hashCode();
    L65:
        int r49 = (r46 + r48) * 31;
        String r50 = this.q;
        if (r50 == null) goto L68;
        int r51 = r50.hashCode();
    L69:
        int r52 = (r49 + r51) * 31;
        String r53 = this.r;
        if (r53 == null) goto L72;
        int r54 = r53.hashCode();
    L73:
        int r55 = (r52 + r54) * 31;
        String r56 = this.s;
        if (r56 == null) goto L76;
        int r57 = r56.hashCode();
    L77:
        int r58 = (r55 + r57) * 31;
        boolean r59 = this.t;
        if (r59 == true) goto L81;
        r17 = r59;
    L81:
        int r60 = (r58 + r17) * 31;
        String r61 = this.u;
        if (r61 == null) goto L84;
        int r62 = r61.hashCode();
    L85:
        int r63 = (r60 + r62) * 31;
        String r64 = this.v;
        if (r64 == null) goto L88;
        int r65 = r64.hashCode();
    L89:
        int r66 = (r63 + r65) * 31;
        String r67 = this.w;
        if (r67 == null) goto L93;
        r1 = r67.hashCode();
    L93:
        return r66 + r1;
    L88:
        r65 = 0;
        goto L89
    L84:
        r62 = 0;
        goto L85
    L76:
        r57 = 0;
        goto L77
    L72:
        r54 = 0;
        goto L73
    L68:
        r51 = 0;
        goto L69
    L64:
        r48 = 0;
        goto L65
    L60:
        r45 = 0;
        goto L61
    L56:
        r42 = 0;
        goto L57
    L52:
        r39 = 0;
        goto L53
    L48:
        r36 = 0;
        goto L49
    L44:
        r33 = 0;
        goto L45
    L40:
        r30 = 0;
        goto L41
    L36:
        r27 = 0;
        goto L37
    L32:
        r24 = 0;
        goto L33
    L28:
        r21 = 0;
        goto L29
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
        return "ProductActionEventContext(ecomEntranceFrom=" + this.a + ", searchParams=" + this.b + ", preProductId=" + this.c + ", preRoomId=" + this.d + ", preGroupId=" + this.e + ", isEcShare=" + this.f + ", shareContent=" + this.g + ", shareObject=" + this.h + ", pageName=" + this.i + ", entranceLocation=" + this.j + ", followStatus=" + this.k + ", tempId=" + this.l + ", storeSourcePage=" + this.m + ", storeSourceMethod=" + this.n + ", storeGroupType=" + this.o + ", liveAnchorId=" + this.p + ", productForm=" + this.q + ", tabNameSecond=" + this.r + ", isDiscountSelected=" + this.s + ", isCustom=" + this.t + ", customerId=" + this.u + ", iconType=" + this.v + ", passThroughApi=" + this.w + ")";
    }

    public /* synthetic */ q(String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, int r37) {
        if ((r37 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r37 & 256) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r37 & 512) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r37 & 4096) == 0) goto L17;
        String r16 = null;
    L19:
        if ((r37 & 8192) == 0) goto L21;
        String r17 = null;
    L23:
        if ((r37 & 16384) == 0) goto L25;
        String r18 = null;
    L27:
        if ((65536 & r37) == 0) goto L29;
        String r20 = null;
    L31:
        if ((131072 & r37) == 0) goto L33;
        String r21 = CommentServiceId.HOT_SPOT;
    L35:
        if ((r37 & 262144) == 0) goto L37;
        String r22 = "0";
    L38:
        this(r4, null, null, null, null, false, null, null, r12, r13, null, null, r16, r17, r18, null, r20, r21, r22, false, null, null, null);
        return;
    L37:
        r22 = r36;
        goto L38
    L33:
        r21 = r35;
        goto L35
    L29:
        r20 = r34;
        goto L31
    L25:
        r18 = r33;
        goto L27
    L21:
        r17 = r32;
        goto L23
    L17:
        r16 = r31;
        goto L19
    L13:
        r13 = r30;
        goto L15
    L9:
        r12 = r29;
        goto L11
    L5:
        r4 = r28;
        goto L7
    }

    public q(String r5, String r6, String r7, String r8, String r9, boolean r10, String r11, String r12, String r13, String r14, Integer r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, boolean r24, String r25, String r26, String r27) {
        Intrinsics.checkNotNullParameter(r22, "tabNameSecond");
        Intrinsics.checkNotNullParameter(r23, "isDiscountSelected");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
        this.o = r19;
        this.p = r20;
        this.q = r21;
        this.r = r22;
        this.s = r23;
        this.t = r24;
        this.u = r25;
        this.v = r26;
        this.w = r27;
    }
}
