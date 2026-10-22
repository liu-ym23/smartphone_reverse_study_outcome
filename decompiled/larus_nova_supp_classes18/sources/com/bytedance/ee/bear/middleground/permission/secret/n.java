package com.bytedance.ee.bear.middleground.permission.secret;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public String g;
    public final boolean h;
    public boolean i;

    public n() {
        this(false, false, false, false, false, false, null, false, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
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
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.f == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (((r10 + r11) * 31) + this.g.hashCode()) * 31;
        if (this.h == false) goto L29;
        int r13 = 1231;
    L30:
        int r14 = (r12 + r13) * 31;
        if (this.i == true) goto L35;
        r1 = 1237;
    L35:
        return r14 + r1;
    L29:
        r13 = 1237;
        goto L30
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "RecommendSecretBean(isAdminDefault=" + this.a + ", isAutoMark=" + this.b + ", isRecommendMark=" + this.c + ", haveSecretLevel=" + this.d + ", doubleCheckLevel=" + this.e + ", isForceSecret=" + this.f + ", secName=" + this.g + ", isBannerStatus=" + this.h + ", hasColloborateval=" + this.i + ')';
    }

    public /* synthetic */ n(boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, String r20, boolean r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r22 & 2) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r11 = false;
    L34:
        this(r4, r5, r6, r7, r8, r9, r10, r11, false);
        return;
    L33:
        r11 = r21;
        goto L34
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public n(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, String r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "secName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
