package sw3;

import android.os.Process;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C7665a f543715c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<b> f543716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f543717b;

    /* JADX INFO: renamed from: sw3.a$a, reason: collision with other inner class name */
    public static class C7665a extends com.bytedance.applog.log.b<a> {
        public C7665a() {
        }

        @Override // com.bytedance.applog.log.b
        public final a a(Object[] r100) {
            return new a();
        }
    }

    static {
        f543715c = new C7665a();
    }

    public a() {
        this.f543716a = new CopyOnWriteArraySet();
        this.f543717b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r100, Throwable r101) {
        Iterator<b> r102 = this.f543716a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a();
        goto L4
    L6:
        Thread.UncaughtExceptionHandler r103 = this.f543717b;
        if (r103 == null) goto L12;
        r103.uncaughtException(r100, r101);
        return;
    L12:
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L11
        System.exit(10);     // Catch: Throwable -> L11
        return;
    }
}
