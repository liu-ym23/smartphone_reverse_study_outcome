package com.bytedance.ee.bear.more;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public final String a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final String i;
    public final boolean j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.d == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.e == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.f == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (r11 + r12) * 31;
        if (this.g == false) goto L25;
        int r14 = 1231;
    L26:
        int r15 = (r13 + r14) * 31;
        if (this.h == false) goto L29;
        int r16 = 1231;
    L30:
        int r17 = (r15 + r16) * 31;
        String r18 = this.i;
        if (r18 == null) goto L34;
        r1 = r18.hashCode();
    L34:
        int r19 = (r17 + r1) * 31;
        if (this.j == true) goto L39;
        r7 = 1237;
    L39:
        return r19 + r7;
    L29:
        r16 = 1237;
        goto L30
    L25:
        r14 = 1237;
        goto L26
    L21:
        r12 = 1237;
        goto L22
    L17:
        r10 = 1237;
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
        return "MoreMenuViewViewBean(objToken=" + this.a + ", type=" + this.b + ", subType=" + this.c + ", isSubscribed=" + this.d + ", reportMoreMenuView=" + this.e + ", isWiki=" + this.f + ", isAtVc=" + this.g + ", isOwner=" + this.h + ", userPermisson=" + this.i + ", haveAiButton=" + this.j + ')';
    }

    public final int getType() {
        return this.b;
    }

    public j(String r1, int r2, String r3, boolean r4, boolean r5, boolean r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = false;
        this.e = false;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = true;
    }
}
