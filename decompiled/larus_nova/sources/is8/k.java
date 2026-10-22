package is8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f495693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f495694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f495695c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f495693a == r101.f495693a) goto L12;
        return false;
    L12:
        if (this.f495694b == r101.f495694b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495695c, r101.f495695c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f495693a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f495694b;
        return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f495695c.hashCode();
    }

    public final String toString() {
        return "UploadTraceSnapshot(startTimeMs=" + this.f495693a + ", endTimeMs=" + this.f495694b + ", attributes=" + this.f495695c + ')';
    }

    public k(long r100, long r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r102, "attributes");
        this.f495693a = r100;
        this.f495694b = r101;
        this.f495695c = r102;
    }
}
