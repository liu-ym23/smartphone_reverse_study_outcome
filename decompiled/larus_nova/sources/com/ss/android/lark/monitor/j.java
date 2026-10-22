package com.ss.android.lark.monitor;

import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f432414a;

    public final void a() {
        k.a r100 = this.f432414a.f432415a;
        if (r100 == null) goto L13;
        LarkMetrics r101 = (LarkMetrics) r100;
        if (r101.f432310d.f432403g == false) goto L8;
        Log.d("LarkMetrics", "background ticked");
    L8:
        if (r101.f432317k == true) goto L14;
        r101.b("Background");
        if (r101.f432310d.f432400d == false) goto L15;
        Intent r102 = new Intent("com.ss.android.lark.metrics.doMetrics");
        r102.setPackage(r101.f432307a.getPackageName());
        r102.putExtra("activity_name", "Background");
        r101.f432307a.sendBroadcast(r102);
        return;
    L15:
        return;
    L14:
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

    public j(k r100) {
        this.f432414a = r100;
    }
}
