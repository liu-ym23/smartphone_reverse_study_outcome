package js8;

import is8.g;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f500232a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "providers");
        this.f500232a = r100;
    }

    public final Object a(g r100, is8.a r101, Continuation<? super b> r102) {
        Iterator<T> r103 = this.f500232a.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (((c) r104).b(r101.f495636a) == false) goto L4;
    L9:
        c r105 = (c) r104;
        if (r105 == null) goto L14;
        return r105.a(r100, r101, r102);
    L14:
        throw new IllegalStateException("No credential provider bound for auth mode: " + r101.f495636a);
    L8:
        r104 = null;
        goto L9
    }
}
