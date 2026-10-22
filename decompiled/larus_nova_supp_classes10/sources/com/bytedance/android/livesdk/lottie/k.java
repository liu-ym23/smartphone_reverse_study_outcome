package com.bytedance.android.livesdk.lottie;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k {
    public final long a;
    public final boolean b;
    public final j c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof k) == false) goto L12;
        k r7 = (k) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        boolean r2 = this.b;
        ?? r3 = r2;
        if (r2 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r1 + r3) * 31;
        j r5 = this.c;
        if (r5 == null) goto L8;
        int r6 = r5.hashCode();
    L10:
        return r4 + r6;
    L8:
        r6 = 0;
        goto L10
    }

    public final String toString() {
        return "LottieAnimationEvent(assetId=" + this.a + ", autoFinish=" + this.b + ", callback=" + this.c + ")";
    }

    public k(long r2, boolean r4, LottieService.a r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
