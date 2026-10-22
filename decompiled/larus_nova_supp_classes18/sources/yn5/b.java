package yn5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final String h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        int r9 = 1231;
        if (this.d == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r8 + r10) * 31;
        if (this.e == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (r11 + r12) * 31;
        if (this.f == true) goto L27;
        r9 = 1237;
    L27:
        return ((((r13 + r9) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L21:
        r12 = 1237;
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecommendTemplateParams(parentToken=" + this.a + ", module=" + this.b + ", subModule=" + this.c + ", isFolder=" + this.d + ", isFromEmpty=" + this.e + ", showTitleBg=" + this.f + ", createSelectResultJson=" + this.g + ", spaceId=" + this.h + ')';
    }

    public b(String r2, String r3, String r4, boolean r5, boolean r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "createSelectResultJson");
        Intrinsics.checkNotNullParameter(r8, "spaceId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = false;
        this.g = r7;
        this.h = r8;
    }
}
