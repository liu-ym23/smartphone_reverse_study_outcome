package ev6;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends b> f474300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f474301b;

    public d0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f474300a, r101.f474300a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f474301b, r101.f474301b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f474300a.hashCode() * 31) + Float.floatToIntBits(this.f474301b);
    }

    public final String toString() {
        return "ShelfProductSecondPriceUIData(content=" + this.f474300a + ", marginStart=" + this.f474301b + ')';
    }

    public d0(Object r100) {
        List<? extends b> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f474300a = r101;
        this.f474301b = 1.0f;
    }

    public final void a(List<? extends b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f474300a = r100;
    }
}
