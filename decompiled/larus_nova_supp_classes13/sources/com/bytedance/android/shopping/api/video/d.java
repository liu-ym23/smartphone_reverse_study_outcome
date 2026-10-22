package com.bytedance.android.shopping.api.video;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public boolean a;
    public final boolean b;
    public int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public boolean h;
    public final Bundle i;

    public d() {
        this(false, false, 0, 0, false, 511);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L24;
        d r4 = (d) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
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
        int r6 = (((((((r3 + r5) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        boolean r7 = this.f;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.g;
        ?? r11 = r10;
        if (r10 == false) goto L14;
        r11 = 1;
    L14:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.h;
        if (r13 == true) goto L18;
        r1 = r13;
    L18:
        int r14 = (r12 + r1) * 31;
        Bundle r15 = this.i;
        if (r15 == null) goto L21;
        int r16 = r15.hashCode();
    L23:
        return r14 + r16;
    L21:
        r16 = 0;
        goto L23
    }

    public final String toString() {
        return "ECPlayerOptions(mute=" + this.a + ", loop=" + this.b + ", initialStartTimeMs=" + this.c + ", loopPlayStartTime=" + this.d + ", loopPlayEndTime=" + this.e + ", isAudioOnly=" + this.f + ", needCookie=" + this.g + ", isSharePlayer=" + this.h + ", gaussianParams=" + this.i + ")";
    }

    public d(boolean r4, boolean r5, int r6, int r7, boolean r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r9 & 8) == 0) goto L12;
        r6 = -1;
    L12:
        if ((r9 & 16) == 0) goto L15;
        r7 = -1;
    L15:
        if ((r9 & 128) == 0) goto L17;
        r8 = false;
    L17:
        this.a = r4;
        this.b = r5;
        this.c = 0;
        this.d = r6;
        this.e = r7;
        this.f = false;
        this.g = false;
        this.h = r8;
        this.i = null;
    }
}
