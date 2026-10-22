package com.bytedance.dataplatform;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f204300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f204301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f204302c;

    @Override // java.lang.Runnable
    public final void run() {
        g.c(this.f204300a, this.f204301b).edit().remove(this.f204302c).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(Context r100, String r101, String r102) {
        this.f204300a = r100;
        this.f204301b = r101;
        this.f204302c = r102;
    }
}
