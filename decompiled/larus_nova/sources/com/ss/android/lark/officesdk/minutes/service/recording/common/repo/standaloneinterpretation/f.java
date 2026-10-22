package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f435143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f435144b;

    public /* synthetic */ f() {
        this(false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f435143a == r101.f435143a) goto L12;
        return false;
    L12:
        if (this.f435144b == r101.f435144b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f435143a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f435144b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationSaveArtifactSyncResult(isSuccess=" + this.f435143a + ", suppressLocalFallback=" + this.f435144b + ')';
    }

    public f(boolean r100, boolean r101) {
        this.f435143a = r100;
        this.f435144b = r101;
    }
}
