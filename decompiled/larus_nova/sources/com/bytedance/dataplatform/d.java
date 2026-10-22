package com.bytedance.dataplatform;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f204293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f204294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f204295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f204296d;

    public final void a() {
        if (this.f204293a != null) goto L5;
        g.c(this.f204294b, this.f204295c).edit().remove(this.f204296d).apply();
        return;
    L5:
        g.c(this.f204294b, this.f204295c).edit().putString(this.f204296d, this.f204293a).apply();
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

    public d(String r100, Context r101, String r102, String r103) {
        this.f204293a = r100;
        this.f204294b = r101;
        this.f204295c = r102;
        this.f204296d = r103;
    }
}
