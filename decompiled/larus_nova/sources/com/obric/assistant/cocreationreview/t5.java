package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f387737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387738b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t5) == true) goto L8;
        return false;
    L8:
        t5 r101 = (t5) r100;
        if (this.f387737a == r101.f387737a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387738b, r101.f387738b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f387737a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f387738b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "SubmitAnnotationResult(accepted=" + this.f387737a + ", message=" + this.f387738b + ')';
    }

    public t5(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f387737a = r100;
        this.f387738b = r101;
    }
}
