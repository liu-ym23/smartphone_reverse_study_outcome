package oi2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Integer e;
    public final String f;
    public final String g;

    public c() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L20;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        int r0 = this.a * 31;
        boolean r1 = this.b;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.c;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.d;
        if (r8 == true) goto L12;
        r2 = r8;
    L12:
        int r9 = (r7 + r2) * 31;
        Integer r10 = this.e;
        int r11 = 0;
        if (r10 == null) goto L15;
        int r12 = r10.hashCode();
    L16:
        int r13 = (r9 + r12) * 31;
        String r14 = this.f;
        if (r14 == null) goto L19;
        int r15 = r14.hashCode();
    L20:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 == null) goto L24;
        r11 = r17.hashCode();
    L24:
        return r16 + r11;
    L19:
        r15 = 0;
        goto L20
    L15:
        r12 = 0;
        goto L16
    }

    public final String toString() {
        return "ECSelectModel(selectCardPosition=" + this.a + ", isUserAction=" + this.b + ", isExpand=" + this.c + ", needAnim=" + this.d + ", isReplayDefaultProduct=" + this.e + ", promotionId=" + this.f + ", fragmentId=" + this.g + ")";
    }

    public /* synthetic */ c(int r9) {
        this(-1, false, false, false, null, null, null);
    }

    public static c a(c r8, int r9, boolean r10, boolean r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        int r1 = r9;
        if ((r12 & 2) == 0) goto L8;
        r10 = r8.b;
    L8:
        boolean r2 = r10;
        if ((r12 & 4) == 0) goto L11;
        r11 = r8.c;
    L11:
        boolean r3 = r11;
        if ((r12 & 8) == 0) goto L14;
        boolean r4 = r8.d;
    L16:
        if ((r12 & 16) == 0) goto L18;
        Integer r5 = r8.e;
    L20:
        if ((r12 & 32) == 0) goto L22;
        String r6 = r8.f;
    L24:
        if ((r12 & 64) == 0) goto L26;
        String r7 = r8.g;
    L27:
        r8.getClass();
        return new c(r1, r2, r3, r4, r5, r6, r7);
    L26:
        r7 = null;
        goto L27
    L22:
        r6 = null;
        goto L24
    L18:
        r5 = null;
        goto L20
    L14:
        r4 = true;
        goto L16
    }

    public c(int r1, boolean r2, boolean r3, boolean r4, Integer r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
