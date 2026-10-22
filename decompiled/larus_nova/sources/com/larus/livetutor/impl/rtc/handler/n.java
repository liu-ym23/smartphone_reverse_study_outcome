package com.larus.livetutor.impl.rtc.handler;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes30.dex */
public final class n extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RTCMonitor f356346a;

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f356346a.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(RTCMonitor r100) {
        this.f356346a = r100;
    }
}
