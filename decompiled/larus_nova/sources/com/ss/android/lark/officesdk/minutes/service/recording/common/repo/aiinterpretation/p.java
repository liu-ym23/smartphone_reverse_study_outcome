package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f434787b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f434786a, r101.f434786a) == true) goto L12;
        return false;
    L12:
        if (this.f434787b == r101.f434787b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f434786a.hashCode() * 31) + this.f434787b;
    }

    public final String toString() {
        return "MmAIInterpretationUpdateResult(channel=" + this.f434786a + ", status=" + this.f434787b + ')';
    }

    public final boolean a() {
        if (this.f434787b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public p(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        this.f434786a = r100;
        this.f434787b = r101;
    }
}
