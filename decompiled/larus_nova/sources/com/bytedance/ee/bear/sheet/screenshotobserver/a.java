package com.bytedance.ee.bear.sheet.screenshotobserver;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotObserver f238329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f238330b;

    public a(ScreenshotObserver r100, String r101, long r102) {
        this.f238329a = r100;
        this.f238330b = r101;
    }

    public final void a() {
        ScreenshotObserver r100 = this.f238329a;
        if (r100.f238315i != ScreenshotObserver.LifecycleState.ObserveStarted) goto L8;
        Iterator r101 = ((CopyOnWriteArrayList) r100.f238307a).iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        ((gn5.a) r101.next()).a(this.f238330b);
        goto L6
    L11:
        return;
    L8:
        int r102 = ScreenshotObserver.f238306o;
        tt5.a.h("ScreenshotObserver", "ScreenshotObserver's lifecycle state error: " + this.f238329a.f238315i);
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
