package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.event.LynxEvent;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxEvent f383295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383296b;

    @Override // java.lang.Runnable
    public final void run() {
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L3:
        if (this.f383296b.f383244a != 0) goto L5;
        LLog.e("LynxEngineProxy", "startEventGenerate failed since mNativePtr is null");     // Catch: Throwable -> L11
        return;
    L5:
        j7a.a r100 = j7a.a.f497652a;     // Catch: Throwable -> L11
        ArrayList<Object> r101 = this.f383295a.getEventParams();     // Catch: Throwable -> L11
        r100.getClass();     // Catch: Throwable -> L11
        ByteBuffer r102 = j7a.a.b(r101);     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        int r103 = 0;
    L9:
        LynxEngineProxy r104 = this.f383296b;     // Catch: Throwable -> L11
        LynxEngineProxy.l(r104, r104.f383244a, r102, r103);     // Catch: Throwable -> L11
        return;
    L8:
        r103 = r102.position();     // Catch: Throwable -> L11
        goto L9
    }

    public l(LynxEngineProxy r100, LynxEvent r101) {
        this.f383296b = r100;
        this.f383295a = r101;
    }
}
