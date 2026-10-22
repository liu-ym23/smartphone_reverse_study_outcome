package com.bytedance.bdp.bdpplatform.service.ui.picker.wheel;

import com.larus.apm.impl.protector.RunnableProtector;
import ib4.g;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f201488a;

    @Override // java.lang.Runnable
    public final void run() {
        WheelView r100 = this.f201488a;     // Catch: Throwable -> L6
        g r101 = r100.f201447c;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.a(r100.B);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public f(WheelView r100) {
        this.f201488a = r100;
    }
}
