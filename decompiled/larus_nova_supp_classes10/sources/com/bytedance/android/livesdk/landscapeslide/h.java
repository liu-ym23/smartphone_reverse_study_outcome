package com.bytedance.android.livesdk.landscapeslide;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    public final long a;
    public final String b;
    public final Pair<Integer, Integer> c;
    public final int d;
    public final boolean e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L16;
        h r7 = (h) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        Pair<Integer, Integer> r6 = this.c;
        if (r6 == null) goto L9;
        r3 = r6.hashCode();
    L9:
        int r7 = (((r5 + r3) * 31) + this.d) * 31;
        boolean r8 = this.e;
        ?? r9 = r8;
        if (r8 == false) goto L13;
        r9 = 1;
    L13:
        return r7 + r9;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomInfo(roomId=" + this.a + ", anchorId=" + this.b + ", videoSize=" + this.c + ", screenOrientation=" + this.d + ", enableSwitch=" + this.e + ')';
    }

    public h(long r2, String r4, Pair<Integer, Integer> r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "videoSize");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
