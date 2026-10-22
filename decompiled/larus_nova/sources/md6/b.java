package md6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f513291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1 f513292b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f513291a, r101.f513291a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513292b, r101.f513292b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f513291a.hashCode() * 31) + this.f513292b.hashCode();
    }

    public final String toString() {
        return "FrameTimingData(frameData=" + this.f513291a + ", traceData=" + this.f513292b + ')';
    }

    public b(a r100, d1 r101) {
        Intrinsics.checkNotNullParameter(r100, "frameData");
        Intrinsics.checkNotNullParameter(r101, "traceData");
        this.f513291a = r100;
        this.f513292b = r101;
    }
}
