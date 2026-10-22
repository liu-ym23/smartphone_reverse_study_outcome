package com.bytedance.android.window.shop.innerflow;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final Map<String, String> a;
    public final String b;
    public final int c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, String> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.c;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECWindowInnerFlowParam(schemaParams=" + this.a + ", secAuthorId=" + this.b + ", innerFlowType=" + this.c + ")";
    }

    public b(Map<String, String> r2, String r3, @WindowInnerFlowType int r4) {
        Intrinsics.checkNotNullParameter(r2, "schemaParams");
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
