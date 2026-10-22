package com.bytedance.locallife.dito.common.plugin;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<o> f257589a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f257589a, ((n) r100).f257589a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f257589a.hashCode();
    }

    public final String toString() {
        return "DitoVirtualRefreshTargetActCreateEvent(targetActWeakRef=" + this.f257589a + ')';
    }

    public n(WeakReference<o> r100) {
        Intrinsics.checkNotNullParameter(r100, "targetActWeakRef");
        this.f257589a = r100;
    }
}
