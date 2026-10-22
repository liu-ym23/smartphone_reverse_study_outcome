package mh2;

import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f513902a;

    public d(List r100) {
        this.f513902a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Object[] r101 = (Object[]) r100;
        Intrinsics.checkNotNullParameter(r101, "rets");
        Iterator<T> r102 = CollectionsKt.sortedWith(ArraysKt.filterIsInstance(r101, r.b.class), new c()).iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r.b r103 = (r.b) r102.next();
        this.f513902a.add(r103.f513938b);
        goto L4
    L7:
        return Unit.INSTANCE;
    }
}
