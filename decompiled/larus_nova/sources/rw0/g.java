package rw0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.deal.f f539566a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f539566a, ((g) r100).f539566a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        com.bytedance.android.live.recharge.deal.f r100 = this.f539566a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "RechargeSelectedDealLog(deal=" + this.f539566a + ")";
    }

    public g(com.bytedance.android.live.recharge.deal.f r100) {
        Intrinsics.checkNotNullParameter(r100, "deal");
        this.f539566a = r100;
    }
}
