package lw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f511025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final iw5.c f511026b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f511025a, r101.f511025a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511026b, r101.f511026b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f511025a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        iw5.c r104 = this.f511026b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowVoiceInputRetryResult(audioFilePath=" + this.f511025a + ", asrResult=" + this.f511026b + ')';
    }

    public c(String r100, iw5.c r101) {
        this.f511025a = r100;
        this.f511026b = r101;
    }
}
