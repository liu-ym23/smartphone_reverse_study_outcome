package com.lynx.tasm.ui.image;

import com.facebook.datasource.DataSource;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f384067a;

    public final void a() {
        q r100 = this.f384067a.f384072d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f384044l == null) goto L14;
        r100.f384033a.f383859a.remove(r100);
        r100.f384035c = true;
        if (r100.f384036d == true) goto L15;
        r100.d().onSubmit(r100.f384047o, r100.f384048p);
        r100.f384036d = true;
        r100.f384037e = false;
        DataSource<T> r101 = r100.e();
        r100.f384039g = r101;
        String r102 = r100.f384047o;
        if (r101 == 0) goto L11;
        r101.subscribe(new r(r100, r102, r101.hasResult()), r100.f384034b);
        return;
    L11:
        LLog.i("LynxImage", "request after dataSource release url= " + r100.f384046n);
        return;
    L15:
        return;
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

    public w(y r100) {
        this.f384067a = r100;
    }
}
