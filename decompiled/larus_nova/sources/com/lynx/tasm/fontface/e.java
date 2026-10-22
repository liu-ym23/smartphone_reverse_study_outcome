package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c f383426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f383427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f383428c;

    @Override // java.lang.Runnable
    public final void run() {
        LLog.i("Lynx", "load font success");     // Catch: Throwable -> L4
        this.f383426a.a(this.f383427b, this.f383428c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(com.lynx.tasm.behavior.shadow.text.g.c r100, Typeface r101, int r102) {
        this.f383426a = r100;
        this.f383427b = r101;
        this.f383428c = r102;
    }
}
