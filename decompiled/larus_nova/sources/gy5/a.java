package gy5;

import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f483327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RunnableC6081a f483328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<gy5.b> f483329c;

    /* JADX INFO: renamed from: gy5.a$a, reason: collision with other inner class name */
    public class RunnableC6081a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f483330a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<gy5.b> r100 = this.f483330a.f483329c.iterator();     // Catch: Throwable -> L8 OutOfMemoryError -> L14
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().onTimeEvent(System.currentTimeMillis());     // Catch: Throwable -> L8 OutOfMemoryError -> L14
            goto L4
        L6:
            this.f483330a.getClass();     // Catch: Throwable -> L8 OutOfMemoryError -> L14
            c r101 = this.f483330a.f483327a;     // Catch: Throwable -> L8 OutOfMemoryError -> L14
            r101.b(Message.obtain(r101.f483337d, this), 30000);     // Catch: Throwable -> L8 OutOfMemoryError -> L14
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        L18:
            return;
        }

        public RunnableC6081a(a r100) {
            this.f483330a = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f483331a = null;

        static {
            f483331a = new a();
        }
    }

    public a() {
        this.f483328b = new RunnableC6081a(this);
        this.f483329c = new CopyOnWriteArraySet();
        c r100 = new c();
        this.f483327a = r100;
        ThreadMethodProxy.start(r100.f483334a);
    }

    public final void a(gy5.b r100) {
        if (r100 == null) goto L8;
        this.f483329c.add(r100);     // Catch: Throwable -> L5
        this.f483327a.a(this.f483328b);     // Catch: Throwable -> L5
        c r101 = this.f483327a;     // Catch: Throwable -> L5
        RunnableC6081a r102 = this.f483328b;     // Catch: Throwable -> L5
        r101.b(Message.obtain(r101.f483337d, r102), 30000);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public final void b(Runnable r100) {
        c r101 = this.f483327a;
        r101.b(Message.obtain(r101.f483337d, r100), 0);
    }
}
