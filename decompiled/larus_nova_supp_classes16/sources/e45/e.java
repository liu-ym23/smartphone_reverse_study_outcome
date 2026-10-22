package e45;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final ArrayList<a> a;
    public final ArrayList<a> b;
    public final ArrayList<a> c;

    public e() {
        this.a = CollectionsKt.arrayListOf(new a[]{new d()});
        this.b = new ArrayList();
        this.c = CollectionsKt.arrayListOf(new a[]{new d()});
        new ArrayList();
    }

    public static void a(List r1) {
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((a) r2.next()).a();
        goto L4
    }
}
