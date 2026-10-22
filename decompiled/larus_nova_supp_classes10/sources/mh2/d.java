package mh2;

import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ List a;

    public d(List r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Object[] r4 = (Object[]) r3;
        Intrinsics.checkNotNullParameter(r4, "rets");
        Iterator<T> r5 = CollectionsKt.sortedWith(ArraysKt.filterIsInstance(r4, r.b.class), new c()).iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r.b r0 = (r.b) r5.next();
        this.a.add(r0.b);
        goto L4
    L7:
        return Unit.INSTANCE;
    }
}
