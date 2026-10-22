package com.ss.android.lark.imageocr.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ llb.b f426582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f426583b;

    public f(llb.b r100, float r101) {
        this.f426582a = r100;
        this.f426583b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f426582a.a(false, false, 0.0f, this.f426583b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
