package com.bytedance.dataplatform;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f204285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f204286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f204287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f204288d;

    @Override // java.lang.Runnable
    public final void run() {
        g.c(this.f204285a, this.f204286b).edit().putInt(this.f204287c, this.f204288d).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(Context r100, String r101, int r102) {
        this.f204285a = r100;
        this.f204286b = "CLIENT_EXPERIMENT_CACHE_TAG";
        this.f204287c = r101;
        this.f204288d = r102;
    }
}
