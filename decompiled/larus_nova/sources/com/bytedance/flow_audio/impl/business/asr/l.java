package com.bytedance.flow_audio.impl.business.asr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hw5.a f243992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f243993b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f243992a, r101.f243992a) == true) goto L12;
        return false;
    L12:
        if (this.f243993b == r101.f243993b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f243992a.hashCode() * 31) + this.f243993b;
    }

    public final String toString() {
        return "FlowAsrRetryContext(rootError=" + this.f243992a + ", retryCount=" + this.f243993b + ')';
    }

    public l(hw5.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "rootError");
        this.f243992a = r100;
        this.f243993b = r101;
    }
}
