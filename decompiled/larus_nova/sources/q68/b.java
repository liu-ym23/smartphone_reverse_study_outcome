package q68;

import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {
    public static final <T> void a(Set<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "observers");
        Intrinsics.checkNotNullParameter(r101, "action");
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.invoke(r102.next());
        goto L4
    }
}
