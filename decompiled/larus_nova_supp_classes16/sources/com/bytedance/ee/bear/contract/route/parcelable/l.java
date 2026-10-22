package com.bytedance.ee.bear.contract.route.parcelable;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;

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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        String r4 = this.e;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "WikiCreateInfo(space_id=" + this.a + ", wiki_token=" + this.b + ", obj_token=" + this.c + ", obj_type=" + this.d + ", title=" + this.e + ", url=" + this.f + ')';
    }

    public l(String r2, String r3, String r4, int r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "wiki_token");
        Intrinsics.checkNotNullParameter(r4, "obj_token");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
