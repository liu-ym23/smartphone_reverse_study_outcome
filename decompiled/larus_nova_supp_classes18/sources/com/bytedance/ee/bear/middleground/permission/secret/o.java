package com.bytedance.ee.bear.middleground.permission.secret;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;

    public o() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.d == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.e == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.f == true) goto L23;
        r2 = 1237;
    L23:
        return r9 + r2;
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResponseBannerParam(msg=" + this.a + ", showBtn=" + this.b + ", showClose=" + this.c + ", showBanner=" + this.d + ", autoBanner=" + this.e + ", isForceSecret=" + this.f + ')';
    }

    public o(int r2) {
        Intrinsics.checkNotNullParameter("", "msg");
        this.a = "";
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
