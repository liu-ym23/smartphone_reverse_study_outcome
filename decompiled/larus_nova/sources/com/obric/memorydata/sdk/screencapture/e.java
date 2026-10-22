package com.obric.memorydata.sdk.screencapture;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenEventReaction f397226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f397227b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f397226a, r101.f397226a) == true) goto L12;
        return false;
    L12:
        if (this.f397227b == r101.f397227b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        this.f397226a.hashCode();
        throw null;
    }

    public final String toString() {
        return "PendingOperation(screenEventReaction=" + this.f397226a + ", timeout=" + this.f397227b + ", callback=null)";
    }

    public e(ScreenEventReaction r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "screenEventReaction");
        Intrinsics.checkNotNullParameter(null, "callback");
        this.f397226a = r100;
        this.f397227b = r101;
    }
}
