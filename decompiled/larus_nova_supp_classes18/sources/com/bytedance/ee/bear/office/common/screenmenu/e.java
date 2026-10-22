package com.bytedance.ee.bear.office.common.screenmenu;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements fk5.a {
    public final int a;
    public final String b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public final boolean f;
    public final boolean g;
    public final Integer h;
    public final boolean i;
    public final boolean j;
    public final Object k;
    public final int l;
    public final boolean m;
    public final boolean n;
    public final Integer o;
    public final Integer p;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
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
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        int r14 = 1231;
        if (this.f == false) goto L21;
        int r15 = 1231;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.g == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        Integer r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        if (this.i == false) goto L33;
        int r22 = 1231;
    L34:
        int r23 = (r21 + r22) * 31;
        if (this.j == false) goto L37;
        int r24 = 1231;
    L38:
        int r25 = (r23 + r24) * 31;
        Object r26 = this.k;
        if (r26 != null) goto L41;
        int r27 = 0;
    L42:
        int r28 = (((r25 + r27) * 31) + this.l) * 31;
        if (this.m == false) goto L45;
        int r29 = 1231;
    L46:
        int r30 = (r28 + r29) * 31;
        if (this.n == true) goto L50;
        r14 = 1237;
    L50:
        int r31 = (r30 + r14) * 31;
        Integer r32 = this.o;
        if (r32 != null) goto L53;
        int r33 = 0;
    L54:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.p;
        if (r35 == null) goto L59;
        r2 = r35.hashCode();
    L59:
        return r34 + r2;
    L53:
        r33 = r32.hashCode();
        goto L54
    L45:
        r29 = 1237;
        goto L46
    L41:
        r27 = r26.hashCode();
        goto L42
    L37:
        r24 = 1237;
        goto L38
    L33:
        r22 = 1237;
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = 1237;
        goto L26
    L21:
        r15 = 1237;
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuItem(id=" + this.a + ", textString=" + this.b + ", subTextString=" + this.c + ", textColor=" + this.d + ", icon=" + this.e + ", iconAtEnd=" + this.f + ", reserveIconSpace=" + this.g + ", endIcon=" + this.h + ", isSelected=" + this.i + ", removeAroundDivider=" + this.j + ", any=" + this.k + ", paddingStart=" + this.l + ", isEnabled=" + this.m + ", isGray=" + this.n + ", iconSize=" + this.o + ", iconTextSpacing=" + this.p + ')';
    }

    @Override // fk5.a
    public final boolean a() {
        return this.j;
    }

    @Override // fk5.a
    public final int getId() {
        return this.a;
    }

    public e(int r18, String r19, String r20, Integer r21, Integer r22, boolean r23, boolean r24, Integer r25, boolean r26, Object r27, boolean r28, boolean r29, Integer r30, Integer r31, int r32) {
        Integer r3 = null;
        if ((r32 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r32 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r32 & 8) == 0) goto L13;
        Integer r5 = null;
    L15:
        if ((r32 & 16) == 0) goto L17;
        Integer r6 = null;
    L19:
        if ((r32 & 32) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r32 & 64) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r32 & 128) == 0) goto L29;
        Integer r10 = null;
    L31:
        if ((r32 & 256) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r32 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L37;
        Object r12 = null;
    L39:
        if ((r32 & DocUserPermission.USER_PERCEIVE) == 0) goto L41;
        boolean r13 = true;
    L43:
        if ((r32 & 8192) == 0) goto L45;
        boolean r14 = false;
    L47:
        if ((r32 & 16384) == 0) goto L49;
        Integer r15 = null;
    L51:
        if ((r32 & 32768) != 0) goto L54;
        r3 = r31;
    L54:
        this.a = r18;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = false;
        this.k = r12;
        this.l = 0;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        this.p = r3;
        return;
    L49:
        r15 = r30;
        goto L51
    L45:
        r14 = r29;
        goto L47
    L41:
        r13 = r28;
        goto L43
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }
}
