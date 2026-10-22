package ev6;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends b> f474359a;

    public k() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f474359a, ((k) r100).f474359a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f474359a.hashCode();
    }

    public final String toString() {
        return "ShelfProductFinalPriceUIData(content=" + this.f474359a + ')';
    }

    public k(Object r100) {
        List<? extends b> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f474359a = r101;
    }
}
