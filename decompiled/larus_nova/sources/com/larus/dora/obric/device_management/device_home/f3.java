package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraObricGlassesMode f339223a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f3) == true) goto L9;
        return false;
    L9:
        if (this.f339223a == ((f3) r100).f339223a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f339223a.hashCode();
    }

    public final String toString() {
        return "DoraObricGlassesModeSheetState(selectedMode=" + this.f339223a + ')';
    }

    public f3(DoraObricGlassesMode r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedMode");
        this.f339223a = r100;
    }
}
