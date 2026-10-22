package com.bytedance.ee.bear.more;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public final Bundle a;
    public final String b;
    public final int c;
    public final boolean d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final boolean n;
    public final String o;
    public final String p;
    public String q;
    public String r;
    public String s;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        Bundle r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        int r7 = 1231;
        if (this.d == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.i;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.j;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        if (this.k == false) goto L41;
        int r28 = 1231;
    L42:
        int r29 = (r27 + r28) * 31;
        if (this.l == false) goto L45;
        int r30 = 1231;
    L46:
        int r31 = (r29 + r30) * 31;
        String r32 = this.m;
        if (r32 != null) goto L49;
        int r33 = 0;
    L50:
        int r34 = (r31 + r33) * 31;
        if (this.n == true) goto L54;
        r7 = 1237;
    L54:
        int r35 = (r34 + r7) * 31;
        String r36 = this.o;
        if (r36 == null) goto L59;
        r1 = r36.hashCode();
    L59:
        return ((r35 + r1) * 31) + this.p.hashCode();
    L49:
        r33 = r32.hashCode();
        goto L50
    L45:
        r30 = 1237;
        goto L46
    L41:
        r28 = 1237;
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MoreItemClickBean(bundle=" + this.a + ", objToken=" + this.b + ", type=" + this.c + ", isShareFolder=" + this.d + ", subType=" + this.e + ", click=" + this.f + ", target=" + this.g + ", exportType=" + this.h + ", convertType=" + this.i + ", language=" + this.j + ", isWiki=" + this.k + ", isAtVc=" + this.l + ", shortcutToken=" + this.m + ", isOwner=" + this.n + ", userPermisson=" + this.o + ", menuLevel=" + this.p + ')';
    }

    public final int getType() {
        return this.c;
    }

    public i(Bundle r18, String r19, int r20, boolean r21, String r22, String r23, String r24, String r25, String r26, boolean r27, boolean r28, String r29, boolean r30, String r31) {
        this(r18, r19, r20, r21, r22, r23, r24, r25, r26, "", r27, r28, r29, r30, r31, "");
    }

    public i(Bundle r4, String r5, int r6, boolean r7, String r8, String r9, String r10, String r11, String r12, String r13, boolean r14, boolean r15, String r16, boolean r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r19, "menuLevel");
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
    }
}
