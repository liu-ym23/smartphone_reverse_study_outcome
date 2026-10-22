package eu7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f474094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f474095c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f474093a, r101.f474093a) == true) goto L12;
        return false;
    L12:
        if (this.f474094b == r101.f474094b) goto L15;
        return false;
    L15:
        if (this.f474095c == r101.f474095c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f474093a.hashCode() * 31;
        long r101 = this.f474094b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f474095c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "ScenarioData(name=" + this.f474093a + ", startTime=" + this.f474094b + ", endTime=" + this.f474095c + ')';
    }

    public b(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f474093a = r100;
        this.f474094b = r101;
        this.f474095c = -1;
    }
}
