package ep3;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements c {
    public final List<c> a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramProviders");
        this.a = r2;
    }

    @Override // ep3.c
    public final Object a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Iterator<c> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next().a(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }
}
