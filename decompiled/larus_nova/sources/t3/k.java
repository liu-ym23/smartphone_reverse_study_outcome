package t3;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f544320b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f544319a, r101.f544319a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544320b, r101.f544320b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f544319a.hashCode() * 31) + this.f544320b.hashCode();
    }

    public final String toString() {
        return "BluetoothCharacteristicSnapshot(uuid=" + this.f544319a + ", properties=" + this.f544320b + ')';
    }

    public k(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "properties");
        this.f544319a = r100;
        this.f544320b = r101;
    }
}
