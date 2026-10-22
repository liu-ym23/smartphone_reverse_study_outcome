package da9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f467733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f467734b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f467733a == r101.f467733a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467734b, r101.f467734b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f467733a * 31) + this.f467734b.hashCode();
    }

    public final String toString() {
        return "SourceConfig(preferredFps=" + this.f467733a + ", preferredResolution=" + this.f467734b + ')';
    }

    public f(int r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "preferredResolution");
        this.f467733a = r100;
        this.f467734b = r101;
    }
}
