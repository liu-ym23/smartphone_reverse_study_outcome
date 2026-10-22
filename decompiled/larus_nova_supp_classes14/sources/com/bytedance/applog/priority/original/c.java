package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final String a;
    public long b;
    public final JSONArray c;
    public final JSONObject d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "AppSessionTerminate(sessionId=" + this.a + ", duration=" + this.b + ", pageNames=" + this.c + ", extraParams=" + this.d + ')';
    }

    public c(String r3, JSONArray r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "pageNames");
        Intrinsics.checkNotNullParameter(r5, "extraParams");
        this.a = r3;
        this.b = 0;
        this.c = r4;
        this.d = r5;
    }
}
