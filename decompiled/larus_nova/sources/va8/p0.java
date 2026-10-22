package va8;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f553972a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f553972a, ((p0) r100).f553972a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f553972a.hashCode();
    }

    public final String toString() {
        return "PreviewRoundMessageFilterConfig(queryIds=" + this.f553972a + ')';
    }

    public p0(Set<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "queryIds");
        this.f553972a = r100;
    }
}
