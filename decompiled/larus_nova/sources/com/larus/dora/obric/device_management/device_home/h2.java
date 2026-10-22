package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f339244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraObricEnvironmentMemoryToastType f339245b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h2) == true) goto L8;
        return false;
    L8:
        h2 r101 = (h2) r100;
        if (this.f339244a == r101.f339244a) goto L12;
        return false;
    L12:
        if (this.f339245b == r101.f339245b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f339244a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f339245b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraObricEnvironmentMemoryCompletion(activateOverride=" + this.f339244a + ", toastType=" + this.f339245b + ')';
    }

    public h2(boolean r100, DoraObricEnvironmentMemoryToastType r101) {
        Intrinsics.checkNotNullParameter(r101, "toastType");
        this.f339244a = r100;
        this.f339245b = r101;
    }
}
