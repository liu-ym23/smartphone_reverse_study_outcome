package r25;

import com.bytedance.ee.bear.contract.r0;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class j {
    public boolean a;
    public CountDownLatch b;
    public final a c;

    public class a implements Runnable {
        public final /* synthetic */ j a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.k("PreloadExecutor", "backgroundSleepRunnable======");     // Catch: Throwable -> L4
            this.a.a = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(j r1) {
            this.a = r1;
        }
    }

    public final void h() throws Exception {
        boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        if (this.a == true) goto L5;
        if (r0 == false) goto L5;
        return;
    L5:
        tt5.a.h("PreloadExecutor", "checkCountDownLatch hasBackgroundSleep: " + this.a + "   isConnected: " + r0);
        CountDownLatch r1 = new CountDownLatch(1);
        this.b = r1;
        r1.await();
    }

    public final void i() {
        boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        tt5.a.h("PreloadExecutor", "doCountDown hasBackgroundSleep: " + this.a + "   isConnected: " + r0);
        if (this.a == true) goto L21;
        if (r0 == true) goto L6;
        return;
    L6:
        if (MonitorModule.e().d == false) goto L17;
        MonitorModule.e().getClass();
        if (DevicePerfManager.b.a.e.h == false) goto L17;
        bsb.a r1 = bsb.a.a();
        bsb.a.a r2 = new f(this);
        monitor-enter(r1);
        r1.a.add(r2);     // Catch: Throwable -> L14
        monitor-exit(r1);
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        this.b.countDown();
        return;
    }

    public j() {
        this.a = false;
        this.b = new CountDownLatch(1);
        this.c = new a(this);
        m.a(new g(this));
        r0 r0 = r0.b.a;
        r0.c r1 = new h(this);
        ((CopyOnWriteArrayList) r0.a).add(r1);
    }
}
