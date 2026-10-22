package gn7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<f> f481814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<f> f481815b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<f> f481816c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f481817d = null;

    static {
        f481814a = new ArrayList();
        f481815b = new ArrayList();
        f481816c = new ArrayList();
        f481817d = new Object();
    }

    public static boolean a(g r100) {
        Object r101 = f481817d;
        monitor-enter(r101);
        ArrayList r102 = new ArrayList(f481814a);     // Catch: Throwable -> L27
        monitor-exit(r101);     // Catch: Throwable -> L27
        r102.addAll(f481815b);
        r102.add(new c());
        r102.addAll(f481816c);
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L26;
        f r104 = (f) r103.next();
        r104.a();
        if (r104.d() != 0) goto L12;
    L21:
        boolean r105 = r104.c(r100);
    L23:
        if (r100.f481821d == true) goto L8;
        r100.f481821d = r105;
        goto L8
    L12:
        if (r104.d() == 2) goto L21;
        if (r104.b() == true) goto L21;
        if (r100.f481821d == false) goto L18;
    L20:
        r105 = false;
        goto L23
    L18:
        if (r104.d() != 1) goto L20;
    L26:
        return r100.f481821d;
    L27:
        th = move-exception;
        throw th;
    }

    public static boolean b(f r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Object r101 = f481817d;
        monitor-enter(r101);
        int r102 = r100.d();     // Catch: Throwable -> L19
        if (r102 == 0) goto L16;
        if (r102 != 1) goto L11;
        ((ArrayList) f481815b).add(r100);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return true;
    L11:
        if (r102 == 2) goto L14;
        monitor-exit(r101);     // Catch: Throwable -> L19
        return false;
    L14:
        ((ArrayList) f481816c).add(r100);     // Catch: Throwable -> L19
        goto L17
    L16:
        ((ArrayList) f481814a).add(r100);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
