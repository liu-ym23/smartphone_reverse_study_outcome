package com.bytedance.ee.bear.sheet.screenshotobserver;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Runnable {
    public final /* synthetic */ ScreenshotObserver a;
    public final /* synthetic */ String b;

    public a(ScreenshotObserver r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ScreenshotObserver r0 = this.a;
        if (r0.i != ScreenshotObserver.LifecycleState.ObserveStarted) goto L8;
        Iterator r1 = ((CopyOnWriteArrayList) r0.a).iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        ((gn5.a) r1.next()).a(this.b);
        goto L6
    L11:
        return;
    L8:
        int r2 = ScreenshotObserver.o;
        tt5.a.h("ScreenshotObserver", "ScreenshotObserver's lifecycle state error: " + this.a.i);
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
}
