package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.tasm.event.a f383279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383280b;

    public final void a() {
        if (this.f383280b.f383244a != 0) goto L6;
        LLog.e("LynxEngineProxy", "SendCustomEvent failed since mNativePtr is null");
        return;
    L6:
        j7a.a r100 = j7a.a.f497652a;
        Map<String, Object> r101 = this.f383279a.b();
        r100.getClass();
        ByteBuffer r102 = j7a.a.b(r101);
        if (r102 != null) goto L9;
        int r103 = 0;
    L10:
        String r104 = this.f383279a.c();
        LynxEngineProxy r105 = this.f383280b;
        LynxEngineProxy.h(r105, r105.f383244a, this.f383279a.getName(), this.f383279a.getTag(), r102, r103, r104);
        return;
    L9:
        r103 = r102.position();
        goto L10
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

    public h(LynxEngineProxy r100, com.lynx.tasm.event.a r101) {
        this.f383280b = r100;
        this.f383279a = r101;
    }
}
