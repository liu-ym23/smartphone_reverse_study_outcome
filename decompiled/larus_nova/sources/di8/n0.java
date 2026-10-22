package di8;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<d0>> f468807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f468808b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f468807a, r101.f468807a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468808b, r101.f468808b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f468807a.hashCode() * 31) + this.f468808b.hashCode();
    }

    public final String toString() {
        return "NestedMenuSubMenuModel(menuItemModels=" + this.f468807a + ", sectionOrder=" + this.f468808b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(Map<String, ? extends List<? extends d0>> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "menuItemModels");
        Intrinsics.checkNotNullParameter(r101, "sectionOrder");
        this.f468807a = r100;
        this.f468808b = r101;
    }
}
