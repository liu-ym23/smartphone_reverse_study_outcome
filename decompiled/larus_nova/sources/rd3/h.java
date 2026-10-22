package rd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f537254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f537255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f537256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f537257d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L14;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f537254a, r101.f537254a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f537255b, r101.f537255b) == true) goto L10;
        return false;
    L10:
        if (this.f537256c == r101.f537256c) goto L12;
        return false;
    L12:
        if (this.f537257d == r101.f537257d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r100 = this.f537254a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f537255b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f537256c;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        boolean r108 = this.f537257d;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        return r107 + r109;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InflowFeedCommentVO(urlSchema=" + this.f537254a + ", style=" + this.f537255b + ", count=" + this.f537256c + ", isShowCommentCounts=" + this.f537257d + ")";
    }

    public h(String r100, Integer r101, long r102, boolean r103) {
        this.f537254a = r100;
        this.f537255b = r101;
        this.f537256c = r102;
        this.f537257d = r103;
    }
}
