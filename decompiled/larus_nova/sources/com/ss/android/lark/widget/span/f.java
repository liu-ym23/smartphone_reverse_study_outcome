package com.ss.android.lark.widget.span;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f448673a;

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f448673a;     // Catch: Throwable -> L10
        if (r100.f448663b == true) goto L5;
    L8:
        r100.f448668g = false;     // Catch: Throwable -> L10
    L15:
        return;
    L5:
        if (r100.f448668g == false) goto L8;
        r100.f448667f = (r100.f448667f + 32.0f) % 360.0f;     // Catch: Throwable -> L10
        r100.invalidateSelf();     // Catch: Throwable -> L10
        this.f448673a.f448669h.postDelayed(this, 80);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }

    public f(e r100) {
        this.f448673a = r100;
    }
}
