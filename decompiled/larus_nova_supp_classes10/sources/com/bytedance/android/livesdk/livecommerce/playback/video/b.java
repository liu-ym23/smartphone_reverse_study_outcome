package com.bytedance.android.livesdk.livecommerce.playback.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements com.bytedance.android.ec.core.arch.state.b {
    public final Integer a;
    public final Integer b;
    public final float c;

    public b() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + Float.floatToIntBits(this.c);
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ExplainPlaybackVideoState(currentTime=" + this.a + ", maxTime=" + this.b + ", speedFloat=" + this.c + ")";
    }

    public /* synthetic */ b(int r2) {
        this(null, null, 1.0f);
    }

    public b(Integer r1, Integer r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
