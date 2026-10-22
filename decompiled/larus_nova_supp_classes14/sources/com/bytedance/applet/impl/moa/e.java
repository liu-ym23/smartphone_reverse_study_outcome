package com.bytedance.applet.impl.moa;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final Map<String, Object> d;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.d.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MoaQuickReplyPayload(appletId=" + this.a + ", authorizationID=" + this.b + ", authExt=" + this.c + ", serverOption=" + this.d + ')';
    }

    public e(String r2, String r3, String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "authorizationID");
        Intrinsics.checkNotNullParameter(r5, "serverOption");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
