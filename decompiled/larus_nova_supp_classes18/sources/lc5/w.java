package lc5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final String j;
    public final String k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
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
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.d) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.h;
        if (r17 == null) goto L26;
        r2 = r17.hashCode();
    L26:
        int r18 = (r16 + r2) * 31;
        if (this.i == false) goto L29;
        int r19 = 1231;
    L31:
        return ((((r18 + r19) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    L29:
        r19 = 1237;
        goto L31
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReportSpaceDeleteOrRemoveView(module=" + this.a + ", subModule=" + this.b + ", objToken=" + this.c + ", type=" + this.d + ", subFileType=" + this.e + ", containerObjToken=" + this.f + ", containerType=" + this.g + ", shortcutToken=" + this.h + ", isSharedFolder=" + this.i + ", deleteContentType=" + this.j + ", deleteType=" + this.k + ')';
    }

    public final int getType() {
        return this.d;
    }

    public w(String r4, String r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter("own", "deleteContentType");
        Intrinsics.checkNotNullParameter("delete", "deleteType");
        this.a = r4;
        this.b = "recent";
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = false;
        this.j = "own";
        this.k = "delete";
    }
}
