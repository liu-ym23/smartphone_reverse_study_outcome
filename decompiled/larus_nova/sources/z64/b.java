package z64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f570455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f570457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f570458d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L25:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f570455a, r101.f570455a) == false) goto L24;
        if (this.f570456b != r101.f570456b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L24;
        if (this.f570457c != r101.f570457c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L24;
        if (this.f570458d != r101.f570458d) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L24;
    L21:
        r104 = false;
        goto L22
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f570455a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f570456b) * 31;
        boolean r103 = this.f570457c;
        ?? r104 = r103;
        if (r103 == false) goto L9;
        r104 = 1;
    L9:
        int r105 = (r102 + r104) * 31;
        long r106 = this.f570458d;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "BadgerReport(payload=" + this.f570455a + ", errorCode=" + this.f570456b + ", isFull=" + this.f570457c + ", durationNs=" + this.f570458d + ")";
    }

    public b(String r100, int r101, boolean r102, long r103) {
        this.f570455a = r100;
        this.f570456b = r101;
        this.f570457c = r102;
        this.f570458d = r103;
    }
}
