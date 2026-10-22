package ma3;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f512682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f512683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f512684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f512685d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f512682a, r101.f512682a) == true) goto L8;
        return false;
    L8:
        if (this.f512683b == r101.f512683b) goto L10;
        return false;
    L10:
        if (this.f512684c == r101.f512684c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512685d, r101.f512685d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        m r100 = this.f512682a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f512683b) * 31) + this.f512684c) * 31;
        Integer r104 = this.f512685d;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BuyNowRequestParams(req=" + this.f512682a + ", bTypeNew=" + this.f512683b + ", subBType=" + this.f512684c + ", shape=" + this.f512685d + ")";
    }

    public f(m r100, int r101, int r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        this.f512682a = r100;
        this.f512683b = r101;
        this.f512684c = r102;
        this.f512685d = r103;
    }
}
