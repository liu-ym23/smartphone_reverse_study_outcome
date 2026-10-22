package w88;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f558701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f558702b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f558701a, r101.f558701a) == true) goto L12;
        return false;
    L12:
        if (this.f558702b == r101.f558702b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f558701a.hashCode() * 31;
        long r101 = this.f558702b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "GalleryStorageStats(buckets=" + this.f558701a + ", totalBytes=" + this.f558702b + ')';
    }

    public q(List<n> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "buckets");
        this.f558701a = r100;
        this.f558702b = r101;
    }
}
