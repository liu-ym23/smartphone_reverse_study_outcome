package exc;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f474752a;

    public static synchronized void a(Context r100) {
        monitor-enter(e.class);
        f474752a = d.c(r100);     // Catch: Throwable -> L7
        monitor-exit(e.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void d(String r100) {
        if (f474752a == null) goto L6;
        d.b(3, r100);
        return;
    }

    public static void b(String r100, String r101) {
        if (f474752a == null) goto L12;
        d.b(6, r101);
        fxc.a.C5963a r102 = new fxc.a.C5963a(6, r100);
        r102.f479136g = r101;
        fxc.a r103 = new fxc.a(r102);
        c.a r104 = c.f474748a;
        if (r104 == null) goto L13;
        String r105 = r103.toString();
        a r106 = (a) r104;
        if (r105 != null) goto L9;
        return;
    L9:
        if (r106.f474747b == null) goto L15;
        ((LinkedBlockingQueue) r106.f474746a).offer(r105);
        return;
    L15:
        return;
    L13:
        return;
    }

    public static void c(String r100, String r101) {
        if (f474752a == null) goto L12;
        d.b(4, r101);
        fxc.a.C5963a r102 = new fxc.a.C5963a(4, r100);
        r102.f479136g = r101;
        fxc.a r103 = new fxc.a(r102);
        c.a r104 = c.f474748a;
        if (r104 == null) goto L13;
        String r105 = r103.toString();
        a r106 = (a) r104;
        if (r105 != null) goto L9;
        return;
    L9:
        if (r106.f474747b == null) goto L15;
        ((LinkedBlockingQueue) r106.f474746a).offer(r105);
        return;
    L15:
        return;
    L13:
        return;
    }

    public static void e(String r100, String r101) {
        if (f474752a == null) goto L12;
        d.b(4, r101);
        fxc.a.C5963a r102 = new fxc.a.C5963a(4, r100);
        r102.f479136g = r101;
        fxc.a r103 = new fxc.a(r102);
        c.a r104 = c.f474748a;
        if (r104 == null) goto L13;
        String r105 = r103.toString();
        a r106 = (a) r104;
        if (r105 != null) goto L9;
        return;
    L9:
        if (r106.f474747b == null) goto L15;
        ((LinkedBlockingQueue) r106.f474746a).offer(r105);
        return;
    L15:
        return;
    L13:
        return;
    }
}
