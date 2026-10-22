package com.bytedance.ee.bear.more;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public final String a;
    public final Bundle b;
    public final String c;
    public final int d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final String j;
    public final Map<String, Object> k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Bundle r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.d) * 31;
        String r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        int r13 = 1231;
        if (this.f == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.g == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        if (this.h == false) goto L29;
        int r18 = 1231;
    L30:
        int r19 = (r17 + r18) * 31;
        if (this.i == true) goto L34;
        r13 = 1237;
    L34:
        int r20 = (r19 + r13) * 31;
        String r21 = this.j;
        if (r21 != null) goto L37;
        int r22 = 0;
    L38:
        int r23 = (r20 + r22) * 31;
        Map<String, Object> r24 = this.k;
        if (r24 == null) goto L43;
        r1 = r24.hashCode();
    L43:
        return r23 + r1;
    L37:
        r22 = r21.hashCode();
        goto L38
    L29:
        r18 = 1237;
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = 1237;
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
        return "MoreSubMenuViewBean(event=" + this.a + ", bundle=" + this.b + ", objToken=" + this.c + ", type=" + this.d + ", subType=" + this.e + ", isWiki=" + this.f + ", isAtVc=" + this.g + ", isOwner=" + this.h + ", isVersion=" + this.i + ", userPermisson=" + this.j + ", extraParams=" + this.k + ')';
    }

    public final int getType() {
        return this.d;
    }

    public /* synthetic */ l(String r13, Bundle r14, String r15, int r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, String r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, null);
    }

    public l(String r1, Bundle r2, String r3, int r4, String r5, boolean r6, boolean r7, boolean r8, boolean r9, String r10, Map<String, ? extends Object> r11) {
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
    }
}
