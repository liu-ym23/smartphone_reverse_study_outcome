package io.ktor.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class n0 {
    public static final z b(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "parameters");
        b0 r101 = d0.a();
        Iterator<T> r102 = r100.names().iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        String r103 = (String) r102.next();
        List<String> r104 = r100.a(r103);
        if (r104 != null) goto L8;
        r104 = CollectionsKt.emptyList();
    L8:
        String r105 = CodecsKt.e(r103, 0, 0, false, 15);
        List<String> r106 = r104;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        r107.add(CodecsKt.e((String) r108.next(), 0, 0, true, 11));
        goto L10
    L12:
        r101.d(r105, r107);
        goto L4
    L14:
        return new c0(r101.f491945b);
    }

    public static final void a(a0 r100, z r101) {
        Iterator<T> r102 = r101.names().iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        String r103 = (String) r102.next();
        List<String> r104 = r101.a(r103);
        if (r104 != null) goto L8;
        r104 = CollectionsKt.emptyList();
    L8:
        String r105 = CodecsKt.f(r103, false);
        List<String> r106 = r104;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        r107.add(CodecsKt.g((String) r108.next()));
        goto L10
    L12:
        r100.d(r105, r107);
        goto L4
    }
}
