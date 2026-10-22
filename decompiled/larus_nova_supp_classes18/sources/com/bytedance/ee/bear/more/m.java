package com.bytedance.ee.bear.more;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public final String a;
    public final Bundle b;
    public final String c;
    public final int d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final String i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final Map<String, Object> n;

    public m(Bundle r15, String r16, int r17, String r18, boolean r19, boolean r20, String r21, boolean r22, String r23) {
        this("ccm_space_drive_rename_click", r15, r16, r17, r18, r19, r20, r21, "none", "", r22, false, r23);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
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
        String r18 = this.h;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.i;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        String r24 = this.j;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        if (this.k == false) goto L41;
        int r27 = 1231;
    L42:
        int r28 = (r26 + r27) * 31;
        if (this.l == true) goto L46;
        r13 = 1237;
    L46:
        int r29 = (r28 + r13) * 31;
        String r30 = this.m;
        if (r30 != null) goto L49;
        int r31 = 0;
    L50:
        int r32 = (r29 + r31) * 31;
        Map<String, Object> r33 = this.n;
        if (r33 == null) goto L55;
        r1 = r33.hashCode();
    L55:
        return r32 + r1;
    L49:
        r31 = r30.hashCode();
        goto L50
    L41:
        r27 = 1237;
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
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
        return "MoreSubMenuViewClickBean(event=" + this.a + ", bundle=" + this.b + ", objToken=" + this.c + ", type=" + this.d + ", subType=" + this.e + ", isWiki=" + this.f + ", isAtVc=" + this.g + ", click=" + this.h + ", target=" + this.i + ", moduleType=" + this.j + ", isOwner=" + this.k + ", isVersion=" + this.l + ", userPermisson=" + this.m + ", extraParams=" + this.n + ')';
    }

    public final int getType() {
        return this.d;
    }

    public /* synthetic */ m(String r16, Bundle r17, String r18, int r19, String r20, boolean r21, boolean r22, String r23, String r24, String r25, boolean r26, boolean r27, String r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, null);
    }

    public m(String r1, Bundle r2, String r3, int r4, String r5, boolean r6, boolean r7, String r8, String r9, String r10, boolean r11, boolean r12, String r13, Map<String, ? extends Object> r14) {
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
        this.m = r13;
        this.n = r14;
    }
}
