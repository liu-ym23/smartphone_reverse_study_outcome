package p70;

import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<? extends a<?>> f527976a;

    public b() {
        this.f527976a = null;
    }

    public final <T extends a<?>> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "classChain");
        Set<? extends a<?>> r101 = this.f527976a;
        Object r102 = null;
        if (r101 == null) goto L15;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((a) r104).getClass(), r100) == false) goto L6;
        r102 = r104;
    L11:
        return (T) r102;
    L15:
        return null;
    }
}
