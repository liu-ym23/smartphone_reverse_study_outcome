package tw6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f547762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f547763b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f547762a, r101.f547762a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547763b, r101.f547763b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f547762a.hashCode() * 31) + this.f547763b.hashCode();
    }

    public final String toString() {
        return "FrameSwitch(allowList=" + this.f547762a + ", blockList=" + this.f547763b + ')';
    }

    public a(List<String> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "allowList");
        Intrinsics.checkNotNullParameter(r101, "blockList");
        this.f547762a = r100;
        this.f547763b = r101;
    }
}
