package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c f383423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f383424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f383425c;

    @Override // java.lang.Runnable
    public final void run() {
        LLog.i("Lynx", "load font success");     // Catch: Throwable -> L4
        this.f383423a.a(this.f383424b, this.f383425c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(com.lynx.tasm.behavior.shadow.text.g.c r100, Typeface r101, int r102) {
        this.f383423a = r100;
        this.f383424b = r101;
        this.f383425c = r102;
    }
}
