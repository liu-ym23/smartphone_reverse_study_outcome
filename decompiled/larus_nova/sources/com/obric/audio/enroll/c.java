package com.obric.audio.enroll;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f395433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f395434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f395435c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f395433a, r101.f395433a) == true) goto L12;
        return false;
    L12:
        if (this.f395434b == r101.f395434b) goto L15;
        return false;
    L15:
        if (this.f395435c == r101.f395435c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f395433a.hashCode() * 31) + this.f395434b) * 31) + this.f395435c;
    }

    public final String toString() {
        return "EnrolledDeviceBluetoothInfo(deviceName=" + this.f395433a + ", blueDeviceTypeValue=" + this.f395434b + ", blueProductIdValue=" + this.f395435c + ')';
    }

    public c(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "deviceName");
        this.f395433a = r100;
        this.f395434b = r101;
        this.f395435c = r102;
    }
}
