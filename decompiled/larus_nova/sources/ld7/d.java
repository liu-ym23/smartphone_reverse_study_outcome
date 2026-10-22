package ld7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f508726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f508727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f508728c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f508726a, r101.f508726a) == true) goto L12;
        return false;
    L12:
        if (this.f508727b == r101.f508727b) goto L15;
        return false;
    L15:
        if (this.f508728c == r101.f508728c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f508726a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f508727b) * 31) + this.f508728c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "BridgeCallRecord(lastCallTimeStamp=" + this.f508726a + ", callTimes=" + this.f508727b + ", callFreqTimes=" + this.f508728c + ')';
    }

    public d(Long r100, int r101, int r102) {
        this.f508726a = r100;
        this.f508727b = r101;
        this.f508728c = r102;
    }
}
