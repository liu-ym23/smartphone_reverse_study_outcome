package com.bytedance.flow_audio.impl.business.asr;

/* JADX INFO: loaded from: classes19.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f244016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f244017b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f244016a == r101.f244016a) goto L12;
        return false;
    L12:
        if (this.f244017b == r101.f244017b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f244016a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f244017b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowAsrStopDecision(canStop=" + this.f244016a + ", shouldStopSource=" + this.f244017b + ')';
    }

    public q(boolean r100, boolean r101) {
        this.f244016a = r100;
        this.f244017b = r101;
    }
}
