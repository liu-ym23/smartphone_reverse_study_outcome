package tf3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f545731a;

    public l() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f545731a, ((l) r100).f545731a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.f545731a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PrefetchExtraParams(defaultSpecIds=" + this.f545731a + ")";
    }

    public l(List<String> r100) {
        this.f545731a = r100;
    }
}
