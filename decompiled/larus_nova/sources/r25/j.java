package r25;

import com.bytedance.ee.bear.contract.r0;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes16.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f535781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CountDownLatch f535782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f535783c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f535784a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.k("PreloadExecutor", "backgroundSleepRunnable======");     // Catch: Throwable -> L4
            this.f535784a.f535781a = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(j r100) {
            this.f535784a = r100;
        }
    }

    public final void h() throws Exception {
        boolean r100 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
        if (this.f535781a == true) goto L5;
        if (r100 == false) goto L5;
        return;
    L5:
        tt5.a.h("PreloadExecutor", "checkCountDownLatch hasBackgroundSleep: " + this.f535781a + "   isConnected: " + r100);
        CountDownLatch r101 = new CountDownLatch(1);
        this.f535782b = r101;
        r101.await();
    }

    public final void i() {
        boolean r100 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
        tt5.a.h("PreloadExecutor", "doCountDown hasBackgroundSleep: " + this.f535781a + "   isConnected: " + r100);
        if (this.f535781a == true) goto L21;
        if (r100 == true) goto L6;
        return;
    L6:
        if (MonitorModule.e().f432323d == false) goto L17;
        MonitorModule.e().getClass();
        if (DevicePerfManager.b.f432386a.f432372e.f20370h == false) goto L17;
        bsb.a r101 = bsb.a.a();
        bsb.a.InterfaceC0357a r102 = new f(this);
        monitor-enter(r101);
        r101.f20361a.add(r102);     // Catch: Throwable -> L14
        monitor-exit(r101);
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        this.f535782b.countDown();
        return;
    }

    public j() {
        this.f535781a = false;
        this.f535782b = new CountDownLatch(1);
        this.f535783c = new a(this);
        m.a(new g(this));
        r0 r100 = r0.b.f217133a;
        r0.c r101 = new h(this);
        ((CopyOnWriteArrayList) r100.f217131a).add(r101);
    }
}
