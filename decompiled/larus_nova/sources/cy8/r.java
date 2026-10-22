package cy8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f465907a;

    public r() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f465907a, ((r) r100).f465907a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<g> r100 = this.f465907a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CanvasParamFilterConf(confList=" + this.f465907a + ')';
    }

    public r(List<g> r100) {
        this.f465907a = r100;
    }
}
