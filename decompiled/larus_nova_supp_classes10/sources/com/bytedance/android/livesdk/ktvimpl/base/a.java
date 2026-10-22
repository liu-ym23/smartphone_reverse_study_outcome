package com.bytedance.android.livesdk.ktvimpl.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final String a;
    public final long b;
    public final boolean c;
    public final String d;
    public final int e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L16;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
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
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        boolean r5 = this.c;
        ?? r6 = r5;
        if (r5 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L13;
        r1 = r8.hashCode();
    L13:
        return ((r7 + r1) * 31) + this.e;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "KaraokeMusicParam(musicId=" + this.a + ", singProgress=" + this.b + ", isSinger=" + this.c + ", lyricUrl=" + this.d + ", lyricType=" + this.e + ")";
    }

    public a(String r2, long r3, boolean r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        Intrinsics.checkNotNullParameter(r6, "lyricUrl");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
