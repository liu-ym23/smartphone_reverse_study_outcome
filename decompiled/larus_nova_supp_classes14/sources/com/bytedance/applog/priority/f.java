package com.bytedance.applog.priority;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final PriorityCallback f;
    public final PriorityEventMetaFactory g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean r1 = this.c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.d;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.e;
        if (r8 == true) goto L13;
        r2 = r8;
    L13:
        return ((((r7 + r2) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "PriorityConfig(appId='" + this.a + "', defaultReportUrl='" + this.b + "', logEnabled=" + this.c + ", eventUidEnabled=" + this.d + ", encryptable=" + this.e + ')';
    }

    public f(String r2, String r3, boolean r4, boolean r5, boolean r6, PriorityCallbackImpl r7, i r8) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "defaultReportUrl");
        Intrinsics.checkNotNullParameter(r7, "priorityCallback");
        Intrinsics.checkNotNullParameter(r8, "eventMetaFactory");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
