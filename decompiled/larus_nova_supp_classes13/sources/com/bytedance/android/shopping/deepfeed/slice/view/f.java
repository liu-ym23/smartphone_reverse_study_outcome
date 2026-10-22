package com.bytedance.android.shopping.deepfeed.slice.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;
    public final int f;
    public final boolean g;
    public final int h;
    public final boolean i;
    public final Float j;
    public final boolean k;

    public f() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L28;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L17;
        r12 = 1;
    L17:
        int r13 = (((((r9 + r12) * 31) + this.e) * 31) + this.f) * 31;
        boolean r14 = this.g;
        ?? r15 = r14;
        if (r14 == false) goto L20;
        r15 = 1;
    L20:
        int r16 = (((r13 + r15) * 31) + this.h) * 31;
        boolean r17 = this.i;
        ?? r18 = r17;
        if (r17 == false) goto L23;
        r18 = 1;
    L23:
        int r19 = (r16 + r18) * 31;
        Float r20 = this.j;
        if (r20 == null) goto L26;
        r1 = r20.hashCode();
    L26:
        int r21 = (r19 + r1) * 31;
        boolean r22 = this.k;
        if (r22 == true) goto L31;
        r11 = r22;
    L31:
        return r21 + r11;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoViewData(vid=" + this.a + ", src=" + this.b + ", image=" + this.c + ", mute=" + this.d + ", width=" + this.e + ", height=" + this.f + ", fullScreen=" + this.g + ", topMargin=" + this.h + ", visible=" + this.i + ", progress=" + this.j + ", isPlaying=" + this.k + ")";
    }

    public /* synthetic */ f(int r13) {
        this("", "", "", true, 0, 0, true, 0, false, null, false);
    }

    public f(String r2, String r3, String r4, boolean r5, int r6, int r7, boolean r8, int r9, boolean r10, Float r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        Intrinsics.checkNotNullParameter(r3, "src");
        Intrinsics.checkNotNullParameter(r4, "image");
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
    }
}
