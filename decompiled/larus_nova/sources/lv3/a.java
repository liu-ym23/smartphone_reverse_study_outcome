package lv3;

import com.bytedance.applet.aibridge.ecommerce.impl.ECommerceProductCardPreloadGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECommerceProductCardPreloadGroup f510888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f510889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f510890c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f510888a == r101.f510888a) goto L12;
        return false;
    L12:
        if (Double.compare(this.f510889b, r101.f510889b) == 0) goto L15;
        return false;
    L15:
        if (this.f510890c == r101.f510890c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f510888a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f510889b);
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f510890c;
    }

    public final String toString() {
        return "ECommerceProductCardPreloadConfiguration(group=" + this.f510888a + ", cardThrottleIntervalSeconds=" + this.f510889b + ", maxCardCount=" + this.f510890c + ')';
    }

    public a(ECommerceProductCardPreloadGroup r100, double r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "group");
        this.f510888a = r100;
        this.f510889b = r101;
        this.f510890c = r102;
    }
}
