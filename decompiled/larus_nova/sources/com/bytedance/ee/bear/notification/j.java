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

/* JADX INFO: loaded from: classes18.dex */
public final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f235120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f235121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<g.a, Observer<Notification>> f235122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f235123d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Observer f235124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g.a f235125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f235126c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f235126c.f235120a.f235131a.removeObserver(this.f235124a);     // Catch: Throwable -> L4
            Map<g.a, Observer<Notification>> r100 = this.f235126c.f235122c;     // Catch: Throwable -> L4
            HashMap r101 = (HashMap) r100;     // Catch: Throwable -> L4
            r101.remove(this.f235125b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(j r100, Observer r101, g.a r102) {
            this.f235126c = r100;
            this.f235124a = r101;
            this.f235125b = r102;
        }
    }

    public j() {
        this.f235122c = new HashMap();
        this.f235123d = new Handler(Looper.getMainLooper());
        o r100 = new o();
        this.f235120a = r100;
        dk5.e r101 = r100.f235135e;
        r101.getClass();
        Flowable.create(new dk5.g(r101), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b()).filter(new s()).subscribe(new p(r100), new q());
        r100.a();
        r100.f235135e.f469003a.Rb(new dk5.e.c().getType()).a(new NetService.f("/api/bulletin/get/")).map(new dk5.f()).subscribe(new t(r100), new u());
    }

    @Override // com.bytedance.ee.bear.notification.g
    public final void a(String r100) {
        if (this.f235121b.equals(r100) == false) goto L6;
        o r101 = this.f235120a;
        dk5.e r102 = r101.f235135e;
        r102.getClass();
        fo5.d.b().scheduleDirect(new dk5.k(r102, r100));
        ArrayList r103 = new ArrayList();
        r103.add(r100);
        r101.f235135e.a(r103);
        r101.f235131a.postValue(null);
        return;
    }

    @Override // com.bytedance.ee.bear.notification.g
    public final void b(f.b r100) {
        h r101 = new h(this, r100);
        this.f235123d.post(new i(this, r101, r100));
    }

    @Override // com.bytedance.ee.bear.notification.g
    public final void c(g.a r100) {
        Observer r101 = (Observer) ((HashMap) this.f235122c).get(r100);
        this.f235123d.post(new a(this, r101, r100));
    }
}
