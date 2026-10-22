package jw4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final Boolean j;
    public final String k;
    public final String l;

    public c() {
        this(null, null, null, null, null, 4095);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        String r17 = this.f;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.g;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.h;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r26 = (r22 + r24) * 31;
        String r27 = this.i;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        Boolean r30 = this.j;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        String r33 = this.k;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r36 = (r32 + r34) * 31;
        String r37 = this.l;
        if (r37 == null) goto L51;
        r1 = r37.hashCode();
    L51:
        return r36 + r1;
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r28 = r27.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateSuccessEventReportParams(fileType=" + this.a + ", objToken=" + this.b + ", product=" + this.c + ", parentToken=" + this.d + ", module=" + this.e + ", source=" + this.f + ", subSource=" + this.g + ", templateToken=" + this.h + ", templateId=" + this.i + ", reportToken=" + this.j + ", templateCenterSource=" + this.k + ", name=" + this.l + ')';
    }

    public c(String r8, String r9, String r10, String r11) {
        this(r8, r9, "suite", r10, r11, 4032);
    }

    public /* synthetic */ c(String r17, String r18, String r19, String r20, String r21, int r22) {
        Boolean r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r22 & 512) == 0) goto L25;
        r2 = Boolean.FALSE;
    L25:
        this(r4, r5, r6, r7, r8, null, null, null, null, r2, null, null);
        return;
    L21:
        r8 = r21;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public c(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, Boolean r10, String r11, String r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }
}
