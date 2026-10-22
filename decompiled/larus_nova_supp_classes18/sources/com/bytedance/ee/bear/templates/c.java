package com.bytedance.ee.bear.templates;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final int a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;
    public final a f;

    public static final class a {
        public boolean a;

        public a() {
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.e) * 31) + this.f.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ShowBottomActionSheetParams(objType=" + this.a + ", objToken=" + this.b + ", name=" + this.c + ", showEditItem=" + this.d + ", shareSource=" + this.e + ", extraInfo=" + this.f + ')';
    }

    public c(int r2, String r3, String r4, boolean r5, int r6, int r7) {
        if ((r7 & 8) == 0) goto L6;
        r5 = false;
    L6:
        if ((r7 & 16) == 0) goto L9;
        r6 = 3;
    L9:
        if ((r7 & 32) == 0) goto L11;
        a r8 = new a();
    L12:
        Intrinsics.checkNotNullParameter(r3, "objToken");
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r8, "extraInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        return;
    L11:
        r8 = null;
        goto L12
    }
}
