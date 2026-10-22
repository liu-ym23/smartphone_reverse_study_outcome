package com.larus.dora.impl.dynamic.viewmodel;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraDevice f335452a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f335452a, ((c) r100).f335452a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f335452a.hashCode();
    }

    public final String toString() {
        return "ShowDisconnectFailedDialog(device=" + this.f335452a + ')';
    }

    public c(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "device");
        this.f335452a = r100;
    }
}
