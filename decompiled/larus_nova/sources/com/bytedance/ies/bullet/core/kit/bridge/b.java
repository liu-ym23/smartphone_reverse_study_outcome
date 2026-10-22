package com.bytedance.ies.bullet.core.kit.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f246543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f246544b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f246543a, r101.f246543a) == true) goto L12;
        return false;
    L12:
        if (this.f246544b == r101.f246544b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f246543a.hashCode() * 31;
        if (this.f246544b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "BridgeMergeOperation(otherRegistry=" + this.f246543a + ", useOthersOnConflict=" + this.f246544b + ')';
    }

    public b(BridgeRegistry r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "otherRegistry");
        this.f246543a = r100;
        this.f246544b = r101;
    }
}
