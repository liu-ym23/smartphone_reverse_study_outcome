package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile b f214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f463109b;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ae f463112a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final LinkedBlockingQueue<b> f217a;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_xiaomi_push_ae$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_xiaomi_push_ae$a__run$___twin___() {
            if (ae.a(this.f463112a) <= 0) goto L5;
            long r100 = ae.a(this.f463112a);
        L7:
            if (ae.m8802a(this.f463112a) == true) goto L17;
            b r101 = this.f217a.poll(r100, TimeUnit.SECONDS);     // Catch: InterruptedException -> L15
            ae.a(this.f463112a, r101);     // Catch: InterruptedException -> L15
            if (r101 != null) goto L10;
            if (ae.a(this.f463112a) <= 0) goto L7;
            ae.m8801a(this.f463112a);     // Catch: InterruptedException -> L15
            goto L7
        L10:
            a(0, r101);     // Catch: InterruptedException -> L15
            r101.b();     // Catch: InterruptedException -> L15
            a(1, r101);     // Catch: InterruptedException -> L15
        L15:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            goto L7
        L17:
            return;
        L5:
            r100 = Long.MAX_VALUE;
            goto L7
        }

        public a(ae r100) {
            this.f463112a = r100;
            super("PackageProcessor");
            this.f217a = new LinkedBlockingQueue();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_xiaomi_push_ae$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_xiaomi_push_ae$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void a(b r100) {
            this.f217a.add(r100);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        private void a(int r100, b r101) {
            ae.m8800a(this.f463112a).sendMessage(ae.m8800a(this.f463112a).obtainMessage(r100, r101));     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static abstract class b {
        public b() {
        }

        public void a() {
        }

        public abstract void b();

        /* JADX INFO: renamed from: c */
        public void mo8933c() {
        }
    }

    public ae() {
        this(false);
    }

    private synchronized void a() {
        monitor-enter(this);
        this.f213a = null;     // Catch: Throwable -> L7
        this.f215a = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ae(boolean r100) {
        this(r100, 0);
    }

    public synchronized void a(b r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f213a != null) goto L6;
        a r101 = new a(this);     // Catch: Throwable -> L9
        this.f213a = r101;     // Catch: Throwable -> L9
        r101.setDaemon(this.f463109b);     // Catch: Throwable -> L9
        this.f215a = false;     // Catch: Throwable -> L9
        ThreadMethodProxy.start(this.f213a);     // Catch: Throwable -> L9
    L6:
        this.f213a.a(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ void m8801a(ae r100) {
        r100.a();
    }

    public static /* synthetic */ int a(ae r100) {
        return r100.f463108a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ Handler m8800a(ae r100) {
        return r100.f212a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ boolean m8802a(ae r100) {
        return r100.f215a;
    }

    public ae(boolean r100, int r101) {
        this.f212a = null;
        this.f215a = false;
        this.f463108a = 0;
        final Looper r102 = Looper.getMainLooper();
        this.f212a = new AnonymousClass1(this, r102);
        this.f463109b = r100;
        this.f463108a = r101;
    }

    public void a(final b r100, long r101) {
        this.f212a.postDelayed(new AnonymousClass2(this, r100), r101);
    }

    public static /* synthetic */ b a(ae r100, b r101) {
        r100.f214a = r101;
        return r101;
    }
}
