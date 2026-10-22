package y58;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566281b;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f566280a, r101.f566280a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566281b, r101.f566281b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f566280a.hashCode() * 31) + this.f566281b.hashCode();
    }

    public final String toString() {
        return "AudioSdkAsrTraceInfo(traceId=" + this.f566280a + ", enterFrom=" + this.f566281b + ')';
    }

    public final String a() {
        return this.f566281b;
    }

    public final String b() {
        return this.f566280a;
    }

    public /* synthetic */ d(int r100) {
        this("", "");
    }

    public d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        this.f566280a = r100;
        this.f566281b = r101;
    }
}
