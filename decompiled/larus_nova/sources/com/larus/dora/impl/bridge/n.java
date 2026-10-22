package com.larus.dora.impl.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f332104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f332105b;

    public n() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f332104a, r101.f332104a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f332105b, r101.f332105b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f332104a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f332105b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraDeviceSettingsSnapshot(isAdaptationEnable=" + this.f332104a + ", cueToneVolumeRaw=" + this.f332105b + ')';
    }

    public n(Boolean r100, Integer r101) {
        this.f332104a = r100;
        this.f332105b = r101;
    }

    public static n a(n r100, Boolean r101, Integer r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f332104a;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f332105b;
    L9:
        return new n(r101, r102);
    }
}
