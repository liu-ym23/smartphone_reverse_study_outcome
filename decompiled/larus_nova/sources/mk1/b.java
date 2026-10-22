package mk1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements Comparable<b> {
    public b() {
    }

    public abstract a a();

    public c b() {
        c r100 = c.f514296b;
        return c.f514296b;
    }

    public final int hashCode() {
        return b().hashCode();
    }

    @Override // java.lang.Comparable
    public final int compareTo(b r100) {
        b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return r101.b().f514298a - b().f514298a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(r101, r102)) == false) goto L14;
        return false;
    L14:
        if ((r100 instanceof b) == true) goto L16;
        return true;
    L16:
        return Intrinsics.areEqual(((b) r100).b(), b());
    L8:
        r102 = null;
        goto L10
    }
}
