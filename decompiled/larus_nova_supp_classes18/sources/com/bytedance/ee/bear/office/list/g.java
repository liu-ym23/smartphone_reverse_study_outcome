package com.bytedance.ee.bear.office.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements Runnable {
    public final /* synthetic */ OfficeListHostFragment a;
    public final /* synthetic */ String b;

    public g(OfficeListHostFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        OfficeListHostFragment r0 = this.a;
        if (r0.m == true) goto L6;
        return;
    L6:
        if (r0.isResumed() == true) goto L8;
    L12:
        tt5.a.h("OfficeListHostFragment", "keep RECENT refresh mark after office create, reason=" + this.b);
        return;
    L8:
        if (this.a.getView() == null) goto L12;
        tt5.a.h("OfficeListHostFragment", "refresh RECENT once after office create action, reason=" + this.b);
        OfficeListHostFragment r1 = this.a;
        r1.m = false;
        r1.n = false;
        r1.o = false;
        r1.gM();
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
}
