package c25;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public final boolean e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
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
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((((r3 + r1) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L13;
        int r6 = 1231;
    L15:
        return ((r5 + r6) * 31) + this.f.hashCode();
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ItemData(url=" + this.a + ", appId=" + this.b + ", type=" + this.c + ", subType=" + this.d + ", isWiki=" + this.e + ", title=" + this.f + ')';
    }

    public final int getType() {
        return this.c;
    }

    public c(String r2, String r3, int r4, String r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "subType");
        Intrinsics.checkNotNullParameter(r7, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
