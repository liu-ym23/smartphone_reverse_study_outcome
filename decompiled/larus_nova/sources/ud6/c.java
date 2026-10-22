package ud6;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f549737a;

    public c() {
        this.f549737a = CollectionsKt.arrayListOf(new b[]{new f(), new e(), new d(), new a()});
    }

    public final b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        Iterator<T> r101 = this.f549737a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((b) r102).f549736a, r100) == false) goto L4;
    L10:
        return (b) r102;
    L8:
        r102 = null;
        goto L10
    }
}
