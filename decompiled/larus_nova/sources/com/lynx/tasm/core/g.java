package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.event.LynxTouchEvent;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTouchEvent f383277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383278b;

    public final void a() {
        if (this.f383278b.f383244a != 0) goto L6;
        LLog.e("LynxEngineProxy", "sendMultiTouchEvent failed since mNativePtr is null");
        return;
    L6:
        j7a.a r100 = j7a.a.f497652a;
        JavaOnlyMap r101 = this.f383277a.getUITouchMap();
        r100.getClass();
        ByteBuffer r102 = j7a.a.b(r101);
        if (r102 != null) goto L9;
        int r103 = 0;
    L10:
        LynxEngineProxy r104 = this.f383278b;
        LynxEngineProxy.g(r104, r104.f383244a, this.f383277a.getName(), r102, r103, this.f383277a.getTimestamp());
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

    public g(LynxEngineProxy r100, LynxTouchEvent r101) {
        this.f383278b = r100;
        this.f383277a = r101;
    }
}
