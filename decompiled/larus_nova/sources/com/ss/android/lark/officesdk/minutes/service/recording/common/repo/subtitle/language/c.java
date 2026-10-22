package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f435286a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f435286a, ((c) r100).f435286a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f435286a.hashCode();
    }

    public final String toString() {
        return "SetBilingual(state=" + this.f435286a + ')';
    }

    public c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f435286a = r100;
    }
}
