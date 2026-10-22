package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f383281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f383282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f383283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f383284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f383285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383286f;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r100 = this.f383286f;     // Catch: Throwable -> L7
        long r101 = r100.f383244a;     // Catch: Throwable -> L7
        if (r101 != 0) goto L5;
        LLog.e("LynxEngineProxy", "sendGestureEvent failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.i(r100, r101, this.f383281a, this.f383282b, this.f383283c, this.f383284d, this.f383285e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public i(LynxEngineProxy r100, String r101, int r102, int r103, ByteBuffer r104, int r105) {
        this.f383286f = r100;
        this.f383281a = r101;
        this.f383282b = r102;
        this.f383283c = r103;
        this.f383284d = r104;
        this.f383285e = r105;
    }
}
