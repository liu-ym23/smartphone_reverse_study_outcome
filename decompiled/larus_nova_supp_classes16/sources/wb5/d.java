package wb5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final boolean a;
    public final String b;
    public String c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((((((((((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "MainNavParams(isInDocOrDrive=" + this.a + ", appId=" + this.b + ", title=" + this.c + ", url=" + this.d + ", type=" + this.e + ", subType=" + this.f + ", objToken=" + this.g + ", token=" + this.h + ')';
    }

    public final int getType() {
        return this.e;
    }

    public /* synthetic */ d(String r10, String r11, String r12, int r13, String r14) {
        this(false, r10, r11, r12, r13, r14, "", "");
    }

    public d(boolean r2, String r3, String r4, String r5, int r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r7, "subType");
        Intrinsics.checkNotNullParameter(r8, "objToken");
        Intrinsics.checkNotNullParameter(r9, "token");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
