package wi8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f559856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f559857c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f559855a, r101.f559855a) == true) goto L12;
        return false;
    L12:
        if (this.f559856b == r101.f559856b) goto L15;
        return false;
    L15:
        if (this.f559857c == r101.f559857c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f559855a.hashCode() * 31;
        long r101 = this.f559856b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f559857c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "ChatLimitInfo(message=" + this.f559855a + ", startTime=" + this.f559856b + ", duration=" + this.f559857c + ')';
    }

    public a(String r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f559855a = r100;
        this.f559856b = r101;
        this.f559857c = r102;
    }
}
