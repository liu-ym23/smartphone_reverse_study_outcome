package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraObricGlassesMode f339172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f339173b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a3) == true) goto L8;
        return false;
    L8:
        a3 r101 = (a3) r100;
        if (this.f339172a == r101.f339172a) goto L12;
        return false;
    L12:
        if (this.f339173b == r101.f339173b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f339172a.hashCode() * 31;
        if (this.f339173b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraObricGlassesModeSheetOption(mode=" + this.f339172a + ", isSelected=" + this.f339173b + ')';
    }

    public a3(DoraObricGlassesMode r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f339172a = r100;
        this.f339173b = r101;
    }
}
