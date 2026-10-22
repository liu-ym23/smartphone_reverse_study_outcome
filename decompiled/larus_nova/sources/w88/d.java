package w88;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<m> f558660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f558661b;

    static {
        f558660a = new CopyOnWriteArrayList();
        f558661b = 1;
    }

    public static void a(int r100) {
        if (f558661b != r100) goto L5;
        return;
    L5:
        Iterator<m> r101 = f558660a.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().a();
        goto L7
    L9:
        f558661b = r100;
    }
}
