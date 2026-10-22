package qma;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f533957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f533958b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f533957a == r101.f533957a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f533958b, r101.f533958b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f533957a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f533958b.hashCode();
    }

    public final String toString() {
        return "Keyframe(timeMs=" + this.f533957a + ", value=" + this.f533958b + ')';
    }

    public f(long r100, d r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f533957a = r100;
        this.f533958b = r101;
    }
}
