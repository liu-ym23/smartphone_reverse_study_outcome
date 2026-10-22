package com.bytedance.ee.bear.notification;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements g {
    public final o a;
    public String b;
    public final Map<g.a, Observer<Notification>> c;
    public final Handler d;

    public class a implements Runnable {
        public final /* synthetic */ Observer a;
        public final /* synthetic */ g.a b;
        public final /* synthetic */ j c;

        @Override // java.lang.Runnable
        public final void run() {
            this.c.a.a.removeObserver(this.a);     // Catch: Throwable -> L4
            Map<g.a, Observer<Notification>> r0 = this.c.c;     // Catch: Throwable -> L4
            HashMap r1 = (HashMap) r0;     // Catch: Throwable -> L4
            r1.remove(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(j r1, Observer r2, g.a r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public j() {
        this.c = new HashMap();
        this.d = new Handler(Looper.getMainLooper());
        o r0 = new o();
        this.a = r0;
        dk5.e r1 = r0.e;
        r1.getClass();
        Flowable.create(new dk5.g(r1), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b()).filter(new s()).subscribe(new p(r0), new q());
        r0.a();
        r0.e.a.Rb(new dk5.e.c().getType()).a(new NetService.f("/api/bulletin/get/")).map(new dk5.f()).subscribe(new t(r0), new u());
    }

    @Override // com.bytedance.ee.bear.notification.g
    public final void a(String r5) {
        if (this.b.equals(r5) == false) goto L6;
        o r0 = this.a;
        dk5.e r1 = r0.e;
        r1.getClass();
        fo5.d.b().scheduleDirect(new dk5.k(r1, r5));
        ArrayList r2 = new ArrayList();
        r2.add(r5);
        r0.e.a(r2);
        r0.a.postValue(null);
        return;
    }

    @Override // com.bytedance.ee.bear.notification.g
    public final void b(f.b r4) {
        h r0 = new h(this, r4);
        this.d.post(new i(this, r0, r4));
    }

    @Override // com.bytedance.ee.bear.notification.g
    public final void c(g.a r4) {
        Observer r0 = (Observer) ((HashMap) this.c).get(r4);
        this.d.post(new a(this, r0, r4));
    }
}
