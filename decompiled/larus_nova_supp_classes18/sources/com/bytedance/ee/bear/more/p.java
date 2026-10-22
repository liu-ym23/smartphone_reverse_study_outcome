package com.bytedance.ee.bear.more;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p {
    public final FragmentActivity a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final PageviewUIHolder g;
    public final Fragment h;
    public final boolean i;
    public final HashMap<String, Serializable> j;
    public final sj5.d k;

    public p() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
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
        FragmentActivity r0 = this.a;
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
        String r12 = this.f;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        PageviewUIHolder r15 = this.g;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        Fragment r18 = this.h;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        if (this.i == true) goto L34;
        r7 = 1237;
    L34:
        int r21 = (r20 + r7) * 31;
        HashMap<String, Serializable> r22 = this.j;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        sj5.d r25 = this.k;
        if (r25 == null) goto L43;
        r1 = r25.hashCode();
    L43:
        return r24 + r1;
    L37:
        r23 = r22.hashCode();
        goto L38
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
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
        return "ShowPageFragmentBean(activity=" + this.a + ", documentType=" + this.b + ", token=" + this.c + ", isDocV2=" + this.d + ", isShowViewHistory=" + this.e + ", title=" + this.f + ", titleHolder=" + this.g + ", sourceFragment=" + this.h + ", replaceSource=" + this.i + ", extraParams=" + this.j + ", listener=" + this.k + ')';
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public p(FragmentActivity r1, int r2, String r3, boolean r4, boolean r5, String r6, PageviewUIHolder r7, Fragment r8, boolean r9, HashMap<String, Serializable> r10, sj5.d r11) {
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
