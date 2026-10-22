package com.bytedance.android.shopping.slice.elements.liveplayer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public final int hashCode() {
        String r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final boolean equals(Object r3) {
        String r1 = null;
        if ((r3 instanceof a) == true) goto L5;
        r3 = null;
    L5:
        a r4 = (a) r3;
        if (r4 == null) goto L9;
        r1 = r4.b;
    L9:
        return Intrinsics.areEqual(r1, this.b);
    }

    public a(String r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = null;
    }
}
