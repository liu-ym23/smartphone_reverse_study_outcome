package com.larus.voicecall.impl.tracer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceCallTraceReplyType f379222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f379223b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f379222a == r101.f379222a) goto L12;
        return false;
    L12:
        if (this.f379223b == r101.f379223b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f379222a.hashCode() * 31;
        long r101 = this.f379223b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "PendingReplyTraceEvent(kind=" + this.f379222a + ", millis=" + this.f379223b + ')';
    }

    public p(VoiceCallTraceReplyType r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        this.f379222a = r100;
        this.f379223b = r101;
    }
}
