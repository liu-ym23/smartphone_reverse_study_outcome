package va8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f553975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f553976d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.f553973a, r101.f553973a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553974b, r101.f553974b) == true) goto L15;
        return false;
    L15:
        if (this.f553975c == r101.f553975c) goto L18;
        return false;
    L18:
        if (this.f553976d == r101.f553976d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f553973a.hashCode() * 31) + this.f553974b.hashCode()) * 31;
        long r101 = this.f553975c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f553976d;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "SearchLandingHighlightParams(targetMessageId=" + this.f553973a + ", keyword=" + this.f553974b + ", durationMs=" + this.f553975c + ", sessionId=" + this.f553976d + ')';
    }

    public q0(String r100, String r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "targetMessageId");
        Intrinsics.checkNotNullParameter(r101, "keyword");
        this.f553973a = r100;
        this.f553974b = r101;
        this.f553975c = r102;
        this.f553976d = r103;
    }
}
