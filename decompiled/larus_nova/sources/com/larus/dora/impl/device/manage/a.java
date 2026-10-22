package com.larus.dora.impl.device.manage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f333694a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f333694a, ((a) r100).f333694a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        c r100 = this.f333694a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "DeviceSwitchEvent(newDevice=" + this.f333694a + ')';
    }

    public a(c r100) {
        this.f333694a = r100;
    }
}
