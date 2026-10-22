package zd9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class e {
    public static final <T, R> List<T> a(Iterable<? extends T> r100, Iterable<? extends T> r101, final Function1<? super T, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        Intrinsics.checkNotNullParameter(r102, "selector");
        Set r103 = SetsKt.minus(SequencesKt.toSet(SequencesKt.map(CollectionsKt.asSequence(r100), new c(r102))), SequencesKt.toSet(SequencesKt.map(CollectionsKt.asSequence(r101), new d(r102))));
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        T r106 = ((j) r105.next()).f571484b;
        if (r106 == null) goto L4;
        r104.add(r106);
        goto L4
    L8:
        return r104;
    }
}
