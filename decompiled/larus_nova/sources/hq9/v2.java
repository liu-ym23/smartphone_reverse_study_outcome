package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f486795b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v2) == true) goto L8;
        return false;
    L8:
        v2 r101 = (v2) r100;
        if (Intrinsics.areEqual(this.f486794a, r101.f486794a) == true) goto L12;
        return false;
    L12:
        if (this.f486795b == r101.f486795b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f486794a.hashCode() * 31;
        long r101 = this.f486795b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "LarkSocialSessionToken(uid=" + this.f486794a + ", generation=" + this.f486795b + ')';
    }

    public v2(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f486794a = r100;
        this.f486795b = r101;
    }
}
