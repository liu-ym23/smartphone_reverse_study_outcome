package com.bytedance.ee.bear.widgets.menuconfig;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final int a;
    public final String b;
    public final int c;
    public final Map<String, e> d;

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
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "OfficeSpaceMenuConfigSnapshot(schemaVersion=" + this.a + ", configVersion=" + this.b + ", runtimeIdHash=" + this.c + ", menus=" + this.d + ')';
    }

    public final e a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.d.get(r2);
    }

    public d(int r2, String r3, int r4, Map<String, e> r5) {
        Intrinsics.checkNotNullParameter(r3, "configVersion");
        Intrinsics.checkNotNullParameter(r5, "menus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
