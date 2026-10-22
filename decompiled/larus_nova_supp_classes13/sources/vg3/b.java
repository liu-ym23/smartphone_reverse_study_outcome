package vg3;

import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityVO;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> a;
    public final ActivityVO b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ActivityVO r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AuctionInfo(componentVOS=" + this.a + ", activityInfo=" + this.b + ")";
    }

    public b(List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r1, ActivityVO r2) {
        this.a = r1;
        this.b = r2;
    }
}
