package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final j a;
    public final j b;
    public final boolean c;
    public final String d;
    public final String e;
    public final long f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof g) == false) goto L18;
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r6.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        j r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        j r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 == null) goto L20;
        r1 = r13.hashCode();
    L20:
        int r14 = (r12 + r1) * 31;
        long r15 = this.f;
        return r14 + ((int) (r15 ^ (r15 >>> 32)));
    L16:
        r11 = 0;
        goto L17
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedScrollNumberConfig(integer=" + this.a + ", decimal=" + this.b + ", animate=" + this.c + ", textColor=" + this.d + ", textAlign=" + this.e + ", delayMs=" + this.f + ")";
    }

    public g(j r2, j r3, boolean r4, String r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r2, "integer");
        Intrinsics.checkNotNullParameter(r3, "decimal");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
