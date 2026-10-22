package gz3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f483395b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f483394a, r101.f483394a) == true) goto L12;
        return false;
    L12:
        if (this.f483395b == r101.f483395b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f483394a.hashCode() * 31;
        long r101 = this.f483395b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "AosPlayerSeekEvent(aid=" + this.f483394a + ", seekTo=" + this.f483395b + ')';
    }

    public c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        this.f483394a = r100;
        this.f483395b = r101;
    }
}
