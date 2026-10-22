package xw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f565230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f565231b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f565230a == r101.f565230a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565231b, r101.f565231b) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f565230a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = 0;
        int r102 = ((r100 * 31) + 0) * 31;
        h r103 = this.f565231b;
        if (r103 == null) goto L11;
        r101 = r103.hashCode();
    L11:
        return r102 + r101;
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "KMPFlowAudioSceneActivationResult(isSuccess=" + this.f565230a + ", resource=null, error=" + this.f565231b + ')';
    }

    public f(boolean r100, h r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        r101 = null;
    L5:
        this.f565230a = r100;
        this.f565231b = r101;
    }
}
