package com.ss.cast.discovery.nsd;

import android.text.TextUtils;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.api.ICastSource;
import com.byted.cast.common.source.ServiceInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.cast.discovery.ClientProxy;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ServiceInfo f456355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.cast.discovery.nsd.a f456356b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f456357a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f456357a;     // Catch: Throwable -> L4
            com.ss.cast.discovery.nsd.a r101 = r100.f456356b;     // Catch: Throwable -> L4
            ServiceInfo r102 = r100.f456355a;     // Catch: Throwable -> L4
            r101.getClass();     // Catch: Throwable -> L4
            Dispatcher.getInstance().enqueue(new b(r101, r102));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f456357a = r100;
        }
    }

    public final void a() {
        if (this.f456356b.f456347a == null) goto L36;
        ServiceInfo r100 = this.f456355a;
        if (r100 == null) goto L36;
        if (r100.isSupportDetect() == false) goto L36;
        if (this.f456356b.f456353g == false) goto L36;
        ServiceInfo r101 = this.f456356b.f456347a.getCurrentPlayServiceInfo();
        if (r101 == null) goto L22;
        if (TextUtils.equals(this.f456355a.name, r101.name) == false) goto L22;
        if (TextUtils.equals(this.f456355a.f33719ip, r101.f33719ip) == false) goto L22;
        if (this.f456355a.port != r101.port) goto L22;
        this.f456356b.f456350d.i("BDLinkServiceDetector", "currentService same with nsdService, currentService: " + r101 + ", serviceInfo: " + this.f456355a);
        return;
    L22:
        if (this.f456355a.isSupportPing() == false) goto L27;
        this.f456356b.f456350d.i("BDLinkServiceDetector", "use ping detect");
        ICastSource r102 = this.f456356b.f456347a;
        ServiceInfo r103 = this.f456355a;
        if (r102.ping(r103.f33719ip, r103.port) == false) goto L31;
        this.f456356b.f456350d.i("BDLinkServiceDetector", "detect success, name:" + this.f456355a.name + ", ip:" + this.f456355a.f33719ip);
        this.f456355a.setDetectFailCount(0);
        return;
    L31:
        ServiceInfo r104 = this.f456355a;
        r104.setDetectFailCount(r104.getDetectFailCount() + 1);
        this.f456356b.f456350d.i("BDLinkServiceDetector", "detect fail, name:" + this.f456355a.name + ", ip:" + this.f456355a + ", detectFailCount:" + this.f456355a.getDetectFailCount());
        if (this.f456355a.getDetectFailCount() >= 3) goto L34;
        this.f456356b.f456348b.postDelayed(new a(this), 1000);
        return;
    L34:
        wjc.a r105 = this.f456356b.f456351e;
        ((ClientProxy.a) r105).f456262a.onDeviceOffline(this.f456355a);
        return;
    L27:
        this.f456356b.f456350d.i("BDLinkServiceDetector", "use getDeviceInfo detect");
        ICastSource r106 = this.f456356b.f456347a;
        ServiceInfo r107 = this.f456355a;
        if (r106.getSinkDeviceInfo(r107.f33719ip, r107.port) == null) goto L31;
        this.f456356b.f456350d.i("BDLinkServiceDetector", "detect success, name:" + this.f456355a.name + ", ip:" + this.f456355a.f33719ip);
        this.f456355a.setDetectFailCount(0);
        return;
    L36:
        this.f456356b.f456350d.w("BDLinkServiceDetector", "detectService isStart: " + this.f456356b.f456353g + ", nsdService: " + this.f456355a);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(com.ss.cast.discovery.nsd.a r100, ServiceInfo r101) {
        this.f456356b = r100;
        this.f456355a = r101;
    }
}
