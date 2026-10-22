package yv0;

import com.bytedance.android.live.recharge.model.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f569276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f569277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f569278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f569279d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f569276a, r101.f569276a) == true) goto L8;
        return false;
    L8:
        if (this.f569277b == r101.f569277b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f569278c, r101.f569278c) == true) goto L12;
        return false;
    L12:
        if (this.f569279d == r101.f569279d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        d r100 = this.f569276a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f569277b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        List<Long> r105 = this.f569278c;
        if (r105 == null) goto L9;
        r101 = r105.hashCode();
    L9:
        int r106 = (r104 + r101) * 31;
        boolean r107 = this.f569279d;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        return r106 + r108;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RechargePreOrderData(entranceParams=" + this.f569276a + ", balance=" + this.f569277b + ", diamondList=" + this.f569278c + ", isCachedDiamondList=" + this.f569279d + ")";
    }

    public b(d r100, long r101, List<Long> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "entranceParams");
        Intrinsics.checkNotNullParameter(r102, "diamondList");
        this.f569276a = r100;
        this.f569277b = r101;
        this.f569278c = r102;
        this.f569279d = r103;
    }
}
