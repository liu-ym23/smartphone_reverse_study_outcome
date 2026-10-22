package m7c;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f512402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f512403b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f512402a, r101.f512402a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512403b, r101.f512403b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f512402a.hashCode() * 31) + this.f512403b.hashCode();
    }

    public final String toString() {
        return "ListTaskSectionSortSaveData(sectionGuids=" + this.f512402a + ", sectionRankMap=" + this.f512403b + ')';
    }

    public f(List<String> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionGuids");
        Intrinsics.checkNotNullParameter(r101, "sectionRankMap");
        this.f512402a = r100;
        this.f512403b = r101;
    }
}
