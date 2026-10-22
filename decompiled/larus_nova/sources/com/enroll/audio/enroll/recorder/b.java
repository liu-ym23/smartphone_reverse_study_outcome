package com.enroll.audio.enroll.recorder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f273778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecordState f273779b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f273778a == r101.f273778a) goto L12;
        return false;
    L12:
        if (this.f273779b == r101.f273779b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f273778a * 31) + this.f273779b.hashCode();
    }

    public final String toString() {
        return "RecordToken(index=" + this.f273778a + ", state=" + this.f273779b + ')';
    }

    public b(int r100, RecordState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f273778a = r100;
        this.f273779b = r101;
    }
}
