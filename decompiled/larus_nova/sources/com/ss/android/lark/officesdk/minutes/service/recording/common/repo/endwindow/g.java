package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f434962a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f434962a, ((g) r100).f434962a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        c r100 = this.f434962a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "EndRecording(entity=" + this.f434962a + ')';
    }

    public g(c r100) {
        this.f434962a = r100;
    }
}
