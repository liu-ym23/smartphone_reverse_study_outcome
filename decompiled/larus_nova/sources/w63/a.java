package w63;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f558411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j53.a> f558412b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f558411a == r101.f558411a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f558412b, r101.f558412b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f558411a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<j53.a> r102 = this.f558412b;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "AuctionOfferRecords(count=" + this.f558411a + ", items=" + this.f558412b + ")";
    }

    public a(long r100, List<j53.a> r101) {
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f558411a = r100;
        this.f558412b = r101;
    }
}
