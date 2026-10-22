package ev6;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f474360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends b> f474361b;

    public k0() {
        this(0, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (this.f474360a == r101.f474360a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474361b, r101.f474361b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f474360a * 31) + this.f474361b.hashCode();
    }

    public final String toString() {
        return "ShelfProductTitleUIData(textLines=" + this.f474360a + ", content=" + this.f474361b + ')';
    }

    public k0(int r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 2;
    L6:
        if ((r101 & 2) == 0) goto L8;
        List<? extends b> r102 = CollectionsKt.emptyList();
    L9:
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f474360a = r100;
        this.f474361b = r102;
        return;
    L8:
        r102 = null;
        goto L9
    }
}
