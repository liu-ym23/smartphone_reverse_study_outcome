package com.bytedance.ee.bear.widgets.menuconfig;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final List<f> c;
    public final List<g> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeSpaceMenuDefinition(key=" + this.a + ", enabled=" + this.b + ", groups=" + this.c + ", items=" + this.d + ')';
    }

    public e(String r2, boolean r3, List<f> r4, List<g> r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "groups");
        Intrinsics.checkNotNullParameter(r5, "items");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
