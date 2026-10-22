package q80;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f532003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f532004b;

    /* JADX INFO: renamed from: q80.a$a, reason: collision with other inner class name */
    public static final class C7296a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f532005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f532006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f532007c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f532007c = true;
            this.f532005a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f532007c;
        }

        public C7296a(Handler r100, boolean r101) {
            this.f532005a = r100;
            this.f532006b = r101;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            if (r100 == null) goto L23;
            if (r102 == null) goto L21;
            if (this.f532007c == true) goto L7;
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            Handler r104 = this.f532005a;
            b r105 = new b(r104, r103);
            Message r106 = Message.obtain(r104, r105);
            r106.obj = this;
            if (this.f532006b == false) goto L12;
            r106.setAsynchronous(true);
        L12:
            if (r101 > 0) goto L14;
            this.f532005a.sendMessageAtTime(r106, 4);
        L16:
            if (this.f532007c == false) goto L19;
            this.f532005a.removeCallbacks(r105);
            return Disposables.disposed();
        L19:
            return r105;
        L14:
            this.f532005a.sendMessageDelayed(r106, r102.toMillis(r101));
            goto L16
        L7:
            return Disposables.disposed();
        L21:
            throw new NullPointerException("unit == null");
        L23:
            throw new NullPointerException("run == null");
        }
    }

    public static final class b implements Runnable, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f532008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f532009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f532010c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f532008a.removeCallbacks(this);
            this.f532010c = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f532009b.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            RxJavaPlugins.onError(th);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f532010c;
        }

        public b(Handler r100, Runnable r101) {
            this.f532008a = r100;
            this.f532009b = r101;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new C7296a(this.f532003a, this.f532004b);
    }

    public a(Handler r100, boolean r101) {
        this.f532003a = r100;
        this.f532004b = r101;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        if (r100 == null) goto L9;
        if (r102 == null) goto L7;
        Runnable r103 = RxJavaPlugins.onSchedule(r100);
        Handler r104 = this.f532003a;
        b r105 = new b(r104, r103);
        r104.postDelayed(r105, r102.toMillis(r101));
        return r105;
    L7:
        throw new NullPointerException("unit == null");
    L9:
        throw new NullPointerException("run == null");
    }
}
