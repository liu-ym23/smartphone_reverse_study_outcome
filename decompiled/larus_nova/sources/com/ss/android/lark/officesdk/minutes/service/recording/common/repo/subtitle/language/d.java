package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f435287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f435288b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f435287a, r101.f435287a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435288b, r101.f435288b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f435287a.hashCode() * 31) + this.f435288b.hashCode();
    }

    public final String toString() {
        return "SetTranslation(state=" + this.f435287a + ", language=" + this.f435288b + ')';
    }

    public d(e r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "language");
        this.f435287a = r100;
        this.f435288b = r101;
    }
}
