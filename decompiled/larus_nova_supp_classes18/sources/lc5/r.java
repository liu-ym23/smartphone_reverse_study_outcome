package lc5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final String g;
    public final boolean h;
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
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
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
        int r10 = (((r7 + r9) * 31) + this.f) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        int r14 = 1231;
        if (this.h == false) goto L21;
        int r15 = 1231;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.i == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        if (this.j == true) goto L30;
        r14 = 1237;
    L30:
        int r19 = (((r18 + r14) * 31) + this.k) * 31;
        String r20 = this.l;
        if (r20 != null) goto L33;
        int r21 = 0;
    L34:
        int r22 = (r19 + r21) * 31;
        String r23 = this.m;
        if (r23 != null) goto L37;
        int r24 = 0;
    L38:
        int r25 = (r22 + r24) * 31;
        String r26 = this.n;
        if (r26 == null) goto L43;
        r2 = r26.hashCode();
    L43:
        return r25 + r2;
    L37:
        r24 = r23.hashCode();
        goto L38
    L33:
        r21 = r20.hashCode();
        goto L34
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
        return "ReportPageSwitchClickParam(event=" + this.a + ", module=" + this.b + ", subModule=" + this.c + ", currentSubView=" + this.d + ", objToken=" + this.e + ", type=" + this.f + ", subFileType=" + this.g + ", isFolder=" + this.h + ", isSharedFolder=" + this.i + ", isSubFolder=" + this.j + ", folderLevel=" + this.k + ", parentToken=" + this.l + ", containerEnv=" + this.m + ", baseHpFrom=" + this.n + ')';
    }

    public final int getType() {
        return this.f;
    }

    public r(String r15, String r16, String r17, String r18, int r19, boolean r20, boolean r21, boolean r22, int r23, String r24) {
        Intrinsics.checkNotNullParameter(r15, "event");
        Intrinsics.checkNotNullParameter(r16, "module");
        this(r15, r16, r17, "", r18, r19, r20, r21, r22, r23, r24, null, null);
    }

    public r(String r2, String r3, String r4, String r5, String r6, int r7, boolean r8, boolean r9, boolean r10, int r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "module");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = "";
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }
}
