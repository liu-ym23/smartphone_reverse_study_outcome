package sw3;

import android.os.Process;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Thread.UncaughtExceptionHandler {
    public static final C0170a c = null;
    public final CopyOnWriteArraySet<b> a;
    public final Thread.UncaughtExceptionHandler b;

    /* JADX INFO: renamed from: sw3.a$a, reason: collision with other inner class name */
    public static class C0170a extends com.bytedance.applog.log.b<a> {
        public C0170a() {
        }

        public final Object a(Object[] r1) {
            return new a();
        }
    }

    static {
        c = new C0170a();
    }

    public a() {
        this.a = new CopyOnWriteArraySet();
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r3, Throwable r4) {
        Iterator<b> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a();
        goto L4
    L6:
        Thread.UncaughtExceptionHandler r1 = this.b;
        if (r1 == null) goto L12;
        r1.uncaughtException(r3, r4);
        return;
    L12:
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L11
        System.exit(10);     // Catch: Throwable -> L11
        return;
    }
}
