package t3;

import android.bluetooth.BluetoothGatt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothGatt f544383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s0 f544384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f544385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f544386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f544387f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.f544382a, r101.f544382a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544383b, r101.f544383b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544384c, r101.f544384c) == true) goto L18;
        return false;
    L18:
        if (this.f544385d == r101.f544385d) goto L21;
        return false;
    L21:
        if (this.f544386e == r101.f544386e) goto L24;
        return false;
    L24:
        if (this.f544387f == r101.f544387f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f544382a.hashCode() * 31) + this.f544383b.hashCode()) * 31) + this.f544384c.hashCode()) * 31;
        if (this.f544385d == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f544386e) * 31) + this.f544387f;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "GattSession(deviceId=" + this.f544382a + ", gatt=" + this.f544383b + ", callback=" + this.f544384c + ", connected=" + this.f544385d + ", mtu=" + this.f544386e + ", lastRssi=" + this.f544387f + ')';
    }

    public t0(String r100, BluetoothGatt r101, s0 r102) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "gatt");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f544382a = r100;
        this.f544383b = r101;
        this.f544384c = r102;
        this.f544385d = false;
        this.f544386e = 23;
        this.f544387f = 0;
    }
}
