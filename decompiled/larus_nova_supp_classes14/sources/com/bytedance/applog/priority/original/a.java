package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final JSONObject c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        boolean r1 = this.b;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        JSONObject r4 = this.c;
        if (r4 != null) goto L8;
        int r5 = 0;
    L9:
        int r6 = (r3 + r5) * 31;
        long r7 = this.d;
        return r6 + ((int) (r7 ^ (r7 >>> 32)));
    L8:
        r5 = r4.hashCode();
        goto L9
    }

    public final String toString() {
        return "AppSessionLaunch(sessionId=" + this.a + ", isForeground=" + this.b + ", extraParams=" + this.c + ", timestamp=" + this.d + ')';
    }

    public a(String r2, boolean r3, JSONObject r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
