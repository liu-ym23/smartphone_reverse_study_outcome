package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final KtvMusic a;
    public final boolean b;
    public final boolean c;
    public final long d;
    public final Long e;

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
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        KtvMusic r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.c;
        if (r8 == true) goto L13;
        r5 = r8;
    L13:
        long r9 = this.d;
        int r10 = (((r7 + r5) * 31) + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        Long r11 = this.e;
        if (r11 == null) goto L17;
        r1 = r11.hashCode();
    L17:
        return r10 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BGMMusicParams(music=" + this.a + ", enableMixer=" + this.b + ", enableKtvAccurateProgress=" + this.c + ", startTimeMs=" + this.d + ", assignedDuration=" + this.e + ")";
    }

    public a(KtvMusic r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "music");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 0;
        this.e = null;
    }
}
