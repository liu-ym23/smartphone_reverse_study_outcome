package pd5;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<InterfaceC7184a>> f528673a = null;

    /* JADX INFO: renamed from: pd5.a$a, reason: collision with other inner class name */
    public interface InterfaceC7184a {
        void L2();
    }

    static {
        f528673a = new CopyOnWriteArrayList();
    }

    public static void b() {
        Iterator<WeakReference<InterfaceC7184a>> r100 = f528673a.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        WeakReference<InterfaceC7184a> r101 = r100.next();
        if (r101 == null) goto L4;
        if (r101.get() == null) goto L4;
        r101.get().L2();
        goto L4
    }

    public static void a(InterfaceC7184a r100) {
        if (r100 == null) goto L5;
        f528673a.add(new WeakReference(r100));
        return;
    }

    public static void c(InterfaceC7184a r100) {
        if (r100 == null) goto L19;
        int r101 = 0;
        int r102 = -1;
    L4:
        CopyOnWriteArrayList<WeakReference<InterfaceC7184a>> r103 = f528673a;
        if (r101 >= r103.size()) goto L12;
        WeakReference<InterfaceC7184a> r104 = r103.get(r101);
        if (r104 == null) goto L11;
        if (r104.get() != r100) goto L11;
        r102 = r101;
    L11:
        r101 = r101 + 1;
        goto L4
    L12:
        if (r102 == (-1)) goto L20;
        r103.remove(r102);
        return;
    L20:
        return;
    }
}
