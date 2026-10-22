package pd5;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final CopyOnWriteArrayList<WeakReference<InterfaceC0287a>> a = null;

    /* JADX INFO: renamed from: pd5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0287a {
        void L2();
    }

    static {
        a = new CopyOnWriteArrayList();
    }

    public static void b() {
        Iterator<WeakReference<InterfaceC0287a>> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        WeakReference<InterfaceC0287a> r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.get() == null) goto L4;
        r1.get().L2();
        goto L4
    }

    public static void a(InterfaceC0287a r2) {
        if (r2 == null) goto L5;
        a.add(new WeakReference(r2));
        return;
    }

    public static void c(InterfaceC0287a r5) {
        if (r5 == null) goto L19;
        int r1 = 0;
        int r2 = -1;
    L4:
        CopyOnWriteArrayList<WeakReference<InterfaceC0287a>> r3 = a;
        if (r1 >= r3.size()) goto L12;
        WeakReference<InterfaceC0287a> r4 = r3.get(r1);
        if (r4 == null) goto L11;
        if (r4.get() != r5) goto L11;
        r2 = r1;
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        if (r2 == (-1)) goto L20;
        r3.remove(r2);
        return;
    L20:
        return;
    }
}
