package y93;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566972b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f566971a, r101.f566971a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f566972b, r101.f566972b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f566971a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f566972b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallDeliveryParams(process=" + this.f566971a + ", uuid=" + this.f566972b + ")";
    }

    public e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "process");
        Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
        this.f566971a = r100;
        this.f566972b = r101;
    }
}
