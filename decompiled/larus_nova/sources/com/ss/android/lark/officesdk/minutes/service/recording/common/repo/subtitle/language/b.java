package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f435284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f435285b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f435284a, r101.f435284a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435285b, r101.f435285b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f435284a.hashCode() * 31) + this.f435285b.hashCode();
    }

    public final String toString() {
        return "Complete(state=" + this.f435284a + ", language=" + this.f435285b + ')';
    }

    public b(e r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "language");
        this.f435284a = r100;
        this.f435285b = r101;
    }
}
