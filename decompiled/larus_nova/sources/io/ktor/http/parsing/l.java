package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class l extends d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f491902a;

    @Override // io.ktor.http.parsing.c
    public final List<d> a() {
        return this.f491902a;
    }

    public l(List<? extends d> r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceGrammars");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = (d) r102.next();
        if ((r103 instanceof l) == true) goto L7;
        r101.add(r103);
        goto L4
    L7:
        CollectionsKt.addAll(r101, ((c) r103).a());
        goto L4
    L9:
        this.f491902a = r101;
    }
}
