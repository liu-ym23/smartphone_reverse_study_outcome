package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n5 {
    private final String localDay;
    private final String signature;

    public n5() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n5) == true) goto L8;
        return false;
    L8:
        n5 r101 = (n5) r100;
        if (Intrinsics.areEqual(this.localDay, r101.localDay) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signature, r101.signature) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.localDay.hashCode() * 31) + this.signature.hashCode();
    }

    public final String toString() {
        return "SwitchExposureState(localDay=" + this.localDay + ", signature=" + this.signature + ')';
    }

    public final String a() {
        return this.localDay;
    }

    public final String b() {
        return this.signature;
    }

    public /* synthetic */ n5(int r100) {
        this("", "");
    }

    public n5(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localDay");
        Intrinsics.checkNotNullParameter(r101, "signature");
        this.localDay = r100;
        this.signature = r101;
    }
}
