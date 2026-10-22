package z29;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f569815a;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f569815a, ((c) r100).f569815a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f569815a.hashCode();
    }

    public final String toString() {
        return "MembershipQuotaViewModel(rows=" + this.f569815a + ')';
    }

    public c(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "rows");
        this.f569815a = r100;
    }

    public /* synthetic */ c(int r100) {
        this(CollectionsKt.emptyList());
    }
}
