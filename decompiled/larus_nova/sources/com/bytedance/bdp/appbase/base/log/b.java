package com.bytedance.bdp.appbase.base.log;

import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BdpAppLogServiceImpl.i f200587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f200588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object[] f200589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BdpAppLogServiceImpl f200590d;

    public final void a() {
        if (this.f200587a.f200585b != null) goto L7;
        BdpAppLogServiceImpl.G2(this.f200588b);
    L7:
        if (this.f200587a.f200586c != null) goto L10;
        BdpAppLogServiceImpl r100 = this.f200590d;
        Object[] r101 = this.f200589c;
        int r102 = BdpAppLogServiceImpl.f200566d;
        r100.F2(r101);
    L10:
        BdpLogService r103 = BdpAppLogServiceImpl.I2();
        long r104 = this.f200587a.f200584a;
        r103.q1();
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

    public b(BdpAppLogServiceImpl r100, BdpAppLogServiceImpl.i r101, Object[] r102) {
        this.f200590d = r100;
        this.f200587a = r101;
        this.f200588b = "BdpAppMonitor";
        this.f200589c = r102;
    }
}
