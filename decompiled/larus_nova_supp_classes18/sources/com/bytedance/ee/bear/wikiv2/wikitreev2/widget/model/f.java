package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements c {
    public final String a;
    public final String b;
    public final double c;
    public final boolean d;
    public final String e;
    public final TreeNode f;
    public final WikiRelation g;
    public final String h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.c, r9.c) == 0) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = Double.doubleToLongBits(this.c);
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.d == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r2 + r3) * 31;
        String r5 = this.e;
        int r6 = 0;
        if (r5 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r4 + r7) * 31;
        TreeNode r9 = this.f;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        WikiRelation r12 = this.g;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.h;
        if (r15 == null) goto L23;
        r6 = r15.hashCode();
    L23:
        return r14 + r6;
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r5.hashCode();
        goto L10
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "MovToNodeBean(srcToken=" + this.a + ", destToken=" + this.b + ", newSortId=" + this.c + ", forceExpand=" + this.d + ", expandToToken=" + this.e + ", spareNode=" + this.f + ", spareRelation=" + this.g + ", destSpaceId=" + this.h + ')';
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.c
    public final String getSpaceId() {
        return this.h;
    }

    public f(String r2, String r3, double r4, boolean r6, String r7, TreeNode r8, WikiRelation r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "srcToken");
        Intrinsics.checkNotNullParameter(r3, "destToken");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
