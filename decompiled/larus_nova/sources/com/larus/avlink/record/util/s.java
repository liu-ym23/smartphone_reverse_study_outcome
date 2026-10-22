package com.larus.avlink.record.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f294440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RetryTrigger f294441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f294442c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.f294440a == r101.f294440a) goto L12;
        return false;
    L12:
        if (this.f294441b == r101.f294441b) goto L15;
        return false;
    L15:
        if (this.f294442c == r101.f294442c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f294440a * 31) + this.f294441b.hashCode()) * 31) + this.f294442c;
    }

    public final String toString() {
        return "RetryContext(attempt=" + this.f294440a + ", trigger=" + this.f294441b + ", delaySec=" + this.f294442c + ')';
    }

    public s(int r100, RetryTrigger r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "trigger");
        this.f294440a = r100;
        this.f294441b = r101;
        this.f294442c = r102;
    }
}
