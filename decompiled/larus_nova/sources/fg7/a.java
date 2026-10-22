package fg7;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import hg7.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import yf7.j;
import yf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements n, LifecycleObserver, fg7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f476866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C5898a f476867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.sync.v2.protocal.b f476868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xf7.g f476869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile cg7.a f476870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile fg7.f f476871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f476872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f476873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f476874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f476875j;

    /* JADX INFO: renamed from: fg7.a$a, reason: collision with other inner class name */
    public class C5898a extends xf7.n<Handler> {
        public C5898a() {
        }

        @Override // xf7.n
        public final Handler a(Object[] r100) {
            return new Handler(((yf7.f) rgc.b.a(yf7.f.class)).get());
        }
    }

    public class b implements hg7.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sync.v2.net.b f476876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f476877b;

        /* JADX INFO: renamed from: fg7.a$b$a, reason: collision with other inner class name */
        public class RunnableC5899a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ig7.a f476878a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f476879b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f476879b.f476876a.F(this.f476878a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC5899a(b r100, ig7.a r101) {
                this.f476879b = r100;
                this.f476878a = r101;
            }
        }

        @Override // hg7.g
        public final boolean l() {
            return false;
        }

        @Override // hg7.g
        public final void F(ig7.a r100) {
            a r101 = this.f476877b;
            r100.f489742d = new com.bytedance.sync.v2.net.a(r101.f476872g, r101.f476871f);
            RunnableC5899a r102 = new RunnableC5899a(this, r100);
            com.bytedance.sync.net.a.f270377a.b(new Object[0]).submit(r102);
        }

        public b(a r100, com.bytedance.sync.v2.net.b r101) {
            this.f476877b = r100;
            this.f476876a = r101;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cg7.a f476880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f476881b;

        @Override // java.lang.Runnable
        public final void run() {
            a.b(this.f476881b, this.f476880a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(a r100, cg7.a r101) {
            this.f476881b = r100;
            this.f476880a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f476882a;

        @Override // java.lang.Runnable
        public final void run() {
            cg7.a r100 = cg7.b.c(this.f476882a.f476866a).b();     // Catch: Throwable -> L11
            cg7.b r101 = cg7.b.c(this.f476882a.f476866a);     // Catch: Throwable -> L11
            a r102 = this.f476882a;     // Catch: Throwable -> L11
            List<n> r103 = r101.f23678d;     // Catch: Throwable -> L11
            monitor-enter(r103);     // Catch: Throwable -> L11
            ((ArrayList) r101.f23678d).add(r102);     // Catch: Throwable -> L8
            monitor-exit(r103);     // Catch: Throwable -> L8
            a.b(this.f476882a, r100);     // Catch: Throwable -> L11
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }

        public d(a r100) {
            this.f476882a = r100;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f476883a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f476883a.f476872g = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(a r100) {
            this.f476883a = r100;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f476884a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f476884a.f476872g = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(a r100) {
            this.f476884a = r100;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAppBackground() {
        zf7.b.a("[Compensator] startCompensate ON_STOP");
        this.f476867b.b(new Object[0]).post(new e(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAppForeground() {
        zf7.b.a("[Compensator] startCompensate ON_START");
        this.f476867b.b(new Object[0]).post(new f(this));
    }

    @Override // fg7.e
    public final boolean isForeground() {
        return this.f476872g;
    }

    @Override // yf7.n
    public final void a(j.a r100) {
        cg7.a r101 = cg7.b.c(this.f476866a).b();
        this.f476867b.b(new Object[0]).post(new c(this, r101));
    }

    public static void b(a r100, cg7.a r110) {
        if (r110 != null) goto L4;
        r100.getClass();
        return;
    L4:
        cg7.a r101 = r100.f476870e;
        fg7.f r102 = r100.f476871f;
        if (r101 == null) goto L23;
        if (r102 == null) goto L23;
        if (r100.f476870e.n() == false) goto L13;
        if (r110.n() == true) goto L13;
    L16:
        r102.destroy();
        if (r110.n() == false) goto L19;
        fg7.f r103 = new h(r100, r100.f476868c, r100.f476869d);
    L20:
        r103.d(r110, r100.f476873h.get());
        r100.f476871f = r103;
    L27:
        r100.f476870e = r110;
        r100.f476874i.set(true);
        return;
    L19:
        r103 = new com.bytedance.sync.v2.compensate.a(r100, r100.f476867b, r100.f476868c, false, true);
    L13:
        if (r100.f476870e.n() == false) goto L15;
    L21:
        r102.a(r110);
        goto L27
    L15:
        if (r110.n() == false) goto L21;
    L23:
        if (r110.n() == false) goto L25;
        fg7.f r104 = new h(r100, r100.f476868c, r100.f476869d);
    L26:
        r104.d(r110, r100.f476873h.get());
        r100.f476871f = r104;
        goto L27
    L25:
        r104 = new com.bytedance.sync.v2.compensate.a(r100, r100.f476867b, r100.f476868c, false, true);
        goto L26
    }

    public a(Context r100, xf7.g r101, i r102) {
        this.f476873h = new AtomicBoolean(false);
        this.f476874i = new AtomicBoolean(false);
        this.f476875j = new d(this);
        this.f476866a = r100;
        this.f476869d = r101;
        this.f476867b = new C5898a();
        this.f476868c = new com.bytedance.sync.v2.protocal.b(new b(this, new com.bytedance.sync.v2.net.b(r100, r101, r102, null)));
    }
}
