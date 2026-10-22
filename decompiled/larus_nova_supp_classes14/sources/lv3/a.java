package lv3;

import com.bytedance.applet.aibridge.ecommerce.impl.ECommerceProductCardPreloadGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final ECommerceProductCardPreloadGroup a;
    public final double b;
    public final int c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r9.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = Double.doubleToLongBits(this.b);
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c;
    }

    public final String toString() {
        return "ECommerceProductCardPreloadConfiguration(group=" + this.a + ", cardThrottleIntervalSeconds=" + this.b + ", maxCardCount=" + this.c + ')';
    }

    public a(ECommerceProductCardPreloadGroup r2, double r3, int r5) {
        Intrinsics.checkNotNullParameter(r2, "group");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
