package com.bytedance.android.shopping.commentv3.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u {
    public final boolean a;
    public final boolean b;
    public final StopReason c;
    public final y d;
    public final t e;

    public u() {
        boolean r2 = false;
        this(r2, null, 31);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u) == false) goto L16;
        u r4 = (u) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
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
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        StopReason r6 = this.c;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (r5 + r8) * 31;
        y r10 = this.d;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        t r13 = this.e;
        if (r13 == null) goto L21;
        r7 = r13.hashCode();
    L21:
        return r12 + r7;
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    }

    public final String toString() {
        return "PlayDecision(allowPlay=" + this.a + ", stopCurrent=" + this.b + ", stopReason=" + this.c + ", stopOptions=" + this.d + ", externalAudioRequest=" + this.e + ")";
    }

    public /* synthetic */ u(boolean r9, t r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r11 & 2) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r11 & 4) == 0) goto L13;
        StopReason r5 = StopReason.REPLACED_BY_OTHER;
    L15:
        if ((r11 & 8) == 0) goto L17;
        y r6 = new y(false, 7);
    L19:
        if ((r11 & 16) == 0) goto L21;
        t r7 = null;
    L22:
        this(r3, r4, r5, r6, r7);
        return;
    L21:
        r7 = r10;
        goto L22
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = false;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public u(boolean r2, boolean r3, StopReason r4, y r5, t r6) {
        Intrinsics.checkNotNullParameter(r4, "stopReason");
        Intrinsics.checkNotNullParameter(r5, "stopOptions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
