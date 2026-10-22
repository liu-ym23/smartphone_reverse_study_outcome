package com.larus.audio.call.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CaptureBackTraceReadScene f289602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f289603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f289604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f289605d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f289602a == r101.f289602a) goto L12;
        return false;
    L12:
        if (this.f289603b == r101.f289603b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f289604c, r101.f289604c) == true) goto L18;
        return false;
    L18:
        if (this.f289605d == r101.f289605d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f289602a.hashCode() * 31;
        long r101 = this.f289603b;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f289604c.hashCode()) * 31) + this.f289605d;
    }

    public final String toString() {
        return "CaptureBackTraceReadRequest(scene=" + this.f289602a + ", wantedStartTimeMs=" + this.f289603b + ", reason=" + this.f289604c + ", wakeupId=" + this.f289605d + ')';
    }

    public l(CaptureBackTraceReadScene r100, long r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "reason");
        this.f289602a = r100;
        this.f289603b = r101;
        this.f289604c = r102;
        this.f289605d = r103;
    }
}
