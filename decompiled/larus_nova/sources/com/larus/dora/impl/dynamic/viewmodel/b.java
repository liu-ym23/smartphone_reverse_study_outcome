package com.larus.dora.impl.dynamic.viewmodel;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraDevice f335451a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f335451a, ((b) r100).f335451a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f335451a.hashCode();
    }

    public final String toString() {
        return "NeedUnbind(device=" + this.f335451a + ')';
    }

    public b(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "device");
        this.f335451a = r100;
    }
}
