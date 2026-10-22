package vg3;

import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityVO;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> f554682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityVO f554683b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f554682a, r101.f554682a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f554683b, r101.f554683b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r100 = this.f554682a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ActivityVO r104 = this.f554683b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AuctionInfo(componentVOS=" + this.f554682a + ", activityInfo=" + this.f554683b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r100, ActivityVO r101) {
        this.f554682a = r100;
        this.f554683b = r101;
    }
}
