package t3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f544327b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f544326a, r101.f544326a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544327b, r101.f544327b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f544326a.hashCode() * 31) + this.f544327b.hashCode();
    }

    public final String toString() {
        return "ConnectedBluetoothDeviceSnapshot(deviceId=" + this.f544326a + ", name=" + this.f544327b + ')';
    }

    public l0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f544326a = r100;
        this.f544327b = r101;
    }
}
