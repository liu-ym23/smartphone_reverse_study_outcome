package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTouchEvent f383275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383276b;

    public final void a() {
        if (this.f383276b.f383244a != 0) goto L6;
        LLog.e("LynxEngineProxy", "sendTouchEvent failed since mNativePtr is null");
        return;
    L6:
        LynxTouchEvent.a r100 = this.f383275a.getClientPoint();
        LynxTouchEvent.a r101 = this.f383275a.getPagePoint();
        LynxTouchEvent.a r102 = this.f383275a.getViewPoint();
        LynxEngineProxy r103 = this.f383276b;
        LynxEngineProxy.f(r103, r103.f383244a, this.f383275a.getName(), this.f383275a.getTag(), r100.f383322a, r100.f383323b, r101.f383322a, r101.f383323b, r102.f383322a, r102.f383323b, this.f383275a.getTimestamp());
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

    public f(LynxEngineProxy r100, LynxTouchEvent r101) {
        this.f383276b = r100;
        this.f383275a = r101;
    }
}
