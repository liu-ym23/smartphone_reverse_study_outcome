package f10;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f475041a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f475041a, ((d) r100).f475041a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<f> r100 = this.f475041a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "InteractRecentUsedGroupList(itemList=" + this.f475041a + ")";
    }

    public d(List<f> r100) {
        Intrinsics.checkNotNullParameter(r100, "itemList");
        this.f475041a = r100;
    }
}
