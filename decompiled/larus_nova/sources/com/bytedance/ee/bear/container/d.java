package com.bytedance.ee.bear.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yx4.d f216750a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f216750a, ((d) r100).f216750a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        yx4.d r100 = this.f216750a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ContainerLoadingLayoutState(loadingLayout=" + this.f216750a + ')';
    }

    public d(yx4.d r100) {
        this.f216750a = r100;
    }
}
