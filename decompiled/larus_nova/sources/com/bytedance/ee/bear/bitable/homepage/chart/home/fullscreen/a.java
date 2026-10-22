package com.bytedance.ee.bear.bitable.homepage.chart.home.fullscreen;

import android.content.Context;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f212563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f212564b;

    public a(Context r100, Intent r101) {
        this.f212563a = r100;
        this.f212564b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f212563a.startActivity(this.f212564b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
