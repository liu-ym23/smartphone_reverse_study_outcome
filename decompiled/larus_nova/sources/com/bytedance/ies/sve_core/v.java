package com.bytedance.ies.sve_core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r<?> f248703a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f248703a, ((v) r100).f248703a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        r<?> r100 = this.f248703a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "WidgetContext(widget=" + this.f248703a + ")";
    }

    public v(r<?> r100) {
        this.f248703a = r100;
    }
}
