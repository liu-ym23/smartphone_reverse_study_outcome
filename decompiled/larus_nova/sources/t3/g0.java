package t3;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f544295b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f544294a, r101.f544294a) == true) goto L12;
        return false;
    L12:
        if (this.f544295b == r101.f544295b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f544294a.hashCode() * 31;
        if (this.f544295b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "BluetoothServiceSnapshot(uuid=" + this.f544294a + ", isPrimary=" + this.f544295b + ')';
    }

    public g0(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        this.f544294a = r100;
        this.f544295b = r101;
    }
}
