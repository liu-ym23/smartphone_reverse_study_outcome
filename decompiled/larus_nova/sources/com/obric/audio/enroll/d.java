package com.obric.audio.enroll;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f395436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f395437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f395438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f395439d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f395436a, r101.f395436a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f395437b, r101.f395437b) == true) goto L15;
        return false;
    L15:
        if (this.f395438c == r101.f395438c) goto L18;
        return false;
    L18:
        if (this.f395439d == r101.f395439d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f395436a.hashCode() * 31) + this.f395437b.hashCode()) * 31) + this.f395438c) * 31) + this.f395439d;
    }

    public final String toString() {
        return "EnrolledDeviceInfo(sn=" + this.f395436a + ", deviceName=" + this.f395437b + ", blueDeviceTypeValue=" + this.f395438c + ", blueProductIdValue=" + this.f395439d + ')';
    }

    public d(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        Intrinsics.checkNotNullParameter(r101, "deviceName");
        this.f395436a = r100;
        this.f395437b = r101;
        this.f395438c = r102;
        this.f395439d = r103;
    }
}
