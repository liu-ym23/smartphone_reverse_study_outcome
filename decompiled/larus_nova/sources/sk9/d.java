package sk9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<c> f542433a = null;

    static {
        f542433a = new CopyOnWriteArrayList();
    }

    public static void a() {
        Iterator<c> r100 = f542433a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().a();
        goto L4
    }
}
