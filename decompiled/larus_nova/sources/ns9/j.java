package ns9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f520385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f520386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f520387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f520388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f520389e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f520385a, r101.f520385a) == true) goto L12;
        return false;
    L12:
        if (this.f520386b == r101.f520386b) goto L15;
        return false;
    L15:
        if (this.f520387c == r101.f520387c) goto L18;
        return false;
    L18:
        if (this.f520388d == r101.f520388d) goto L21;
        return false;
    L21:
        if (this.f520389e == r101.f520389e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f520385a.hashCode() * 31;
        long r101 = this.f520386b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f520387c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        int r105 = 1231;
        if (this.f520388d == false) goto L5;
        int r106 = 1231;
    L6:
        int r107 = (r104 + r106) * 31;
        if (this.f520389e == true) goto L11;
        r105 = 1237;
    L11:
        return r107 + r105;
    L5:
        r106 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReachHostDisplayEntry(request=" + this.f520385a + ", arrivalOrder=" + this.f520386b + ", firstShownAtUptimeMs=" + this.f520387c + ", isP0=" + this.f520388d + ", isDismissing=" + this.f520389e + ')';
    }

    public j(t r100, long r101, long r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f520385a = r100;
        this.f520386b = r101;
        this.f520387c = r102;
        this.f520388d = r103;
        this.f520389e = r104;
    }
}
