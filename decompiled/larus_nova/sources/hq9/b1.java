package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b5 f486544a;

    public b1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f486544a, ((b1) r100).f486544a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        b5 r100 = this.f486544a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "FeaturesConfig(videoStreaming=" + this.f486544a + ')';
    }

    public b1(b5 r100) {
        this.f486544a = r100;
    }
}
