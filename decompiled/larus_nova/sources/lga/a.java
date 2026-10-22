package lga;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f509215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f509216c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f509214a, r101.f509214a) == true) goto L12;
        return false;
    L12:
        if (this.f509215b == r101.f509215b) goto L15;
        return false;
    L15:
        if (this.f509216c == r101.f509216c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f509214a.hashCode() * 31;
        int r101 = 1231;
        if (this.f509215b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f509216c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VendorBluetoothSppStatus(deviceAddress=" + this.f509214a + ", doraUuidAvailable=" + this.f509215b + ", huaweiUuidAvailable=" + this.f509216c + ')';
    }

    public a(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "deviceAddress");
        this.f509214a = r100;
        this.f509215b = r101;
        this.f509216c = r102;
    }
}
