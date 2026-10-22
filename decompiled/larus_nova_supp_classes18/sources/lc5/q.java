package lc5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final int k;
    public final String l;
    public final String m;
    public final String n;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
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
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.g) * 31;
        String r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        int r17 = 1231;
        if (this.i == false) goto L25;
        int r18 = 1231;
    L26:
        int r19 = (r16 + r18) * 31;
        if (this.j == true) goto L30;
        r17 = 1237;
    L30:
        int r20 = (((r19 + r17) * 31) + this.k) * 31;
        String r21 = this.l;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        String r24 = this.m;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        String r27 = this.n;
        if (r27 == null) goto L43;
        r2 = r27.hashCode();
    L43:
        return r26 + r2;
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L25:
        r18 = 1237;
        goto L26
    L21:
        r15 = r14.hashCode();
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
        return "ReportPageItemClickParam(event=" + this.a + ", module=" + this.b + ", subModule=" + this.c + ", currentSubView=" + this.d + ", parentToken=" + this.e + ", objToken=" + this.f + ", type=" + this.g + ", subFileType=" + this.h + ", isSharedFolder=" + this.i + ", isSubFolder=" + this.j + ", folderLevel=" + this.k + ", shortcutToken=" + this.l + ", containerEnv=" + this.m + ", baseHpFrom=" + this.n + ')';
    }

    public final int getType() {
        return this.g;
    }

    public q(String r16, String r17, String r18, String r19, String r20, int r21, String r22, boolean r23, boolean r24, int r25, String r26) {
        Intrinsics.checkNotNullParameter(r16, "event");
        Intrinsics.checkNotNullParameter(r17, "module");
        this(r16, r17, r18, "", r19, r20, r21, r22, r23, r24, r25, r26, null, null);
    }

    public q(String r2, String r3, String r4, String r5, String r6, String r7, int r8, String r9, boolean r10, boolean r11, int r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "module");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }
}
