package x1c;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f562153a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f562153a, ((a) r100).f562153a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f562153a.hashCode();
    }

    public final String toString() {
        return "DoubaoHomepageData(images=" + this.f562153a + ')';
    }

    public a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "images");
        this.f562153a = r100;
    }
}
