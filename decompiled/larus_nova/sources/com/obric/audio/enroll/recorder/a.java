package com.obric.audio.enroll.recorder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f395485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecordState f395486b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f395485a == r101.f395485a) goto L12;
        return false;
    L12:
        if (this.f395486b == r101.f395486b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f395485a * 31) + this.f395486b.hashCode();
    }

    public final String toString() {
        return "RecordToken(index=" + this.f395485a + ", state=" + this.f395486b + ')';
    }

    public a(int r100, RecordState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f395485a = r100;
        this.f395486b = r101;
    }
}
