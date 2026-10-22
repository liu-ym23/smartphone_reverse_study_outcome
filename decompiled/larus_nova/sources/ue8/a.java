package ue8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements i {
    public a() {
    }

    @Override // ue8.i
    public final c a(List<j> r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "currentlyVisible");
        Intrinsics.checkNotNullParameter(r101, "previouslyExposed");
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((j) r103.next()).f549826a);
        goto L4
    L6:
        Set r104 = CollectionsKt.toSet(r102);
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        if ((!((j) r107).f549829d) == false) goto L8;
        r105.add(r107);
        goto L8
    L12:
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r101.iterator();
    L14:
        if (r109.hasNext() == false) goto L19;
        Object r110 = r109.next();
        if ((!r104.contains((String) r110)) == false) goto L14;
        r108.add(r110);
        goto L14
    L19:
        return new c(r105, r108);
    }
}
