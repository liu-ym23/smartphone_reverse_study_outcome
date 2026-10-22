package e2a;

import com.larus.utils.y;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<a> f470849a = null;

    static {
        f470849a = new CopyOnWriteArrayList();
    }

    public static void a() {
        Iterator r100 = ((CopyOnWriteArrayList) f470849a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        final a r101 = (a) r100.next();
        y.c(new b(r101));
        goto L4
    }

    public static void b() {
        Iterator r100 = ((CopyOnWriteArrayList) f470849a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        final a r101 = (a) r100.next();
        y.c(new d(r101));
        goto L4
    }

    public static void c() {
        Iterator r100 = ((CopyOnWriteArrayList) f470849a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        final a r101 = (a) r100.next();
        y.c(new c(r101));
        goto L4
    }
}
