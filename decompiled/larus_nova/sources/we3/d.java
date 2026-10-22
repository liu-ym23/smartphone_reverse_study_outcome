package we3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f559392a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f559392a, ((d) r100).f559392a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<e> r100 = this.f559392a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LiveListOpenMessage(productInfo=" + this.f559392a + ")";
    }

    public d(List<e> r100) {
        this.f559392a = r100;
    }
}
