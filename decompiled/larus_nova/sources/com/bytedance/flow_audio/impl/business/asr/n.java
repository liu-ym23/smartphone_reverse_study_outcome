package com.bytedance.flow_audio.impl.business.asr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f244000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f244001b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f244000a == r101.f244000a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f244001b, r101.f244001b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f244000a * 31) + this.f244001b.hashCode();
    }

    public final String toString() {
        return "FlowAsrRetryDecision(retryCount=" + this.f244000a + ", filePath=" + this.f244001b + ')';
    }

    public n(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "filePath");
        this.f244000a = r100;
        this.f244001b = r101;
    }
}
