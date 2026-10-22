package com.larus.voicecall.impl.tracer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReplyAudioEventType f379241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f379242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f379243c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f379241a == r101.f379241a) goto L12;
        return false;
    L12:
        if (this.f379242b == r101.f379242b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f379243c, r101.f379243c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f379241a.hashCode() * 31;
        long r101 = this.f379242b;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f379243c.hashCode();
    }

    public final String toString() {
        return "ReplyAudioTraceEvent(eventType=" + this.f379241a + ", millis=" + this.f379242b + ", endType=" + this.f379243c + ')';
    }

    public v(ReplyAudioEventType r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r102, "endType");
        this.f379241a = r100;
        this.f379242b = r101;
        this.f379243c = r102;
    }
}
