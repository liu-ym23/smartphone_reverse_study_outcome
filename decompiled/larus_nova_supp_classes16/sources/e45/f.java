package e45;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final ArrayList<b> a;
    public final ArrayList<b> b;
    public final ArrayList<b> c;
    public final ArrayList<b> d;

    public f() {
        this.a = CollectionsKt.arrayListOf(new b[]{new c()});
        this.b = new ArrayList();
        this.c = CollectionsKt.arrayListOf(new b[]{new c()});
        this.d = new ArrayList();
    }

    public static void a(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        b r0 = (b) r3.next();
        if (r0.a() == false) goto L4;
        if (r0.c() == false) goto L4;
        r0.b();
        goto L4
    }

    public static boolean b(List r1) {
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((b) r2.next()).a() == false) goto L4;
        return true;
    L9:
        return false;
    }
}
