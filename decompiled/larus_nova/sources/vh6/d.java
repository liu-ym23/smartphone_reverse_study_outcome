package vh6;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<T> f554978a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f554978a, ((d) r100).f554978a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        KClass<T> r100 = this.f554978a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "TypedKey(cls=" + this.f554978a + ")";
    }

    public d(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        this.f554978a = r100;
    }
}
