package q99;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f532142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532143b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f532142a == r101.f532142a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f532143b, r101.f532143b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f532142a * 31) + this.f532143b.hashCode();
    }

    public final String toString() {
        return "FlowDislikeOption(code=" + this.f532142a + ", displayText=" + this.f532143b + ')';
    }

    public b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "displayText");
        this.f532142a = r100;
        this.f532143b = r101;
    }
}
