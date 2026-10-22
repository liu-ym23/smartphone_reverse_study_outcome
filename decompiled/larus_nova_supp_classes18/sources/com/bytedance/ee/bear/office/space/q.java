package com.bytedance.ee.bear.office.space;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    public static final /* synthetic */ int d = 0;
    public final OfficeSpaceTabAnchor a;
    public final OfficeSpaceTabAnchor b;
    public final OfficeSpaceTabAlignment c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "OfficeSpaceTabLayoutRule(startAnchor=" + this.a + ", endAnchor=" + this.b + ", alignment=" + this.c + ')';
    }

    public q(OfficeSpaceTabAnchor r2, OfficeSpaceTabAnchor r3, OfficeSpaceTabAlignment r4) {
        Intrinsics.checkNotNullParameter(r2, "startAnchor");
        Intrinsics.checkNotNullParameter(r3, "endAnchor");
        Intrinsics.checkNotNullParameter(r4, "alignment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
