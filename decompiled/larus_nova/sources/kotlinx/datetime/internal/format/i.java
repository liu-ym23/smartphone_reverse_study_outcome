package kotlinx.datetime.internal.format;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class i<T> implements s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<s<T>> f505291a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends s<? super T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicates");
        this.f505291a = r100;
    }

    @Override // kotlinx.datetime.internal.format.s
    public final boolean test(T r100) {
        List<s<T>> r101 = this.f505291a;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (((s) r102.next()).test(r100) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return true;
    }
}
