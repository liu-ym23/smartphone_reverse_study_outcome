package ki4;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<? extends m> f503617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Class<? extends m>> f503618b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f503617a, r101.f503617a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503618b, r101.f503618b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f503617a.hashCode() * 31) + this.f503618b.hashCode();
    }

    public final String toString() {
        return "GroupStrategyClazzWrapper(currentClazz=" + this.f503617a + ", clazzList=" + this.f503618b + ')';
    }

    public c(Class<? extends m> r100, List<Class<? extends m>> r101) {
        Intrinsics.checkNotNullParameter(r100, "currentClazz");
        Intrinsics.checkNotNullParameter(r101, "clazzList");
        this.f503617a = r100;
        this.f503618b = r101;
    }
}
