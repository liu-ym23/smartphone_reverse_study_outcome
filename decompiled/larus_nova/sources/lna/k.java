package lna;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f510066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f510067c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f510065a, r101.f510065a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510066b, r101.f510066b) == true) goto L15;
        return false;
    L15:
        if (this.f510067c == r101.f510067c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f510065a.hashCode() * 31) + this.f510066b.hashCode()) * 31;
        long r101 = this.f510067c;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "ThreadWrapper(tName=" + this.f510065a + ", rThread=" + this.f510066b + ", startTimeStamp=" + this.f510067c + ')';
    }

    public k(String r100, Thread r101) {
        Intrinsics.checkNotNullParameter(r100, "tName");
        Intrinsics.checkNotNullParameter(r101, "rThread");
        this.f510065a = r100;
        this.f510066b = r101;
        this.f510067c = 0;
    }
}
