package com.larus.voicecall.impl.tracer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f379119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f379120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f379121c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f379119a == r101.f379119a) goto L12;
        return false;
    L12:
        if (this.f379120b == r101.f379120b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f379121c, r101.f379121c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f379119a * 31;
        long r101 = this.f379120b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Boolean r103 = this.f379121c;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "CallRoundTraceEvent(eventType=" + this.f379119a + ", eventTimeMillis=" + this.f379120b + ", isTtsPlayFinished=" + this.f379121c + ')';
    }

    public b(int r100, long r101, Boolean r102) {
        this.f379119a = r100;
        this.f379120b = r101;
        this.f379121c = r102;
    }
}
