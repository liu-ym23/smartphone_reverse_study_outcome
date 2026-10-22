package com.bytedance.android.shopping.commentv3.audio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    public y() {
        this(false, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof y) == false) goto L12;
        y r4 = (y) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return r6 + r1;
    }

    public final String toString() {
        return "StopOptions(executeOnStop=" + this.a + ", releasePlayer=" + this.b + ", restoreExternalAudio=" + this.c + ")";
    }

    public /* synthetic */ y(boolean r4, int r5) {
        boolean r1 = true;
        if ((r5 & 1) == 0) goto L6;
        r4 = true;
    L6:
        if ((r5 & 2) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r5 & 4) != 0) goto L13;
        r1 = false;
    L13:
        this(r4, r0, r1);
        return;
    L8:
        r0 = false;
        goto L10
    }

    public y(boolean r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
