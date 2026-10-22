package com.bytedance.android.livesdk.livecommerce.intro.manager;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final int a;
    public final boolean b;
    public final int c;
    public final Runnable d;
    public final Runnable e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L16;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r0 = this.a * 31;
        boolean r1 = this.b;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (((r0 + r2) * 31) + this.c) * 31;
        Runnable r4 = this.d;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        Runnable r8 = this.e;
        if (r8 == null) goto L13;
        r5 = r8.hashCode();
    L13:
        return r7 + r5;
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "CardQueueParams(priority=" + this.a + ", isInterruptible=" + this.b + ", cardType=" + this.c + ", showCardRunnable=" + this.d + ", hideCardRunnable=" + this.e + ")";
    }

    public b(int r2, m r3, n r4) {
        Intrinsics.checkNotNullParameter(r3, "showCardRunnable");
        Intrinsics.checkNotNullParameter(r4, "hideCardRunnable");
        this.a = 100;
        this.b = true;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
